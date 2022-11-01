package onboarding;

public class Problem3 {
    //박수 카운트 세기
    public static int countClapNum(int num, int answer) {
        int digit;
        while(num != 0) {
            digit = num % 10;
            if(digit != 0 && digit % 3 == 0) { //0 제외 3의 배수(3, 6, 9)인 경우
                answer++;
            }
            num /= 10;
        }
        return answer;
    }

    //솔루션 메소드
    public static int solution(int number) {
        int answer = 0;
        int currentNumber;

        for(currentNumber = 1; currentNumber <= number ; currentNumber++) {
            answer = countClapNum(currentNumber, answer); //박수 카운트 세기
        }

        return answer;
    }
}
