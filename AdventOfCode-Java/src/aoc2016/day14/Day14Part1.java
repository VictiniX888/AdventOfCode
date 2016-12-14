package aoc2016.day14;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Day14Part1 {

    private static int index = -1;
    private static int keys = 0;

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.nextLine();

        MessageDigest md = MessageDigest.getInstance("MD5");

        while(keys < 64) {
            index++;
            String md5Input = input + index;
            byte[] inputBytes = md5Input.getBytes("UTF-8");
            byte[] outputBytes = md.digest(inputBytes);
            String hash = DatatypeConverter.printHexBinary(outputBytes);

            for (int i = 0; i < hash.length() - 2; i++) {
                char currentChar = hash.charAt(i);
                if(hash.charAt(i+1) == currentChar && hash.charAt(i+2) == currentChar) {
                    if(isKey(hash.charAt(i), input)) {
                        keys++;
                        break;
                    }
                    else {
                        break;
                    }
                }
            }
        }

        System.out.println(index);
    }

    private static boolean isKey(char c, String s) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        boolean legit = false;
        MessageDigest md = MessageDigest.getInstance("MD5");

        for (int i = index+1; i < index+1001; i++) {
            String md5Input = s + i;
            byte[] inputBytes = md5Input.getBytes("UTF-8");
            byte[] outputBytes = md.digest(inputBytes);
            String hash = DatatypeConverter.printHexBinary(outputBytes);
            if(hash.contains(new String(new char[]{c, c, c, c, c}))) {
                legit = true;
                break;
            }
        }

        return legit;
    }
}
