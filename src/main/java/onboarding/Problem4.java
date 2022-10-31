package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuffer stringBuffer = new StringBuffer();
        char[] splitWordArray = splitStringArray(word);
        for (char c : splitWordArray) {
            stringBuffer.append(transChar(c));
        }
        return stringBuffer.toString();
    }

    // string을 한글자씩 분리하기
    public static char[] splitStringArray(String word){
        return word.toCharArray();
    }

    // 치환 로직
    public static char transChar(char c){
        char result;
        // 대문자인 경우 65 ~ 90 소문자인 경우 97 ~ 122
        if (!Character.isLetter(c)) {
            return c;
        }
        if (Character.isUpperCase(c)) {
            int total = 155;
            result = (char) (total - c);
        }
        else {
            int total = 219;
            result = (char) (total - c);
        }
        return result;
    }


}
