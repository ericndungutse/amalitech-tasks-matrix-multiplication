package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Declare scanner to read stream from console
        Scanner scanner = new Scanner(System.in);

        System.out.println("🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟 WELCOME👋 🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟");
        System.out.println("Please enter dimensions of you matrices. ⚠️ Number of columns in matrix A should be equal to the number of rows in matrix B.");

        // Read dimension for both matrices from console
        Dimensions matrixADimensions = readDimensions(scanner, "A");
        Dimensions matrixBDimensions = readDimensions(scanner, "B");

        // Check if matrices can be multiplied by checking if number of columns in first matrix is equal to the number of rows in the second matrix
        while(matrixADimensions.getCols() != matrixBDimensions.getRows()){
            System.out.println("🔥 Number of Matrix A columns is not equal to the number of matrix B rows 👎");
            matrixADimensions = readDimensions(scanner,"A");
            matrixBDimensions = readDimensions(scanner, "B");
        }

        // Declare and allocate matrices
        int[][] matrixA = readMatrix(matrixADimensions.rows, matrixADimensions.getCols(), "A", scanner);
        int[][] matrixB = readMatrix(matrixBDimensions.getRows(), matrixBDimensions.getCols(), "B", scanner);


        // Display matrix A
        displayMatrix(matrixA, "A");
        // Display matrix B
        displayMatrix(matrixB, "B");

        System.out.println("\nMatrix A * Matrix B\n");

        // Declare and initialize result matrix C
        int[][] matrixC = multiplyMatrices(matrixA, matrixB);

        // Display result matrix C
        displayMatrix(matrixC, "C");

        //  Release system resources
        scanner.close();
    }

    // Read dimensions of matrices
    public static Dimensions readDimensions(Scanner scanner, String matrixName){
        System.out.print("Enter the number of rows for matrix " + matrixName + ": ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns for matrix " + matrixName + ": ");
        int cols = scanner.nextInt();

        return new Dimensions(rows, cols);

    }

    // Read matrx
    public static int[][] readMatrix(int rows,int cols, String matrixName, Scanner scanner){
     int[][] result = new int[rows][cols];
      for(int i=0; i<rows; i++){
          for(int j=0; j<cols; j++){
              System.out.print("Enter value "+ matrixName + "[" + i + "][" + j + "]: ");
              int value = scanner.nextInt();
              result[i][j] = value;
          }
      }
      return result;
    };

    // Display Matrix
    public static void displayMatrix(int[][] matrix, String name){
        System.out.print("\n");
        System.out.println("Matrix " + name + ":\n");
        for (int[] ints : matrix) {
            System.out.print("|\t");
            for (int anInt : ints) {
                System.out.print(anInt);
                System.out.print("\t");
            }
            System.out.print("|");
            System.out.print("\n");
        }
    }

    // Multiply Matrices
    public static int[][] multiplyMatrices(int[][] matrixa, int[][] matrixb){
        // Calculate results rows and columns
        // Result rows is the number of rows of first matrix, which is the length of matrix a
        // Result columns is the number of columns in second matrix, which is the length of inner arrays of second matrix
        int[][] result = new int[matrixa.length][matrixb[0].length];

        for(int i = 0; i < matrixa.length; i++){
            for(int j = 0; j < matrixb[0].length; j++){
                for(int k = 0; k < matrixb.length; k++){
                    result[i][j] = result[i][j] + matrixa[i][k] * matrixb[k][j];
                }
            }
        }

        return result;
    }
}

