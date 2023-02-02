package Homework4;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class task2 {

    // Даны два Deque представляющие два неотрицательных целых числа. Цифры хранятся
    // в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    // Сложите два числа и верните сумму в виде связанного списка.
    public static void main(String[] args) {
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(5, 6, 2));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(5, 0, 0));
        // result [6,6,0,1]
        System.out.println(sum(d1, d2));
    }

    public static Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) {
        Deque<Integer> result_sum = new ArrayDeque<>();

        int first_d1 = 0;
        int first_d2 = 0;
        int sum_item = 0;

        for (int i = 0; i <= d1.size() + 1; i++) {

            first_d1 = d1.pollFirst();
            first_d2 = d2.pollFirst();
            sum_item = sum_item + first_d1 + first_d2;

            if (sum_item > 9) {

                result_sum.addLast(sum_item % 10);
                sum_item = 1;
            }

            else {
                result_sum.addLast(sum_item);
                sum_item = 0;
            }
        }
        if (sum_item != 0) {
            result_sum.addLast(sum_item);
        }
        return result_sum;
    }
}
