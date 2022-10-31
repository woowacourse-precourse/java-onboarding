package onboarding;

/**
 * 기능 사항
 * 1.숫자가 3,6,9면 1을 리턴하는 함수
 * 2.각 자릿수를 확인하기 위한 함수
 */
public class Problem3 {
    /**
     * 1.숫자가 3,6,9면 1을 리턴하는 함수
     */
    public static int clap (int c){
        int count = 0;
        if(c == 3 || c == 6 || c == 9){
            count = 1;
        }
        return count;
    }

    /**
     * 2.각 자릿수를 확인하기 위한 함수
     */
    public static int numberSplit(int number){
        int sum = 0;
        while (number>0){
            sum += clap(number%10);
            number = number/10;
        }
        return sum;
    }

    /**
     * 문제 해결을 위한 함수
     * 기능 요구 사항 결과 리턴
     */
    public static int solution(int number) {
        int answer = 0;
        for(int i =1; i<=number;i++){
            int numberCheck = i;
            answer += numberSplit(i);
            i = numberCheck;
        }
        return answer;
    }
}
