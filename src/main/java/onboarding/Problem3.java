package onboarding;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem3 {
    /* getCount: 숫자를 각 자리수로 나누고 3,6,9가 포함되어있는 숫자 세는 함수 */
    public static int getCount(int num){
        int count = 0;
        while (num >0) {
            int mod = num%10;
            if ((mod!=0)&(mod%3==0)) count++;
            num /= 10;
        }
        return count;
    }
    public static int solution(int number) {
        int answer = 0;

        for(int i=1; i<=number; i++){
            answer += getCount(i);
        }

        return answer;
    }

}
