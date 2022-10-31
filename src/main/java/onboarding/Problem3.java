package onboarding;


/**
 * 기능명세
 * 아래 절차를 입력받은 number까지 반복해서 결과값을 구한다.
 * 1. 각 숫자 탐색
 * 2. 각 숫자 자릿수 탐색
 * 3. 3,6,9중 하나가 있으면 손뼉 수 증가
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
