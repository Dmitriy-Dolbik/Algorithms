package org.example.yandex.interview;

import org.junit.Assert;
import org.junit.Test;

public class ZeroToEndTest {

    private ZeroToEnd zeroToEnd = new ZeroToEnd();

    @Test
    public void replaceZeroToTheEndTest_shouldMoveZeroes() {
        //Given
        int[] initArray = new int[]{0, 1, 0, 2, 0, 3};

        //When
        zeroToEnd.moveZeroes(initArray);

        //Then
        int[] expected = new int[]{1,2,3,0,0,0};
        Assert.assertArrayEquals(expected, initArray);
    }

    @Test
    public void replaceZeroToTheEndTest_shouldMoveZeroes_2() {
        //Given
        int[] initArray = new int[]{5, 1, 0, 2, 0, 3};

        //When
        zeroToEnd.moveZeroes(initArray);

        //Then
        int[] expected = new int[]{5,1,2,3,0,0};
        Assert.assertArrayEquals(expected, initArray);
    }

}