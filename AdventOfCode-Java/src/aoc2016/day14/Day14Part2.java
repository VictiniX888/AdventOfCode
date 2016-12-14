package aoc2016.day14;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day14Part2 {

    private static int index = -1;
    private static int keys = 0;
    private static List<String> hashList = new ArrayList<>();

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.nextLine();

        while(keys < 64) {
            index++;

            if(hashList.size() <= index) {
                String hash = input + index;
                for (int i = 0; i < 2017; i++) {
                    hash = hash(hash);
                }
                hashList.add(hash);
            }

            String currentHash = hashList.get(index);
            for (int i = 0; i < currentHash.length() - 2; i++) {
                char currentChar = currentHash.charAt(i);
                if(currentHash.charAt(i+1) == currentChar && currentHash.charAt(i+2) == currentChar) {
                    if(isKey(currentHash.charAt(i), input)) {
                        keys++;
                        System.out.println(keys + " " + index);
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

    private static String hash(String s) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] inputBytes = s.getBytes("UTF-8");
        byte[] outputBytes = md.digest(inputBytes);

        return DatatypeConverter.printHexBinary(outputBytes).toLowerCase();
    }

    private static boolean isKey(char c, String s) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        boolean legit = false;

        for (int i = index+1; i < index+1001; i++) {
            if (hashList.size() <= i) {
                String hash = s + i;
                for (int j = 0; j < 2017; j++) {
                    hash = hash(hash);
                }
                hashList.add(hash);
            }
            if(hashList.get(i).contains(new String(new char[]{c, c, c, c, c}))) {
                legit = true;
                break;
            }
        }

        return legit;
    }
}
