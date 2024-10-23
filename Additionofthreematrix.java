/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAS;


public class Additionofthreematrix {
    public static void main(String[] args) {
        int[][] matrixA = {
        {1,2,3},
        {4,5,6},
        {7,8,9}
        };
            
      int[][] matrixB = {
          {9,8,7},
          {6,5,4},
          {3,2,1}
      };
      int [][]result = new int[3][3];
      for(int k=0;k<3;k++){
          for(int h=0;h<3;h++){
              result[k][h]= matrixA[k][h]+matrixB[k][h];
          }
      }
        System.out.println("sum of the two matrix");
        System.out.println("Sum of the two matrices:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
