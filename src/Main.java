import java.util.Arrays;

public class Main {

//        System.out.println("Hello world!");

    public static Employee[] repository = new Employee[10];

    // Общая сумма затрат на выплаты...
    public static double calculateSumSalary() {
        double totalSalary = 0;
        for (Employee employee : repository) {
            if (employee != null) {
                totalSalary = employee.getSalary() + totalSalary;
            }
        }
        return totalSalary;
    }

    // Максимальная ставка...
    public static Employee calculateMaxSalary() {
        double maxSalary = Double.MIN_VALUE;
        int i = 0;
        for (int in = 0; in < repository.length; in++) {
            if (repository[in] != null && maxSalary < repository[in].getSalary()) {
                maxSalary = repository[in].getSalary();
                i = in;
            }
        }
        return repository[i];
    }

    // Минимальная ставка...
    public static Employee calculateMinSalary() {
        double minSalary = Double.MAX_VALUE;
        int i = 0;
        for (int in = 0; in < repository.length; in++) {
            if (repository[in] != null && minSalary > repository[in].getSalary()) {
                minSalary = repository[in].getSalary();
                i = in;
            }
        }
        return repository[i];
    }

    // Среднее значение...
    public static double calculateMiddleSalary() {
        int middle = 0;
        double totalSalary = 0;
        for (Employee employee : repository) {
            if (employee != null) {
                middle += 1;
                totalSalary = employee.getSalary() + totalSalary;
            }
        }
        if (middle != 0) {
            return totalSalary / middle;
        } else {
            return middle;
        }
    }

    // Вывод Ф.И.О...
    public static Employee printFullName() {
        for (Employee employee : repository) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
        return null;
    }

    public static void main(String[] args) {
        repository[0] = new Employee("Александров Александр Александрович", 1, 25_000);
        repository[1] = new Employee("Иванов Иван иванович", 1, 20_000);
        repository[2] = new Employee("Семенов Семен Семенович", 2, 23_000);
        repository[3] = new Employee("Сергеев Сергей Сергеевич", 2, 28_000);
        repository[4] = new Employee("Петров Петр Петрович", 3, 33_000);
        repository[5] = new Employee("Константинов Константин Константинович", 3, 30_000);
        repository[6] = new Employee("Николаев Никой Николаевич", 4, 50_000);
        repository[7] = new Employee("Алексеев Алексей Алексеевич", 4, 35_000);
        repository[8] = new Employee("Дмитриев Дмитрий Дмитриевич", 5, 42_000);
        repository[9] = new Employee("Юрьев Юрий Юрьевич", 5, 45_000);
        System.out.print(Arrays.toString(repository));
        System.out.println();
        //Сумма зп за месяц...
        double totalSalary = Main.calculateSumSalary();
        System.out.println("Сумма затрат на выплаты, за месяц составила: " + totalSalary);
        //Максимальное значение зп...
        Employee maxSalary = Main.calculateMaxSalary();
        System.out.println("Максимальная зарплата у сотрудника: " + maxSalary);
        //Минимальное значение зп...
        Employee minSalary = Main.calculateMinSalary();
        System.out.println("Минимальная зарплата у сотрудника: " + minSalary);
        //Среднее значение зп...
        System.out.println("Среднее значение зарплаты составило: " + calculateMiddleSalary());
        // Распечатать ФИО всех сотрудников...
        Employee printFullName = Main.printFullName();
        System.out.println(printFullName);
    }


}