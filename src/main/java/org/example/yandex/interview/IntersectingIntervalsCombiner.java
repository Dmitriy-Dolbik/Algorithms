package org.example.yandex.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Дан массив интервалов, где intervals[i] = [start, end],
 * объедините все пересекающиеся интервалы
 * и верните массив непересекающихся интервалов.
 * Вход: [[2,6], [1,3], [8,10], [15, 18]]
 * Выход: [[1,6], [8,10], [15,18]]
 *
 * Суть решения:
 * 1. Сортируем массив по началу интервалов
 * 2. Заводим переменную предыдущего интервала
 * 3. Пробегаемся по оставшимся элементам отсортированного массива
 * 4. Если конец предыдущего интервала больше начала следубщего,
 *    то конце предыдущего интервала становится большим из концов предыдущего интервала и следующего
 * 5. Если конце предыдущего интервала не больше начала следующего
 *    то помещаем предыдущеий ингтервал в результирующий список
 * 6. После перебора всех элементов добавляем предыдущий интервал в результирующий список
 */
public class IntersectingIntervalsCombiner {

    public static void main(String[] args) {
        int[][] intervalsArray = new int[][]{
                new int[]{2, 5},
                new int[]{1, 3},
                new int[]{15, 18},
                new int[]{8, 10}
        };

        int[][] combinedIntervals = getCombinedIntersectingIntervals(intervalsArray);

        for (int[] interval : combinedIntervals) {
            System.out.println(interval[0] + ", " + interval[1]);
        }
    }

//    private static int[][] getCombinedIntersectingIntervals(int[][] initIntervals) {
//        //сортируем массив интервалов относительно старта интервалов
//        Arrays.sort(initIntervals, Comparator.comparingInt(interval -> interval[0]));
//
//        List<int[]> result = new ArrayList<>();
//
//        //сохраняем первый интервал в переменную
//        int[] prev = initIntervals[0];
//
//        //пробегаемся по оставшимся интервалам
//        for (int i = 1; i < initIntervals.length; i++) {
//            int[] interval = initIntervals[i];
//
//            //если конец предыдущего интервала больше начала текущего интервала
//            if (prev[1] >= interval[0]) {
//
//                //то конце предыдущего интервала теперь будет максимальное из концов предыдущего и текущего
//                //если были интервалы (1, 7) и (4, 5), то результирующий будет (1, 7);
//                prev[1] = Math.max(prev[1], interval[1]);
//            } else {
//                //иначе интервалы не пересекаются и предыдущий интервал можно записать в массив
//                //а следующий интервал записать, как предыдущий.
//                result.add(prev);
//                prev = interval;
//            }
//        }
//        //в самом конце добавляем интервал каким юы он не был, т.к. он последний
//        result.add(prev);
//
//        return result.toArray(new int[result.size()][2]);
//    }

    private static int[][] getCombinedIntersectingIntervals(int[][] initIntervals) {
        Arrays.sort(initIntervals, Comparator.comparingInt(interval -> interval[0]));

        List<int[]> combinedIntervals = new ArrayList<>();
        int[] previousInterval = initIntervals[0];


        for (int i = 1; i < initIntervals.length; i++) {
            int[] nextInterval = initIntervals[i];
            if (previousInterval[1] > nextInterval[0]) {
                previousInterval[1] = Math.max(previousInterval[1], nextInterval[1]);
            } else {
                combinedIntervals.add(previousInterval);
                previousInterval = nextInterval;
            }
        }

        combinedIntervals.add(previousInterval);

        return combinedIntervals.toArray(new int[combinedIntervals.size()][2]);
    }


}
