package org.example.YandexContest.RouteFinder.solution3;

import java.util.LinkedList;

public class Graph {
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
