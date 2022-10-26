package onboarding;

public class Problem2 {
    /*
        기능 요구 사항 목록
        1. 반복되는 문자의 인덱스를 찾는 함수
        2. 반복되는 문자를 제거하는 함수
        3. solution (반복문으로 문자 제거)
    */

    // 반복되는 문자의 인덱스를 찾는 함수
    private static Integer repeatedIndex(String cryptogram) {
        for (int i = 1; i < cryptogram.length(); i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i-1))
                return i-1;
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
        while ((index = repeatedIndex(cryptogram)) != null) {
            System.out.println(index);
            cryptogram = removeRepetition(cryptogram, index);
            System.out.println(cryptogram);
        }

        return cryptogram;
    }
}
