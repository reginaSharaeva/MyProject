package ru.kpfu.itis.toyshop.sender;

import java.util.Random;
/**
 * Created by Регина on 04.04.2016.
 */
public class KeyGenerate {

    private int size = 15;

    private char letters[] = {'a', 'A', 'b', 'B', 'c', 'C',
            'd', 'D', 'e', 'E', 'f', 'F', 'g', 'G',
            'h', 'H', 'i', 'I', 'j', 'J', 'k', 'K',
            'l', 'L', 'm', 'M', 'n', 'N', 'o', 'O',
            'p', 'P', 'q', 'Q', 'r', 'R', 's', 'S',
            't', 'T', 'u', 'U', 'v', 'V', 'w', 'W',
            'x', 'X', 'y', 'Y', 'z', 'Z', 0, 1 , 2, 3, 4, 5, 6, 7, 8, 9};

    public String generate() {
        Random rand = new Random();
        String key = "";
        for(int i = 0; i < size; i++) {
            key += letters[rand.nextInt(letters.length)];
        }
        return key;
    }
}
