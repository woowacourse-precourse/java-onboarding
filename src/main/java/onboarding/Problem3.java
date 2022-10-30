package onboarding;


public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        // 매 횟수별 손뼉수 계산
        for (int i = 1; i <= number; i++){
            answer += checkDigits(i);
        }
        return answer;
    }
    // 정수 자릿수별 3,6,9 확인하여 손뼉수 계산
    public static int checkDigits(int num){
        int answer = 0;
        do{
            if (num % 10 == 3 || num % 10 == 6 || num % 10 == 9){
                answer += 1;
            };
            num /= 10;
        } while  (num > 0);
        return answer;
    }

}
