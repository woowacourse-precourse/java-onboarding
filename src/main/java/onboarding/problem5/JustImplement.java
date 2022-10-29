package onboarding.problem5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JustImplement {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();
        int coinIndex = 0;
        int arrCnt = 0;
        int arrIndex = 0;

        List<Integer> arrResult = new ArrayList<>();

        int[] coin = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        // 입력값이 15,000 같은 경우 50,000 넘기기 위해
        while (input <= (coin[coinIndex])) {
            coinIndex++;
            arrIndex++;
            arrResult.add(arrCnt);
        }

        //     90000  >=  50000
        while (input >= (coin[coinIndex])) {

            input = input - coin[coinIndex];
            arrCnt++; // 출력할 값 증가 시키기


            // 종료 시켜주기 위해
            if (input == 0) {
                arrResult.add(arrCnt);
                arrCnt = 0;

                // 15000 같은 경우 [0, 1, 1] 만 출력 되는데,
                // 뒤에 '0' 을 추가 시켜주기 위해.
                while (arrIndex < 8) {
                    arrIndex++;
                    arrResult.add(arrCnt);
                }

                break;
            }

            // 50000 -> 10000 -> 5000 순으로 증가 시켜주기 위해
            // 아닐 경우, 위 과정 반복
            while (input < (coin[coinIndex])) {
                coinIndex++;
                arrIndex++;
                arrResult.add(arrCnt);
                arrCnt = 0;
            }
        }

        System.out.println(arrResult);

    }
}