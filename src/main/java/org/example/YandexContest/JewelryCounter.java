package org.example.YandexContest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Даны две строки строчных латинских символов: строка J и строка S.
 * Символы, входящие в строку J, — «драгоценности», входящие в строку S — «камни».
 * Нужно определить, какое количество символов из S одновременно являются «драгоценностями».
 * Проще говоря, нужно проверить, какое количество символов из S входит в J.
 * https://contest.yandex.ru/contest/8458/problems/?utm_source=habr&utm_content=post070519&nc=hth1vvNP&success=106588978#1037/2018_07_04/7NfhNJ2TDa
 * Пример
 * Ввод	     Вывод
 * ab        4
 * aabbccd
 */
public class JewelryCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String jLine = br.readLine();
        String sLine = br.readLine();

        int countOfJewerlyInSLine = 0;
        for (int i = 0; i < sLine.length(); i++) {
            char charOfSline = sLine.charAt(i);
            if (jLine.indexOf(charOfSline) >= 0) {
                countOfJewerlyInSLine++;
            }
        }

        System.out.println(countOfJewerlyInSLine);
    }
}
