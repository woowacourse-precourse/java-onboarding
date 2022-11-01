package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        while(deleteIdx(cryptogram).size()!=0){
            cryptogram = replace(cryptogram);
        }
        return cryptogram;
    }

    // 중복 문자 삭제
    private static String replace(String input) {
        List<Integer> delete = deleteIdx(input);
        char[] chars = input.toCharArray();
        for (int i : delete) {
            String temp = Character.toString(chars[i])+Character.toString(chars[i]);
            input = input.replace(temp,"");
        }
        return input;
    }

    private static boolean[] checkJungbok(char[] input) {
        boolean[] result = new boolean[input.length];
        for (int i=1; i<input.length; i++){
            if (input[i-1]==input[i]) {
                result[i-1] = true;
                result[i] = true;
            }
        }
        return result;
    }
}
