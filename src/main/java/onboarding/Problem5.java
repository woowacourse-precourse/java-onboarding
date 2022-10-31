package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        System.out.println("====solution====");
        //동전 배열
        int[] unit = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> result = new ArrayList<Integer>();
        int index = 0;

        //인출 하기
        while(index<9) {
            System.out.println(index+ " 번 째...");
            System.out.print("인출 전 money: "+money+", 인출 중...: "+money/unit[index]);
            result.add(money/unit[index]);
            money-=result.get(index)*unit[index];
            System.out.println(", 인출 후 money: "+money);
            index++;
        }
        System.out.println("====solution end====");

        return result;
    }
}
