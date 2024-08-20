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
        //Идея:
        //Мы считаываем число строк
        //В цикле считываем значения строк (0 или 1)
        //Если это 1, то увеличиваем счетчик единиц
        //Если это 0, то записисываем сетчик в другую переменную
        // (если её значнние меньше текущего значения счетчика) и обнуляем счетчик
        //И так повторяем цикл

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int countOfLinesWithOneOrZero = Integer.parseInt(br.readLine());
        int maxOnesSequenceSize = 0;
        int onesSequenceSize = 0;
        for (int i = 0; i < countOfLinesWithOneOrZero; i++) {
            int contentLine = Integer.parseInt(br.readLine());
            if (contentLine == 1) {
                onesSequenceSize++;
            }
            if (contentLine == 0 || i == countOfLinesWithOneOrZero - 1) {
                if (maxOnesSequenceSize < onesSequenceSize) {
                    maxOnesSequenceSize = onesSequenceSize;
                }
                onesSequenceSize = 0;
            }
        }
        System.out.println(maxOnesSequenceSize);
    }
}
