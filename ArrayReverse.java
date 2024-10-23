/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAS;

public class ArrayReverse {
    public static void main(String[] args) {
        // Define an array
        int[] arr = {1, 2, 3, 4, 5, 6};

        // Print the original array
        System.out.print("Original Array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // Reverse the array using swapping
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            // Swap the elements at start and end index
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            // Move the pointers towards the center
            start++;
            end--;
        }

        // Print the reversed array
        System.out.print("Reversed Array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
