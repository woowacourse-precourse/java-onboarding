package onboarding;

public class Problem3 {
    // 해당 자리수(digit)의 관점에서 박수 친 횟수 구하기
    public static int calculateClapOfDigits(int number, int digit) {
        int answer = 0;
        int powDigit10 = (int)Math.pow(10, digit);
        int digitNumber = number/powDigit10;

        if(number >= powDigit10*10) { // 예시 : 274은 30, 60, 90을 거쳤으므로 digit == 1의 관점에서 30*2번이 일단 더해져야 함
            answer = (number/(powDigit10*10)) * 3 * powDigit10;
            digitNumber -= (number/(powDigit10*10))*10; // 해당 자리의 한자리수를 구해야 하므로 그 위의 자리수들은 빼준다.
        }

        // 예시 : 274는 60을 지났으므로 digit == 1의 관점에서 10*2번이 일단 더해져야 함
        if(digitNumber == 9) answer += 2*powDigit10 + number%powDigit10+1; // 95일 때는 30이 더해지는 게 아니라 20 + 6이 더해진다. 90 ~ 95
        else if(digitNumber > 6) answer += 2*powDigit10;
        else if(digitNumber == 6) answer += powDigit10 + number%powDigit10+1;
        else if(digitNumber > 3) answer += powDigit10;
        else if(digitNumber == 3) answer += number%powDigit10+1;
        return answer;
    }

    public static int solution(int number) {
        int answer = 0;
        for(int digit = 0; Math.pow(10, digit) <= number; digit++) {
            answer += calculateClapOfDigits(number, digit);
        }
        return answer;
    }
}
