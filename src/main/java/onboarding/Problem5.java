package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        List<Integer> num = new ArrayList<Integer>();
        int [] num_list = {50000,10000,5000,1000,500,100,50,10,1};
        for (int i = 0; i < num_list.length; i++) {
            if (money >= num_list[i]) {
                num.add(money / num_list[i]);
                money = money % num_list[i];
            } else {
                num.add(0);
            }
        }
        return num;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        System.out.println(solution(money));
    }
}
