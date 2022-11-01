package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {

    private final static int MIN = 1;
    private final static int MAX = 1000;

    public static String solution(String cryptogram) {
        String answer = "answer";
        checkValidateLength(cryptogram);
        checkUseOnlyLowerCase(cryptogram);
        List<Character> cryptogramList = makeCryptogramToList(cryptogram);
        decrypt(cryptogramList);
        answer = makeCryptogramListToString(cryptogramList);
        return answer;
    }

    private static void checkValidateLength(String cryptogram) {
        int len = cryptogram.length();
        if(len < MIN || len > MAX) {
            throw new RuntimeException("문자열의 길이가 잘못되었습니다.(길이가 1 이상 1000 이하의 문자열만 가능)");
        }
    }

    private static void checkUseOnlyLowerCase(String cryptogram) {
        int len = cryptogram.length();
        for(int i = 0; i < len; i++) {
            if(Character.isUpperCase(cryptogram.charAt(i))) {
                throw new RuntimeException("대문자는 사용할 수 없습니다.");
            }
        }
    }

    private static List<Character> makeCryptogramToList(String cryptogram) {
        int len = cryptogram.length();
        List<Character> list = new ArrayList<>();
        for(int i =0; i < len; i++) {
            list.add(cryptogram.charAt(i));
        }
        return list;
    }

    private static void decrypt(List<Character> cryptogramList) {
        int len = cryptogramList.size();

        for(int i = 0; i < len; i++) {
            if(i < len - 1 && cryptogramList.get(i) == cryptogramList.get(i + 1)) {
                while(i < len - 1 && cryptogramList.get(i) == cryptogramList.get(i + 1)) {
                    cryptogramList.remove(i + 1);
                    len--;
                }
                cryptogramList.remove(i);
                len--;
                if(i == 0) {
                    i--;
                }else {
                    i -= 2;
                }
            }
        }
    }

    private static String makeCryptogramListToString(List<Character> cryptogramList) {
        StringBuilder sb = new StringBuilder();
        for (char word : cryptogramList) {
            sb.append(word);
        }
        String result = sb.toString();
        return result;
    }
}
