package org.example.interfaceTask;

import java.io.IOException;
import java.nio.file.*;
import java.util.logging.Logger;

/**
 * Синхронизация файлов
 */
public class FileSync {

    private final Path sourceDir;
    private final Path targetDir;
    private final static Logger LOGGER = Logger.getLogger(FileSync.class.getName());

    /**
     * Конструктор FileSync. Получает путь до основной и
     * целевой папки
     * @param sourceDir основная папка
     * @param targetDir целевая папка
     */
    public FileSync(String sourceDir, String targetDir) {
        this.sourceDir = Paths.get(sourceDir);
        this.targetDir = Paths.get(targetDir);
    }

    /**
     * Синхронизировать файлы из папок
     */
    protected void syncFiles() {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(sourceDir)) {
            for (Path sourceFile : stream) {
                Path targetFile = targetDir.resolve(sourceFile.getFileName());
                if (Files.exists(targetFile)) {
                    if (Files.getLastModifiedTime(sourceFile)
                            .compareTo(Files.getLastModifiedTime(targetFile)) > 0) {
                        Files.copy(sourceFile, targetFile,
                                StandardCopyOption.REPLACE_EXISTING);
                        LOGGER.info("Синхронизация: " + sourceFile + " ---> " + targetFile);
                    }
                } else {
                    Files.copy(sourceFile, targetFile);
                    LOGGER.info("Синхронизация: " + sourceFile + " ---> " + targetFile);
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка синхронизации: " + e.getMessage());
        }
    }
}
