package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        for (char ch : word.toCharArray()) {
            char convertedCh = convertCharacter(ch);
            answer.append(convertedCh);
        }

        return answer.toString();
    }

    public static char convertCharacter(char ch) {
        int num;
        if ((ch >= 65 && ch <= 77)) {
            num = ch - 65;
            ch = (char) (90 - num);
            return ch;
        }
        else if ((ch >= 97 && ch <= 109)) {
            num = ch - 97;
            ch = (char) (122 - num);
            return ch;
        }
        else if ((ch >= 78 && ch <= 90)) {
            num = 90 - ch;
            ch = (char) (65 + num);
            return ch;
        }
        else if ((ch >= 110 && ch <= 122)) {
            num = 122 - ch;
            ch = (char) (97 + num);
            return ch;
        }

        return ch;
    }
}
