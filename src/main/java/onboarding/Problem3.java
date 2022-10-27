package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        int threeNum=0;
        int sixNum=0;
        int nineNum=0;

        // 1. 1~number 까지 몇 개의 3,6,9가 나오는지 체크
        for (int i = 1; i <= number; i++) {
            String s = String.valueOf(i);
            threeNum+=countChar(s,'3');
            sixNum+=countChar(s,'6');
            nineNum+=countChar(s,'9');
        }
        // 2. 나온 3,6,9 의 갯수만큼 더하기


        return answer;
    }

    public static int countChar(String str,char ch){
        return (int) str.chars()
                .filter(c->c==ch)
                .count();
    }
}
