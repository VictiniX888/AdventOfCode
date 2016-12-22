open System

let rec turnOn xSrc xDest yDest x y (grid : int [,]) =
    match x with
    | i when i = xDest + 1 -> 
        match y with
        | i when i <> yDest ->
            grid |> turnOn xSrc xDest yDest (xSrc) (y+1)
        | _ -> ()
    | _ ->
        grid.[x,y] <- 1
        grid |> turnOn xSrc xDest yDest (x+1) (y)

let rec turnOff xSrc xDest yDest x y (grid : int [,]) =
    match x with
    | i when i = xDest + 1 -> 
        match y with
        | i when i <> yDest ->
            grid |> turnOff xSrc xDest yDest (xSrc) (y+1)
        | _ -> ()
    | _ ->
        grid.[x,y] <- 0
        grid |> turnOff xSrc xDest yDest (x+1) (y)

let rec toggle xSrc xDest yDest x y (grid : int [,]) =
    match x with
    | i when i = xDest + 1 -> 
        match y with
        | i when i <> yDest ->
            grid |> toggle xSrc xDest yDest (xSrc) (y+1)
        | _ -> ()
    | _ ->
        grid.[x,y] <- (grid.[x,y] + 1) % 2
        grid |> toggle xSrc xDest yDest (x+1) (y)

let rec lights (input : string array) i grid =
    match i with
    | a when a = input.Length -> grid
    | _ ->
        let s = input.[i]
        let instruction = s.Split[|' '|]
        match instruction.[0] with
        | "toggle" -> 
            let src = instruction.[1]
            let srcA = src.Split[|','|]
            let dest = instruction.[3]
            let destA = dest.Split[|','|]
            toggle (srcA.[0] |> int) (destA.[0] |> int) (destA.[1] |> int) (srcA.[0] |> int) (srcA.[1] |> int) grid
        | "turn" when instruction.[1] = "on" ->
            let src = instruction.[2]
            let srcA = src.Split[|','|]
            let dest = instruction.[4]
            let destA = dest.Split[|','|]
            turnOn (srcA.[0] |> int) (destA.[0] |> int) (destA.[1] |> int) (srcA.[0] |> int) (srcA.[1] |> int) grid
        | "turn" when instruction.[1] = "off" ->
            let src = instruction.[2]
            let srcA = src.Split[|','|]
            let dest = instruction.[4]
            let destA = dest.Split[|','|]
            turnOff (srcA.[0] |> int) (destA.[0] |> int) (destA.[1] |> int) (srcA.[0] |> int) (srcA.[1] |> int) grid
        | _ -> ()
        lights input (i+1) grid

let mutable lightCount = 0

let checkLight = function
    | 1 -> lightCount <- lightCount + 1
    | _ -> ()

let main() = 
    let path = Console.ReadLine()
    let input = IO.File.ReadAllLines(path)
    
    let grid = Array2D.create 1000 1000 0
    let lightedGrid = lights input 0 grid
    Array2D.iter checkLight lightedGrid
    printf "%i" lightCount

main()