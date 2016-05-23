package edu.test;

import edu.test.exception.ComputationException;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Created by kash on 5/19/16.
 */
public class ArrayDiff {
    private int[] randomArray;

    public ArrayDiff(int[] intArray) {
        this.randomArray = intArray;
    }


    private static Logger log = Logger.getLogger(ArrayDiff.class);

    public List removeDuplicate() throws ComputationException {
        log.debug("Removing duplicate using List......");
        List<Integer> uniqueList = new ArrayList();
        int[] intArray = getRandomArray();
        log.debug("Actual size of int array:" + intArray.length);
        log.debug(Arrays.toString(intArray));
        for (int i = 0; i < intArray.length; i++) {
            if (!isAdded(uniqueList, intArray[i])) {
                uniqueList.add(intArray[i]);
            }

        }
        log.debug("refined size of int array: " + uniqueList.size());
        log.debug(uniqueList.toString());
        return uniqueList;

    }

    public Set removeDuplicateUsingSet() throws ComputationException {
        Set<Integer> uniqueSet = new HashSet<>();
        log.debug("Removing duplicate using Set......");
        int[] intArray = getRandomArray();
        log.debug("Actual size of int array:" + intArray.length);
        for (int i = 0; i < intArray.length; i++) {
            uniqueSet.add(intArray[i]);
        }
        log.debug("refined size of int array using Set: " + uniqueSet.size());
        log.debug(Arrays.toString(uniqueSet.toArray()));
        return uniqueSet;
    }

    public Set removeDuplicateUsingConcurrentSet() throws ComputationException {
        Set<Integer> uniqueSet = new ConcurrentSkipListSet<>();
        log.debug("Removing duplicate using concurrent Set......");
        int[] intArray = getRandomArray();
        log.debug("Actual size of int array:" + intArray.length);
        for (int i = 0; i < intArray.length; i++) {
            uniqueSet.add(intArray[i]);
        }
        log.debug("refined size of int array using Set: " + uniqueSet.size());
        log.debug(Arrays.toString(uniqueSet.toArray()));
        return uniqueSet;
    }

    private int[] getRandomArray() throws ComputationException {
        if (randomArray == null || randomArray.length == 0) {
            throw new ComputationException("Unable to compute");
        }
        return randomArray;
    }

    private boolean isAdded(List<Integer> uniqueList, int randomInteger) {
        if (uniqueList.contains(randomInteger)) {
            return true;
        }
        return false;
    }


}
