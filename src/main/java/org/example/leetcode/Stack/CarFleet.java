package org.example.leetcode.Stack;

import org.example.leetcode.Task;

import java.util.ArrayList;
import java.util.List;

public class CarFleet implements Task {

    public static void main(String[] args) {
        System.out.println(carFleet(12, new int[]{10,8,0,5,3,6}, new int[]{2,4,1,1,3,6}));
    }

    public static int carFleet(int target, int[] position, int[] speed) {
        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < position.length; i++) {
            int carPosition = position[i];
            int carSpeed = speed[i];
            double carTimeTODestination = (double) (target - carPosition) / carSpeed;
            carList.add(new Car(carPosition, carTimeTODestination));
        }

        carList.sort((car1, car2) -> car2.position - car1.position);

        int carFleetCount = 0;
        double previousTimeToDestination = 0.0;
        for (Car car : carList) {
            if (car.getTimeToDestination() > previousTimeToDestination) {
                carFleetCount++;
                previousTimeToDestination = car.getTimeToDestination();
            }
        }
        return carFleetCount;
    }

    private static class Car {
        private int position;
        private double timeToDestination;

        public Car(int position, double timeToDestination) {
            this.position = position;
            this.timeToDestination = timeToDestination;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public double getTimeToDestination() {
            return timeToDestination;
        }

        public void setTimeToDestination(double timeToDestination) {
            this.timeToDestination = timeToDestination;
        }
    }

    @Override
    public String getLink() {
        return "https://leetcode.com/problems/car-fleet/description/";
    }

    @Override
    public void getMySolution() {
//        int carFleetCount = 0;
//
//        //Формируем массив времени до пункта назначения, где индекс массива, это начальня точка старта
//        //Т.е. мы видим сколько времени понадобится машине на каждой точке старта [12.0, 0.0, 0.0, 3.0, 0.0, 7.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0]
//        double[] timesToDestination = new double[target];
//        for (int i = 0; i < position.length; i++) {
//            timesToDestination[position[i]] = (double) (target - position[i]) / speed[i];
//        }
//
//        //Дальше мы пробегаемся по полученному массиву справа налево и сравниваем время.
//        //Если время больше, чем время предыдущего, значит эта машина никогда не догонит
//        //впереди идущую, и значит счетчик можно увеличить на один
//        double previousTimeToDestination = 0.0;
//        for (int i = timesToDestination.length - 1; i >= 0; i--) {
//            double currentTimeToDestination = timesToDestination[i];
//            if (currentTimeToDestination > previousTimeToDestination) {
//                previousTimeToDestination = currentTimeToDestination;
//                carFleetCount++;
//            }
//        }
//
//        return carFleetCount;
    }

    @Override
    public void getOptimizeSolution() {
        //Первое решение
//
//        //Формируем массив времени до пункта назначения, где индекс массива, это начальня точка старта
//        //Т.е. мы видим сколько времени понадобится машине на каждой точке старта [12.0, 0.0, 0.0, 3.0, 0.0, 7.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0]
//        double[] timesToDestination = new double[target];
//        for (int i = 0; i < position.length; i++) {
//            timesToDestination[position[i]] = (double) (target - position[i]) / speed[i];
//        }
//
//        //Дальше мы пробегаемся по полученному массиву справа налево и сравниваем время.
//        //Если время больше, чем время предыдущего, значит эта машина никогда не догонит
//        //впереди идущую, и значит счетчик можно увеличить на один
//        int carFleetCount = 0;
//        double previousTimeToDestination = 0.0;
//        for (int i = timesToDestination.length - 1; i >= 0; i--) {
//            double currentTimeToDestination = timesToDestination[i];
//            if (currentTimeToDestination > previousTimeToDestination) {
//                previousTimeToDestination = currentTimeToDestination;
//                carFleetCount++;
//            }
//        }
//
//        return carFleetCount;

        //Второе решение через сортировку.
        //1. Создаем список машин с позициями и временем движения
        //2. Сортируем его от большей позиции к меньшей
        //3. Если времня двиджения больше, чем у предыдущей, то увеличиваем счетчик
//        public static int carFleet(int target, int[] position, int[] speed) {
//            List<Car> carList = new ArrayList<>();
//
//            for (int i = 0; i < position.length; i++) {
//                int carPosition = position[i];
//                int carSpeed = speed[i];
//                double carTimeTODestination = (double) (target - carPosition) / carSpeed;
//                carList.add(new Car(carPosition, carTimeTODestination));
//            }
//
//            carList.sort((car1, car2) -> car2.position - car1.position);
//
//            int carFleetCount = 0;
//            double previousTimeToDestination = 0.0;
//            for (Car car : carList) {
//                if (car.getTimeToDestination() > previousTimeToDestination) {
//                    carFleetCount++;
//                    previousTimeToDestination = car.getTimeToDestination();
//                }
//            }
//            return carFleetCount;
//        }
//
//        private static class Car {
//            private int position;
//            private double timeToDestination;
//
//            public Car(int position, double timeToDestination) {
//                this.position = position;
//                this.timeToDestination = timeToDestination;
//            }
//
//            public int getPosition() {
//                return position;
//            }
//
//            public void setPosition(int position) {
//                this.position = position;
//            }
//
//            public double getTimeToDestination() {
//                return timeToDestination;
//            }
//
//            public void setTimeToDestination(double timeToDestination) {
//                this.timeToDestination = timeToDestination;
//            }
    }

    @Override
    public String getTimeComplexity() {
        return "O(nlogn)";//т.к. нужно отсортировать машины в порядке их расположения
    }

    @Override
    public String getSpaceComplexity() {
        return "O(n)";
    }
}
