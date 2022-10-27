package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < forms.size(); i++) {
            String nickName = forms.get(i).get(1);
            List<String> partOfNicknameList = takeApartNickname(nickName);
            boolean confusing = checkConfusing(partOfNicknameList, i, forms);
            if (confusing) {
                set.add(forms.get(i).get(0));
            }
        }
        List<String> answer = new ArrayList<>(set);
        Collections.sort(answer);
        return answer;
    }

    private static List<String> takeApartNickname(String nickname) {
        List<String> partOfNicknameList = new ArrayList<>();
        for (int i = 0; i < nickname.length() - 1; i++) {
            partOfNicknameList.add(nickname.substring(i, i + 2));
        }
        return partOfNicknameList;
    }

    private static boolean checkConfusing(List<String> partList, int curIndex, List<List<String>> forms) {
        for (int i = 0; i < forms.size(); i++) {
            if (i == curIndex) {
                continue;
            }

            String nickname = forms.get(i).get(1);
            // TODO : indent 2 넘지 않도록 함수 분리
            for (int j = 0; j < partList.size(); j++) {
                String part = partList.get(j);
                if (nickname.contains(part)) {
                    return true;
                }
            }
        }
        return false;
    }
}
