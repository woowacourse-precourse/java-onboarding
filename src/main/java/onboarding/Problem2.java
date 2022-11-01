package onboarding;

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
public class Problem2 {

    public static String removeDuplication (String cryptogram) {
        Stack<Character> stringStack = new Stack<>();
        if (cryptogram.length() == 1) return cryptogram;


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
        String removedDuplicateString = "";
        for (char answerelEment : stringStack) {
            removedDuplicateString += answerelEment;
        }
        return removedDuplicateString;
    }

    public static String solution(String cryptogram) {
        List<String> comparedStrings = new ArrayList<>();
        comparedStrings.add(cryptogram);
        int lastIndex;
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
