package aoc2015.days.day22;

import aoc2015.lib.ReadInput;

import java.util.concurrent.ThreadLocalRandom;

public class Day22Part1 {

    public Day22Part1() {

        ReadInput readInput = new ReadInput();
        String[] input = readInput.input.split(";");

        int leastMana = Integer.MAX_VALUE;

        for (int j = 0; j < Integer.MAX_VALUE; j++) {
            int mana = 500;
            int playerHP = 50;
            int bossDamage = Integer.parseInt(input[1].split(" ")[1]);
            int bossHP = Integer.parseInt(input[0].split(" ")[2]);

            boolean shieldEffect = false;
            boolean poisonEffect = false;
            boolean rechargeEffect = false;

            int shieldTurns = 0;
            int poisonTurns = 0;
            int rechargeTurns = 0;

            int usedMana = 0;

            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                if(poisonEffect) {
                    bossHP -= 3;
                    poisonTurns--;
                }
                if(rechargeEffect) {
                    mana += 101;
                    rechargeTurns--;
                }
                if(shieldEffect) {
                    shieldTurns--;
                }

                if(bossHP <= 0) {
                    break;
                }

                if(shieldTurns <= 0) shieldEffect = false;
                if(poisonTurns <= 0) poisonEffect = false;
                if(rechargeTurns <= 0) rechargeEffect = false;

                int random = ThreadLocalRandom.current().nextInt(0, 5);

                for (int k = 0; k < Integer.MAX_VALUE; k++) {
                    if(random == 2 && shieldEffect) {
                        random = ThreadLocalRandom.current().nextInt(0, 5);
                    }
                    else if(random == 3 && poisonEffect) {
                        random = ThreadLocalRandom.current().nextInt(0, 5);
                    }
                    else if(random == 4 && rechargeEffect) {
                        random = ThreadLocalRandom.current().nextInt(0, 5);
                    }
                    else {
                        break;
                    }
                }

                if(random == 0) {
                    mana -= 53;
                    usedMana += 53;
                    bossHP -= 4;
                }
                else if(random == 1) {
                    mana -= 73;
                    usedMana += 73;
                    bossHP -= 2;
                    playerHP += 2;
                }
                else if(random == 2) {
                    shieldEffect = true;
                    shieldTurns = 6;
                    mana -= 113;
                    usedMana += 113;
                }
                else if(random == 3) {
                    poisonEffect = true;
                    poisonTurns = 6;
                    mana -= 173;
                    usedMana += 173;
                }
                else if(random == 4) {
                    rechargeEffect = true;
                    rechargeTurns = 5;
                    mana -= 229;
                    usedMana += 229;
                }

                if(mana <= 0) {
                    usedMana = Integer.MAX_VALUE;
                    break;
                }

                if(bossHP <= 0) {
                    break;
                }

                if(poisonEffect) {
                    bossHP -= 3;
                    poisonTurns--;
                }
                if(rechargeEffect) {
                    mana += 101;
                    rechargeTurns--;
                }

                if(bossHP <= 0) {
                    break;
                }

                if(shieldEffect) {
                    int bossCurrentDamage = bossDamage - 7;
                    if(bossCurrentDamage <= 0) {
                        bossCurrentDamage = 1;
                    }
                    playerHP -= bossCurrentDamage;
                    shieldTurns--;
                }
                else {
                    playerHP -= bossDamage;
                }

                if(playerHP <= 0) {
                    usedMana = Integer.MAX_VALUE;
                    break;
                }

                if(shieldTurns <= 0) shieldEffect = false;
                if(poisonTurns <= 0) poisonEffect = false;
                if(rechargeTurns <= 0) rechargeEffect = false;
            }

            if(usedMana < leastMana) {
                leastMana = usedMana;
                System.out.println(leastMana);
            }
        }
    }
}
