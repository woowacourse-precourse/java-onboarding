package onboarding;

import java.util.List;
import java.util.stream.Stream;

/*
*   구현 기능
*   1. 현재 숫자를 자릿수 별로 나누는 기능
*   2. 나눠진 숫자에서 박수를 몇번 쳐야하는지 카운트 하는 기능
*/
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}

class StringNumSpliter {
    public int[] splitNum(int num) {
        return Stream.of(makeStringArr(num)).mapToInt(Integer::parseInt).toArray();
    }

    public String[] makeStringArr(int num){
        return String.valueOf(num).split("");
    }
}
