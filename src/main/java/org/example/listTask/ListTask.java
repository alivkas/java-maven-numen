package org.example.listTask;

import org.example.interfaces.Output;
import org.example.utils.CollectionGenerateUtils;

import java.util.List;

/**
 * Сортировка вставками
 */
public class ListTask implements Output {

    private final CollectionGenerateUtils collectionGenerate = new CollectionGenerateUtils();
    private final List<Double> list;

    /**
     * Конструктор ListTask, инициализирующий длину
     * сгенерированного списка
     * @param size длина списка
     */
    public ListTask(int size) {
        list = collectionGenerate.generateList(size);
    }

    @Override
    public void print() {
        try {
            System.out.println("Неотсортированный список: " + list + "\n"
                    + "Отсортированный список: " + insertionSort(list));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Отсортировать список алгоритмом "сортировка вставками"
     * @param list неотсортированный список
     * @return отсортированный список
     */
    private List<Double> insertionSort(List<Double> list) {
        int j;
        for (int i = 1; i < list.size(); i++) {
            Double swap = list.get(i);
            for (j = i; j > 0 && swap < list.get(j-1); j--) {
                list.set(j, list.get(j - 1));
            }
            list.set(j, swap);
        }
        return list;
    }
}
