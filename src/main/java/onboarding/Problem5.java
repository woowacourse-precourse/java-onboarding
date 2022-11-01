package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Problem5 {
    public static List<Integer> solution(int money) {

        List<Integer> answer = new ArrayList<>();

        int[] moneyStandard = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for(int i = 0; i < moneyStandard.length; i++)
        {
            answer.add(money / moneyStandard[i]);
            money = money % moneyStandard[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("금액을 입력하십시오.");
        List<Integer> answer = solution(scanner.nextInt());

        System.out.println(answer.toString());
    }

}
