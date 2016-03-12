puzzleInput = input("Input: ")
floor = 0
inputLength = len(puzzleInput)

for i in range(inputLength):
    if puzzleInput[i:i+1] == "(":
        floor += 1
    elif puzzleInput[i:i+1] == ")":
        floor -= 1

print(floor)