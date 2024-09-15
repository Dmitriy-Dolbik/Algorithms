package org.example.yandex.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Нужно сформировать list индексов indexesList, где
 * индекс 0 будет прсиутствовать с вероятностью probabilitiesList[0]
 * индекс 1 с вероятность probabilitiesList[1] и тд.
 */
public class WeightedChoice {

    public static void main(String[] args) {
        List<Double> probabilitiesList = List.of(0.1, 0.2, 0.3, 0.4); // Example probabilitiesList
        int sizeOfResultList = 5; // Example sizeOfResultList

        List<Integer> choices = weightedChoice(probabilitiesList, sizeOfResultList);
        System.out.println(choices);
    }

    public static List<Integer> weightedChoice(List<Double> probabilitiesList, int sizeOfResultList) {
        //формируем массив из коммулятивных сумм вероятностей
        List<Double> cumSumList = getCumulativeAmounts(probabilitiesList);
        List<Integer> indexesList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < sizeOfResultList; i++) {
            double randomNumber = random.nextDouble(); // берем рандомное число от 0 до 1
            for (int j = 0; j < cumSumList.size(); j++) { // пробегаемся по значениям коммулятивных сумм
                if (randomNumber <= cumSumList.get(j)) { // если рандомное число меньше значения коммулятивной суммы,
                    indexesList.add(j); // то запишем в результат индекс этой коммулятивной суммы
                    break;
                }
            }
        }
        return indexesList;
    }

    private static List<Double> getCumulativeAmounts(List<Double> probabilitiesList) {
        double cumulativeSum = 0;
        List<Double> cumSumList = new ArrayList<>();
        for (Double probability : probabilitiesList) {
            cumulativeSum += probability;
            cumSumList.add(cumulativeSum);
        }
        return cumSumList;
    }
}
