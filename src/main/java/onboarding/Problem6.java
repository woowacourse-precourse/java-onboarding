package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    /* 닉네임의 길이가 1보다 큰 크루들만 담긴 리스트 */
    private static String[][] seperateLengthOneNickname(List<List<String>> forms) {
        List<String[]> result = new ArrayList<>();
        for (List<String> crew : forms) {
            String nickname = crew.get(1);
            if (nickname.length() > 1) {
                result.add(crew.toArray(new String[2]));
            }
        }
        int resultSize = result.size();
        return result.toArray(new String[resultSize][2]);
    }

    /* 상호간 공유하는 2 이상의 문자열이 있는지 체크하는 메서드 */
    private static Set<String> checkMutualContaning(String[][] forms) {
        for (int i = 0; i < forms.length - 1; i++) {
            String nickname = forms[i][1];

            for (int j = 0; j < nickname.length() - 1; j++) {
                String cutString = nickname.substring(j, j + 2);
            }
        }
    }
}
