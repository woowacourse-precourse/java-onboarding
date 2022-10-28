package onboarding;


/**
 * 1. 각 숫자 확인
 * 2. 손뼉 수 증가
 * 3.
 */
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i=1; i<=number; i++){
            answer += countAllClapInNumber(i);
        }

        return answer;
    }

    public static int countAllClapInNumber(int number) {
        int count = 0;
        while(number!=0){
            int digit = number%10;
            count+= clapIfDigitIsRight(digit);
            number/=10;
        }

        return count;
    }

    public static int clapIfDigitIsRight(int digit) {
        if(digit==3 || digit==6 || digit==9)
            return 1;

        return 0;
    }

}
