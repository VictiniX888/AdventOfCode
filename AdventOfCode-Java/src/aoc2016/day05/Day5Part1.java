package aoc2016.day05;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Day5Part1 {

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.nextLine();

        int i = 0;
        String password = "";

        while(true) {
            String doorID = input + i;
            byte[] inputBytes = doorID.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] outputBytes = md.digest(inputBytes);
            String hash = DatatypeConverter.printHexBinary(outputBytes);

            if(hash.substring(0, 5).equals("00000")) {
                password = password.concat(hash.substring(5, 6));
                if(password.length() == 8) {
                    break;
                }
            }
            i++;
        }

        System.out.println(password);
    }
}
