package onboarding;

import java.util.stream.Stream;

/*
*   구현 기능
*   1. 현재 숫자를 자릿수 별로 나누는 기능
*   2. 나눠진 숫자에서 박수를 몇번 쳐야하는지 카운트 하는 기능
*   3. 각 토큰이 3의 배수인지 확인하는 기능
*/
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        StringNumSpliter stringNumSpliter = new StringNumSpliter();

        for(int i = 1; i <= number ; i++) {
            answer += clapCounter(stringNumSpliter.splitNum(i));
        }

        return answer;
    }

    public static int clapCounter(int[] numToken) {
        int count = 0;

        for(int num : numToken){
            count += checkNumber(num);
        }

        return count;
    }

    public static int checkNumber(int num) {
        int result = 0;

        if(num != 0 && num % 3 == 0) {
            result = 1;
        }

        return result;
    }
}
class StringNumSpliter {
    public int[] splitNum(int num) {
        return Stream.of(makeStringArr(num)).mapToInt(Integer::parseInt).toArray();
    }

    private String[] makeStringArr(int num){
        return String.valueOf(num).split("");
    }
}
