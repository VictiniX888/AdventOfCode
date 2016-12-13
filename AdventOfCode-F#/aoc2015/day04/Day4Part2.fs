open System

let rec hashToString (bA : byte[]) (s : string) (i : int) = 
    let b = bA.[i]
    let newS = s + b.ToString("x2")
    let bALength = bA.Length - 1
    match i with
    | a when a = bALength -> newS
    | _ -> hashToString bA newS (i+1)

let rec generateMD5 (s : string) (i : int) = 
    let newInput = s + i.ToString()
    let inputArray : byte[] = Text.Encoding.ASCII.GetBytes(newInput)
    let md5 = new Security.Cryptography.MD5CryptoServiceProvider()
    let hash = md5.ComputeHash(inputArray)
    let output = hashToString hash "" 0
    if output.Substring(0, 6) = "000000" then
        printf "%i" i
    else
        generateMD5 s (i+1)

let main() = 
    let path = Console.ReadLine() 
    let input = IO.File.ReadAllText(path)
    generateMD5 input 1

main()