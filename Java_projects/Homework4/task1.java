package Homework4;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class task1 {

    // Дан Deque состоящий из последовательности цифр.
    // Необходимо проверить, что последовательность цифр является палиндромом
    public static void main(String[] args) {

        Deque<Integer> deque = new ArrayDeque<>(Arrays.asList(1, 2, 15, 3, 2, 1));

        System.out.println(checkOn(deque));
    }

    public static boolean checkOn(Deque<Integer> deque) {

        System.out.println(deque);

        for (int i = 0; i <= deque.size(); i++) {

            int start = deque.pollFirst();
            int end = deque.pollLast();

            if (start != end) {
                return false;
            }
        }
        return true;
    }
}
