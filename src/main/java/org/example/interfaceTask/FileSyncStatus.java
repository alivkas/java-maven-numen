package org.example.interfaceTask;

import org.example.interfaces.Task;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Реализуйте интерфейс “Task” для синхронизации файлов между
 * двумя заданными папками. Каждый синхронизированный файл логируется
 * в консоль. Метод start() начинает процесс синхронизации, а stop()
 * останавливает его. Для выполнения задания рекомендуется использовать
 * классы из пакета “java.nio.file”.
 */
public class FileSyncStatus implements Task {

    private boolean isRun;
    private final ScheduledExecutorService scheduler;
    private final FileSync fileSync;
    private final static Logger LOGGER = Logger.getLogger(FileSyncStatus.class.getName());

    /**
     * Конструктор FileSync. Получает путь до основной и
     * целевой папки
     * @param sourceDir основная папка
     * @param targetDir целевая папка
     */
    public FileSyncStatus(String sourceDir, String targetDir) {
        isRun = false;
        scheduler = Executors.newScheduledThreadPool(1);
        fileSync = new FileSync(sourceDir, targetDir);
    }

    @Override
    public void start() {
        if (isRun) {
            LOGGER.info("Синхронизация уже запущена");
            return;
        }
        isRun = true;
        scheduler.scheduleAtFixedRate(fileSync::syncFiles, 0,
                1, TimeUnit.SECONDS);
        LOGGER.info("Синхронизация запущена");
    }

    @Override
    public void stop() {
        if (!isRun) {
            LOGGER.info("Синхронизация не запущена");
        }
        isRun = false;
        scheduler.shutdown();
        LOGGER.info("Синхронизация остановлена");
    }
}
