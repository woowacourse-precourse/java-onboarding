package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = getCovertString(word);
        return answer;
    }

    public static String getCovertString(String word) {
        StringBuilder sb = new StringBuilder("");
        char[] charAry = word.toCharArray();

        for (char ch :
                charAry) {
            sb.append(convertChar(ch));
        }

        return sb.toString();
    }

    public static char convertChar(char ch) {
//        char[] upperAry = new char[] {'Z', 'Y', 'X', 'W', 'V', 'U', 'T', 'S', 'R', 'Q', 'P', 'O',
//                'N', 'M', 'L', 'K', 'J', 'I', 'H', 'G', 'F', 'E', 'D', 'C', 'B', 'A'};

        //  대문자
        if (65 <= ch && ch <= 90) {
            return (char) ((char)(90 - ch) + 65);
        }
        //  소문자
        else if (97 <= ch && ch <= 122) {
            return (char) ((char)(122 - ch) + 97);
        } else {
            return ch;
        }
    }
}
