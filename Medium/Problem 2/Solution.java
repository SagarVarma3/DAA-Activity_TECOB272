import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int ss3=0;
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] matrix = new int[2*n][2*n];

            for (int i = 0; i < 2*n; i++) {
                String[] matrixRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2*n; j++) {
                    int matrixItem = Integer.parseInt(matrixRowItems[j]);
                    matrix[i][j] = matrixItem;
                }
            }

             for(int i = 0; i < n; i++)
            {
              for(int j = 0; j < n; j++)
              {
                  int n1 = matrix[i][(2*n) - j - 1];
                  int n2 = matrix[i][j];
                  int n3 = matrix[(2*n) - i - 1][j];
                  int n4 = matrix[(2*n) - i - 1][(2*n) - j - 1];
                  ss3 += Math.max(n1, Math.max(n2, Math.max(n3, n4)));
              }
            }
            System.out.println(ss3);
            

            bufferedWriter.write(String.valueOf(ss3));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
