package aoc2016.day05;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Day5Part2 {

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.nextLine();

        int i = 0;
        int count = 0;
        String password = "00000000";
        int[] validPos = new int[8];

        while(true) {
            String doorID = input + i;
            byte[] inputBytes = doorID.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] outputBytes = md.digest(inputBytes);
            String hash = DatatypeConverter.printHexBinary(outputBytes);

            if(hash.substring(0, 5).equals("00000") && hash.substring(5, 6).matches("[0-7]")) {
                if(validPos[Integer.parseInt(hash.substring(5, 6))] == 0) {
                    password = password.substring(0, Integer.parseInt(hash.substring(5, 6))) + hash.substring(6, 7) + password.substring(Integer.parseInt(hash.substring(5, 6)) + 1);
                    validPos[Integer.parseInt(hash.substring(5, 6))] = 1;
                    count++;
                    if (count == 8) {
                        break;
                    }
                }
            }
            i++;
        }

        System.out.println(password);
    }
}
