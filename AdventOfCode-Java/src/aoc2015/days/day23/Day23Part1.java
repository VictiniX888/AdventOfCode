package aoc2015.days.day23;

import aoc2015.lib.ReadInput;

public class Day23Part1 {

    public Day23Part1() {

        ReadInput readInput = new ReadInput();
        String[] input = readInput.input.split(";");

        int a = 0;
        int b = 0;
        int i = 0;

        while(i < input.length) {

            String[] splitInput = input[i].split(" ");

            if(splitInput[0].equals("hlf")) {
                if(splitInput[1].equals("a")) {
                    a = hlf(a, i)[0];
                    i = hlf(a, i)[1];
                }
                else {
                    b = hlf(b, i)[0];
                    i = hlf(b, i)[1];
                }
            }
            else if(splitInput[0].equals("tpl")) {
                if(splitInput[1].equals("a")) {
                    a = tpl(a, i)[0];
                    i = tpl(a, i)[1];
                }
                else {
                    b = tpl(b, i)[0];
                    i = tpl(b, i)[1];
                }
            }
            else if(splitInput[0].equals("inc")) {
                if(splitInput[1].equals("a")) {
                    a = inc(a, i)[0];
                    i = inc(a, i)[1];
                }
                else {
                    b = inc(b, i)[0];
                    i = inc(b, i)[1];
                }
            }
            else if(splitInput[0].equals("jmp")) {
                i = jmp(splitInput[1], i);
            }
            else if(splitInput[0].equals("jie")) {
                if(splitInput[1].equals("a,")) {
                    i = jie(a, splitInput[2], i);
                }
                else {
                    i = jie(b, splitInput[2], i);
                }
            }
            else {
                if(splitInput[1].equals("a,")) {
                    i = jio(a, splitInput[2], i);
                }
                else {
                    i = jio(b, splitInput[2], i);
                }
            }
        }

        System.out.println(b);
    }

    public int[] hlf(int r, int i) {

        r /= 2;
        i++;
        return new int[]{r, i};
    }

    public int[] tpl(int r, int i) {

        r *= 3;
        i++;
        return new int[]{r, i};
    }

    public int[] inc(int r, int i) {

        r++;
        i++;
        return new int[]{r, i};
    }

    public int jmp(String offset, int i) {

        if(offset.substring(0, 1).equals("+")) {
            i += Integer.parseInt(offset.substring(1));
        }
        else {
            i -= Integer.parseInt(offset.substring(1));
        }
        return i;
    }

    public int jie(int r, String offset, int i) {

        if(r > 0 && r % 2 == 0) {
            if(offset.substring(0, 1).equals("+")) {
                i += Integer.parseInt(offset.substring(1));
            }
            else {
                i -= Integer.parseInt(offset.substring(1));
            }
        }
        else {
            i++;
        }
        return i;
    }

    public int jio(int r, String offset, int i) {

        if(r == 1) {
            if(offset.substring(0, 1).equals("+")) {
                i += Integer.parseInt(offset.substring(1));
            }
            else {
                i -= Integer.parseInt(offset.substring(1));
            }
        }
        else {
            i++;
        }
        return i;
    }
}
