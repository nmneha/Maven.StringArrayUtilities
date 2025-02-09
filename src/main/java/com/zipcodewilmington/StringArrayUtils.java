package com.zipcodewilmington;

import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return array[array.length - 1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length - 2];
    }

    /**
     * @param array array of String objects
     * @param s     value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String s) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == s) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        String reverse = "";
        for (int i = 0; i <= array.length / 2; i++) {
            reverse = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = reverse;
        }
        return array;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        return (Arrays.equals(array, StringArrayUtils.reverse(Arrays.copyOf(array, array.length))));
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        String pangramic = Arrays.toString(array).toLowerCase();
        char letter = 'a';
        for (int i = 1; i <= 26; i++) {
            if (!pangramic.contains((String.valueOf(letter)))) {
                return false;
            } else {
                letter++;
            }

        }
        return true;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                count++;
            }
        }

        return count;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        String[] removed;
        int count = 0;
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(valueToRemove)) {
                count++;

            }
        }
        removed = new String[array.length - count];
        for (int i = 0; i < array.length; i++) {
            if (!array[i].equals(valueToRemove)) {
                removed[j] = array[i];
                j++;
            }
        }
        return removed;
    }
    //List<String> nList = new ArrayList<>(Array.asList(array));
    //nList.removeAll(Array.asList(valueToRemove));
    //array = nList.toArray(newString[0]);
    //return array;


    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        String[] stray;
        int count = 0;
        int j = 0;
        String duplicate = "";
        for (int i = 0; i < array.length; i++) {
            if (!array[i].equals(duplicate)) {
                duplicate = array[i];
            } else {
                count++;
            }
        }
        stray = new String[array.length - count];
        for (int i = 0; i < array.length; i++) {
            if (!array[i].equals(duplicate)) {
                stray[j] = array[i];
                duplicate = array[i];
                j++;
            }

        }
        return stray;
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        int count = 0;
        int length = array.length;
        String[] stray = new String[length];
        for (int i = 0; i < array.length; i++) {
            stray[count] = array[i];
            while(i+1 < array.length && array[i].equals(array[i+1])) {
                stray[count] += array[i];
                i++;
            }
            count++;
        }

        String[] nStray = Arrays.copyOfRange(stray, 0, count);
        return nStray;


    }
}

