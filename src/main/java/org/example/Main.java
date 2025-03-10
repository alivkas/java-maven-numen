package org.example;

import org.example.arrayTask.ArrayTask;
import org.example.httpTask.HttpTask;
import org.example.interfaceTask.FileSyncInput;
import org.example.listTask.ListTask;
import org.example.streamTask.EmployeeListMap;

import java.util.Scanner;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("""
                Впишите номер задания
                
                Задание №1. Работа с массивом [1]
                Задание №2. Работа со списками [2]
                Задание №3. Stream API [3]
                Задание №4. HTTP клиент и JSON [4]
                Задание №5. Реализация интерфейса “Task” [5]
                
                Для выхода используйте [-1]
                """);
        startup();
    }

    /**
     * Запуск заданий
     */
    private static void startup() {
        int taskNumber = 0;
        while (taskNumber != -1) {
            taskNumber = scanner.nextInt();
            scanner.nextLine();

            switch (taskNumber) {
                case 1 -> {
                    System.out.println("Назначьте размер массиву");
                    new ArrayTask(scanner.nextInt()).print();
                    scanner.nextLine();
                }
                case 2 -> {
                    System.out.println("Назначьте размер списку");
                    new ListTask(scanner.nextInt()).print();
                    scanner.nextLine();
                }
                case 3 -> new EmployeeListMap().print();
                case 4 -> new HttpTask().print();
                case 5 -> new FileSyncInput(scanner).handleFileSync();
                case -1 -> System.out.println("Выход");
                default -> System.out.println("Неверный номер задачи.");
            }
        }
        scanner.close();
    }
}