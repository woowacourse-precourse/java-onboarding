package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
돈 인출 방식에 대한 코드
50000원, 10000원
5000원, 1000원
500원, 100원
50원, 10원
1원
으로 인출이 가능

1. 돈을 각자리수마다 배열에 담기(10000원 이상의 금액, 1000원, 100원, 10원, 1원)
2. 각각의 배열 위치에서 5로나눈 몫과 배열위치의 값 - (5로나눈 몫*5)로 5만원, 만원, 5천원, 천원, 500원, 100원, 50원, 10원의 자리수를 구해 정답 배열에 넣는다.
3. 처음 자리수에 담았던 1의 자리 수를 정답 배열에 다시 넣기
 */
public class Problem5 {
    public static List<Integer> solution(int money) {

        String SMoney = String.valueOf(money);
        System.out.println(SMoney);
        List<Integer> answer = new ArrayList<>(9);
        int[] AMoney = {0, 0, 0, 0, 0};
        int order = 4;
        for (int i = SMoney.length() - 1; i >= 0; i--) {
            if (i == SMoney.length() - 5) {
                AMoney[0] = Integer.parseInt(SMoney.substring(0, SMoney.length() - 4));
                break;
            }
            AMoney[order] = (SMoney.charAt(i) - '0');
            order--;
        }
        System.out.println(Arrays.toString(AMoney));
        int[] answerL = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        order = 0;
        for (int i = 0; i < 8; i++) {
            answerL[i] = AMoney[order] / 5;
            answerL[++i] = AMoney[order] - answerL[i - 1] * 5;
            order++;
        }

        for (int i = 0; i < answerL.length - 1; i++) {
            answer.add(answerL[i]);
        }
        answer.add(AMoney[4]);

        return answer;
    }
}
