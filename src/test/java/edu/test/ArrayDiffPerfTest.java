package edu.test;

import edu.test.exception.ComputationException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

/**
 * Created by kash on 5/19/16.
 */
public class ArrayDiffPerfTest {
    private ArrayDiff arrayDiff;
    private int[] negativeValduplicate = {-1, 1, 2, 1, -1, -2};
    int actual = 4;

    @Test
    public void testPerf1() throws Exception {
        arrayDiff = new ArrayDiff(negativeValduplicate);

        List response = arrayDiff.removeDuplicate();
        Assert.assertEquals(response.size(), actual, "Expect duplicate array size equal to actual list response");
    }

    @Test
    public void testPerf2() throws Exception {
        arrayDiff = new ArrayDiff(negativeValduplicate);

        Set responseSet = arrayDiff.removeDuplicateUsingSet();
        Assert.assertEquals(responseSet.size(), actual, "Expect duplicate array size equal to actual set response");
    }

    @Test
    public void testPerf3() throws Exception {
        arrayDiff = new ArrayDiff(negativeValduplicate);
        Set sortedSet = arrayDiff.removeDuplicateUsingLinkedHashSet();
        Assert.assertEquals(sortedSet.size(), actual, "Expect duplicate array size equal to actual concurrent set response");
        Integer lastItem = ((Integer) sortedSet.toArray()[sortedSet.size() - 1]);
        Assert.assertTrue(lastItem.equals(-2));
    }

}
