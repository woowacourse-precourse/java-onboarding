package onboarding;

public class Problem2 {
    /*
        기능 요구 사항 목록
        1. 반복되는 문자의 인덱스를 찾는 함수
        2. 반복되는 문자를 제거하는 함수
        3. solution 함수
    */

    // 반복되는 문자의 인덱스를 찾는 함수
    private static Integer findRepetition(String cryptogram) {
        for (int i = 1; i < cryptogram.length(); i++) {
            char firstLetter = cryptogram.charAt(i-1);
            char secondLetter = cryptogram.charAt(i);
            if (firstLetter == secondLetter) return i-1;
        }
        return null;
    }

    // 반복되는 문자를 제거하는 함수
    private static String removeRepetition(String cryptogram, int index) {
        String first = cryptogram.substring(0, index);
        String second = cryptogram.substring(index+2);
        return first + second;
    }

    public static String solution(String cryptogram) {
        Integer index;
        while ((index = findRepetition(cryptogram)) != null)
            cryptogram = removeRepetition(cryptogram, index);

        return cryptogram;
    }
}
