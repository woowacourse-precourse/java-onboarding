package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }


    /**
     * 기능1
     * 각 닉네임을 두 글자로 분리하는 기능
     * ex) 제이엠 -> 제이, 이엠
     */
    public static List<String> separateNickname(String nickname) {

        List<String> twoLetters = new ArrayList<>();
        for(int i = 0; i < nickname.length() - 1; i++)
        {
            twoLetters.add(nickname.substring(i, i + 2));
        }

        return twoLetters;
    }

    /**
     * 기능 2
     * HashMap을 통해서 중복된 닉네임을 작성한 이메일 목록을 찾는 기능
     */

    /**
     * 기능 3
     * 이메일 목록을 오름차순으로 정렬
     */

}
