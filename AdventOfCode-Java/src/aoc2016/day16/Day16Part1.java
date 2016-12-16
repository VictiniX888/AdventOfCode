package aoc2016.day16;

import java.util.Scanner;

public class Day16Part1 {

    private static final int DISK_LENGTH = 272;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.nextLine();

        while(input.length() < DISK_LENGTH) {  //dragon curve
            String b = "";
            for (int i = input.length() - 1; i >= 0; i--) {
                if(input.charAt(i) == '0') {
                    b = b.concat("1");
                }
                else {
                    b = b.concat("0");
                }
            }

            input = input.concat("0");
            input = input.concat(b);

            System.out.println(input);
        }

        String data = input.substring(0, DISK_LENGTH);
        System.out.println(data);
        System.out.println(checksum(data));
    }

    private static String checksum(String data) {

        String s = "";

        for (int i = 0; i < data.length(); i+=2) {
            if(data.charAt(i) == data.charAt(i+1)) {
                s = s.concat("1");
            }
            else {
                s = s.concat("0");
            }
        }

        if(s.length() % 2 == 0) {
            s = checksum(s);
        }

        return s;
    }
}
