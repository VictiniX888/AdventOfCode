puzzleInput = input("Input: ")
inputLength = len(puzzleInput)

posX = 0
posY = 0
visited = ["0,0"]

for i in range(inputLength):
    if puzzleInput[i] == "^":
        posY += 1
    elif puzzleInput[i] == "v":
        posY -= 1
    elif puzzleInput[i] == ">":
        posX += 1
    elif puzzleInput[i] == "<":
        posX -= 1
    currentPos = str(posX) + "," + str(posY)
    visited.append(currentPos)

visitedSet = set(visited)
houses = len(visitedSet)
print(houses)