package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// 기능목록
// 1.배열에 모든 지폐의 단위 +
// 2.지폐의 단위별로 나눈 몫을 배열에 추가 후 나머지를 money로 설정
public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int [] won = {50000,10000,5000,1000,500,100,50,10,1};
        for(int w : won){
            answer.add(money/w);
            money %= w;
        }
        return answer;
    }
}
