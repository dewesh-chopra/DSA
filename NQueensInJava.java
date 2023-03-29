// References: Fundamentals of Computer Algorithms, 2nd Edition

import java.util.Scanner;

public class NQueensInJava {
    private int[] x;
    private static int solnCount = 0;

    public NQueensInJava(int n) {
        x = new int[n];
        NQueens(0, n);
    }

    public void printBoard() {
        System.out.println("Solution:");
        for(int i = 0; i < x.length; i++) {
            for(int j = 0; j < x.length; j++) {
                if(j == x[i]) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }

        solnCount++;
    }

    public boolean canPlace(int k, int i) {
        for(int j = 0; j < k; j++) {
            if(x[j] == i || Math.abs(x[j] - i) == Math.abs(j - k)) {
                return false;
            }
        }
        return true;
    }

    public void NQueens(int k, int n) {
        for(int i = 0; i < n; i++) {
            if(canPlace(k, i)) {
                x[k] = i;

                if(k == n - 1) {
                    printBoard();
                } else {
                    NQueens(k + 1, n);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.print("Enter board size: ");

        int n = 4;
        try {
            Scanner scn = new Scanner(System.in);
            n = Integer.parseInt(scn.nextLine());
            new NQueensInJava(n);
            System.out.println("Total solutions: " + solnCount);
        } catch(Exception e) {
            System.out.println("Something went wrong!");
        }
    }
}
