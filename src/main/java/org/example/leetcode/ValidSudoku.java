package org.example.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku implements Task {

    public static void main(String[] args) {                         //в разрезе переменных i и j поле судоку выглядит так
        System.out.println(isValidSudoku(                            //char[i][j] (т.е. мы его переворачиваем относительно ввода)
                                                                     //    i  0  1  2  3  4  5  6  7  8
                new char[][]{                                        //  j  ---------------------------
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},       //  0 |  .  .  .  8  .  .  .  .  .
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},       //  1 |  .  4  .  .  .  1  .  2  .
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},       //  2 |  .  .  .  .  2  5  .  .  4
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},       //  3 |  .  3  .  .  .  .  .  9  .
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},       //  4 |  5  .  .  .  7  .  .  .  .
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},       //  5 |  .  .  3  .  .  .  2  .  .
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},       //  6 |  .  .  .  .  .  .  .  .  .
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},       //  7 |  1  .  .  2  .  .  .  .  .
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}        //  8 |  .  .  1  .  .  .  .  .  .
        }));
    }

    public static boolean isValidSudoku(char[][] board) {
        Set<Character> characterSet = new HashSet<>();

        //проверяем все вертикальные строки
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                char currectChar = board[i][j];
                if ((currectChar != '.') && !characterSet.add(currectChar)) {
                    return false;
                }
            }
            characterSet.clear();
        }

        //проверяем все горизонтальные строки
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                char currectChar = board[j][i];
                if ((currectChar != '.') && !characterSet.add(currectChar)) {
                    return false;
                }
            }
            characterSet.clear();
        }

        //Проверяем все квадраты 3х3
        for (int p = 0; p < 3; p++) {//передвигаемся к следующей тройке квадратов 3х3 по вертикали
            for (int k = 0; k < 3; k++) { //передвигаемся к следующему квадрату 3х3 по горизонтали
                for (int i = 3 * k; i < 3 + k * 3; i++) {
                    for (int j = 3 * p; j < 3 + p * 3; j++) {
                        char currectChar = board[i][j];
                        if ((currectChar != '.') && !characterSet.add(currectChar)) {
                            return false;
                        }
                    }
                }
                characterSet.clear();
            }
        }
        return true;
    }

    @Override
    public String getLink() {
        return "https://leetcode.com/problems/valid-sudoku/description/";
    }

    @Override
    public void getMySolution() {
//        Set<Character> characterSet = new HashSet<>();
//
//        //проверяем все вертикальные строки
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board.length; j++) {
//                char currectChar = board[i][j];
//                if ((currectChar != '.') && !characterSet.add(currectChar)) {
//                    return false;
//                }
//            }
//            characterSet.clear();
//        }
//
//        //проверяем все горизонтальные строки
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board.length; j++) {
//                char currectChar = board[j][i];
//                if ((currectChar != '.') && !characterSet.add(currectChar)) {
//                    return false;
//                }
//            }
//            characterSet.clear();
//        }
//
//        //Проверяем все квадраты 3х3
//        for (int p = 0; p < 3; p++) {//передвигаемся к следующей тройке квадратов 3х3 по вертикали
//            for (int k = 0; k < 3; k++) { //передвигаемся к следующему квадрату 3х3 по горизонтали
//                for (int i = 3 * k; i < 3 + k * 3; i++) {
//                    for (int j = 3 * p; j < 3 + p * 3; j++) {
//                        char currectChar = board[i][j];
//                        if ((currectChar != '.') && !characterSet.add(currectChar)) {
//                            return false;
//                        }
//                    }
//                }
//                characterSet.clear();
//            }
//        }
//        return true;

    }

    @Override
    public void getOptimizeSolution() {

    }

    @Override
    public String getTimeComplexity() {
        return null;
    }

    @Override
    public String getSpaceComplexity() {
        return null;
    }
}
