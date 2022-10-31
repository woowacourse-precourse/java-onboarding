package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * 가장 처음 사람부터 한 사람씩 닉네임을 2글자씩 자른 뒤
 * 나머지 사람들과 닉네임이 2글자씩 자른 닉네임을 포함하는지 검사해나감.
 * 중복되는 부분이 있으면 검사받는 사람과 비교 대상인 사람들 둘 다 배열에 추가
 * 중복을 제거하기 위해 HashSet사용.
 * 이후 오름차순 정렬 한 뒤 리턴
 */

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> saveEmail = new HashSet<>();
        for(int i = 0; i<forms.size()-1;i++) {
            String nick = forms.get(i).get(1);
            String email = forms.get(i).get(0);

            for (int k = 0; k < nick.length() - 1; k++) {
                String word = nick.substring(k, k + 2); //두 글자씩 자른 닉네임

                for (int j = i + 1; j < forms.size(); j++) {
                    String email2 = forms.get(j).get(0);
                    String nick2 = forms.get(j).get(1);

                    if (nick2.contains(word)) {
                        saveEmail.add(email);
                        saveEmail.add(email2);
                    }
                }
            }
        }
        List<String> answer = new ArrayList<>(saveEmail);
        Collections.sort(answer);
        return answer;
    }
}
