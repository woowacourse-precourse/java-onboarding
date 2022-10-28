package onboarding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {
    /*
    기능 목록
    1. 닉네임을 2글자 단위로 해시맵에 저장해서 중복 체크용 해시맵을 만드는 기능
    2. 닉네임 목록을 순회하며 중복된 닉네임을 가진 이메일 리스트를 만드는 기능
    3. 이메일 리스트에서 중복을 제거하는 기능
    4. 이메일 리스트를 정렬하는 기능
     */
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        return answer;
    }

    private static class NicknameChecker {
        private Map<String, Boolean> checkMap;

        public NicknameChecker() {
            checkMap = new HashMap<>();
        }

        public Boolean addNicknameToCheckMap(String nickname) {
            if (nickname.length() < 2) {
                return true;
            }
            for (int i = 1; i < nickname.length(); i++) {
                String partial = String.valueOf(nickname.charAt(i-1)) +
                                String.valueOf(nickname.charAt(i));
                Boolean isExist = checkMap.getOrDefault(partial, false);
                if (isExist) {
                    return false;
                }
                checkMap.put(partial, true);
            }
            return true;
        }
    }
}
