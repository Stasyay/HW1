package Homework3;

import java.util.ArrayList;
import java.util.List;

public class Homework {

    // Пусть дан произвольный список целых чисел
public static void main(String[] args) {

    ArrayList<Integer> numbers = new ArrayList<Integer>(100);

    for (int i = 0; i < 10; i++) {
        numbers.add(i, (int)(Math.random() * 100));
    }
    System.out.println("Исходный список: " + numbers);
    System.out.println("Минимальное число: " + getMin(numbers));
    System.out.println("Максимальное число: " + getMax(numbers));
    System.out.println("Cреднее целое значение: " + getAverage(numbers));
    System.out.println("Список без четных чисел: " + removeEvenValue(numbers));
}

// Нужно удалить из него четные числа
public static List<Integer> removeEvenValue(List<Integer> list){

    list.removeIf(item -> item % 2 == 0);

    return list;
}

// Найти минимальное значение
public static Integer getMin(List<Integer> list){

    int min = list.get(0); 

    for (int item = 1; item < list.size(); item++){
        if (list.get(item) < min) {
           min = list.get(item);
        }
    }

    return min;
}

// Найти максимальное значение
public static Integer getMax(List<Integer> list){

    int max = list.get(0); 

    for (int item = 1; item < list.size(); item++){
        if (list.get(item) > max) {
           max = list.get(item);
        }
    }
    return max;
}

// Найти среднее значение
public static Integer getAverage(List<Integer> list){
    int sum = 0; 

    for (int item = 0; item < list.size(); item++){
            sum += list.get(item);
    }
    int average = sum/list.size();   

    return average;
}
    
}
