package onboarding;

import java.util.List;
import java.util.TreeSet;

public class Problem6 {
    static TreeSet<String> emailSet = new TreeSet<>();

    /**
     * 중복된 문자열을 지닌 이메일을 전역변수 TreeSet에 추가하는 메서드
     *
     * @param email TreeSet에 추가하는 이메일
     */
    static void addToSet(String email) {
        emailSet.add(email);
    }

    /**
     * TreeSet 전역변수에 email이 존재하는지 확인하는 메서드
     *
     * @param email 확인을 요청하는 이메일
     * @return 이메일이 존재하면 true, 아니라면 false
     */
    static boolean hasEmail(String email) {
        boolean isTrue = false;

        if (emailSet.contains(email)) {
            isTrue = true;
        }

        return isTrue;
    }

    /**
     * 닉네임에 같은 글자가 연속적으로 포함되는 크루 확인하는 메서드
     *
     * @param crew_1 크루 1
     * @param crew_2 크루 2
     */
    static void checkDuplication (List<String> crew_1, List<String> crew_2) {
        for (int i = 0; i < crew_1.get(1).length() - 1; i++) {
            for (int j = 0; j < crew_2.get(1).length() - 1; j++) {
                if ((crew_1.get(1).charAt(i) == crew_2.get(1).charAt(j))
                        && crew_1.get(1).charAt(i + 1) == crew_2.get(1).charAt(j + 1)) {
                    addToSet(crew_1.get(0));
                    addToSet(crew_2.get(0));
                    return;
                }
            }
        }
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
