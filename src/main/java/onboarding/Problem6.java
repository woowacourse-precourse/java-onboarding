package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem6 {
    // main method for testing purposes
    public static void main(String[] args) {
        System.out.println(solution(List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        )));
    }

    public static List<String> solution(List<List<String>> forms) {
        List<Integer> targetIdx = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            String nickname = forms.get(i).get(1);
            for (int j = 1; j < nickname.length(); j++) {
                String nicknameSubStr = nickname.substring(j-1, j+1);
                for (int k = i + 1; k < forms.size(); k++) {
                    if (forms.get(k).get(1).contains(nicknameSubStr)) {
                        // 본인이랑 비교대상을 추가함
                        if (!targetIdx.contains(i))
                            targetIdx.add(i);
                        if (!targetIdx.contains(k))
                            targetIdx.add(k);
                    }
                }
            }
        }
        List<String> answer = new ArrayList<>();
        for (Integer idx : targetIdx) {
            answer.add(forms.get(idx).get(0));
        }
        answer.sort(Comparator.naturalOrder());
        return answer;
    }
}
