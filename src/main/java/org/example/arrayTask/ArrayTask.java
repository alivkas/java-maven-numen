package org.example.arrayTask;

import org.example.interfaces.Output;
import org.example.utils.CollectionGenerateUtils;

import java.util.Arrays;

/**
 * Найти минимальное значение по модулю в массиве
 */
public class ArrayTask implements Output {

    private final CollectionGenerateUtils collectionGenerate = new CollectionGenerateUtils();
    private final int[] array;

    /**
     * Конструктор ArrayTask, инициализирующий длину
     * сгенерированного массива
     * @param size длина массива
     */
    public ArrayTask(int size) {
        array = collectionGenerate.generateArray(size);
    }

    @Override
    public void print() {
        try {
            System.out.println("Массив: " + Arrays.toString(array) + "\n"
                    + "Минимальное значение по модулю: "
                    + findMinAbsoluteValue(array));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Найти минимальное значение по модулю в массиве
     * @param array массив длиной n [0, ∞)
     * @return минимальное значение по модулю
     */
    private int findMinAbsoluteValue(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Массив пуст");
        }

        int[] absoluteSortedArr = Arrays.stream(array)
                .map(Math::abs)
                .sorted()
                .toArray();

        return absoluteSortedArr[0];
    }
}
