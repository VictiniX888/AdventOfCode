puzzleInput = input("Input: ")
inputLength = len(puzzleInput)

santaPosX = 0
santaPosY = 0
robotPosX = 0
robotPosY = 0
visited = ["0,0"]

for i in range(inputLength):
    if i % 2 == 0:
        if puzzleInput[i] == "^":
            santaPosY += 1
        elif puzzleInput[i] == "v":
            santaPosY -= 1
        elif puzzleInput[i] == ">":
            santaPosX += 1
        elif puzzleInput[i] == "<":
            santaPosX -= 1
        currentPos = str(santaPosX) + "," + str(santaPosY)
    else:
        if puzzleInput[i] == "^":
            robotPosY += 1
        elif puzzleInput[i] == "v":
            robotPosY -= 1
        elif puzzleInput[i] == ">":
            robotPosX += 1
        elif puzzleInput[i] == "<":
            robotPosX -= 1
        currentPos = str(robotPosX) + "," + str(robotPosY)
    visited.append(currentPos)

visitedSet = set(visited)
houses = len(visitedSet)
print(houses)