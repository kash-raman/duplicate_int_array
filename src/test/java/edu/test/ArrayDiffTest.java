package edu.test;

import edu.test.exception.ComputationException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

/**
 * Created by kash on 5/19/16.
 */
public class ArrayDiffTest {
    private ArrayDiff arrayDiff;
    private int[] emptyArray = {};
    private int[] unique = {5, 2, 3, 4, 1};
    private int[] duplicate = {1, 1, 45, 45};
    private int[] negativeValduplicate = {-1, 1, 2, 1, -1,-2};

    @Test(expectedExceptions = ComputationException.class)
    public void testnull() throws Exception {
        arrayDiff = new ArrayDiff(null);
        arrayDiff.removeDuplicate();
    }

    @Test(expectedExceptions = ComputationException.class)
    public void testEmpty() throws Exception {
        arrayDiff = new ArrayDiff(emptyArray);
        arrayDiff.removeDuplicate();
    }

    @Test
    public void testBasic() throws Exception {
        arrayDiff = new ArrayDiff(unique);
        List response = arrayDiff.removeDuplicate();
        Set responseSet = arrayDiff.removeDuplicateUsingSet();
        Set sortedSet = arrayDiff.removeDuplicateUsingLinkedHashSet();
        Assert.assertEquals(response.size(), unique.length, "Expect unique array size equal to actual list response");
        Assert.assertEquals(responseSet.size(), unique.length, "Expect unique array size equal to actual set response");
        Assert.assertEquals(sortedSet.size(), unique.length, "Expect unique array size equal to actual concurrent set response");
        Integer lastItem = ((Integer) sortedSet.toArray()[sortedSet.size() - 1]);
        Assert.assertTrue(lastItem.equals(1));
    }
    @Test
    public void testDuplicate() throws Exception {
        arrayDiff = new ArrayDiff(duplicate);
        int actual = 2;
        List response = arrayDiff.removeDuplicate();
        Set responseSet = arrayDiff.removeDuplicateUsingSet();
        Set sortedSet = arrayDiff.removeDuplicateUsingLinkedHashSet();
        Assert.assertEquals(response.size(), actual, "Expect duplicate array size equal to actual list response");
        Assert.assertEquals(responseSet.size(), actual, "Expect duplicate array size equal to actual set response");
        Assert.assertEquals(sortedSet.size(), actual, "Expect duplicate array size equal to actual concurrent set response");
        Integer lastItem = ((Integer) sortedSet.toArray()[sortedSet.size() - 1]);
        Assert.assertTrue(lastItem.equals(45));
    }

    @Test
    public void testDuplicate_negative() throws Exception {
        arrayDiff = new ArrayDiff(negativeValduplicate);
        int actual = 4;
        List response = arrayDiff.removeDuplicate();
        Set responseSet = arrayDiff.removeDuplicateUsingSet();
        Set sortedSet = arrayDiff.removeDuplicateUsingLinkedHashSet();
        Assert.assertEquals(response.size(), actual, "Expect duplicate array size equal to actual list response");
        Assert.assertEquals(responseSet.size(), actual, "Expect duplicate array size equal to actual set response");
        Assert.assertEquals(sortedSet.size(), actual, "Expect duplicate array size equal to actual concurrent set response");
        Integer lastItem = ((Integer) sortedSet.toArray()[sortedSet.size() - 1]);
        Assert.assertTrue(lastItem.equals(-2));
    }

}
