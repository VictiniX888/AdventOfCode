package days.day21;

import lib.ReadInput;

public class Day21Part2 {

    public Day21Part2() {

        ReadInput readInput = new ReadInput();
        String[] input = readInput.input.split(";");

        int[] weaponCost = {8, 10, 25, 40, 74};
        int[] weaponDamage = {4, 5, 6, 7, 8};
        int[] armorCost = {13, 31, 53, 75, 102};
        int[] armorArmor = {1, 2, 3, 4, 5};
        int[] ringCost = {25, 50, 100, 20, 40, 80};
        int[] ringDA = {1, 2, 3, 1, 2, 3};

        int playerHP = 100;

        int most = Integer.MIN_VALUE;

        for (int i = 0; i < weaponCost.length; i++) {
            int damage1 = weaponDamage[i];
            int cost1 = weaponCost[i];
            for (int j = 0; j <= armorCost.length; j++) {
                int armor1;
                int cost2;
                if(j < armorCost.length) {
                    armor1 = armorArmor[j];
                    cost2 = armorCost[j] + cost1;
                }
                else {
                    armor1 = 0;
                    cost2 = cost1;
                }
                for (int k = 0; k <= ringCost.length; k++) {
                    int damage2;
                    int armor2;
                    int cost3;
                    if(k < ringCost.length / 2) {
                        damage2 = ringDA[k] + damage1;
                        cost3 = ringCost[k] + cost2;
                        armor2 = armor1;
                    }
                    else if(k < ringCost.length) {
                        armor2 = ringDA[k] + armor1;
                        cost3 = ringCost[k] + cost2;
                        damage2 = damage1;
                    }
                    else {
                        damage2 = damage1;
                        armor2 = armor1;
                        cost3 = cost2;
                    }
                    for (int l = k + 1; l <= ringCost.length; l++) {
                        int damage3;
                        int armor3;
                        int cost4;
                        if(l < ringCost.length / 2) {
                            damage3 = ringDA[l] + damage2;
                            cost4 = ringCost[l] + cost3;
                            armor3 = armor2;
                        }
                        else if(l < ringCost.length) {
                            armor3 = ringDA[l] + armor2;
                            cost4 = ringCost[l] + cost3;
                            damage3 = damage2;
                        }
                        else {
                            damage3 = damage2;
                            armor3 = armor2;
                            cost4 = cost3;
                        }

                        int playerDealDamage = damage3 - Integer.parseInt(input[2].split(" ")[1]);
                        int bossDealDamage = Integer.parseInt(input[1].split(" ")[1]) - armor3;
                        if(playerDealDamage <= 0) {
                            playerDealDamage = 1;
                        }
                        if(bossDealDamage <= 0) {
                            bossDealDamage = 1;
                        }

                        int playerCurrentHP = playerHP;
                        int bossCurrentHP = Integer.parseInt(input[0].split(" ")[2]);

                        for (int m = 0; m < Integer.MAX_VALUE; m++) {
                            bossCurrentHP -= playerDealDamage;
                            if(bossCurrentHP <= 0) {
                                break;
                            }
                            playerCurrentHP -= bossDealDamage;
                            if(playerCurrentHP <= 0) {
                                if(cost4 > most) {
                                    most = cost4;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(most);
    }
}
