package onboarding;

import java.util.*;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        return pro(forms);
    }

    static List<String> pro(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        boolean[] visit = new boolean[forms.size()];

        for (int i = 0; i < forms.size(); i++) {
            if(visit[i]) continue;

            String email = forms.get(i).get(0);
            String nickname = forms.get(i).get(1);
            visit[i] = true;

            for(int j = 0; j < nickname.length() - 1; j++) {
                // 두 글자씩 조합하여 중복인지 확인한다
                String str = nickname.substring(j, j + 2);

                boolean isDuplicationFound = false;         // 중복이 있는지 체크
                for (int k = 0; k < forms.size(); k++) {
                    if(k == i) continue;                    // 자기 자신의 닉네임을 탐색하는 경우
                    String other_email = forms.get(k).get(0);
                    String other_nickname = forms.get(k).get(1);

                    isDuplicationFound = other_nickname.contains(str); // 다른 크루의 이름에 해당 문자가 들어 있는지 확인

                    // 중복되는 경우 정답 리스트에 이메일을 추가
                    if(isDuplicationFound) {
                        // 새로운 이메일 주소일 경우 리스트에 추가
                        if(!answer.contains(other_email)) answer.add(other_email);
                        if(!answer.contains(email)) answer.add(email);
                        visit[k] = true;
                        break;
                    }
                    else continue;
                }
                if(isDuplicationFound) break; // 중복이 확인 되었으면 더이상 탐색할 필요가 없으므로 탐색을 중단한다
            }
        }

        Collections.sort(answer); // 정답 리스트를 오름차순으로 정렬한다.

        return answer;
    }

}
