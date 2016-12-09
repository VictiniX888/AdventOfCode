open System

let main() = 
    let path = Console.ReadLine()
    let input = IO.File.ReadAllLines(path)
    let mutable output = 0

    for i = 0 to (input.Length - 1) do
        let dim = input.[i].Split('x')
        let l = dim.[0] |> int
        let w = dim.[1] |> int
        let h = dim.[2] |> int
        output <- output + 2*l*w + 2*l*h + 2*w*h

        let mutable smallest = 100
        let mutable smallest2 = 101
        for s in dim do
            if s |> int <= smallest then 
                smallest2 <- smallest
                smallest <- s |> int
            elif s |> int <= smallest2 then
                smallest2 <- s |> int
        output <- output + smallest*smallest2

    printf "%i" output

main()