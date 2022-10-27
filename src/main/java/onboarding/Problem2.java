package onboarding;

import java.util.regex.Pattern;

public class Problem2 {
    // 처음 아이디어
    // 뭔가 정규표현식으로 연속된 문자 제거하는 방식으로 풀면 될듯하다
    // 이게 잘 안돼서ㅠㅠ 다른 방식을 생각해봤다
    // for문을 돌려 연속인 문자를 제거하는 함수를 만든다
    // 제거한 후의 문자열에서 또 연속인 문자가 존재하면 연속된 문자가 없을 때까지 while문 반복

//    public static String isContinue() {
//        String findContinue = "\"";
//        for(int i = 97; i <= 122; i++) {
//            findContinue  += (char) i + "{2,}";
//            if(i<122) findContinue += "|";
//            else findContinue += "\"";
//        }
//        System.out.println(findContinue);
//        return findContinue;
//    }

    public static String removeContinue(String s) {
        String remove = "";
        for(int i = 0; i < s.length()-1; i++) {
            if(s.charAt(i) != s.charAt(i+1)) {
                remove += s.charAt(i);
            }
            if(i == s.length()-1) remove += s.charAt(i);
        }
        return remove;
    }

    public static boolean hasRepeat(String s) {
        boolean hasRepeat = false;
        for(int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                hasRepeat = true;
                break;
            }
        }
        return hasRepeat;
    }

    public static String solution(String cryptogram) {
        String s = cryptogram;
        while(hasRepeat(s)) {
            s = removeContinue(s);
        }
//        while(cryptogram.matches(isContinue())) {
//            cryptogram.replace(isContinue(), "");
//        }
        return cryptogram;
    }
}
