package onboarding;

import java.util.*;

public class Problem6 {
    static final int FORM_EMAIL = 0;
    static final int FORM_NICKNAME = 1;
    static List<String> answer = new ArrayList<>();
    static List<Set<String>> partsOfNicknameList = new ArrayList<>();
    static Map<String, Integer> nicknameAndCountMap = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {
        return answer;
    }

    public static Set<String> nicknameDecomposition(String nickname) {
        Set<String> separatedNickname = new HashSet<>();
        for (int i = 0; i < nickname.length() - 1; i++) {
            separatedNickname.add(nickname.substring(i, i + 2));
        }
        return separatedNickname;
    }
}
