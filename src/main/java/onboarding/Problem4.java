package onboarding;

public class Problem4 {
    public static String solution(String word) {
        //알파벳인지 확인하는 함수
        //반대로 변환하기
        for (int i = 0; i < word.length(); i++) {

            if (isAlphabet(word.charAt(i))) {

            }
        }
        return "";
    }

    public static boolean isAlphabet(char alphabet) {

        if (alphabet >= 'a' && alphabet <= 'z') {
            return true;
        } else if (alphabet >= 'A' && alphabet <= 'Z') {
            return true;
        }
        return false;
    }
}
