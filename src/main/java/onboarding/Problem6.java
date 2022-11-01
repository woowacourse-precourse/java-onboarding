package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {

    public static List<Integer> hasReduplication(String[] nickNames, StringBuilder nickName) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nickName.length() - 1;i++) {

            // 닉네임 부분 추출
            String tmp = nickName.substring(i, i+2);
            System.out.println(tmp);

            for (int j = 0;j < nickNames.length;j++) {

                // 부분 추출한 닉네임 포함 확인
                if (nickNames[j].contains(tmp)) {
                    result.add(j);
                }

            }
        }

        return result;

    }

    public static List<String> compareNickname(List<List<String>> forms) {
        List<String> result = new ArrayList<>();

        return result;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        answer = compareNickname(forms);
        return answer;
    }


}
