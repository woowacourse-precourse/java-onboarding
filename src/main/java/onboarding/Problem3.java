package onboarding;

import java.util.Stack;

public class Problem3 {
    public static int solution(int number) {
        final int ERROR = -1;
        if (violation(number)) return ERROR;
        return count(number);
    }
    
    // 범위 안의 숫자인지 검증
    static boolean violation(int number) {
        return number < 1 || number > 10000;
    }
    
    // 숫자를 자릿수별로 분리 : 가장 높은 자릿수가 가장 먼저 나오도록 함
    static Stack<Digit> digits(int number) {
        Stack<Digit> digits = new Stack<>();
        int positionNumber = 0;
        int weight = 1;
        while (number > 0) {
            digits.push(new Digit(number % 10, weight, positionNumber));
            positionNumber++;
            weight *= 10;
            number /= 10;
        }
        return digits;
    }
    
    // 3, 6, 9의 개수를 세는 함수
    static int count(int number) {
        int answer = 0;
        Stack<Digit> digits = digits(number);
        while (!digits.isEmpty()) {
            Digit digit = digits.pop();
            // 자릿수가 0이면 넘어감
            if (digit.digit == 0) continue;
            // 1 ~ digit * weight - 1까지에 포함된 맨 앞자리를 제외한 3, 6, 9의 개수
            // 예) 6325의 6을 보고 있다면 1 ~ 5999까지 천의자리수를 제외한 3, 6, 9의 개수
            answer += digit.digit * digit.positionNumber * digit.weight * 3 / 10;
            // 1 ~ digit * weight - 1까지에 포함된 맨 앞자리 3, 6, 9의 개수
            // 예) 6325의 6을 보고 있다면 1 ~ 5999까지 천의자리에 나온 3, 6, 9의 개수
            answer += (digit.digit - 1) / 3 * digit.weight;
            // 이미 본 자리수에 해당하는 부분 지우기
            number -= digit.digit * digit.weight;
            // digit * weight ~ number에 포함된 맨 앞자리 3, 6, 9의 개수
            // 예) 6325의 6을 보고 있다면 6000 ~ 6325까지 천의자리에 나온 3, 6, 9의 개수
            if (digit.digit % 3 == 0) answer += (number + 1);
        }
        return answer;
    }

    // 각 자릿수에 대한 정보를 담은 클래스
    // 예 : 1234의 1은 digit 1, weight 1000, positionNumber 3에 해당
    static class Digit {
        int digit; // 자릿수
        int weight; // 해당 자릿수의 가중치
        int positionNumber; // 해당 자릿수의 위치(1의 자리 = 0)

        public Digit(int digit, int weight, int positionNumber) {
            this.digit = digit;
            this.weight = weight;
            this.positionNumber = positionNumber;
        }
    }
}
