package onboarding;

import java.util.stream.IntStream;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    /**
     * number에 들어가는 3, 6, 9의 개수를 카운트
     * @param number 3, 6, 9를 카운트할 숫자
     * @return number에 들어가는 3, 6, 9의 개수
     */
    public static int getNumberOfClap(String number){
        IntStream intStream = number.chars();
        IntStream filteredStream = intStream.filter(digit -> digit == '3' || digit == '6' || digit == '9');
        int numberOfClap = (int) filteredStream.count();
        return numberOfClap;
    }
}
