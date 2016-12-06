package aoc2015.lib;

import java.util.Scanner;

public class ReadInput {

    public String input;

    public ReadInput() {

        Scanner scanner = new Scanner(System.in);
        new MessageRemoveLinebreak();
        System.out.print("Input: ");
        this.input = scanner.nextLine();
    }
}
