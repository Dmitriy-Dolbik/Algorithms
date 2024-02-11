package org.example.YandexContest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * ((()))
 * )(
 * (()())
 * )(
 * (())()
 * )(()
 * ()(())
 * )(
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
        int inputValue = Integer.parseInt(String.valueOf(readLine()).trim());
        int bracketsNumber = inputValue * 2; // количество скобок, должно быть четное
        char[] bracketsArray = new char[bracketsNumber];
        Arrays.fill(bracketsArray, 0, bracketsNumber, '(');
        Arrays.fill(bracketsArray, bracketsNumber / 2, bracketsNumber, ')');

        replaceBrackets(bracketsNumber, bracketsArray);
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

    public static void replaceBrackets(int bracketsNumber, char[] bracketsArray) throws IOException {
        // печатаем нулевую последовательность
        writeLine(bracketsArray);
        while (true) {
            int bracketIndex = bracketsNumber - 1;
            int openedBrackets = 0;
            int closedBrackets = 0;
            // находим откр. скобку, которую можно заменить
            while (bracketIndex >= 0) { //ищем с последнего элемента
                if (bracketsArray[bracketIndex] == ')') {
                    closedBrackets++;
                }
                if (bracketsArray[bracketIndex] == '(') {
                    openedBrackets++;
                }
                if (openedBrackets - closedBrackets < 0 && openedBrackets > 0 && bracketsArray[bracketIndex] == '(') {//останавливаем поиск, если закрывающих скобор
                    // больше, чем открывабщих
                    break;
                }
                bracketIndex--;
            }
            // если не нашли, то алгоритм заканчивает работу
            if (bracketIndex < 0) {
                break;
            }
            // заменяем на закр. скобку
            bracketsArray[bracketIndex] = ')';
            // заменяем на самую лексикографическую минимальную
            for (int i = bracketIndex + 1; i < bracketsNumber; i++) {
                if (openedBrackets > 0) {
                    bracketsArray[i] = '(';
                    openedBrackets--;
                } else {
                    bracketsArray[i] = ')';
                }
            }
            writeLine(bracketsArray);
        }

    }

    private static void writeLine(char[] bracketsArray) throws IOException {
        bufferedWriter.write(bracketsArray);
        bufferedWriter.newLine();
    }
}
