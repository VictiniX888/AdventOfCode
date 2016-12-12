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
    let mutable pos = (0, 0)

    posList.Add(pos)

    for i = 0 to (input.Length - 1) do
        pos <- direction pos (input.Chars(i))
        match posList.Contains(pos) with
        | false -> posList.Add(pos)
        | _ -> ()
    
    printf "%i" posList.Count

main()