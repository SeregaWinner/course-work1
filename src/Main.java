import java.util.Random;

public class Main {

//        System.out.println("Hello world!");

    private final static Employee[] REPOSITORY = new Employee[10];


    // Метод рандома для Ф.И.О и зп...
    private final static Random RANDOM = new Random();
    private final static String[] MALE_SURNAMES = {"Иванов", "Смирнов", "Петров", "Сидоров", "Сергеев", "Алексеев"};
    private final static String[] MALE_NAMES = {"Сергей", "Иван", "Петр", "Александр", "Игорь", "Дмитрий"};
    private final static String[] MALE_PATRONYMIC_NAMES = {"Сергеевич", "Иванович", "Петрович", "Алексеевич", "Александрович"};


    private static Employee generateEmployee() {
        return new Employee(
                MALE_SURNAMES[RANDOM.nextInt(MALE_SURNAMES.length)] + " " +
                        MALE_NAMES[RANDOM.nextInt(MALE_NAMES.length)] + " " +
                        MALE_PATRONYMIC_NAMES[RANDOM.nextInt(MALE_PATRONYMIC_NAMES.length)],

                RANDOM.nextInt(1, 6),
                RANDOM.nextInt(50_000, 100_000)
        );
    }

    private static void printEmployee() {
        System.out.println("Сотрудники: ");
        for (Employee employee : REPOSITORY) {
            System.out.println(employee);
        }
    }

    // Общая сумма затрат на выплаты...
    public static double calculateSumSalary() {
        double totalSalary = 0;
        for (Employee employee : REPOSITORY) {
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
        for (int in = 0; in < REPOSITORY.length; in++) {
            if (REPOSITORY[in] != null && maxSalary < REPOSITORY[in].getSalary()) {
                maxSalary = REPOSITORY[in].getSalary();
                i = in;
            }
        }
        return REPOSITORY[i];
    }

    // Минимальная ставка...
    public static Employee calculateMinSalary() {
        double minSalary = Double.MAX_VALUE;
        int i = 0;
        for (int in = 0; in < REPOSITORY.length; in++) {
            if (REPOSITORY[in] != null && minSalary > REPOSITORY[in].getSalary()) {
                minSalary = REPOSITORY[in].getSalary();
                i = in;
            }
        }
        return REPOSITORY[i];
    }

    // Среднее значение...
    public static double calculateMiddleSalary() {
        return calculateSumSalary() / REPOSITORY.length;
    }

    // Вывод Ф.И.О...
    public static Employee printFullName() {
        System.out.println("Ф.И.О сотрудников: ");
        for (Employee employee : REPOSITORY) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
        return null;
    }

    // Индексация зп...
    public static void increaseSalary(double percentForPerson) {
        for (Employee employee : REPOSITORY) {
            if (employee != null) {
                employee.setSalary(employee.getSalary() * (1 +  percentForPerson / 100));
            }
        }
    }
    //Максимальная зп по отделу...
    public static Employee calculateMaxSalaryInDepartment(int numbDepartment) {
        double maxSalary = Double.MIN_VALUE;
        int i = 0;
        for (int in = 0; in < REPOSITORY.length; in++) {
            if (REPOSITORY[in] != null && REPOSITORY[in].getDepartment() == numbDepartment &&
                    maxSalary < REPOSITORY[in].getSalary()) {
                maxSalary = REPOSITORY[in].getSalary();
                i = in;
            }
        }
        return REPOSITORY[i];
    }

    //Минимальная зп по отделу...
    public static Employee calculateMinSalaryInDepartment(int numbDepartment) {
        double minSalary = Double.MAX_VALUE;
        int i = 0;
        for (int in = 0; in < REPOSITORY.length; in++) {
            if (REPOSITORY[in] != null && REPOSITORY[in].getDepartment() == numbDepartment &&
                    minSalary > REPOSITORY[in].getSalary()) {
                minSalary = REPOSITORY[in].getSalary();
                i = in;
            }
        }
        return REPOSITORY[i];
    }

    // Сумма по отделу...
    public static double calculateSumSalaryInDepartment(int numbDepartment) {
        double totalSalary = 0;
        for (Employee employee : REPOSITORY) {
            if (employee != null && employee.getDepartment() == numbDepartment) {
                totalSalary += employee.getSalary();
            }
        }
        return totalSalary;
    }

    // Среднее значение по отделу...
    public static double calculateMiddleSalaryInDepartment(int numbDepartment) {
        double sumSalary = 0;
        int count = 0;
        for (Employee employee : REPOSITORY) {
            if (employee != null && employee.getDepartment() == numbDepartment) {
                count += 1;
                sumSalary += employee.getSalary();
            }
        }
        if (count != 0) {
            return sumSalary / count;
        } else {
            return count;
        }
    }

    //Индексация зп по отделу...
    public static void increaseSalaryInDepartment(double percentForPerson, int numbDepartment) {
        for (Employee employee : REPOSITORY) {
            if (employee != null && employee.getDepartment() == numbDepartment) {
                employee.setSalary(employee.getSalary() * (1 + percentForPerson / 100));
            }
        }
    }

    //Вывод сотрудников отдела...
    public static void printEmployeeInDepartment(int numbDepartment) {
        for (int i = 0; i < REPOSITORY.length; i++) {
            if (REPOSITORY[i] != null && REPOSITORY[i].getDepartment() == numbDepartment) {
                printInfo(REPOSITORY, i);
            }
        }
    }

    //Сотрудники отдела с зп меньше числа...
    public static void outputSalaryParametersLessNumber(double salaryForSelectionEmployees) {
        System.out.println("Сотрудники с зарплатой < " + salaryForSelectionEmployees + ": ");
        for (int i = 0; i < REPOSITORY.length; i++) {
            if (REPOSITORY[i] != null && REPOSITORY[i].getSalary() < salaryForSelectionEmployees) {
                printInfo(REPOSITORY, i);
            }

        }
    }

    //Сотрудники отдела с зп больше числа...
    public static void outputSalaryParametersMoreNumber(double salaryForSelectionEmployees) {
        System.out.println("Сотрудники с зарплатой >= " + salaryForSelectionEmployees + ": ");
        for (int i = 0; i < REPOSITORY.length; i++) {
            if (REPOSITORY[i] != null && REPOSITORY[i].getSalary() >= salaryForSelectionEmployees) {
                printInfo(REPOSITORY, i);
            }
        }
    }
    //Вывод информации...
    public static void printInfo(Employee [] REPOSITORY, int i) {
        System.out.print("№" + REPOSITORY[i].getId() + ", ");
        System.out.print("Ф.И.О " + REPOSITORY[i].getFullName() + ", ");
        System.out.print("зарплата " + REPOSITORY[i].getSalary() + ".");
        System.out.println();
    }


    ////////// ВЫВОД В КОНСОЛЬ!!!///////////
    public static void main(String[] args) {
        for (int i = 0; i < REPOSITORY.length; i++) {
            REPOSITORY[i] = generateEmployee();
        }

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
        printEmployee();
        System.out.println(printFullName);
        System.out.println();


///////////////ПОВЫШЕННАЯ СЛОЖНОСТЬ/////////////////////
        //Индексация зп...
        increaseSalary(0);
        //Индексация зп по отделу...
        increaseSalaryInDepartment(0, 0);

        //Вывод сотрудников отдела...
        printEmployeeInDepartment(4);
        //Макс..
        System.out.println("Сотрудник с максимальной зп  по отделу " + calculateMaxSalaryInDepartment(4));
        System.out.println();
        //Мин...
        System.out.println("Сотрудник с минемальной зп по отделу " + calculateMinSalaryInDepartment(4));
        System.out.println();
        //Сумма затрат на отдел...
        System.out.printf("Сумма затрат на выплаты по отделу: " + calculateSumSalaryInDepartment(4));
        System.out.println();
        //Среднее значение по отделу...
        System.out.format("Среднее значение затрат по отделу: " + calculateMiddleSalaryInDepartment(4));
        System.out.println();

        //Сотрудники отдела с зп меньше числа...
        outputSalaryParametersLessNumber(80_000);
        //Сотрудники отдела с зп больше числа...
        outputSalaryParametersMoreNumber(60_000);


    }


}