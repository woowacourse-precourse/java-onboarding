package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}

class EmailArrayListValuePerSplitedNickNameKeyMap {
    private List<String> splitByTwoToArrayList(String str) {
        ArrayList arrayList = new ArrayList<>();

        for (int i = 0; i < str.length() - 1; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(str.charAt(i));
            sb.append(str.charAt(i + 1));

            arrayList.add(String.valueOf(sb));
        }

        return arrayList;
    }
}