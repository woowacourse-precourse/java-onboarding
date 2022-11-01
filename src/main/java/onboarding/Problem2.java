package onboarding;

import java.util.Stack;
import java.util.ArrayList;
import java.util.List;
public class Problem2 {

    // 2글자 이상 반복되는 문자열 찾아서 삭제
    public static String removeDuplication (String cryptogram) {
        Stack<Character> stringStack = new Stack<>();
        if (cryptogram.length() == 1) return cryptogram;

        if (cryptogram.length() == 2 && cryptogram.charAt(1) != cryptogram.charAt(0)) return cryptogram;

        for (int j = 0; j < cryptogram.length()-1; j++) {
            if (j == 0 && cryptogram.charAt(1) != cryptogram.charAt(0)){
                stringStack.push(cryptogram.charAt(j));
            }else if (cryptogram.charAt(j) != cryptogram.charAt(j+1)) {
                if (cryptogram.charAt(j-1) != cryptogram.charAt(j)) {
                    stringStack.push(cryptogram.charAt(j));
                }
                if (j == cryptogram.length()-2) {
                    stringStack.push(cryptogram.charAt(j+1));
                }
            }
        }

        // Stack에 있던 문자들 문자열로 합치기
        String removedDuplicateString = "";
        for (char answerelEment : stringStack) {
            removedDuplicateString += answerelEment;
        }
        return removedDuplicateString;
    }

    public static String solution(String cryptogram) {
        List<String> comparedStrings = new ArrayList<>();
        comparedStrings.add(cryptogram);

        int lastIndex; // cryptogram 문자열의 마지막 인덱스

        while (true) {
            cryptogram = removeDuplication(cryptogram);
            comparedStrings.add(cryptogram);
            lastIndex = comparedStrings.size()-1;

            if (comparedStrings.get(lastIndex).equals(comparedStrings.get(lastIndex-1))) {
                break;
            }
        }


        return cryptogram;
    }
}