package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        /* ArrayList를 이용하여 2자리 이상 단어 담기 */
        List<String> ar = new ArrayList<>();

        /* forms 리스트에 닉네임에서 2자리 이상의 단어 찾는 기능 */
        for (int i = 0; i < forms.size(); i++) {

            String nickname = forms.get(i).get(1);

            for (int j = 0; j < nickname.length(); j++) {
                for (int k = j + 1; k < nickname.length(); k++) {
                    /* substring을 이용하여 2자리 이상 단어 추출 */
                    String s = nickname.substring(j, k + 1);
                    if (!ar.contains(s)) ar.add(s);
                }
            }

        }
        return answer;
    }
}
