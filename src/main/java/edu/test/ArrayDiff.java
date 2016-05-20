package edu.test;

import org.apache.log4j.Logger;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Created by kash on 5/19/16.
 */
public class ArrayDiff {
    public static int[] randomIntegers = {1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16, 19, 1, 18, 4, 9, 3, 20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16, 3, 6, 19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11};
    private static Logger log = Logger.getLogger(ArrayDiff.class);

    public static void main(String[] args) {
        log.debug("Start computing...");
        removeDuplicate();
        removeDuplicateUsingSet();
        removeDuplicateUsingConcurrentSet();
    }

    private static void removeDuplicate() {
        log.debug("Removing duplicate using List......");
        List<Integer> uniqueList = new ArrayList();
        log.debug("Actual size of int array:" + randomIntegers.length);
        log.debug(Arrays.toString(randomIntegers));
        for (int i = 0; i < randomIntegers.length; i++) {
            if (!isAdded(uniqueList, randomIntegers[i])) {
                uniqueList.add(randomIntegers[i]);
            }

        }
        log.debug("refined size of int array: " + uniqueList.size());
        log.debug(uniqueList.toString());
    }

    private static boolean isAdded(List<Integer> uniqueList, int randomInteger) {
        if (uniqueList.contains(randomInteger)) {
            return true;
        }
        return false;
    }

    public static void removeDuplicateUsingSet() {
        Set<Integer> uniqueSet = new HashSet<>();
        log.debug("Removing duplicate using Set......");
        log.debug("Actual size of int array:" + randomIntegers.length);
        for (int i = 0; i < randomIntegers.length; i++) {
            uniqueSet.add(randomIntegers[i]);
        }
        log.debug("refined size of int array using Set: " + uniqueSet.size());
        log.debug(Arrays.toString(uniqueSet.toArray()));
    }
    public static void removeDuplicateUsingConcurrentSet() {
        Set<Integer> uniqueSet = new ConcurrentSkipListSet<>();
        log.debug("Removing duplicate using concurrent Set......");
        log.debug("Actual size of int array:" + randomIntegers.length);
        for (int i = 0; i < randomIntegers.length; i++) {
            uniqueSet.add(randomIntegers[i]);
        }
        log.debug("refined size of int array using Set: " + uniqueSet.size());
        log.debug(Arrays.toString(uniqueSet.toArray()));
    }

}
