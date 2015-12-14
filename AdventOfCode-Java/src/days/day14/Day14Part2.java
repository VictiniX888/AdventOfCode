package days.day14;

import lib.ReadInput;

public class Day14Part2 {

    public Day14Part2() {

        ReadInput readInput = new ReadInput();
        String[] input = readInput.input.split(";");
        int count = 1;
        int[] points = new int[input.length];
        int[] distance = new int[input.length];
        int answer = Integer.MIN_VALUE;

        while(count <= 2503) {

            for (int i = 0; i < input.length; i++) {
                String[] splitInput = input[i].split(" ");
                String name = splitInput[0];
                int speed = Integer.parseInt(splitInput[3]);
                int flyingTime = Integer.parseInt(splitInput[6]);
                int restTime = Integer.parseInt(splitInput[13]);

                if(count % (flyingTime + restTime) <= flyingTime && count % (flyingTime + restTime)!= 0) {
                    distance[i] += speed;
                }
            }

            int furthest = Integer.MIN_VALUE;
            for (int i = 0; i < distance.length; i++) {
                if(distance[i] > furthest) {
                    furthest = distance[i];
                }
            }
            for (int i = 0; i < distance.length; i++) {
                if(distance[i] == furthest) {
                    points[i]++;
                }
            }
            count++;
        }

        for (int i = 0; i < points.length; i++) {
            if(points[i] > answer) {
                answer = points[i];
            }
        }

        System.out.println(answer);
    }
}
