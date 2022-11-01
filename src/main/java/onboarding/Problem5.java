package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Problem5 {


    public static ArrayList<Integer> solution(int money) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] moneySort = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for (int i=0; i<moneySort.length; i++){
            int add = 0;
            add = (money / moneySort[i]);
            money = money % moneySort[i];
            answer.add(add);
        }
        return answer;
    }
}
