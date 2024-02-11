package org.example.YandexContest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * n = 3
 * ((()))
 *   )(
 * (()())
 *    )(
 * (())()
 *  )((
 * ()(())
 *    )(
 * ()()()
 * ..................
 * [(, (, (, ), ), )]
 * [(, (, ), (, ), )]
 * [(, (, ), ), (, )]
 * [(, ), (, (, ), )]
 * [(, ), (, ), (, )]
 */
public class BracketsGenerator {
    public static final String FILE_INPUT = "input.txt";
    public static final String FILE_OUTPUT = "output.txt";
    private static BufferedReader bufferedReader;
    private static BufferedWriter bufferedWriter;
    private static final int MAX_ARRAY_SIZE = 15;
    private static int countOfOpenedBrackets = 0;


    public static void main(String[] args) throws IOException {
        init();
        run();
        close();
    }

    private static void init() throws IOException {
        bufferedReader = new BufferedReader(new FileReader(FILE_INPUT));
        bufferedWriter = new BufferedWriter(new FileWriter(FILE_OUTPUT));
    }

    private static void close() throws IOException {
        bufferedReader.close();
        bufferedWriter.close();
    }

    private static void run() throws IOException {
        int halfBracketsNumber = Integer.parseInt(String.valueOf(readLine()).trim());
        int bracketsNumber = halfBracketsNumber * 2;
        char[] bracketsArray = createTheSmallestBracketSequence(bracketsNumber);
        createRemainingBracketSequence(bracketsNumber, bracketsArray);
    }

    private static char[] createTheSmallestBracketSequence(int bracketsNumber) {
        char[] bracketsArray = new char[bracketsNumber];
        Arrays.fill(bracketsArray, 0, bracketsNumber, '(');
        Arrays.fill(bracketsArray, bracketsNumber / 2, bracketsNumber, ')');
        return bracketsArray;
    }

    private static char[] readLine() throws IOException {
        char[] readCharArray = new char[MAX_ARRAY_SIZE];
        for (int i = 0; i < MAX_ARRAY_SIZE; i++) {
            int readCharacter = bufferedReader.read();
            if (readCharacter == '\n' || readCharacter == -1) {
                break;
            }
            if (readCharacter == '\r') {
                continue;
            }
            readCharArray[i] = (char) readCharacter;
        }
        return readCharArray;
    }

    public static void createRemainingBracketSequence(int bracketsNumber, char[] bracketsArray) throws IOException {
        // печатаем нулевую последовательность
        writeLine(bracketsArray);
        while (true) {
            // находим откр. скобку, которую можно заменить
            int indexOfOpenedBracketsToChange = findIndexOfOpenedBracketToChange(bracketsNumber, bracketsArray);
            // если не нашли, то алгоритм заканчивает работу
            if (indexOfOpenedBracketsToChange < 0) {
                break;
            }
            // заменяем на закр. скобку
            bracketsArray[indexOfOpenedBracketsToChange] = ')';
            //проходимся по оставшимся скобкам справа от измененной и меняем их.
            changeRemainingBracketsOnTheRight(bracketsNumber, bracketsArray, indexOfOpenedBracketsToChange);
            writeLine(bracketsArray);
        }
    }

    private static int findIndexOfOpenedBracketToChange(int bracketsNumber, char[] bracketsArray) {
        int countOfClosedBrackets = 0;
        for (int i = bracketsNumber - 1 ; i >= 0 ; i--) {//ищем с конца последовательности, чтобы поменять самую правую
             if (bracketsArray[i] == ')') {              //открывающуюся скобку'(' на закрывающую ')', т.к. '(' < ')'
                countOfClosedBrackets++;                 //таким образом мы формируем последовательность, которая будет больше.
            }
            if (bracketsArray[i] == '(') {
                countOfOpenedBrackets++;//важно запомнить, сколько открывающих скобок было в пройденной части
            }
            //если мы встретили открывающую скобку и закрывающих скобок больше, чем открывающих, то это открывающая скобка, которую можно поменять на закрывающую
            if (countOfOpenedBrackets > 0 && bracketsArray[i] == '(' && countOfOpenedBrackets - countOfClosedBrackets < 0) {
                return i;//возвращаем индекс этой скобки
            }
        }
        return -1;
    }

    private static void changeRemainingBracketsOnTheRight(int bracketsNumber, char[] bracketsArray, int indexOfOpenedBracketsToChange) {
        for (int i = indexOfOpenedBracketsToChange + 1; i < bracketsNumber; i++) {
            if (countOfOpenedBrackets > 0) {
                //сначала меняем на отрывающие скобки. Столько, сколько было открывающих скобок при поиске индекса.
                bracketsArray[i] = '(';
                countOfOpenedBrackets--;
                continue;
            }
            //оставшиеся меняем на закрывающие
            bracketsArray[i] = ')';
            //таким образом мы формируем самую маленькую скобочную последовательность, посколько '(' < ')'.
        }
    }

    private static void writeLine(char[] bracketsArray) throws IOException {
        bufferedWriter.write(bracketsArray);
        bufferedWriter.newLine();
    }
}
