import java.util.Scanner;

public class DepositCalculator {
    double yearRate = 0.06;
    int places = 2;

    double calculateComplexPercent(double amount, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return calculateRound(pay);
    }

    double calculateSimplePercent(double amount, int depositPeriod) {
        return calculateRound(amount + amount * yearRate * depositPeriod);
    }

    double calculateRound(double value) {
        double ScaLe = Math.pow(10, places); //  ScaLe лучше назвать просто scale
        return Math.round(value * ScaLe) / ScaLe;
    }

    void calculateValueOfContribution() {
        int period;
        int action;
        Scanner input = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = input.nextInt(); // Объявление переменной лучше вывести наверх к остальным, здесь написать как и в остальных - amount = input...
        System.out.println("Введите срок вклада в годах:");
        period = input.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = input.nextInt();
        double outDoubleVar = 0; // В названии переменной указан ее тип 

        if (action == 1) outDoubleVar = calculateSimplePercent(amount, period);
        else if (action == 2) {
            outDoubleVar = calculateComplexPercent(amount, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в "
                + outDoubleVar);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateValueOfContribution();

    }
}
