package aoc2016.day11;

import javafx.util.Pair;

import java.util.*;

public class Day11Part2 {

    private static int steps = 0;
    private static Set<Pair<List<Pair<Integer, Integer>>, Integer>> pairs = new HashSet<>();
    private static List<Pair<ArrayList<String>[], Integer>> moves = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.nextLine();
        String[] splitInput = input.split(";");

        ArrayList<String>[] layout =  new ArrayList[4];
        for (int i = 0; i < splitInput.length; i++) {
            String[] t = splitInput[i].split("\\s|\\.|,");
            layout[i] = new ArrayList<>();
            for (int j = 0; j < t.length; j++) {
                if(t[j].equals("nothing")) {break;}
                else if(t[j].equals("generator")) {
                    layout[i].add(t[j-1] + " " + t[j]);
                }
                else if(t[j].equals("microchip")){
                    layout[i].add(t[j-1].substring(0, t[j-1].length() - 11) + " " + t[j]);
                }
            }
        }

        layout[0].add("elerium generator");
        layout[0].add("elerium microchip");
        layout[0].add("dilithium generator");
        layout[0].add("dilithium microchip");

        moves.add(new Pair<>(layout, 0));
        if(legit(layout, 0)) {
            bfs();
        }
    }

    private static void bfs() {

        steps++;
        List<Pair<ArrayList<String>[], Integer>> newMoves = new ArrayList<>();

        for (int o = 0; o < moves.size(); o++) {
            ArrayList<String>[] layout = moves.get(o).getKey();
            int pos = moves.get(o).getValue();

            if (layout[pos].size() > 1) {
                for (int i = 0; i < layout[pos].size() - 1; i++) {
                    for (int j = i + 1; j < layout[pos].size(); j++) {
                        if (pos < 3) {
                            ArrayList<String>[] newLay = new ArrayList[4];
                            for (int k = 0; k < newLay.length; k++) {
                                newLay[k] = new ArrayList<>(layout[k]);
                            }
                            newLay[pos + 1].add(layout[pos].get(i));
                            newLay[pos + 1].add(layout[pos].get(j));
                            newLay[pos].remove(layout[pos].get(i));
                            newLay[pos].remove(layout[pos].get(j));
                            if(newLay[0].size() == 0 && newLay[1].size() == 0 && newLay[2].size() == 0) {
                                System.out.println(steps);
                                System.exit(1);
                            }
                            else if(legit(newLay, pos + 1)) {
                                newMoves.add(new Pair<>(newLay, pos + 1));
                            }
                        }
                        if (pos > 0) {
                            ArrayList<String>[] newLay = new ArrayList[4];
                            for (int k = 0; k < newLay.length; k++) {
                                newLay[k] = new ArrayList<>(layout[k]);
                            }
                            newLay[pos - 1].add(layout[pos].get(i));
                            newLay[pos - 1].add(layout[pos].get(j));
                            newLay[pos].remove(layout[pos].get(i));
                            newLay[pos].remove(layout[pos].get(j));
                            if(newLay[0].size() == 0 && newLay[1].size() == 0 && newLay[2].size() == 0) {
                                System.out.println(steps);
                                System.exit(1);
                            }
                            else if(legit(newLay, pos - 1)) {
                                newMoves.add(new Pair<>(newLay, pos - 1));
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < layout[pos].size(); i++) {
                String s = layout[pos].get(i);
                if (pos < 3) {
                    ArrayList<String>[] newLay = new ArrayList[4];
                    for (int k = 0; k < newLay.length; k++) {
                        newLay[k] = new ArrayList<>(layout[k]);
                    }
                    newLay[pos + 1].add(s);
                    newLay[pos].remove(s);
                    if(newLay[0].size() == 0 && newLay[1].size() == 0 && newLay[2].size() == 0) {
                        System.out.println(steps);
                        System.exit(1);
                    }
                    else if(legit(newLay, pos + 1)) {
                        newMoves.add(new Pair<>(newLay, pos + 1));
                    }
                }
                if (pos > 0) {
                    ArrayList<String>[] newLay = new ArrayList[4];
                    for (int k = 0; k < newLay.length; k++) {
                        newLay[k] = new ArrayList<>(layout[k]);
                    }
                    newLay[pos - 1].add(s);
                    newLay[pos].remove(s);
                    if(newLay[0].size() == 0 && newLay[1].size() == 0 && newLay[2].size() == 0) {
                        System.out.println(steps);
                        System.exit(1);
                    }
                    else if(legit(newLay, pos - 1)) {
                        newMoves.add(new Pair<>(newLay, pos - 1));
                    }
                }
            }
        }

        moves = newMoves;
        bfs();
    }

    private static boolean legit(ArrayList<String>[] layout, int pos) {

        boolean legit = true;
        List<Pair<Integer, Integer>> pairLoc =  new ArrayList<>();

        for (int i = 0; i < layout.length; i++) {
            List<String> l = layout[i];
            for (String s : l) {
                if(s.split(" ")[1].equals("microchip")) {
                    if(l.contains(s.split(" ")[0] + " generator")) {
                        pairLoc.add(new Pair<>(i, i));
                    }
                    else {
                        for (String t : l) {
                            if(t.split(" ")[1].equals("generator")) {
                                legit = false;
                                break;
                            }
                        }
                        if(legit) {
                            pants:
                            for (int j = 0; j < layout.length; j++) {
                                List<String> m = layout[j];
                                for (String t : m) {
                                    if(t.equals(s.split(" ")[0] + " generator")) {
                                        pairLoc.add(new Pair<>(i, j));
                                        break pants;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }


        PairComparator pComp = new PairComparator();
        pairLoc.sort(pComp);

        Pair<List<Pair<Integer, Integer>>, Integer> x = new Pair<>(pairLoc, pos); // microchip, generator

        if(pairs.contains(x)) {
            legit = false;
        }

        if(legit) {
            pairs.add(x);
        }

        return legit;
    }
}