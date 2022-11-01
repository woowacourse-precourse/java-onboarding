package onboarding;

import onboarding.Problem4Package.LowerCase;
import onboarding.Problem4Package.UpperCase;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    // 2. 한 문자씩 Frog Rule에 따라 변환
    public static char translateByFrog(char inputChar)
    {
        UpperCase upperCase = new UpperCase();
        LowerCase lowerCase = new LowerCase();

        if (upperCase.isTrue(inputChar)) {
            return upperCase.translateAlphabetByFrog(inputChar);
        }

        if (lowerCase.isTrue(inputChar)) {
            return lowerCase.translateAlphabetByFrog(inputChar);
        }

        // 대소문자가 아닌 경우 (" " 일 경우 등등)
        return inputChar;
    }
}
