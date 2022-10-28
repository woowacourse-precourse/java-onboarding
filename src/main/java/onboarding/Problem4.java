package onboarding;

public class Problem4 {
    public static String solution(String word) {
        char[] charArray = word.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = toUpperCaseBackward(charArray[i]);
            charArray[i] = toLowerCaseBackward(charArray[i]);
        }
        String answer = String.valueOf(charArray);
        return answer;
    }

    public static char toUpperCaseBackward(char upperCase) {
        if (upperCase >= 65 && upperCase <= 90) {
            upperCase = (char)(90 - (upperCase - 65));
        }
        return upperCase;
    }

    public static char toLowerCaseBackward(char lowerCase) {
        if (lowerCase >= 97 && lowerCase <= 122) {
            lowerCase = (char)(122 - (lowerCase - 97));
        }
        return lowerCase;
    }


}
