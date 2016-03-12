puzzleInput = input("Input: ")
floor = 0
position = 1
inputLength = len(puzzleInput)

for i in range(inputLength):
    if puzzleInput[i:i+1] == "(":
        floor += 1
    elif puzzleInput[i:i+1] == ")":
        floor -= 1
    if floor <= -1:
        break
    else:
        position += 1

print(position)