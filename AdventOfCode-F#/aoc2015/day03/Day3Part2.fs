open System
open System.Collections.Generic

let direction (x, y) = function
    | '>' -> (x + 1, y)
    | '<' -> (x - 1, y)
    | '^' -> (x, y + 1)
    | 'v' -> (x, y - 1)
    | _ -> (x, y)

let main() = 
    let path = Console.ReadLine()
    let input = IO.File.ReadAllText(path)

    let posList = new List<int * int>()
    let mutable posSanta = (0, 0)
    let mutable posRobo = (0, 0)

    posList.Add(posSanta)

    for i = 0 to (input.Length - 1) do
        match i%2 with
        | 0 -> 
            posSanta <- direction posSanta (input.Chars(i))
            if not (posList.Contains(posSanta)) then posList.Add(posSanta)
        | 1 -> 
            posRobo <- direction posRobo (input.Chars(i))
            if not (posList.Contains(posRobo)) then posList.Add(posRobo)
        | _ -> ()
    
    printf "%i" posList.Count

main()