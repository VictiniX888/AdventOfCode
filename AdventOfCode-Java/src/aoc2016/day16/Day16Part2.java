package aoc2016.day16;

import java.util.Scanner;

public class Day16Part2 {

    private static final int DISK_LENGTH = 35651584;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.nextLine();

        String a = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            if(input.charAt(i) == '0') {
                a = a.concat("1");
            }
            else {
                a = a.concat("0");
            }
        }
        input = input.concat("0");
        input = input.concat(a);

        while(input.length() < DISK_LENGTH) {  //dragon curve
            String b = input.substring(0, (input.length()-1)/2);
            b = b.concat("1");
            b = b.concat(input.substring(b.length()));
            input = input.concat("0");
            input = input.concat(b);
        }

        String data = input.substring(0, DISK_LENGTH);
        System.out.println(checksum(data));
    }

    private static String checksum(String data) {

        char[] chars = new char[data.length()/2];

        for (int i = 0; i < data.length(); i+=2) {
            if(data.charAt(i) == data.charAt(i+1)) {
                chars[i/2] = '1';
            }
            else {
                chars[i/2] = '0';
            }
        }

        String s;

        if(chars.length % 2 == 0) {
            s = checksum(new String(chars));
        }
        else {
            s = new String(chars);
        }

        return s;
    }
}
