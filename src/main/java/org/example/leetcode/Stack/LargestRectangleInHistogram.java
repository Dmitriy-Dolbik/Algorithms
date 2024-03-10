package org.example.leetcode.Stack;

import org.example.leetcode.Task;

import java.util.Stack;

public class LargestRectangleInHistogram implements Task {

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{5,5,1,7,1,1,5,2,7,6}));
    }

    public static int largestRectangleArea(int[] heights) {
        Stack<HistoUnit> stack = new Stack<>();
        int maxHeight = 0;

        for (int i = 0; i < heights.length; i++) {
            int startIndexOfCurrentHeight = i;
            int currentHeight = heights[i];

            //Если стек не пустой или текущая высота элемента меньше высоты элемента стека, то pop'им элементы стека и считаем площади
            while (!stack.empty() && currentHeight < stack.peek().height) {
                HistoUnit stackHistoUnit = stack.pop();
                startIndexOfCurrentHeight = stackHistoUnit.index;
                int indexDifference = i - stackHistoUnit.index; //здесь считаем общую ширину всех эелеметов, в которые попадает высота элемента стека
                int squareFromStackHistoUnitToCurrentHistoUnit = stackHistoUnit.height * indexDifference;
                maxHeight = Math.max(maxHeight, squareFromStackHistoUnitToCurrentHistoUnit);
            }
            //кладем в стек элемент с индексом последнего вытащенного элемента, таким образом
            //мы всегда храним реальное количество элементов, в которые попадает данная высота
            stack.push(new HistoUnit(currentHeight, startIndexOfCurrentHeight));
        }

        //Здесь пробегаемся по оставшимся элементам стека, которые расположены в возрастающем порядке
        //и считаем их площади
        for (HistoUnit histoUnit : stack) {
            int summerSquareFromHistoUnit = histoUnit.height * (heights.length - histoUnit.index);
            maxHeight = Math.max(maxHeight, summerSquareFromHistoUnit);
        }

        return maxHeight;

        //Показательные входные данные:
        //5,5,1,7,1,1,5,2,7,6
        //3,6,5,7,4,8,1,0
    }

    @Override
    public String getLink() {
        return "https://leetcode.com/problems/largest-rectangle-in-histogram/description/";
    }

    @Override
    public void getMySolution() {
//        Stack<HistoUnit> stack = new Stack<>();
//
//        int width = 1;
//        int maxHeight = 0;
//
//        for (int i = 0; i < heights.length; i++) {
//            int currentHeight = heights[i];
//            //Если стек пустой или текущая высота больше высоты элемента в стеке, то просто кладем элемент в стек
//            if (stack.empty() || currentHeight >= stack.peek().height) {
//                stack.push(new HistoUnit(currentHeight, i));
//            }
//
//            //Если стек не пустой или текущая высота элемента меньше высоты элемента стека, то pop'им элементы стека и считаем площади
//            if (!stack.empty() && currentHeight < stack.peek().height) {
//                int indexOfLastPopedHistoUnit = 0;
//                while (!stack.empty() && currentHeight < stack.peek().height) {
//                    HistoUnit stackHistoUnit = stack.pop();
//                    indexOfLastPopedHistoUnit = stackHistoUnit.index;
//                    int squareOfHistoUnit = stackHistoUnit.height * width;
//                    int indexDifference = i - stackHistoUnit.index; //здесь считаем общую ширину всех эелеметов, в которые попадает данная высота
//                    int squareFromStackHistoUnitToCurrentHistoUnit = stackHistoUnit.height * indexDifference;
//                    maxHeight = Math.max(maxHeight, Math.max(squareOfHistoUnit, squareFromStackHistoUnitToCurrentHistoUnit));
//                }
//                //кладем в стек элемент с индексом последнего вытащенного элемента, таким образом
//                //мы всегда храним реальное количество элементов, в которые попадает данная высота
//                stack.push(new HistoUnit(currentHeight, indexOfLastPopedHistoUnit));
//            }
//        }
//
//        //Здесь пробегаемся по оставшимся элементам стека, которые расположены в возрастающем порядке
//        while (!stack.empty()) {
//            HistoUnit histoUnit = stack.pop();
//            int squareOfHistoUnit = histoUnit.height * width;
//            int summerSquareFromHistoUnit = histoUnit.height * (heights.length - histoUnit.index);
//            maxHeight = Math.max(maxHeight, Math.max(squareOfHistoUnit, summerSquareFromHistoUnit));
//        }
//
//        return maxHeight;

        //Показательные входные данные:
        //5,5,1,7,1,1,5,2,7,6
        //3,6,5,7,4,8,1,0

    }

    @Override
    public void getOptimizeSolution() {
        //Решение такое же, как MySolution, только упрощенное
        //Избавились от одного ифчика, т.к. данное условие записано в while
//        Stack<HistoUnit> stack = new Stack<>();
//        int maxHeight = 0;
//
//        for (int i = 0; i < heights.length; i++) {
//            int startIndexOfCurrentHeight = i;
//            int currentHeight = heights[i];
//
//            //Если стек не пустой или текущая высота элемента меньше высоты элемента стека, то pop'им элементы стека и считаем площади
//            while (!stack.empty() && currentHeight < stack.peek().height) {
//                HistoUnit stackHistoUnit = stack.pop();
//                startIndexOfCurrentHeight = stackHistoUnit.index;
//                int indexDifference = i - stackHistoUnit.index; //здесь считаем общую ширину всех эелеметов, в которые попадает данная высота
//                int squareFromStackHistoUnitToCurrentHistoUnit = stackHistoUnit.height * indexDifference;
//                maxHeight = Math.max(maxHeight, squareFromStackHistoUnitToCurrentHistoUnit);
//            }
//            //кладем в стек элемент с текущим индексом, либо с индексом, последнего вытащенного элемента
//            //т.к. в этом случае высоту текущего элемента можно расширить влево
//            stack.push(new HistoUnit(currentHeight, startIndexOfCurrentHeight));
//        }
//
//        //Здесь пробегаемся по оставшимся элементам стека, которые расположены в возрастающем порядке
//        //и считаем площади с учетом расширения вправо
//        for (HistoUnit histoUnit : stack) {
//            int summerSquareFromHistoUnit = histoUnit.height * (heights.length - histoUnit.index);
//            maxHeight = Math.max(maxHeight, summerSquareFromHistoUnit);
//        }
//
//        return maxHeight;
    }

    @Override
    public String getTimeComplexity() {
        return "O(n)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(n)";
    }

    private static class HistoUnit {
        private int height;
        private int index;

        public HistoUnit(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }
}
