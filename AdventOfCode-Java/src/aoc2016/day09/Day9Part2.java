package aoc2016.day09;

import java.util.Scanner;

public class Day9Part2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.nextLine().replaceAll(";| ", "");

        long length = 0;
        boolean inMarker = false;

        for (int i = 0; i < input.length(); i++) {
            if(!inMarker) {
                if (input.charAt(i) == '(') {
                    inMarker = true;
                }
                else {
                    length++;
                }
            }
            else {
                int close = input.indexOf(')', i);
                String marker = input.substring(i, close);
                String[] markerArr = marker.split("x");
                length += decompress(Integer.parseInt(markerArr[0]), Integer.parseInt(markerArr[1]), input.substring(close+1, close+1+Integer.parseInt(markerArr[0])));
                i += markerArr[0].length() + markerArr[1].length() + 1 + Integer.parseInt(markerArr[0]);
                inMarker = false;
            }
        }

        System.out.println(length);
    }

    private static long decompress(int a, int b, String s) {

        long count = 0;

        if(s.contains("(")) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    int nextOpen = s.substring(i).indexOf('(');
                    int nextClose = s.substring(i).indexOf(')');
                    String[] marker = s.substring(i).substring(nextOpen + 1, nextClose).split("x");
                    String next = s.substring(i).substring(nextClose + 1, nextClose + 1 + Integer.parseInt(marker[0]));
                    count += decompress(Integer.parseInt(marker[0]), Integer.parseInt(marker[1]), next) * b;
                    i += nextClose + Integer.parseInt(marker[0]);
                }
                else {
                    count += s.length() * b;
                }
            }
        }
        else {
            count += s.length() * b;
        }

        return count;
    }
}
