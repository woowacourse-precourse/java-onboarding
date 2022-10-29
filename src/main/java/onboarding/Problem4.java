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

    public static boolean checkCase(char word) { // true : 대문자 false : 소문자
        if(Character.isUpperCase(word))
            return true;
        else
            return false;
    }

    // 문장 리스트로 바꾸기
    public static String[] stringToList(String word) {
        String[] list = word.split("");

        return list;
    }






}
