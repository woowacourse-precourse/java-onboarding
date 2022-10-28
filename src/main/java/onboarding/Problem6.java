package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> nicknameList = extractNicknames(forms);

        return nicknameList;
    }

    public static List<String> extractNicknames(List<List<String>> forms) {
        List<String> nicknameList = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            nicknameList.add(forms.get(i).get(1));
        }

        return nicknameList;
    }
}
