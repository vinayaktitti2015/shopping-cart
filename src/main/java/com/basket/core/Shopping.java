package com.basket.core;

import java.util.List;

public class Shopping {

    public int checkout(List<String> items) {
        int total = 0;

        long appleCount = items.stream().filter(i -> i.equalsIgnoreCase("Apple")).count();
        long bananaCount = items.stream().filter(i -> i.equalsIgnoreCase("Banana")).count();
        long melonCount = items.stream().filter(i -> i.equalsIgnoreCase("Melon")).count();
        long limeCount = items.stream().filter(i -> i.equalsIgnoreCase("Lime")).count();

        // Prices
        int applePrice = 35;
        int bananaPrice = 20;
        int melonPrice = 50;
        int limePrice = 15;

        total += appleCount * applePrice;

        total += bananaCount * bananaPrice;

        total += ((melonCount / 2) + (melonCount % 2)) * melonPrice;

        total += ((limeCount / 3) * 2 * limePrice) + ((limeCount % 3) * limePrice);

        return total;
    }
}
