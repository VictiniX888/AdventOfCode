puzzleInput = input("Input: ")
floor = 0
inputLength = len(puzzleInput)

for i in range(inputLength):
    if puzzleInput[i] == "(":
        floor += 1
    elif puzzleInput[i] == ")":
        floor -= 1

print(floor)