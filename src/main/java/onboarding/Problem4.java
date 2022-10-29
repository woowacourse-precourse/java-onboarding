package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public static void makeArr(char[] arr) {
        char[] alphArr = new char[26];
        char[] reverseArr = new char[26]; // 기존 array에서 숫자를 빼면 다시 재사용이 가능할 것 같지만 일단 보류

        for (int i = 0; i < alphArr.length; i++) {
            alphArr[i] = (char)('a' + i);
        }

        for (int i = reverseArr.length - 1; i >= 0; i--) {
            reverseArr[i] = (char) ('z' - i);
        }
    }




}
