package org.example.YandexContest;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Требуется найти в бинарном векторе самую длинную последовательность единиц и вывести её длину.
 * Желательно получить решение, работающее за линейное время и при этом проходящее по входному массиву только один раз.
 * https://contest.yandex.ru/contest/8458/problems/B/?success=106595537#1037/2018_06_24/jOG2TVJEbW
 * Пример
 * Ввод	Вывод
 * 5    1
 * 1
 * 0
 * 1
 * 0
 * 1
 */
public class MaxOnesSequenceCounter {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int countOfLinesWithOneOrZero = Integer.parseInt(br.readLine());
        int maxOnesSequanceSize = 0;
        int onesSequanceSize = 0;
        for (int i = 0; i < countOfLinesWithOneOrZero; i++) {
            int contentLine = Integer.parseInt(br.readLine());
            if (contentLine == 1) {
                onesSequanceSize++;
            }
            if (contentLine == 0 || i == countOfLinesWithOneOrZero - 1) {
                if (maxOnesSequanceSize < onesSequanceSize) {
                    maxOnesSequanceSize = onesSequanceSize;
                }
                onesSequanceSize = 0;
            }
        }
        System.out.println(maxOnesSequanceSize);
    }
}
