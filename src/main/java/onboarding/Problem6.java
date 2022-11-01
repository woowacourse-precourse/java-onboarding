package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> getSlicedNicknames(List<List<String>> forms) {
        List<String> slicedNicknames = new ArrayList<>();
        String nickName = "";
        String slicedNickname = "";

        for (List<String> userInfo : forms) {
            nickName = userInfo.get(1);
            for (int index = 0; index < nickName.length() - 1; index++) {
                slicedNickname = nickName.substring(index, index + 2);
                if (!slicedNicknames.contains(slicedNickname)) {
                    slicedNicknames.add(slicedNickname);
                }
            }
        }
        return slicedNicknames;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
