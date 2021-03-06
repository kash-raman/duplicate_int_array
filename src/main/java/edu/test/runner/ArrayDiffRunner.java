package edu.test.runner;

import edu.test.ArrayDiff;
import edu.test.exception.ComputationException;
import org.apache.log4j.Logger;

/**
 * Created by kash on 5/22/16.
 */
public class ArrayDiffRunner {

    public static int[] randomIntegers = {1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16, 19, 1, 18, 4, 9, 3, 20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16, 3, 6, 19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11};
    private static Logger log = Logger.getLogger(ArrayDiffRunner.class);

    public static void main(String[] args) {
        ArrayDiff arrayDiff = new ArrayDiff(randomIntegers);

        log.debug("Start computing...");
        try {
            arrayDiff.removeDuplicate();
            arrayDiff.removeDuplicateUsingSet();
            arrayDiff.removeDuplicateUsingLinkedHashSet();
        } catch (ComputationException e) {
            log.error("error in processing operation", e);
        }
    }
}
