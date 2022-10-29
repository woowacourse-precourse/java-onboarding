package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();
        for (int i=0; i<9; i++) {
            answer.add(0);
        }
        while(true) {
            if (money < 10) {
                answer.set(8, answer.get(8)+money);
                break;
            } else if(money < 50) {
                answer.set(7, answer.get(7)+(int)(money/10));
                money -= (int)(money/10)*10;
            } else if(money < 100) {
                answer.set(6, answer.get(6)+(int)(money/50));
                money -= (int)(money/50)*50;
            } else if(money < 500) {
                answer.set(5, answer.get(5)+(int)(money/100));
                money -= (int)(money/100)*100;
            } else if(money < 1000) {
                answer.set(4, answer.get(4)+(int)(money/500));
                money -= (int)(money/500)*500;
            } else if(money < 5000) {
                answer.set(3, answer.get(3)+(int)(money/1000));
                money -= (int)(money/1000)*1000;
            } else if(money < 10000) {
                answer.set(2, answer.get(2)+(int)(money/5000));
                money -= (int)(money/5000)*5000;
            } else if(money < 50000) {
                answer.set(1, answer.get(1)+(int)(money/10000));
                money -= (int)(money/10000)*10000;
            } else {
                answer.set(0, answer.get(0)+(int)(money/50000));
                money -= (int)(money/50000)*50000;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        System.out.println(solution(money));
    }
}
