package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem5 {

    private static final int CONVERT_MONEY_AMOUNT1 = 50000;
    private static final int CONVERT_MONEY_AMOUNT2 = 10000;
    private static final int CONVERT_MONEY_AMOUNT3 = 5000;
    private static final int CONVERT_MONEY_AMOUNT4 = 1000;
    private static final int CONVERT_MONEY_AMOUNT5 = 500;
    private static final int CONVERT_MONEY_AMOUNT6 = 100;
    private static final int CONVERT_MONEY_AMOUNT7 = 50;
    private static final int CONVERT_MONEY_AMOUNT8 = 10;
    private static final int CONVERT_MONEY_AMOUNT9 = 1;
    private static final int INIT_NUMBER_OF_MONEY_VALUE = 0;
    private static final int INT_VARIABLE_INIT_VALUE = 0;
    private static final String EXCEPTION_MESSAGE_PREFIX = "[ERROR] : ";
    private static final String WRONG_WITHDRAW_MONEY_RANGE_EXCEPTION_MESSAGE = "출금 금액은 1원 이상 1,000,000원 이하여야합니다.";
    private static final int MIN_WITHDRAW_MONEY = 1;
    private static final int MAX_WITHDRAW_MONEY = 1000000;

    private static int withdrawMoney;
    private static final Map<Integer, Integer> moneyMap = new LinkedHashMap<>();

    public static List<Integer> solution(int inputWithdrawMoney) {
        validateWithdrawMoney(inputWithdrawMoney);
        withdrawMoney = inputWithdrawMoney;
        initMoneyMap();
        convertWithdrawMoney();
        return moneyMapValuesConvertToMoneyList();
    }

    public static void initMoneyMap() {
        moneyMap.put(CONVERT_MONEY_AMOUNT1, INIT_NUMBER_OF_MONEY_VALUE);
        moneyMap.put(CONVERT_MONEY_AMOUNT2, INIT_NUMBER_OF_MONEY_VALUE);
        moneyMap.put(CONVERT_MONEY_AMOUNT3, INIT_NUMBER_OF_MONEY_VALUE);
        moneyMap.put(CONVERT_MONEY_AMOUNT4, INIT_NUMBER_OF_MONEY_VALUE);
        moneyMap.put(CONVERT_MONEY_AMOUNT5, INIT_NUMBER_OF_MONEY_VALUE);
        moneyMap.put(CONVERT_MONEY_AMOUNT6, INIT_NUMBER_OF_MONEY_VALUE);
        moneyMap.put(CONVERT_MONEY_AMOUNT7, INIT_NUMBER_OF_MONEY_VALUE);
        moneyMap.put(CONVERT_MONEY_AMOUNT8, INIT_NUMBER_OF_MONEY_VALUE);
        moneyMap.put(CONVERT_MONEY_AMOUNT9, INIT_NUMBER_OF_MONEY_VALUE);
    }

    public static void convertWithdrawMoney() {
        moneyMap.keySet().stream()
                .forEach(moneyUnit -> {
                    int numberOfMoney = INT_VARIABLE_INIT_VALUE;
                    numberOfMoney = withdrawMoney / moneyUnit;
                    withdrawMoney %= moneyUnit;
                    inputMoney(moneyUnit, numberOfMoney);
                });
    }

    public static void inputMoney(int moneyUnit, int numberOfMoney) {
        moneyMap.put(moneyUnit, numberOfMoney);
    }

    public static List<Integer> moneyMapValuesConvertToMoneyList() {
        return moneyMap.values().stream()
                .collect(Collectors.toList());
    }

    public static void validateWithdrawMoney(int withdrawMoney) {
        if(!validateWithdrawMoneyRange(withdrawMoney)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_PREFIX + WRONG_WITHDRAW_MONEY_RANGE_EXCEPTION_MESSAGE );
        }
    }

    public static boolean validateWithdrawMoneyRange(int withdrawMoney) {
        return (withdrawMoney >= MIN_WITHDRAW_MONEY && withdrawMoney <= MAX_WITHDRAW_MONEY);
    }
}
