package org.example.yandex.interview;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class LengthOfTheLongestStringWithoutDuplicateCharactersDeterminerTest {

    private LengthOfLongestSubstringDeterminer determiner = new LengthOfLongestSubstringDeterminer();

    @Test
    public void getCombinedIntersectingIntervalsTest_whenStringIsBlank_shouldReturnZero() {
        //Given
        String testString = "";

        //When
        int actual = determiner.find(testString);

        //Then
        assertEquals(0, actual);
    }

    @Test
    public void getCombinedIntersectingIntervalsTest_shouldReturnOne() {
        //Given
        String testString = "a";

        //When
        int actual = determiner.find(testString);

        //Then
        assertEquals(1, actual);
    }

    @Test
    public void getCombinedIntersectingIntervalsTest_shouldReturnOne_2() {
        //Given
        String testString = "aa";

        //When
        int actual = determiner.find(testString);

        //Then
        assertEquals(1, actual);
    }

    @Test
    public void getCombinedIntersectingIntervalsTest_shouldReturnTwo() {
        //Given
        String testString = "aab";

        //When
        int actual = determiner.find(testString);

        //Then
        assertEquals(2, actual);
    }

    @Test
    public void getCombinedIntersectingIntervalsTest_shouldReturnTwo_2() {
        //Given
        String testString = "aabbc";

        //When
        int actual = determiner.find(testString);

        //Then
        assertEquals(2, actual);
    }

    @Test
    public void getCombinedIntersectingIntervalsTest_shouldReturnTwo_3() {
        //Given
        String testString = "aabbc";

        //When
        int actual = determiner.find(testString);

        //Then
        assertEquals(2, actual);
    }

    @Test
    public void getCombinedIntersectingIntervalsTest_shouldReturnTwo_4() {
        //Given
        String testString = "dvdf";

        //When
        int actual = determiner.find(testString);

        //Then
        assertEquals(3, actual);
    }

    @Test
    public void getCombinedIntersectingIntervalsTest_shouldReturnThree() {
        //Given
        String testString = "abc";

        //When
        int actual = determiner.find(testString);

        //Then
        assertEquals(3, actual);
    }

    @Test
    public void getCombinedIntersectingIntervalsTest_shouldReturnThree_2() {
        //Given
        String testString = "aaabc";

        //When
        int actual = determiner.find(testString);

        //Then
        assertEquals(3, actual);
    }

    @Test
    public void getCombinedIntersectingIntervalsTest_shouldReturnThree_3() {
        //Given
        String testString = "abbaabc";

        //When
        int actual = determiner.find(testString);

        //Then
        assertEquals(3, actual);
    }

    @Test
    public void getCombinedIntersectingIntervalsTest_shouldReturnThree_4() {
        //Given
        String testString = "abcabcbb";

        //When
        int actual = determiner.find(testString);

        //Then
        assertEquals(3, actual);
    }

    @Test
    public void getCombinedIntersectingIntervalsTest_shouldReturnThree_5() {
        //Given
        String testString = "aaabaacabc";

        //When
        int actual = determiner.find(testString);

        //Then
        assertEquals(3, actual);
    }

    @Test
    public void getCombinedIntersectingIntervalsTest_shouldReturnThree_6() {
        //Given
        String testString = "pwwkew";

        //When
        int actual = determiner.find(testString);

        //Then
        assertEquals(3, actual);
    }

}