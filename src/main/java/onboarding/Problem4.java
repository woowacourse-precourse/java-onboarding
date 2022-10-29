package onboarding;

import java.util.Scanner;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}

class Input4 {
    static String inputWord() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

}

class Encode {
    static void validateInput(String word) {
        if (word.length() < 1 || word.length() < 1000) {
            throw new IllegalStateException("길이가 1이상 1000이하로 입력해 주세요!");
        }
    }

}