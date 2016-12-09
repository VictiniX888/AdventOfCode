open System

let main() = 
    let path = Console.ReadLine()
    let input = IO.File.ReadAllText(path)
    let mutable floor = 0
    for i = 0 to (input.Length-1) do
        if (input.Chars(i) = '(') then
            floor <- floor + 1
        else floor <- floor - 1
    printf "%i" floor

main()