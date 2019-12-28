package aoc2019.day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Day1 {

    public static void main(String[] args) {

        List<String> input = null;

        try {
            input = Files.readAllLines(Paths.get("src/aoc2019/day1/input_day1"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert input != null;
        int[] inputInt = input.stream().mapToInt(Integer::parseInt).toArray();

        Scanner scanner = new Scanner(System.in);
        int part = scanner.nextInt();

        if (part == 1) {
            System.out.println(totalFuelNeeded(inputInt));
        }
        else if (part == 2) {
            System.out.println(totalFuelNeededWithFuelMass(inputInt));
        }
        else {
            System.out.println("Invalid Part Number");
        }
    }

    private static int totalFuelNeededWithFuelMass(int[] masses) {

        int total = 0;

        for (int mass : masses) {
            total += fuelNeededWithFuelMass(mass);
        }

        return total;
    }

    private static int fuelNeededWithFuelMass(int mass) {

        int fuelNeeded = fuelNeeded(mass);

        if (fuelNeeded > 0) {
            return fuelNeeded + fuelNeededWithFuelMass(fuelNeeded);
        }
        else {
            return 0;
        }
    }

    private static int totalFuelNeeded(int[] masses) {

        int total = 0;

        for (int mass : masses) {
            total += fuelNeeded(mass);
        }

        return total;
    }

    private static int fuelNeeded(int mass) {

        return (mass / 3) - 2;
    }
}
