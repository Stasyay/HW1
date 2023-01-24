//Task1
//        Заполните массив случайным числами и выведите максимальное, минимальное и среднее значение.
//
//        Для генерации случайного числа используйте метод Math.random(), который возвращает значение в промежутке [0, 300].

import java.util.Arrays;
import java.util.Scanner;

public class Task1 {

    static int search_max (int[] matrix){
        int max = matrix[0];
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i] > max) {
                max = matrix[i];
            }
        }
        return max;
    }

    static int search_min (int[] matrix){
        int min = matrix[0];
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i] < min) {
                min = matrix[i];
            }
        }
        return min;
    }

    static int search_average (int[] matrix){
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
           sum += matrix[i];
        }
        return sum/matrix.length;
    }

    static int[] generation_array(int count) {
        int[] arr = new int[count];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random()*300);
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        Integer count = scn.nextInt();
        scn.close();

        int[] arr = generation_array(count);

        System.out.println(Arrays.toString(arr));
        System.out.println("Максимальное значение: " + search_max(arr));
        System.out.println("Минимальное значение: " + search_min(arr));
        System.out.println("Среднее значение: " + search_average(arr));
        scn.close();
    }
}
