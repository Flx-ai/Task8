package vsu.cs.ru;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        String fileName = readFileName();
        InputArgs inputParams = new InputArgs("src/vsu/cs/ru/tests/" + fileName, "src/vsu/cs/ru/output.txt");
        int[][] arrayOfIntegers = ArrayUtils.readIntArray2FromFile(inputParams.getInputFile());

        try {
            printArrayOfIntegers(arrayOfIntegers);
        } catch (NullPointerException exception) {
            System.out.println("Error! You're trying to see a transposed null array because you specified a file that doesn't exist!");
        }

        int[][] newArrayOfIntegers = swapRowsWithColumns(arrayOfIntegers);
        ArrayUtils.writeArrayToFile(inputParams.getOutputFile(), swapRowsWithColumns(arrayOfIntegers));
        printArrayOfIntegers(newArrayOfIntegers);
    }

    private static String readFileName() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Input fileName: ");
        return scanner.nextLine();
    }

    private static void printArrayOfIntegers(int[][] arrayOfIntegers) {
        System.out.println();
        for (int[] row : arrayOfIntegers) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }

    private static int[][] swapRowsWithColumns(int[][] arrayOfIntegers) {
        int[][] newArrayOfIntegers = new int[arrayOfIntegers[0].length][arrayOfIntegers.length];
        for (int i = 0; i < arrayOfIntegers.length; i++) {
            for (int j = 0; j < arrayOfIntegers[i].length; j++) {
                newArrayOfIntegers[j][i] = arrayOfIntegers[i][j];
            }
        }
        return newArrayOfIntegers;
    }
}