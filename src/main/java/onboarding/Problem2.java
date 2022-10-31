package onboarding;

import java.util.ArrayList;
import java.util.List;

/**
 * a. 배열 요소 반복하면서 리스트에 요소 추가하는 메서드 구현 - decipherCryptogram()
 * b. 해당 요소가 중복된 요소인지 확인하고 중복이면 삭제하고 아니면 리스트에 추가하는 메서드 구현 - add()
 * c. 해당 요소가 중복된 문자인지 확인하는 메서드 기능 구현 - isDuplication()
 * */
public class Problem2 {

    public static String solution(String cryptogram) {
        return decipherCryptogram(cryptogram.split(""));
    }

    private static String decipherCryptogram(String[] cryptograms) {
        List<String> plainText = new ArrayList<>();

        for (String s : cryptograms) {
            add(plainText, s);
        }

        return String.join("", plainText);
    }

    private static void add(List<String> plainText, String s) {
        int size = plainText.size();

        if (isDuplication(plainText, s)) {
            plainText.remove(size - 1);
            return ;
        }

        plainText.add(s);
    }

    private static boolean isDuplication(List<String> plainText, String s) {
        int size = plainText.size();

        if (size == 0) {
            return false;
        }

        return plainText.get(size - 1).equals(s);
    }
}
