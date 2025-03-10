package org.example.interfaceTask;

import java.util.Scanner;

/**
 * Ввод синхронизации файлов
 */
public class FileSyncInput {

    private final Scanner scanner;

    /**
     * Конструктор FileSyncInput. Получает ссылку на сканер
     * @param scanner сканер
     */
    public FileSyncInput(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Перехватить команды для работы синхронизации файлов
     */
    public void handleFileSync() {
        System.out.println("Путь до основной папки:");
        String sourcePath = scanner.nextLine();
        System.out.println("Путь до целевой папки:");
        String targetPath = scanner.nextLine();

        FileSyncStatus task = new FileSyncStatus(sourcePath, targetPath);

        System.out.println("""
                    Запустить - start
                    Остановить - stop
                    Выйти из задачи - back
                    """);

        while (true) {
            String command = scanner.nextLine();

            if (command.equalsIgnoreCase("start")) {
                task.start();
            } else if (command.equalsIgnoreCase("stop")) {
                task.stop();
            } else if (command.equalsIgnoreCase("back")) {
                break;
            } else {
                System.out.println("Неизвестная команда. Попробуйте снова.");
            }
        }
    }
}
