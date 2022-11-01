package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        return logic(money);
    }

    public static List<Integer> logic(int money) {


        int residual = money;
        List<Integer> wallet = new ArrayList<>(9);

        for (int i = 0; i <= 8; i++) {
            wallet.add(0);
        }

        while (residual != 0) {


            if (residual >= 50000) { //오만원
                int num = residual / 50000;
                wallet.set(0, num);
                residual = residual % 50000;
            }

            if (residual >= 10000) { //만원
                int num = residual / 10000;
                wallet.set(1, num);
                residual = residual % 10000;
            }

            if (residual >= 5000) { //오천원
                int num = residual / 5000;
                wallet.set(2, num);
                residual = residual % 5000;
            }

            if (residual >= 1000) { // 천원
                int num = residual / 1000;
                wallet.set(3, num);
                residual = residual % 1000;
            }

            if (residual >= 500) { //오백원
                int num = residual / 500;
                wallet.set(4, num);
                residual = residual % 500;
            }

            if (residual >= 100) { //백원
                int num = residual / 100;
                wallet.set(5, num);
                residual = residual % 100;
            }

            if (residual >= 50) { //오십원
                int num = residual / 50;
                wallet.set(6, num);
                residual = residual % 50;
            }

            if (residual >= 10) { //십원
                int num = residual / 10;
                wallet.set(7, num);
                residual = residual % 10;
            }

            if (residual >= 1) { //일원
                int num = residual;
                wallet.set(8, num);
                residual = 0;
            }

        }

        return wallet;
    }
}
