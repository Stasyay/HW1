package Homework5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    // Пусть дан список сотрудников:Иван Иванов (и остальные)
    // Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
    // Отсортировать по убыванию популярности.

    // Иван Иванов 88001122333
    // Иван Курицин 88001662333
    // Иван Курицин 88001112333
    // Иван Незлобин 88001122432
    // Сергей Потапов 88001112453
    // Сергей Потапов 8800163214
    // Сергей Курицин 8800142421
    // Михаил Незлобин 880012343
    
    // OutPut
    // Иван - 3
    // Сергей - 2
    // Потому как если один сотрудник имеет 2 или более номера , его имя считаем 1 раз.

public class homework {

public static void main(String[] args) {

        Map<Long, String> phonebook = new HashMap<>();
        phonebook.put(88001122333L, "Иван Иванов");
        phonebook.put(88001662333L, "Иван Курицин");
        phonebook.put(88001112333L, "Иван Курицин");
        phonebook.put(88001122432L, "Иван Незлобин");
        phonebook.put(88001112453L, "Сергей Потапов");
        phonebook.put(8800163214L, "Сергей Потапов");
        phonebook.put(8800142421L, "Сергей Курицин");
        phonebook.put(880012343L, "Михаил Незлобин");

        //Список без телефонов
        List<String> value_list = new ArrayList<>();
        for (Map.Entry<Long, String> entry : phonebook.entrySet()) {
            String value = entry.getValue();
            value_list.add(value);
        }
       
        //Список без одинаковых фамилий
        List<String> list_without_duplicates = value_list.stream().distinct().collect(Collectors.toList());

        //Список только имен
        List<String> list_only_names = new ArrayList<>();
        for (String s : list_without_duplicates) {
            list_only_names.add(0, s.split(" ")[0]);
        }

        //Мапа подсчитанных имен
        Map<String,Integer> counter = list_only_names.stream().collect(Collectors.toMap(entry -> entry, entry -> 1, Integer :: sum));
        //Мапа отсортированная в обратном порядке
        Map<String,Integer> sorted_names = new LinkedHashMap<>();
        counter.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).forEachOrdered(entry -> sorted_names.put(entry.getKey(), entry.getValue()));      
        sorted_names.forEach((k, v) -> System.out.println(k + ": " + v));
        
    }

    }
    

    