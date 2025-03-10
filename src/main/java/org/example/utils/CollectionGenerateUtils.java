package org.example.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Генерация коллекций со случайными значениями
 */
public class CollectionGenerateUtils {

    private final Random random = new Random();

    /**
     * Генерация массива с рандомными значениями от -100 до 100
     * @param size длина массива
     * @return массив с рандомными значениями
     */
    public int[] generateArray(int size) {
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(-100, 100);
        }
        return array;
    }

    /**
     * Генерация списка с рандомными плавающими значениями от -100.0 до 100.0
     * @param size длина списка
     * @return список с рандомными значениями
     */
    public List<Double> generateList(int size) {
        List<Double> list = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            list.add(random.nextDouble(-100, 100));
        }
        return list;
    }
}
