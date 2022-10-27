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
            if (compareNickname(partList, nickname)) {
                return true;
            }
        }
        return false;
    }

    private static boolean compareNickname(List<String> partList, String nickname) {
        for (int i = 0; i < partList.size(); i++) {
            String part = partList.get(i);
            if(nickname.contains(part)){
                return true;
            }
        }
        return false;
    }
}
