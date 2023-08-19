package br.com.TomaziTecnologies.CalcMatrizes;

import java.util.Scanner;

class MatrixCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número de linhas da primeira matriz: ");
        int rows1 = scanner.nextInt();
        System.out.print("Digite o número de colunas da primeira matriz: ");
        int cols1 = scanner.nextInt();

        double[][] matrix1 = new double[rows1][cols1];
        System.out.println("Digite os elementos da primeira matriz:");
        readMatrix(scanner, matrix1);

        System.out.print("Digite o número de linhas da segunda matriz: ");
        int rows2 = scanner.nextInt();
        System.out.print("Digite o número de colunas da segunda matriz: ");
        int cols2 = scanner.nextInt();

        double[][] matrix2 = new double[rows2][cols2];
        System.out.println("Digite os elementos da segunda matriz:");
        readMatrix(scanner, matrix2);

        if (cols1 != rows2) {
            System.out.println("As matrizes não podem ser multiplicadas.");
            return;
        }

        System.out.println("Escolha a operação:");
        System.out.println("1. Soma");
        System.out.println("2. Subtração");
        System.out.println("3. Multiplicação");
        int choice = scanner.nextInt();

        double[][] resultMatrix = new double[rows1][cols2];

        switch (choice) {
            case 1:
                addMatrices(matrix1, matrix2, resultMatrix);
                break;
            case 2:
                subtractMatrices(matrix1, matrix2, resultMatrix);
                break;
            case 3:
                multiplyMatrices(matrix1, matrix2, resultMatrix);
                break;
            default:
                System.out.println("Escolha inválida.");
                return;
        }

        System.out.println("Resultado:");
        printMatrix(resultMatrix);

        scanner.close();
    }

    public static void readMatrix(Scanner scanner, double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }
    }

    public static void addMatrices(double[][] A, double[][] B, double[][] result) {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
    }

    public static void subtractMatrices(double[][] A, double[][] B, double[][] result) {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = A[i][j] - B[i][j];
            }
        }
    }

    public static void multiplyMatrices(double[][] A, double[][] B, double[][] result) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < B.length; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
    }

    public static void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

