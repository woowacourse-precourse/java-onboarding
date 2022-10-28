package onboarding;

import java.util.*;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            String nickname = forms.get(i).get(1);
            for (int j = 0; j < nickname.length() - 1; j++) {
                String splitNickname = nickname.substring(j, j + 2);

                for (int k = i + 1; k < forms.size(); k++) {
                    String comparedNickname = forms.get(k).get(1);

                    for (int x = 0; x < comparedNickname.length() - 1; x++) {
                        String splitComparedNickname = comparedNickname.substring(x, x + 2);

                        if (splitNickname.equals(splitComparedNickname)) {
                            if (!answer.contains(forms.get(i).get(0))) {
                                answer.add(forms.get(i).get(0));
                            } else if (!answer.contains(forms.get(k).get(0))) {
                                answer.add(forms.get(k).get(0));
                            }
                        }
                    }
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }
}
