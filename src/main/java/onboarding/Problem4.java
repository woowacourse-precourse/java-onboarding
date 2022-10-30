package onboarding;

public class Problem4 {
    private static Integer[] gap = {
            25, 23, 21, 19, 17, 15, 13, 11, 9, 7,
            5, 3, 1, -1, -3, -5, -7, -9, -11, -13,
            -15, -17, -19, -21, -23, -25
    };

    public static String solution(String word) {
        if(isException(word)) throw new RuntimeException("잘못된 인자입니다.");
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < word.length(); i++) {
            sb.append(getConversion(word.charAt(i)));
        }
        return sb.toString();
    }

    private static Boolean isException(String word) {
        return word.length() < 0 || word.length() > 1000;
    }

    private static Character getConversion(Character c) {
        Character firstChar = 0;
        if (c >= 'A' && c <= 'Z') {
            firstChar = 'A';
        }
        if (c >= 'a' && c <= 'z') {
            firstChar = 'a';
        }
        if (firstChar == 0) {
            return c;
        }

        int result = c + gap[c - firstChar];
        return (char)result;
    }
}
