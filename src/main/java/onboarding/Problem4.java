package onboarding;



public class Problem4 {
    public static char convertUpperAlphabet(char ch) {
        char converted = (char)('Z' - (ch - 'A'));

        return converted;
    }

    public static char convertLowerAlphabet(char ch) {
        char converted = (char)('z' - (ch - 'a'));

        return converted;
    }

    public static char convertAlphabet(char ch) {   // 해당 문자를 변환
        char converted = ch;

        if (Character.isUpperCase(ch)) {
            converted = convertUpperAlphabet(ch);
        }
        else {
            converted = convertLowerAlphabet(ch);
        }

        return converted;
    }

    public static String convertWord(String word) {
        String converted = "";

        for (char ch : word.toCharArray()) {
            if (Character.isLetter(ch)) {
                ch = convertAlphabet(ch);
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
