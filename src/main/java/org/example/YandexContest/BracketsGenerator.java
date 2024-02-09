package org.example.YandexContest;

import java.util.Arrays;

/**
 *          ((()))
 *            )(
 *          (()())
 *             )(
 *          (())()
 *           )(()
 *          ()(())
 *             )(
 *          ()()()
 * ..................
 * [(, (, (, ), ), )]
 * [(, (, ), (, ), )]
 * [(, (, ), ), (, )]
 * [(, ), (, (, ), )]
 * [(, ), (, ), (, )]
 */
public class BracketsGenerator {
    public static void main(String[] args) {
        //Рекурсивный способ
//        int bracketsNumber = 6; // количество скобок
//        char[] bracketsArray = new char[bracketsNumber]; // пустой массив, куда кладем скобки
//        int bracketsDifference = 0; // разница между скобками
//        int bracketIndex = 0; // индекс, по которому кладем скобку в список
//
//        placeBracketToArray(bracketsDifference, bracketIndex, bracketsNumber, bracketsArray);

        //Итеративный способ решения
        int bracketsNumber = 6; // количество скобок, должно быть четное
        char[] bracketsArray = new char[bracketsNumber];
        Arrays.fill(bracketsArray, 0, bracketsNumber/2, '(');
        Arrays.fill(bracketsArray, bracketsNumber/2, bracketsNumber, ')');

        replaceBrackets(bracketsNumber, bracketsArray);
    }

    public static void replaceBrackets(int bracketsNumber, char[] bracketsArray) {
        // печатаем нулевую последовательность
        System.out.println(Arrays.toString(bracketsArray));
        while (true) {
            int bracketIndex = bracketsNumber - 1;
            int bracketsDifference = 0;
            // находим откр. скобку, которую можно заменить
            while (bracketIndex >= 0) { //ищем с последнего элемента
                if (bracketsArray[bracketIndex] == ')') {
                    bracketsDifference--;//достаем из стека открывающую скобку
                }
                if (bracketsArray[bracketIndex] == '(') {
                    bracketsDifference++;
                }
                if (bracketsDifference <  0 && bracketsArray[bracketIndex] == '(') {//останавливаем поиск, если закрывающих скобор больше, чем открывабщих
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
                if (i <= (bracketsNumber - bracketIndex + bracketsDifference) / 2 + bracketIndex) {
                    bracketsArray[i] = '(';
                } else {
                    bracketsArray[i] = ')';
                }
            }
            System.out.println(Arrays.toString(bracketsArray));
        }

    }

    public static void placeBracketToArray(int bracketsDifference, int bracketIndex, int bracketsNumber, char[] bracketsArray) {
        // кладем откр. скобку, только если хватает места
        if (bracketsDifference <= bracketsNumber - bracketIndex - 2) {
            bracketsArray[bracketIndex] = '(';
            placeBracketToArray(bracketsDifference + 1, bracketIndex + 1, bracketsNumber, bracketsArray);
        }
        // закр. скобку можно положить всегда, если bracketsDifference > 0
        if (bracketsDifference > 0) {
            bracketsArray[bracketIndex] = ')';
            placeBracketToArray(bracketsDifference - 1, bracketIndex + 1, bracketsNumber, bracketsArray);
        }
        // выходим из цикла и печатаем
        if (bracketIndex == bracketsNumber) {
            if (bracketsDifference == 0) {
                System.out.println(Arrays.toString(bracketsArray));
            }
        }
    }
}
