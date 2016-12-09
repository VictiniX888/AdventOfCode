open System

let compare a b c =
    let mutable smallest1 = 100
    let mutable smallest2 = 101
    if a <= smallest1 then
        smallest2 <- smallest1
        smallest1 <- a
    elif a <= smallest2 then
        smallest2 <- a
    if b <= smallest1 then
        smallest2 <- smallest1
        smallest1 <- b
    elif b <= smallest2 then
        smallest2 <- b
    if c <= smallest1 then
        smallest2 <- smallest1
        smallest1 <- c
    elif c <= smallest2 then
        smallest2 <- c
    let smallest = [smallest1; smallest2]
    smallest

let main() = 
    let path = Console.ReadLine()
    let input = IO.File.ReadAllLines(path)
    let mutable output = 0

    for i = 0 to (input.Length - 1) do
        let dim = input.[i].Split('x')
        let l = dim.[0] |> int
        let w = dim.[1] |> int
        let h = dim.[2] |> int
        output <- output + l*w*h + 2*(compare l w h).[0] + 2*(compare l w h).[1]
    
    printf "%i" output

main()