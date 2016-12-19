package aoc2016.day17;

import javafx.util.Pair;

import javax.xml.bind.DatatypeConverter;
import java.awt.*;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Day17Part2 {

    private static String passcode;
    private static int steps = 0;
    private static int longest = 0;

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        passcode = scanner.nextLine();

        Set<Pair<String, Point>> startPos = new HashSet<>();
        startPos.add(new Pair<>("", new Point(0, 0)));
        move(startPos);
    }

    private static void move(Set<Pair<String, Point>> paths) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        Set<Pair<String, Point>> newPaths = new HashSet<>();

        for (Pair<String, Point> p : paths) {
            String path = p.getKey();
            int x = p.getValue().x;
            int y = p.getValue().y;

            if(!p.getValue().equals(new Point(3, 3))) {

                String doors = md5(passcode + path).substring(0, 4);

                for (int i = 0; i < doors.length(); i++) {
                    char c = doors.charAt(i);
                    if (c == 'b' || c == 'c' || c == 'd' || c == 'e' || c == 'f') {
                        if (i == 0 && y > 0) {
                            newPaths.add(new Pair<>(path + "U", new Point(x, y - 1)));
                        } else if (i == 1 && y < 3) {
                            newPaths.add(new Pair<>(path + "D", new Point(x, y + 1)));
                        } else if (i == 2 && x > 0) {
                            newPaths.add(new Pair<>(path + "L", new Point(x - 1, y)));
                        } else if (i == 3 && x < 3) {
                            newPaths.add(new Pair<>(path + "R", new Point(x + 1, y)));
                        }
                    }
                }
            }
            else {
                longest = steps;
            }
        }

        if(newPaths.size() <= 0) {
            System.out.println(longest);
        }
        else {
            steps++;
            move(newPaths);
        }
    }

    private static String md5(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] inputBytes = input.getBytes("UTF-8");
        byte[] outputBytes = md.digest(inputBytes);

        return DatatypeConverter.printHexBinary(outputBytes).toLowerCase();
    }
}
