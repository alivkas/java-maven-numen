package org.example.streamTask;

import org.example.interfaces.Output;

import java.util.ArrayList;
import java.util.List;

/**
 * Преобразование списка сотрудников
 */
public class EmployeeListMap implements Output {

    @Override
    public void print() {
        System.out.println("Изначальный список:");
        init().forEach(System.out::println);
        System.out.println(" ");
        System.out.println("Преобразованный:");
        employeeListMap().forEach(System.out::println);
    }

    /**
     * Инициализация объектов со списком
     * @return Список с сотрудниками
     */
    private List<Employee> init() {
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee("Иванов Иван Иванович",
                32, "Продажи", 45000.0));
        employeeList.add(new Employee("Олегов Олег Олегович",
                27, "IT", 90000.0));
        employeeList.add(new Employee("Сергеев Сергей Сергеевич",
                38, "Бухгалтерия", 70000.0));
        employeeList.add(new Employee("Пупкин Василий Васильевич",
                19, "Аналитика", 50000.0));
        employeeList.add(new Employee("Максимов Максим Максимович",
                22, "Дизайн", 60000.0));

        return employeeList;
    }

    /**
     * Преобразовать список сотрудников в список строк
     * вида "ИМЯ - ОТДЕЛ"
     * @return список строк вида "ИМЯ - ОТДЕЛ"
     */
    private List<String> employeeListMap() {
        List<Employee> employeeList = init();

        return employeeList.stream()
                .map(employee -> employee.getFullName().split(" ")[1]
                        + " - " + employee.getDepartment())
                .toList();
    }
}
