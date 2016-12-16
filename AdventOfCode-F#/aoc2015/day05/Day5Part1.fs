open System

let rec hasVowels (s : string) (charPos : int) (count : int) = 
    let len = s.Length - 1
    let c = s.Chars(charPos)
    match c with
    | 'a' | 'e' | 'i' | 'o' | 'u' ->
        match count with
        | 2 -> true
        | _ ->
            match charPos with
            | i when i = len -> false
            | _ -> count + 1 |> hasVowels s (charPos+1)
    | _ -> 
        match charPos with
        | i when i = len -> false
        | _ -> hasVowels s (charPos+1) count

let rec hasRepeat (s : string) charPos = 
    let c = s.Chars(charPos)
    match c with
    | d when d = s.Chars(charPos+1) -> true
    | _ -> 
        match charPos with
        | i when i = s.Length - 2 -> false
        | _ -> hasRepeat s (charPos+1)

let rec hasNaughty (s : string) charPos =
    let two = s.Substring(charPos, 2)
    match two with
    | "ab" | "cd" | "pq" | "xy" -> true
    | _ -> 
        match charPos with
        | i when i = s.Length - 2 -> false
        | _ -> hasNaughty s (charPos+1)

let isNice (s : string) =
    (hasVowels s 0 0) && (hasRepeat s 0) && not (hasNaughty s 0)

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