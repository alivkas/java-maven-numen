package org.example.streamTask;

/**
 * Сотрудник
 */
public class Employee {

    private String fullName;
    private Integer age;
    private String department;
    private Double salary;

    /**
     * Конструктор Employee
     * @param fullName ФИО
     * @param age возраст
     * @param department отдел
     * @param salary З/П
     */
    public Employee(String fullName,
                    Integer age,
                    String department,
                    Double salary) {
        this.fullName = fullName;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    /**
     * Установить ФИО сотрудника
     * @param fullName ФИО сотрудника
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Получить ФИО сотрудника
     * @return ФИО сотрудника
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Установить возраст сотрудника
     * @param age возраст сотрудника
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * Получить возраст сотрудника
     * @return возраст сотрудника
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Установить отдел сотрудника
     * @param department отдел сотрудника
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Получить отдел сотрудника
     * @return отдел сотрудника
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Установить зарплату сотрудника
     * @param salary зарплата сотрудника
     */
    public void setSalary(Double salary) {
        this.salary = salary;
    }

    /**
     * Получить зарплату сотрудника
     * @return зарплата сотрудника
     */
    public Double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return fullName + " - "
                + age + " - "
                + department + " - "
                + salary;
    }
}
