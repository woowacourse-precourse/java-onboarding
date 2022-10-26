package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        List<String> cryptogramList = new ArrayList<>(Arrays.asList(cryptogram.split("")));

        // 중복되는 문자열을 제거하는 단계
        for (int i = 1; i < cryptogramList.size(); i++) {
            if (cryptogramList.get(i - 1).equals(cryptogramList.get(i))) {
                cryptogramList.remove(i);
                cryptogramList.remove(i - 1);
                i -= 2; // 반복문이 끝나고 i++로 증감되는 것을 감안하여 2를 빼줍니다.
            }
        }


        // 배열에 남아있는 문자열을 answer 에 더해줍니다.
        for (String str : cryptogramList) {
            answer += str;
        }

        return answer;
    }
}