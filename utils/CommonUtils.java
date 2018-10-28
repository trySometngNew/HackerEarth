/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sourabh.internet.archieves.utils;

import hackerearth.HackerEarth;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sourabh
 */
public class CommonUtils {

    /**
     * Determine lexicographic score of phrase
     * @param phrase
     * @return
     */
    public static int lexicographicScore(String phrase) {
        String[] alphabetArr = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N",
                "O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        List<String> alphabetList = new ArrayList<>();
        alphabetList = Arrays.asList(alphabetArr);
        Integer[] phraseArr = new Integer[phrase.length()];
        // Create Phrase Alphabets code point mapping
        for(int index=0; index<phrase.length(); index++) {
            String str = (String) String.valueOf(phrase.charAt(index));
            int alphabetIndex = alphabetList.indexOf(str);
            phraseArr[index] = alphabetIndex;
        }
        List<Integer> phraseCodeList = Arrays.asList(phraseArr);
    }

    public static int numberOfDivisors(int number) {
        int nod = 0;
        int sqRoot = (int) Math.sqrt(number);
        for (int index = 1; index < sqRoot; index++) {
            if (number % index == 0) {
                nod += 2;
            }
            if ((sqRoot * sqRoot) == number) {
                nod--;
            }
        }
        return nod;
    }

    /**
     * Determines whether given number is palindrome
     *
     * @param number
     * @return
     */
    public static boolean isPalindrome(long number) {
        if (number % 10 != 0) {
            long reverse = 0;
            long localNum = number;
            while (localNum > 0) {
                reverse = (reverse * 10) + localNum % 10;
                localNum /= 10;
            }
            if (reverse == number) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param upperLimit
     * @return
     */
    public static Integer[] getPrimeNumberArr(int upperLimit) {
        ArrayList<Integer> primeNumberArr = new ArrayList<>();
        if (upperLimit > 1) {
            primeNumberArr.add(2);
            for (int index = 3; index <= upperLimit; index += 2) {
                if (isPrimeNumber(index)) {
                    primeNumberArr.add(index);
                }
            }
        } else {
            return null;
        }

        primeNumberArr.trimToSize();
        return primeNumberArr.toArray(new Integer[primeNumberArr.size()]);
    }

    public static boolean isPrimeNumber(long number) {
        if ((number > 1) && (number & 1) == 1) {
            for (int i = 3; (i * i) <= number; i += 2) {
                if (number % i == 0) {
//                    System.out.println(i+" factorOf " + number);
                    return false;
                }
            }
            return true;
        } else if (number == 2) {
            return true;
        }
        return false;
    }

    public static long largestPrimeFactor(long number) {

        for (long i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) {
                number /= i;
                i = 1;
            }
        }
        return number;
    }

}
