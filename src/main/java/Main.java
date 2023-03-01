import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int earnings = 0;
        int spendings = 0;
        while (true) {

            System.out.println("1 - Добавить новый доход");
            System.out.println("2 - Добавить новый расход");
            System.out.println("3 - Выбрать систему налогообложения");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    String moneyStr = scanner.nextLine();
                    int money = Integer.parseInt(moneyStr);
                    earnings += money;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода:");

                    String moneyStr1 = scanner.nextLine();
                    int money1 = Integer.parseInt(moneyStr1);
                    spendings += money1;
                    break;
                case 3:
                    int taxPlus = taxEarnings(earnings);
                    int taxMinus = taxEarningsMinusSpendings(earnings,spendings);
                    if (taxPlus < taxMinus) {
                        System.out.println("Мы советуем вам УСН доходы");
                        System.out.println("Ваше налог составит: " + taxPlus);
                        System.out.println("Налог на другой системе: " + taxMinus);
                        System.out.println("Экономия: " + (taxMinus - taxPlus));
                    } else {
                        System.out.println("Мы советуем вам УСН доходы минус расходы");
                        System.out.println("Ваше налог составит: " + taxMinus);
                        System.out.println("Налог на другой системе: " + taxPlus);
                        System.out.println("Экономия: " + (taxPlus - taxMinus));
                    }
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }
    }
    public static int taxEarnings(int earnings) {

        int tax1 = earnings * 6 / 100;
        if (tax1 >= 0) {
            return tax1;
        } else {
            return 0;
        }

    }

    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings/spendings);
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }

    public boolean notEquals(int a, int b) {
        if (taxEarnings(a) >= taxEarningsMinusSpendings(a, b)) {
            return true;
        } else return false;
    }

}

