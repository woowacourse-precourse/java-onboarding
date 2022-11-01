package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i < number+1; i++) {
            List<Integer> separatedNumbers = separateNumber(i);
            answer += countClap(separatedNumbers);
        }
        return answer;
    }

    // 자리수별로 숫자 분리
    private static List<Integer> separateNumber(int num){
        List<Integer> separatedNumbers = new ArrayList<>();
        final int NOTATION = 10;

        while (num >= NOTATION){
            separatedNumbers.add(num % NOTATION);
            num /= NOTATION;
        }
        separatedNumbers.add(num % NOTATION);
        return separatedNumbers;
    }
    
    private static int countClap(List<Integer> numbers){
        int clapCount = 0;
        System.out.println(numbers.toString());
        for (int i: numbers) {
            // 3, 6, 9인지 확인
            if(i !=0 && i%3==0) clapCount++;
            System.out.println(i);
        }
        return clapCount;
    }
}
