package onboarding.problem5;

public class Calculator {
    public static boolean isBigger(int money, int baseMoney) {
        if (money >= baseMoney) {
            return true;
        }
        return false;
    }
    public static int getQuotient(int money, int baseMoney) {
        int quotient = money / baseMoney;
        return quotient;
    }
}
