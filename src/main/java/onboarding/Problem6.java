package onboarding;

import java.util.*;

class PreventDuplication {
    /**
     * 중복 이름 방지에 쓰이는 메소드들을 정의한 클래스입니다.
     *
     * 모두 외부에 기능을 제공하기 위한 메소드들이고,
     * 인스턴스 변수의 값을 참조하거나 수정하지 않기 때문에
     * 불필요한 인스턴스의 생성을 줄이기 위해 클래스 메소드로 선언했습니다.
     *
     */
    public static Set<String> getDuplicatedTwoCharSet(List<List<String>> forms) {
        /**
         * 중복의 대상이 되는 최소 2글자 문자열들로 이루어진 Set을 반환하는 메소드
         */

        List<String> twoCharList = new ArrayList<>();
        Set<String> duplicatedTwoCharSet = new HashSet<>();

        for (List<String> crewInfo : forms) {
            String crewName = crewInfo.get(1);
            for (int i = 0; i <= crewName.length() - 2; i++) {
                String twoChar = crewName.substring(i, i + 2);
                if (twoCharList.contains(twoChar)) duplicatedTwoCharSet.add(twoChar);
                twoCharList.add(twoChar);
            }
        }

        return duplicatedTwoCharSet;
    }
}

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        /**
         * forms를 순회하며 이름을 조회하여
         * getDuplicatedTwoCharSet 메소드로 만든 '중복의 대상이 되는 최소 2글자 문자열'들로 이루어진 Set에 있는 각 요소들이 이름에 포함되어있는지를 검사합니다.
         */

        List<String> answer = new ArrayList<>();
        Set<String> duplicatedTwoCharSet = PreventDuplication.getDuplicatedTwoCharSet(forms);

        for (List<String> crewInfo : forms) {
            String crewName = crewInfo.get(1);
            for (String duplicatedTwoChar : duplicatedTwoCharSet) {
                if (crewName.contains(duplicatedTwoChar)) answer.add(crewInfo.get(0));
            }
        }

        Collections.sort(answer);

        return answer;
    }
}
