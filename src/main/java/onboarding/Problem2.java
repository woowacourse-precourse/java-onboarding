package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    /* 공백으로 대체된 문자 제거 */
    public static String removeSpace(char[] chars) {
        String result = "";
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == ' ') {
                continue;
            }
            result += Character.toString(chars[i]);
        }
        return result;
    }

    /* 2개 이상 중복되는 문자 제거
    *  중복 문자 즉시 제거 시 index가 달라질 수 있으므로 공백으로 대입 후 removeSpace를 통해 공백 제거
    */
    public static String deleteDuplication(String cryptogram, List<Integer> indexes) {
        char[] chars = cryptogram.toCharArray();
        for(Integer i : indexes) {
            chars[i] = ' ';
        }
        cryptogram = removeSpace(chars);
        return cryptogram;
    }

    /* 중복 문자에 해당하는 인덱스 찾기 */
    public static String findDuplication(String cryptogram) {
        char prevChar = cryptogram.charAt(0);
        while(true) {
            List<Integer> indexes = new ArrayList<Integer>();
            for(int i = 1; i < cryptogram.length(); i++) {
                if(prevChar == cryptogram.charAt(i)) {
                    indexes.add(i - 1);
                    indexes.add(i);
                }
                prevChar = cryptogram.charAt(i);
            }
            if(indexes.size() == 0) {
                break;
            }
            cryptogram = deleteDuplication(cryptogram, indexes);
        }
        return cryptogram;
    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = findDuplication(cryptogram);
        System.out.println(answer);
        return answer;
    }
}
