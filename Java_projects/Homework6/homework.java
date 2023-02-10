package Homework6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// 1) Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
// 2) Создать коллекцию ноутбуков.
// 3) Написать мапу, которая будет содержать критерий (или критерии) фильтрации и выведет
//      ноутбуки, отвечающие фильтру.
//      Пример: ОЗУ - Значение, Объем ЖД - Значение, Операционная система - Значение, Цвет - Значение
// 4) Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
import java.util.Scanner;

public class homework {

    
    public static List<Notebook> initListNotebooks(){
    
        List<Notebook> notebooks = new ArrayList<Notebook>();
        Notebook notebook = new Notebook("Asus", "Black", true, 16, 500, 15, 200000);
        Notebook notebook1 = new Notebook("Asus", "White", false, 32, 250, 17, 300000);
        Notebook notebook2 = new Notebook("Asus", "Black", true, 8, 120, 15, 150000);
        Notebook notebook3 = new Notebook("Dell", "Black", false, 16, 1000, 17, 500000);
        Notebook notebook4 = new Notebook("Dell", "Pinck", true, 8, 250, 19, 250000);
        Notebook notebook5 = new Notebook("Lenovo", "Black", false, 16, 1000, 17, 250000);
        Notebook notebook6 = new Notebook("Lenovo", "White", true, 64, 2000, 15, 450000);
        notebooks.add(notebook);
        notebooks.add(notebook1);
        notebooks.add(notebook2);
        notebooks.add(notebook3);
        notebooks.add(notebook4);
        notebooks.add(notebook5);
        notebooks.add(notebook6);
        return notebooks;
    }
    
    public static Integer get_data_integer(String text) throws IOException {
    
        System.out.printf(text);
        Scanner scn = new Scanner(System.in);
        int data = scn.nextInt();
        // scn.close();
        return data;
    }

    public static Map<String,Integer> QuestionForFilter(Integer answer_for_filter) throws IOException{
        
        Map<String,Integer> hash_map_for_filter = new HashMap<String,Integer>();
           
        if (answer_for_filter == 1){
            int max_price = get_data_integer("Максимальная цена: ");
            hash_map_for_filter.put("Максимальная цена: ", max_price);
        } 
        if (answer_for_filter == 2){
            int min_ram = get_data_integer("Минимальный размер ОЗУ: ");
            hash_map_for_filter.put("Минимальный размер ОЗУ: ", min_ram);
        } 
        if (answer_for_filter == 3){
            int min_hdd = get_data_integer("Минимальный размер HDD: ");
            hash_map_for_filter.put("Минимальный размер HDD: ", min_hdd);
        } 
        return hash_map_for_filter;
    }

    public static List<Notebook> filter(Map<String, Integer> params, List<Notebook> notebooks,
            Integer answer_for_filter) {

        List<Notebook> sorted_notebooks = new ArrayList<Notebook>();

        for (Notebook notebook : notebooks) {
            if (answer_for_filter == 1 && notebook.get_price() <= params.get("Максимальная цена: ")) {
                sorted_notebooks.add(notebook);
            }

            if (answer_for_filter == 2 && notebook.get_ram() >= params.get("Минимальный размер ОЗУ: ")) {
                sorted_notebooks.add(notebook);
            }

            if (answer_for_filter == 3 && notebook.get_hdd() >= params.get("Минимальный размер HDD: ")) {
                sorted_notebooks.add(notebook);
            }
        }
        return sorted_notebooks;
    }
    
    public static void main(String[] args) throws IOException {
        System.out.println(initListNotebooks());
        List<Notebook> notebooks = initListNotebooks();

        Integer answer_for_filter = 0;
        answer_for_filter = get_data_integer("Фильтруем по: \n Максимальная цена (1)\n Минимальный размер ОЗУ (2)\n Минимальный размер HDD (3) \n");
        Map<String,Integer> hash_map_for_filter = QuestionForFilter(answer_for_filter);
        
        List<Notebook> sorted_notebooks = filter(hash_map_for_filter, notebooks, answer_for_filter);
        for (Notebook notebook : sorted_notebooks){
            System.out.println(notebook);
        }
        

    }

}
