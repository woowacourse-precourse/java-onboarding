package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String str = "";
        for (char c : word.toCharArray()) {
            str += getOppositeWord(c);
        }
        return str;
    }

    // 아스키 코드를 이용하여 반대되는 알파뱃을 반환하는 함수
    static char getOppositeWord(char c) {
        // A~Z 65~90
        // a~z 97~122
        // 문자를 아스키 코드로 변환
        int asciiCode = (int)c;
        // 알파뱃 대문자인 경우 반대되는 알파뱃으로 변환
        if(asciiCode >= 65 && asciiCode <= 90) {
            return (char)(155 - asciiCode);
        }
        // 알파뱃 소문자인 경우 반대되는 알파뱃으로 변환
        else if (asciiCode >= 97 && asciiCode <= 122) {
            return (char)(219 - asciiCode);
        }
        // 알파뱃이 아닌 경우 그대로 반환
        return c;
    }
}