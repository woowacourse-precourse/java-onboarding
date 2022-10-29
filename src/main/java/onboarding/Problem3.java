package onboarding;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}

class Input3 {
    static int inputNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}

class ThreeSixNine {

    static void checkNumberRange(int inputNumber) {
        if (inputNumber < 1 || 10000 < inputNumber) {
            throw new IllegalStateException("1이상 10,000 이하인 자연수를 입력하세요");
        }
    }
    
}