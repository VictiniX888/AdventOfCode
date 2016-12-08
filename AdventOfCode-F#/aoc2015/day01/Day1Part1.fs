open System.IO

let main() = 
    let input = File.ReadAllText("D:/AdventOfCode/AdventOfCode-F#/aoc2015/day01/Day1Input.txt")
    let mutable floor = 0
    for i = 0 to (input.Length-1) do
        if (input.Chars(i) = '(') then
            floor <- floor + 1
        else floor <- floor - 1
    printf "%i" floor

main()