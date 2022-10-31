package onboarding;

import java.util.regex.Pattern;

public class Problem2 {
    // 처음 아이디어
    // 뭔가 정규표현식으로 연속된 문자 제거하는 방식으로 풀면 될듯하다
    // 이게 잘 안돼서ㅠㅠ 두번째 아이디어
    // for문을 돌려 연속인 문자를 제거하는 함수를 만든다
    // -> 첫번째 index에서 뒤의 index 값과 일치하지 않으면 새로 선언한 string에 추가
    // -> 마지막 index에서 앞의 index 값과 일치하지 않으면 새로 선언한 string에 추가
    // -> 나머지 index에서 해당 인덱스 중심으로 앞, 뒤의 값과 일치하지 않으면 새로 선언한 string에 추가
    // 문자열에서 연속이 존재하면 while문을 돌려 연속된 문자가 없을 때까지 위의 함수를 실행시킨다
    
    public static String removeContinue(String s) {
        String remove = "";
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) != s.charAt(i+1)){
                remove += s.charAt(i);
            }
            if(i == s.length()-1 && s.charAt(i-1) != s.charAt(i)) {
                remove += s.charAt(i);
            }
            if(i > 0 && i < s.length()-1 && s.charAt(i) != s.charAt(i-1) && s.charAt(i) != s.charAt(i+1)) {
                remove += s.charAt(i);
            }
        }
        return remove;
    }

    public static boolean hasRepeat(String s) {
        boolean hasRepeat = false;
        for(int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                hasRepeat = true;
                break;
            }
        }
        return hasRepeat;
    }

    public static String solution(String cryptogram) {
        String s = cryptogram;
        while (hasRepeat(s)) {
            s = removeContinue(s);
        }
        return s;
    }
}
