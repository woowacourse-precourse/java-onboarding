package onboarding;

import java.util.*;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {

        ArrayList<Integer> list = new ArrayList<>();
        List<Integer> answer = Collections.emptyList();

        int arr[] = new int[9];

        while (money != 0) {

            if (money >= 50000) {
                money = money - 50000;

                arr[0]++;
            } else if (money >= 10000 && money < 50000) {
                money = money - 10000;

                arr[1]++;
            } else if (money >= 5000 && money < 10000) {
                money = money - 5000;

                arr[2]++;
            } else if (money >= 1000 && money < 5000) {
                money = money - 1000;

                arr[3]++;
            } else if (money >= 500 && money < 1000) {
                money = money - 500;

                arr[4]++;
            }else if (money >= 100 && money <500) {
                money = money - 100;

                arr[5]++;
            }else if (money >= 50 && money < 100) {
                money = money - 50;

                arr[6]++;
            }else if (money >= 10 && money < 50) {
                money = money - 10;

                arr[7]++;
            }else if (money >= 1 && money < 10) {
                money = money - 1;

                arr[8]++;
            }

        }
        for(int i = 0 ; i <arr.length; i ++) {
            int input = arr[i];
            list.add(input);
        }
        answer = list;
        return answer;
    }
}