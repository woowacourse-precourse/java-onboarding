package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        int[] moneyList = {50000,10000,5000,1000,500,100,50,10,1};
        int[] answerTemp = {0,0,0,0,0,0,0,0,0};
        for(int i = 0; i < moneyList.length; i++){
            answerTemp[i] = money / moneyList[i];
            money = money -(answerTemp[i] * moneyList[i]);
        }
        answer = List.of(answerTemp[0],answerTemp[1],answerTemp[2],answerTemp[3],answerTemp[4],answerTemp[5],answerTemp[6],answerTemp[7],answerTemp[8]);
        return answer;
    }

}
