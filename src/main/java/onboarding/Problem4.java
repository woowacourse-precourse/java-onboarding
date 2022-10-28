package onboarding;

public class Problem4 {


    public static char convertAlpahbet(char ch) {   // 해당 문자를 변환
        char converted = ch;

        if (Character.isUpperCase(ch)) {
            converted = (char)('Z' - (ch - 'A'));
        }
        else {
            converted = (char)('z' - (ch - 'a'));
        }

        return converted;
    }

    public static String convertWord(String word) {
        String converted = "";

        for (char ch : word.toCharArray()) {
            if (Character.isLetter(ch)) {
                ch = convertAlpahbet(ch);
            }
            converted += ch;
        }

        return converted;
    }


    public static String solution(String word) {
        String answer = "";

        answer = convertWord(word);

        return answer;
    }
}
