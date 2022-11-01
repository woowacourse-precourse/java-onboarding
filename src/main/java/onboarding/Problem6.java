package onboarding;

import java.util.*;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        Set<String> sameName = new HashSet<>(); //중복제거를 위해 사용

        for (int i = 0; i < forms.size(); i++) {
            String email = forms.get(i).get(0);
            String nickname = forms.get(i).get(1);
            List<String> subStrings = new ArrayList<>();

            for (int j = 0; j < nickname.length() - 1; j++) {
                subStrings.add(nickname.substring(j, j + 2)); //두글자 이상 연속이면 중복이므로, 2글자 부분집합을 저장
            }

            for (int k = i + 1; k < forms.size(); k++) { //다른 모든 유저들을 돌면서
                String email2 = forms.get(k).get(0);
                String nickname2 = forms.get(k).get(1);

                for (String word : subStrings) { //substring에 넣어놨던 부분집합들 중,
                    if (nickname2.contains(word)) { //다른 유저의 닉네임에 속한게 있다면 답안에 추가
                        sameName.add(email);
                        sameName.add(email2);
                        break;
                    }
                }
            }
        }
        List<String> answer = new ArrayList<>(sameName);
        Collections.sort(answer);
        return answer;
    }
}
