package org.example.YandexContest.RouteFinder.solution3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Источник
 * https://www.youtube.com/watch?v=pyDS_sTSsFo&t=547s
 */
public class RouteFinder3 {
    public static BufferedReader bufferedReader;
    public static BufferedWriter bufferedWriter;
    public static final String INPUT_FILE = "input.txt";
    public static final String OUTPUT_FILE = "output.txt";

    public static void main(String[] args) throws IOException {
        init();
        run();
        close();
    }

    private static void run() throws IOException {
        int citiesCount = Integer.parseInt(bufferedReader.readLine().trim());

        Graph graph = new Graph();
        for (int i = 0; i < citiesCount; i++) {
            String[] cityXY = bufferedReader.readLine().trim().split(" ");
            int x = Integer.parseInt(cityXY[0]);
            int y = Integer.parseInt(cityXY[1]);
            graph.addCity(new City(x, y));
        }

        int maxDistance = Integer.parseInt(bufferedReader.readLine().trim());
        String[] fromCityToCityIndexes = bufferedReader.readLine().trim().split(" ");
        int fromCityIndex = Integer.parseInt(fromCityToCityIndexes[0]);
        int toCityIndex = Integer.parseInt(fromCityToCityIndexes[1]);

        if (fromCityIndex == toCityIndex) {
            bufferedWriter.write(String.valueOf(-1));
        }

        int countOfRoads = graph.passInWidth(fromCityIndex, toCityIndex, maxDistance);

        bufferedWriter.write(String.valueOf(countOfRoads));


    }

    private static void init() throws IOException {
        bufferedReader = new BufferedReader(new FileReader(INPUT_FILE));
        bufferedWriter = new BufferedWriter(new FileWriter(OUTPUT_FILE));
    }

    private static void close() throws IOException {
        bufferedWriter.close();
        bufferedReader.close();
    }
}

class Graph {
    private final int maxCountOfCities = 1000;
    private int[][] adjacencyMatrix;
    private City[] citiesList;
    private int countOfCities;
    private final LinkedList<Integer> queue = new LinkedList<>();

    public Graph() {
        this.citiesList = new City[maxCountOfCities];
        this.adjacencyMatrix = new int[maxCountOfCities][maxCountOfCities];
        this.countOfCities = 0;
    }

    public void addCity(City city) {
        citiesList[countOfCities] = city;
        countOfCities++;
    }

    public int getNotVisitedCityFor(int fromCityIndex, int maxDistance) {
        for (int i = 0; i < countOfCities; i++) {
            if (getDistanceBetween(fromCityIndex, i) <= maxDistance && !citiesList[i].isVisited()) {
                return i;
            }
        }
        return -1;
    }

    private int getDistanceBetween(int fromCityIndex, int i) {
        City fromCity = citiesList[fromCityIndex];
        City iterratedCity = citiesList[i];
        return Math.abs(fromCity.getX() - iterratedCity.getX()) + Math.abs(fromCity.getY() - iterratedCity.getY());

    }

    public void passInDeep(int fromCityIndex, int toCityIndex, int maxDistance) {
        City fromCity = citiesList[fromCityIndex];
        fromCity.setVisited(true);
        queue.add(fromCityIndex);

        while(!queue.isEmpty()) {
            int nextCity = getNotVisitedCityFor(queue.getLast(), maxDistance);

            if  (nextCity == -1) {
                nextCity = queue.removeLast();
            } else {
                citiesList[nextCity].setVisited(true);
                queue.add(nextCity);
            }
        }
    }

    public int passInWidth(int fromCityIndex, int toCityIndex, int maxDistance) {
        int indexOfFromCityInGraf = fromCityIndex - 1;
        int indexOfToCityInGraf = toCityIndex - 1;
        LinkedList<int[]> queue = new LinkedList<>();

        citiesList[indexOfFromCityInGraf].setVisited(true);
        queue.add(new int[]{indexOfFromCityInGraf, 0});

        while (!queue.isEmpty()) {
            int[] cityIndexAndCountOfRoadsToIt = queue.removeFirst();
            int currentIndex = cityIndexAndCountOfRoadsToIt[0];
            int countOfRoads = cityIndexAndCountOfRoadsToIt[1];

            if (currentIndex == indexOfToCityInGraf) {
                return countOfRoads;
            }

            while(true) {
                int nextCityIndex = getNotVisitedCityFor(currentIndex, maxDistance);

                if (nextCityIndex == -1) {
                    break;
                }

                citiesList[nextCityIndex].setVisited(true);
                queue.add(new int[]{nextCityIndex, countOfRoads + 1});
            }
        }

        return -1;
    }
}

class City {
    private boolean isVisited;
    private final int x;
    private final int y;

    public City(int x, int y) {
        this.isVisited = false;
        this.x = x;
        this.y = y;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}