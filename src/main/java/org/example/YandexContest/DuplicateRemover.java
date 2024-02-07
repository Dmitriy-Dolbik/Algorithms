package org.example.YandexContest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Дан упорядоченный по неубыванию массив целых 32-разрядных чисел. Требуется удалить из него все повторения.
 * Желательно получить решение, которое не считывает входной файл целиком в память, т.е., использует лишь константный объем памяти в процессе работы.
 * Input 	Output
 * 5        2
 * 2        4
 * 4        8
 * 8
 * 8
 * 8
 * https://contest.yandex.ru/contest/8458/problems/C/?success=106776507#1037/2018_06_27/PCZWie3Bt7
 */
public class DuplicateRemover {
    private static final String FILE_INPUT = "input.txt";
    private static final String FILE_OUTPUT = "output.txt";
    private static BufferedReader bufferedReader;
    private static BufferedWriter bufferedWriter;
    private static final int MAX_CHAR_ARRAY_SIZE = 15;

    public static void main(String[] args) throws Exception {
        init();
        run();
        close();
    }

    private static void init() throws IOException {
        bufferedReader = new BufferedReader(new FileReader(FILE_INPUT));
        bufferedWriter = new BufferedWriter(new FileWriter(FILE_OUTPUT));
    }

    private static void run() throws IOException {
        int numberOfContentLines = Integer.parseInt(String.valueOf(readLine()).trim());//читаем одну строку (или её часть. если строка большая), как массив символов. Убираем пробелы из
        // строки
        if (numberOfContentLines < 1) {
            return;
        }
        char[] readContent = readLine();
        writeLine(readContent);
        char[] previousContent = readContent;

        for (int i = 1; i < numberOfContentLines; i++) {
            readContent = readLine();
            if (!equals(readContent, previousContent)) {
                writeLine(readContent);
                previousContent = readContent;
            }
        }
    }

    private static void close() throws IOException {
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static char[] readLine() throws IOException {
        char[] content = new char[MAX_CHAR_ARRAY_SIZE];//создаем массив с фиксированным размером в 15 символов
        for (int i = 0; i < MAX_CHAR_ARRAY_SIZE; i++) {
            int oneCharacterFromLine = bufferedReader.read();//читаем один символ
            if (oneCharacterFromLine == '\n' || oneCharacterFromLine == -1) {//если символ перенос строки или конец файла, то выходим из цикла
                break;
            }
            if (oneCharacterFromLine == '\r') {//если символ - это возврат корретки, просто пропускаме его
                continue;
            }
            content[i] = (char) oneCharacterFromLine;//записываем этот символ в массив
        }
        return content;
    }

    private static void writeLine(char[] intToFile) throws IOException {
        bufferedWriter.write(intToFile);
        bufferedWriter.newLine();
    }

    private static boolean equals(char[] chars1, char[] chars2) {
        for (int i = 0; i < MAX_CHAR_ARRAY_SIZE; ++i) {
            if (chars1[i] != chars2[i]) {
                return false;
            }
        }
        return true;
    }
}