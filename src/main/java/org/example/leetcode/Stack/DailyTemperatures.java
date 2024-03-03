package org.example.leetcode.Stack;

import org.example.leetcode.Task;

import java.util.Stack;

public class DailyTemperatures implements Task {

    public static void main(String[] args) {
        System.out.println(dailyTemperatures(new int[]{89, 62, 70, 58, 47, 47, 46, 76, 100, 70}));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.empty() && temperatures[i] > temperatures[stack.peek()]) {
                int indexOfSTackElement = stack.pop();
                result[indexOfSTackElement] = i - indexOfSTackElement;
            }
            stack.add(i);
        }
        return result;
    }

    @Override
    public String getLink() {
        return null;
    }

    @Override
    public void getMySolution() {
//        public static int[] dailyTemperatures(int[] temperatures) {
//            int[] result = new int[temperatures.length];
//            Stack<Pair> stack = new Stack<>();
//
//            //Помещаем в стек первый элемент
//            stack.add(new Pair(temperatures[0], 0));
//
//            //Начинаем итерацию со второго элемента массива
//            for (int i = 1; i < temperatures.length; i++) {
//                //Начинаем сравнивать элемент массива со всем элементами стека, начиная с конца
//                while (true) {
//                    //Если стек пустой, значит итерироваться уже нельзя
//                    if (stack.empty()) {
//                        break;
//                    }
//
//                    //Достаем последний добавленный элемент стека
//                    Pair topStackElement = stack.peek();
//
//                    //Если значение элемента массива больше, значения элемента в стеке
//                    if (temperatures[i] > topStackElement.value) {
//
//                        //То записываем на место индекса элемента стека значение разницы индексов двух чисел
//                        int indexOfStackTopElement = topStackElement.indexInArray;
//                        result[indexOfStackTopElement] = i - indexOfStackTopElement;
//
//                        //Вынимаем этот элемент из стека
//                        stack.pop();
//
//                        //Таким образом мы проходимся по стеку и находим все числа, которые меньше текущего числа из массива,
//                        //и записываем, как далеко от него они расположены
//                    } else {
//                        //Если значение текущего числа меньше элемента из стека, значит дальше идти смысла нет
//                        break;
//                    }
//                }
//                //После сравнения числа из массива со всеми числами из стека, добавляем этот элемент в стек.
//                stack.add(new Pair(temperatures[i], i));
//            }
//
//            return result;
//        }
//
//        public static class Pair {
//            private final int value;
//            private final int indexInArray;
//
//            public Pair(int value, int indexInArray) {
//                this.value = value;
//                this.indexInArray = indexInArray;
//            }
//        }
    }

    @Override
    public void getOptimizeSolution() {
//        int[] result = new int[temperatures.length];
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 0; i < temperatures.length; i++) {
//            while (!stack.empty() && temperatures[i] > temperatures[stack.peek()]) {
//                int indexOfSTackElement = stack.pop();
//                result[indexOfSTackElement] = i - indexOfSTackElement;
//            }
//            stack.add(i);
//        }
//        return result;

        //Объяснение
        //Сравниваем элемент массива со всеми элементами стека
//            //Если число больше, чем число в стеке, то в результирующем массиве
//            //под индексом элеиента из стека ставим разницу положений текущего элемента
//            //и элемента из стека.

        //В стеке мы можем хранить не само число, а его индекс, т.к. значение числа
        //мы всегда можем найти по индексу из исходного массива
    }

    @Override
    public String getTimeComplexity() {
        return "O(n)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(n)";
    }
}
