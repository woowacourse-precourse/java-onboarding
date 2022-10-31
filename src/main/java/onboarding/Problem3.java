package onboarding;

public class Problem3 {
    // 해당 자리수(digit)의 관점에서 박수 친 횟수 구하기
    public static int calculateClapOfDigits(int number, int digit) {
        int answer = 0;
        int powDigit10 = (int)Math.pow(10, digit);
        int digitNumber = number/powDigit10;

        if(number >= powDigit10*10) { // 예시 : 274은 30, 60, 90을 거쳤으므로 digit == 1의 관점에서 30*2번이 일단 더해져야 함
            answer = (number/(powDigit10*10)) * 3 * powDigit10;
            digitNumber -= (number/(powDigit10*10));
        }

        // 예시 : 274는 60을 지났으므로 digit == 1의 관점에서 10*2번이 일단 더해져야 함
        if(digitNumber == 9) answer += 3*powDigit10;
        else if(digitNumber >= 6) answer += 2*powDigit10;
        else if(digitNumber >= 3) answer += powDigit10;
        return answer;
    }

    public static int solution(int number) {
        int answer = 0;
        for(int digit = 0; number >= Math.pow(10, digit); digit++) {
            answer += calculateClapOfDigits(number, digit);
        }
        return answer;
    }
}
