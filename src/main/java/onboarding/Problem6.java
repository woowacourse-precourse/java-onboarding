package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    /**
     * 입력받은 문자열 2개를 비교해 2자 이상 중복되었는 판별함
     * 
     * @param name
     * @param compareName
     * @return {@code} boolean} 2자이상 중복 여부
     */
    private static boolean isDuplicated(String name, String compareName) {

        for (int s = 0; s < name.length() - 1; s++) {
            String slicedName = name.substring(s, s + 2);

            if (compareName.indexOf(slicedName) > -1) {
                return true;
            }
        }

        return false;
    }
}
