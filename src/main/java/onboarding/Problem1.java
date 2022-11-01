package onboarding;


import java.util.List;

import static onboarding.problem1.Comparator.getWinner;
import static onboarding.problem1.ExceptionHandler.runtimeException;
import static onboarding.problem1.CollectionVariable.getMax;

// 50줄 이하 클래스 줄이
public class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;

        // 예외 처리
        if (runtimeException(pobi) || runtimeException(crong)) answer = -1;
        else {

            int pobiScore = getMax(pobi);
            int crongScore = getMax(crong);

            // 승자 구하기
            answer = getWinner(pobiScore, crongScore);
        }
        return answer;
    }
}




