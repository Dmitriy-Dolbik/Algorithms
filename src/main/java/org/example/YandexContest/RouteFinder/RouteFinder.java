package org.example.YandexContest.RouteFinder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://contest.yandex.ru/contest/8458/problems/G/
 * (не проходит 15-й тест, почему не понятно. Вроде все правильно)
 */

public class RouteFinder {
    public static BufferedReader bufferedReader;
    public static BufferedWriter bufferedWriter;
    public static final String INPUT_FILE = "input.txt";
    public static final String OUTPUT_FILE = "output.txt";


    public static void main(String[] args) throws IOException {
        initSource();
        run();
        closeSource();
    }

    private static void run() throws IOException {
        int countOfCities = Integer.parseInt(bufferedReader.readLine().trim());
        int[][] citiesWithXY = new int[countOfCities + 1][2];
        for (int i = 1; i <= countOfCities; i++) {
            String xyLine = bufferedReader.readLine();
            String[] xy = xyLine.split(" ");
            citiesWithXY[i][0] = Integer.parseInt(xy[0]);
            citiesWithXY[i][1] = Integer.parseInt(xy[1]);
        }
        int maxDistance = Integer.parseInt(bufferedReader.readLine());
        String[] fromCityAndToCity = bufferedReader.readLine().trim().split(" ");
        int fromCityIndex = Integer.parseInt(fromCityAndToCity[0]);
        int toCityIndex = Integer.parseInt(fromCityAndToCity[1]);

        if (fromCityIndex == toCityIndex) {
            bufferedWriter.write(String.valueOf(-1));
        }
        bufferedWriter.write(String.valueOf(bfs(fromCityIndex, toCityIndex, countOfCities, citiesWithXY, maxDistance)).trim());
    }

    //поиск в ширину
    public static int bfs(int fromCityIndex, int toCityIndex, int countOfCities, int[][] citiesWithXY, int maxDistance) {
        Set<Integer> visitedCities = new HashSet<>();
        Queue<int[]> cityAndCountOfRoads = new LinkedList<>();
        cityAndCountOfRoads.add(new int[]{fromCityIndex, 0});//помещаем в очередь город и количество дорог, которое к нему привело
        visitedCities.add(fromCityIndex);//здесь сохраняем города, в которых мы уже были

        while (!cityAndCountOfRoads.isEmpty()) {//начинаем с начального города
            int[] currentCityAndCountOfRoads = cityAndCountOfRoads.poll();
            int currentCityIndex = currentCityAndCountOfRoads[0];//достаем из очереди город
            int countRoads = currentCityAndCountOfRoads[1];////достаем из очереди количество дорог, которое мы преодолели

            if (currentCityIndex == toCityIndex) {
                return countRoads;//если текущий город равен городу, в который мы должны были приехать, то возвращаем количество дорог
            }

            for (int cityIndex = 1; cityIndex <= countOfCities; cityIndex++) {//проходимся по всем городам
                //проверяем посещали ли мы уже этот город
                //и находим расстояние между текущим городом и каждый городом из списка
                if (!visitedCities.contains(cityIndex) && getDistanceBetween(citiesWithXY[currentCityIndex], citiesWithXY[cityIndex]) <= maxDistance) {
                    //добавляем в очередь город в который мы пришли и увеличиваем счетчик дорог на один
                    cityAndCountOfRoads.add(new int[]{cityIndex, countRoads + 1});
                    visitedCities.add(cityIndex);//запоминаем город в который мы пришли
                }
                //Главная идея. Мы берем точку и проверяем все возможные точки из списка до которых мы можем дойти за максимальное количество дорог.
                //начинаем с начальной точки конечно же
            }
        }
        return -1;
    }

    public static int getDistanceBetween(int[] firstCoordinates, int[] secondCoordinates) {
        int x1 = firstCoordinates[0];
        int x2 = secondCoordinates[0];
        int y1 = firstCoordinates[1];
        int y2 = secondCoordinates[1];

        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    private static void initSource() throws IOException {
        bufferedReader = new BufferedReader(new FileReader(INPUT_FILE));
        bufferedWriter = new BufferedWriter(new FileWriter(OUTPUT_FILE));
    }

    private static void closeSource() throws IOException {
        bufferedReader.close();
        bufferedWriter.close();
    }
}
