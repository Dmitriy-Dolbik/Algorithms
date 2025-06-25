package org.example.YandexContest.TrialTasks;

import java.util.Scanner;

public class B_zipper_closure {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfNumbers = Integer.parseInt(scanner.nextLine()); //n = 3
        String[] firstArray = getInputArray(scanner); //[1,2,3]
        String[] secondArray = getInputArray(scanner);//[4,5,6]


        int resultArraySize = 3 + 4 * (countOfNumbers - 1);
        String[] resultArray = new String[resultArraySize];
        for (int i = 0; i < countOfNumbers; i++) {
            int indexForElementFromFirstArray = i * 4;
            int indexForElementFromSecondArray = indexForElementFromFirstArray + 2;
            if (i > 0) {
                //Нужен пробел перед элементом из первого массива
                resultArray[indexForElementFromFirstArray - 1] = " ";
            }
            resultArray[indexForElementFromFirstArray] = firstArray[i];
            //Нужен пробел после элемента из первого массива
            resultArray[indexForElementFromFirstArray + 1] = " ";
            resultArray[indexForElementFromSecondArray] = secondArray[i];
        }
        printArray(resultArray);
    }


    private static void printArray(String[] resultArray) {
        for (String number : resultArray) {
            System.out.print(number);
        }
    }


    private static String[] getInputArray(Scanner scanner) {
        return scanner.nextLine().split(" ");
    }
}
