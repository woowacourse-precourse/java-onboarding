package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        Set<String> emailSet = new HashSet<>();

        for (int i = 0; i < forms.size(); i++) {
            String email = forms.get(i).get(0);
            String nickname = forms.get(i).get(1);

            List<String> nicknameWordList = findNicknameWordList(nickname);

            for (int j = i + 1; j < forms.size(); j++) {
                String NextEmail = forms.get(j).get(0);
                String NextNickname = forms.get(j).get(1);

                nicknameWordList.stream().filter(NextNickname::contains).forEachOrdered(word -> {
                    emailSet.add(email);
                    emailSet.add(NextEmail);
                });
            }
        }
        List<String> answer = new ArrayList<>(emailSet);
        Collections.sort(answer);
        return answer;
    }

    private static List<String> findNicknameWordList(String nickname) {
        List<String> nicknameWordList = IntStream.range(0, nickname.length() - 1)
            .mapToObj(j -> nickname.substring(j, j + 2)).collect(Collectors.toList());
        return nicknameWordList;
    }
}
