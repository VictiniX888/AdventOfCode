package days.day14;

import lib.ReadInput;

public class Day14Part1 {

    public Day14Part1() {

        ReadInput readInput = new ReadInput();
        String[] input = readInput.input.split(";");
        int fastest = Integer.MIN_VALUE;

        for (int i = 0; i < input.length; i++) {
            int count = 0;
            String[] splitInput = input[i].split(" ");
            String name = splitInput[0];
            int speed = Integer.parseInt(splitInput[3]);
            int flyingTime = Integer.parseInt(splitInput[6]);
            int restTime = Integer.parseInt(splitInput[13]);
            int currentDistance = 0;

            racing:
            while(count < 2503) {

                for (int j = 0; j < flyingTime; j++) {
                    if(count >= 2503) break racing;
                    currentDistance += speed;
                    count++;
                }
                for (int j = 0; j < restTime; j++) {
                    if(count >= 2503) break racing;
                    count++;
                }
            }

            if(currentDistance > fastest) {
                fastest = currentDistance;
            }
        }

        System.out.println(fastest);
    }
}
