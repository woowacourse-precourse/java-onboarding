package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Problem2 {
    /*
        기능 요구 사항 목록
        1. 반복되는 문자의 인덱스를 찾는 함수
        2. 반복되는 문자를 제거하는 함수
        3. solution 함수
    */

    // 리스트에 원소 추가
    private static HashSet<Integer> addToBasket(
            String cryptogram,
            HashSet<Integer> basket,
            Integer idx
    ) {
        char firstLetter = cryptogram.charAt(idx - 1);
        char secondLetter = cryptogram.charAt(idx);
        if (firstLetter == secondLetter) {
            basket.add(idx - 1);
            basket.add(idx);
        }
        return basket;
    }

    // 반복되는 문자의 인덱스를 찾는 함수
    private static HashSet<Integer> findRepetition(String cryptogram) {
        HashSet<Integer> basket = new HashSet<>();
        for (int i = 1; i < cryptogram.length(); i++)
            addToBasket(cryptogram, basket, i);
        return basket;
    }

    // 반복되는 문자를 제거하는 함수
    private static String removeRepetition(String cryptogram, HashSet<Integer> basket) {
        String result = "";
        for (int i = 0; i < cryptogram.length(); i++) {
            char letter = cryptogram.charAt(i);
            if (!basket.contains(i)) result += letter;
        }
        return result;
    }

    public static String solution(String cryptogram) {
        HashSet<Integer> basket = findRepetition(cryptogram);
        while (basket.size() > 0) {
            cryptogram = removeRepetition(cryptogram, basket);
            basket = findRepetition(cryptogram);
        }

        return cryptogram;
    }
}
