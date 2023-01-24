//        Task2
//        Реализуйте алгоритм сортировки пузырьком для сортировки массива


import java.util.Arrays;
import java.util.Scanner;

public class Task2 {

    static int[] generation_array(int count) {
        int[] matrix = new int[count];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = (int) (Math.random()*300);
        }
        return matrix;
    }

    static int[] bubble_sorted_to_min(int[] matrix) {
        for (int i = 0; i <matrix.length-1; i++){

            for (int j = 0; j < matrix.length - i -1; j++){
                if (matrix[j+1 ] > matrix[j]) {
                    int tmp = matrix[j];
                    matrix[j] = matrix[j+1];
                    matrix[j+1] = tmp;
                }
            }
        }
        return matrix;
    }

    static int[] bubble_sorted_to_max(int[] matrix) {
        for (int i = matrix.length-1; i>0; i--){

            for (int j = 0; j < i; j++){
                if (matrix[j ] > matrix[j+1]) {
                    int tmp = matrix[j];
                    matrix[j] = matrix[j+1];
                    matrix[j+1] = tmp;
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        Integer count = scn.nextInt();
        scn.close();

        int[] arr = generation_array(count);

        System.out.println("Исходный массив: " + Arrays.toString(arr));
        System.out.println("Отсортированный массив ->: " + Arrays.toString(bubble_sorted_to_max(arr)));
        System.out.println("Отсортированный массив <-: " + Arrays.toString(bubble_sorted_to_min(arr)));
    }

}
