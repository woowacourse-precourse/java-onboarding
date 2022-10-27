package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    static int sumDigits(int digits){
        // 정수 digits가 주어졌을 때 자리수별 숫자(digit)의 합을 return
        // 정수 digits를 10으로 나누었을 때 나머지(digit)를 차례로 더한다.
        int sum = 0;

        while(digits!=0) {
            // digits를 10으로 나눈 나머지(digit)를 sum에 더한다.
            sum += digits%10;
            // digits를 10으로 나눈 몫을 digits에 저장한다.
            digits /= 10;
        }
        return sum;
    }
}