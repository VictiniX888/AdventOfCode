open System

let rec move pos floor (s : string) = 
    if floor = -1 then printf "%i" pos
    else
        match s.Chars(pos) with
        | '(' -> move (pos + 1) (floor + 1) s
        | ')' -> move (pos + 1) (floor - 1) s
        | _ -> printf "Error"


let main() = 
    let path = Console.ReadLine()
    let input = IO.File.ReadAllText(path)
    let mutable floor = 0 
    let mutable output = 0
    move 0 0 input

main()