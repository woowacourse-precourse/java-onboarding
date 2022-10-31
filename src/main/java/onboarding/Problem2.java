package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static void removeDuplicates(List<String> stringList) {        // 중복되는 문자열을 제거하는 메소드
        for(int i = 1; i < stringList.size(); i++) {
            if(i == 0) {
                continue;    // NullPointException 방지
            }
            if(stringList.get(i - 1).equals(stringList.get(i))) {
                stringList.remove(i);
                stringList.remove(i - 1);
                i -= 2;    // 반복문이 끝나고 i++로 증감되는 것을 감안하여 2를 빼줍니다.
            }
        }
    }
    public static String solution(String cryptogram) {
        String answer = "";

        List<String> cryptogramList = new ArrayList<>(Arrays.asList(cryptogram.split("")));    // 문자열을 하나씩 나눠 리스트로 변환

        removeDuplicates(cryptogramList);

        for(String str : cryptogramList) {        // 중복 제거가 완료된 리스트를 문자열에 하나씩 담아준다
            answer += str;
        }

        return answer;
    }
}