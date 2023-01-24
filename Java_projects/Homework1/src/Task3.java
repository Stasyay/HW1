//        Task3
//        Напишите программу, которая выводит на консоль простые числа в промежутке от [2, 100].
//        Используйте для решения этой задачи оператор "%" (остаток от деления) и циклы.

public class Task3 {

    static boolean simple_numbers(int number) {

        if (number <= 1){
            return false;
        }
        else if( number == 2) {
            return true;
        }

        for( int i = 2; i < number; i++ ) {
            if (number % i == 0 ) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] arg) {

        int number= 2;
        while (number <= 100) {

            if (simple_numbers(number)) {
                System.out.printf(number + " ");
            }
            number ++;
        }
    }
}
