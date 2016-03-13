puzzleInput = input("Input: ")
splitInput = puzzleInput.split(";")
inputLength = len(splitInput)
total = 0

for i in range(inputLength):
    dimensions = splitInput[i].split("x")
    l = int(dimensions[0])
    w = int(dimensions[1])
    h = int(dimensions[2])
    dimensions = [l, w, h]
    for j in range(3):
        if dimensions[j] == max(dimensions):
            smallestSide1 = dimensions[j-1]
            smallestSide2 = dimensions[j-2]
            break
    wrap = smallestSide1*2 + smallestSide2*2
    bow = l*w*h
    total = total + wrap + bow

print(total)