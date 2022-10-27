package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int num=1; num<=number; num++){
            answer += getClapCnt(num);
        }
        return answer;
    }

    public static int getClapCnt(int num){
        int cnt = 0;

        //(일의 자리 숫자부터) 각 자리 숫자가 3,6,9인지 확인
        while(num>0){
            int digit = num % 10;
            if(digit % 3 == 0 && digit != 0) cnt++;
            num /= 10;
        }
        return cnt;
    }
}
