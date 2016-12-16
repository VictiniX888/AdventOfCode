open System

let rec hasPair (s : string) charPos = 
    let pair = s.Substring(charPos, 2)
    let search = s.Substring(charPos + 2)
    match search.Contains(pair) with
    | true -> true
    | false -> 
        match charPos with
        | i when i = s.Length - 2 -> false
        | _ -> charPos + 1 |> hasPair s

let rec hasABA (s : string) charPos =
    match s.Chars(charPos) with
    | c when c = s.Chars(charPos+2) -> true
    | _ -> 
        match charPos with
        | i when i = s.Length - 3 -> false
        | _ -> charPos + 1 |> hasABA s

let isNice (s : string) =
    (hasPair s 0) && (hasABA s 0)

let rec checkStrings (input : string array) pos count = 
    match isNice input.[pos] with
    | true ->
        match pos with 
        | i when i = input.Length - 1 -> count + 1 |> printf "%i"
        | _ -> count + 1 |> checkStrings input (pos + 1)
    | false ->
        match pos with 
        | i when i = input.Length - 1 -> printf "%i" count
        | _ -> checkStrings input (pos + 1) count

let main() = 
    let path = Console.ReadLine()
    let input = IO.File.ReadAllLines(path)
    checkStrings input 0 0

main()