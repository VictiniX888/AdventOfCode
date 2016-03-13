puzzleInput = input("Input: ")
splitInput = puzzleInput.split(";")
inputLength = len(splitInput)
total = 0

for i in range(inputLength):
    dimensions = splitInput[i].split("x")
    l = int(dimensions[0])
    w = int(dimensions[1])
    h = int(dimensions[2])
    surface = 2*l*w + 2*w*h + 2*h*l
    sides = [l*w, w*h, h*l]
    smallestSide = min(sides)
    total = total + surface + smallestSide

print(total)