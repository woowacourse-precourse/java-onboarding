package onboarding;

import onboarding.PROBLEM3.NumberRangeException;

public class Problem3 {
    public static int solution(int number) throws NumberRangeException {
        int answer = 0;

        // number 범위 초과하는 경우 예외 처리
        if (number<1 || number>10000) {
            throw new NumberRangeException("[Error] 범위초과");
        }

        for (int i=1; i<=number; i++) {
            answer += clap(i);
        }
        return answer;
    }

    // current에서 박수를 치는지에 대한 여부
    public static int clap(int current) {
        int count = 0;

        while(current != 0) {
            if ((current%10)%3 == 0 && (current%10) != 0) {
                count++;
                current /= 10;
            }else current /= 10;
        }

        return count;
    }
}
