package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) throws Exception {
        String answer = "";
        List<Character> charList = new ArrayList<>();

        if (cryptogram.length() < 1 || cryptogram.length() > 1000) {
            throw new Exception("입력값의 길이가 올바르지 않습니다");
        }
        for(char each: cryptogram.toCharArray()) {
            if(!Character.isLowerCase(each)) {
                throw new Exception("소문자로만 구성되어 있지 않습니다");
            }
            charList.add(each);
        }

        answer = decode(charList);
        return answer;
    }

    private static String decode(List<Character> cryptogram) throws Exception {
        List<Character> answerList = new ArrayList<>();

        Character prev = null;
        for(Character each : cryptogram) {
            if (prev == null) {
                answerList.add(each);
                prev = each;
                continue;
            }
            if (prev == each) {
                if(answerList.get(answerList.size()-1) == prev) {
                    answerList.remove(answerList.size()-1);
                }
                continue;
            }
            answerList.add(each);
            prev = each;
        }

        if(cryptogram.size() != answerList.size()) {
            return decode(answerList);
        }
        String answer = "";
        for(Character each : answerList) {
            answer += Character.toString(each);
        }
        return answer;
    }
}
