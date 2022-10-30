package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        // 단순반복문으로 풀기 (규칙 50000->10000 갈때는 5나누기 // 10000 -> 5000 갈때는 2 나누기 5,2 스위칭 하면서 진행)
        // while로 풀었을 때는 1의 값이 한번에 처리가 안됨 그래서 do while로 진행
        // 주의점 1) 10원 다음에 오는 동전은 1원 동전임 if 문으로 대비해야함
        List<Integer> answer = new ArrayList<>();
        // 1) 초기 값 세팅(십만원으로 세팅
        int Change = 100000;
        int Switch = 2; // Switch 변수 2로 나눌지 5로 나눌지 정하는 변수
        do  {
            // 2) 단위 나누기
            Change = (int)Change/Switch;
            Switch = (Switch==5) ? 2 : 5;
            // 3) 5원짜리 동전은 없으므로 1원으로 치환
            if (Change==5) Change=1;
            // 4) 몫이 개수이므로 저장
            answer.add((int)money/Change);
            // 5) 단위의 나머지값을 저장
            money = money%Change;
        }while(Change!=1);
        return answer;
    }
}
