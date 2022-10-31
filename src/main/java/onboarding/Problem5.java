package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>(); //돈 단위별 필요한 개수를 담을 리스트 생성
        for (int i=0; i<9; i++) { //돈 단위별 개수를 0으로 초기화
            answer.add(0);
        }
        while(true) { //최소 한자리 수
            if (money < 10) { // 10보다 작을 때는 money의 크기만큼 1원짜리 동전의 개수를 추가
                answer.set(8, answer.get(8)+money);
                break;
            } else if(money < 50) { // 50보다 작을 때는 10원짜리 동전의 개수 추가
                answer.set(7, answer.get(7)+(int)(money/10));
                money -= (int)(money/10)*10;
            } else if(money < 100) { // 100보다 작을 때는 50원짜리 동전의 개수 추가
                answer.set(6, answer.get(6)+(int)(money/50));
                money -= (int)(money/50)*50;
            } else if(money < 500) { // 500보다 작을 때는 100원짜리 동전의 개수 추가
                answer.set(5, answer.get(5)+(int)(money/100));
                money -= (int)(money/100)*100;
            } else if(money < 1000) { // 1000보다 작을 때는 500원짜리 동전의 개수 추가
                answer.set(4, answer.get(4)+(int)(money/500));
                money -= (int)(money/500)*500;
            } else if(money < 5000) { // 5000보다 작을 때는 1000원권 개수 추가
                answer.set(3, answer.get(3)+(int)(money/1000));
                money -= (int)(money/1000)*1000;
            } else if(money < 10000) { // 10000보다 작을 때는 5000원권 개수 추가
                answer.set(2, answer.get(2)+(int)(money/5000));
                money -= (int)(money/5000)*5000;
            } else if(money < 50000) {// 50000보다 작을 때는 10000원권 개수 추가
                answer.set(1, answer.get(1)+(int)(money/10000));
                money -= (int)(money/10000)*10000;
            } else { // 50000이상일 때는 50000원권 개수 추가
                answer.set(0, answer.get(0)+(int)(money/50000));
                money -= (int)(money/50000)*50000;
            }
        }
        return answer; //리스트 반환
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        System.out.println(solution(money));
    }

}
