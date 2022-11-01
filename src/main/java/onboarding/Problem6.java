package onboarding;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        String[][] crewsExceptOneLengthName = seperateLengthOneNickname(forms);
        /* 길이 1의 문자열에서 길이 2의 문자열을 추출 할 수 없으므로 제거된 배열을 매개변수로 넣는다 */
        Set<String> emails = checkMutualContaning(crewsExceptOneLengthName);
        List<String> answer = new ArrayList<>(emails);
        Collections.sort(answer);
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
        Set<String> result = new HashSet<>();
        int formsLength = forms.length;
        for (int i = 0; i < formsLength - 1; i++) {
            String nickname = forms[i][1];

            for (int j = 0; j < nickname.length() - 1; j++) {
                String cutString = nickname.substring(j, j + 2);

                for (int h = i + 1; h < formsLength; h++) {
                    if (forms[h][1].contains(cutString)) {
                        result.add(forms[i][0]);
                        result.add(forms[h][0]);
                    }
                }
            }
        }

        return result;
    }
}
