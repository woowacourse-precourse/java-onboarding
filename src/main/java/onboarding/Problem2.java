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

    // 삭제할 문자 인덱스 반환
    private static List<Integer> deleteIdx(String input){
        char[] chars = input.toCharArray();
        List<Integer> delete = new ArrayList<>();
        for (int i=1; i<chars.length; i++){
            if (chars[i-1]==chars[i]) delete.add(i);
        }
        return delete;
    }
}
