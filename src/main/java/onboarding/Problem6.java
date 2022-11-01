package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    // 닉네임의 연속된 2글자로 만들 수 있는 경우의 수를 모두 찾습니다,
    public static List<String> getTwoWords(String nickname) {
        List<String> result = new ArrayList<>();
        for(int i = 0; i < nickname.length() - 1; i++) {
            String word = nickname.substring(i, i + 2);
            if(!result.contains(word))
                result.add(word);
        }
        return result;
    }

    // 사용중인 단어 및 중복 회원들의 정보를 관리하는 클래스
    public static class UsersTool {
        private HashMap<String, String> words;
        private List<String> duplicateEmailList;

        public UsersTool(HashMap<String, String> words, List<String> duplicateEmailList) {
            this.words = words;
            this.duplicateEmailList = duplicateEmailList;
        }

    }
}
