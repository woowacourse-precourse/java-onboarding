package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    static int[] seatMoney = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        int resultArrSize = seatMoney.length;
        ArrayList<Integer> resultArr = new ArrayList<>(resultArrSize);
        getResultArr(resultArr, money);
        return resultArr;
    }

    private static void getResultArr(ArrayList<Integer> arr, int money) {
        int[] intArr = new int[2];
        int end = seatMoney.length;
        for (int i = 0; i < end; i++) {
            if (invertorMoney(money, seatMoney[i], intArr)) {
                int typeMoney = intArr[0];
                arr.add(typeMoney);
                money = intArr[1];
            } else {
                arr.add(0);
            }
        }
    }

    // intArr 에 [ 지페의 갯수, 남은 돈 ] 을 하여 할당한다.
    private static boolean invertorMoney(int money, int typeMoney, int[] intArr) {
        if (money >= typeMoney) {
            intArr[0] = money / typeMoney;
            intArr[1] = money - intArr[0] * typeMoney;
            return true;
        } else {
            return false;
        }
    }
}
