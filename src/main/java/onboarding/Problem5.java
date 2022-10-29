package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

//    public static List<Integer> solution(int money) {
//        List<Integer> answer = Collections.emptyList();
//        answer = new ArrayList<>();
//
//        for(int i=0; i<9; i++) {
//            answer.add(i, 0);
//        }
//
//        for(int i=0; i<9; i++) {
//            answer.set(i, calculation(money)[i]);
//        }
//        return answer;
//    }


    public static int[] calculation(int money) {
        int[] resultLst = new int[9];

        int[] divNumLst = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        int rest = money;
        for(int i=0; i<9; i++) {
            /**
             * 몫을 배열에 저장, 나머지 값에 대해서 다시 다음 배열원소에 대해 나누어 몫 배열저장 이 과정을 반복
             */
            resultLst[i] = rest / divNumLst[i];
            rest -= resultLst[i] * divNumLst[i];

        }
        return resultLst;
    }
}
