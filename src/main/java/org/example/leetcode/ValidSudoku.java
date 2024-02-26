package org.example.leetcode;

public class ValidSudoku implements Task {

    public static void main(String[] args) {                         //в разрезе переменных i и j поле судоку выглядит так
        System.out.println(isValidSudoku(                            //char[i][j] (т.е. мы его переворачиваем относительно ввода)
                                                                     //  square index
                                                                     //            0        1        2
                                                                     //      i  0  1  2  3  4  5  6  7  8
                new char[][]{                                        //    j  ---------------------------
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},       //    0 |  .  .  .  8  .  .  .  .  .
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},       // 0  1 |  .  4  .  .  .  1  .  2  .
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},       //    2 |  .  .  .  .  2  5  .  .  4
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},       //    3 |  .  3  .  .  .  .  .  9  .
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},       // 3  4 |  5  .  .  .  7  .  .  .  .
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},       //    5 |  .  .  3  .  .  .  2  .  .
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},       //    6 |  .  .  .  .  .  .  .  .  .
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},       // 6  7 |  1  .  .  2  .  .  .  .  .
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}        //    8 |  .  .  1  .  .  .  .  .  .
        }));
    }

    public static boolean isValidSudoku(char[][] board) {

        //Точно такое же решение, как черезе мапы, только вместо мап используются двойные массивы.
        //ДЛя каждого числа вычисляется позиция в массиве и значение в этой позиции увеличивается на один.
        //Если значение в позиции увеличили более чем на один, значит число встрелили более одного раза
        //Быстрее на 2 ms чем решение через мапы
        int[][] rowsArray = new int[9][9];
        int[][] columnArray = new int[9][9];
        int[][] squareArray = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int pos = board[i][j] - '0' - 1; //Для числа 5 -> 5(53) - 0(48) - 1 = 4. Т.е. единица в идексе 4 значит, что число 5 встретили 1 раз.
                    int pos_square = (i / 3) + (j / 3) * 3;
                    if (++rowsArray[i][pos] > 1 || ++columnArray[j][pos] > 1 || ++squareArray[pos_square][pos] > 1) {
                        return false;
                    }
                }
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
        //2 ms  По своей сути оптимальное решение, но очень многословный и четыре раза вложенный цикл for пугает
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
        //3 ms
        //Создаем три мапы для строк, колонок и квадратов 3х3.
        //Проходимся по всем ячейкам и заполняем мапы
//        Map<Integer, Set<Integer>> columnsMap = new HashMap<>();
//        Map<Integer, Set<Integer>> rowsMap = new HashMap<>();
//        Map<Integer, Set<Integer>> squaresMap = new HashMap<>();
//
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board.length; j++) {
//                int currentNumber = board[i][j];
//                if (currentNumber == '.') {
//                    continue;
//                }
//                int indexOfSubSquare = i / 3 + j / 3 * 3; //то 0 до 8
//                if (!columnsMap.computeIfAbsent(i, ignore -> new HashSet<>()).add(currentNumber) ||
//                        !rowsMap.computeIfAbsent(j, ignore -> new HashSet<>()).add(currentNumber) ||
//                        !squaresMap.computeIfAbsent(indexOfSubSquare, ignore -> new HashSet<>()).add(currentNumber)) {
//                    return false;
//                }
//            }
//        }
//        return true;
        //                                                                  0  1  2
        //i / 3 + j / 3 * 3 - идентификатор для квадрата 3х3: от 0 до 8    ----------
        //                                                               0 |0  1  2
        //                                                               3 |3  4  5
        //                                                               6 |6  7  8
    }

    @Override
    public String getTimeComplexity() {
        return "O(9^2)";//Сложность равна размеру поля, т.к. сложность опреации вставки в HashSet O(1)
    }

    @Override
    public String getSpaceComplexity() {
        return "O(9^2)";
    }
}
