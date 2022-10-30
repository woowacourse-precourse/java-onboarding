package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(9);
        distribute(answer,money);

        return answer;
    }
    public static List<Integer> distribute(List<Integer> answer , int money) { // 입력받은 금액을 조건에 맞게 환전
        int[] cloud = {50000 ,10000 ,5000 ,1000 ,500 ,100, 50, 10, 1};
        int repeat;
        for(int i=0;i< cloud.length;i++) {

            repeat =0;

            while(cloud[i]<=money) {
                money -= cloud[i];
                repeat++;
            }
            answer.add(i,repeat); // i칸에 반복된 횟수만큼 저장
        }
        return answer;
    }
}
