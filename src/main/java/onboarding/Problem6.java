package onboarding;

import java.util.*;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        // HashMap을 활용하여 중복 검사 + 검색 빠르게 수행
        Map<String, Integer> strSlices = new HashMap<>();
        Set<Integer> duplicatedIndexes = new HashSet<>();
        for (int i = 0; i < forms.size(); i++) {
            List<String> slices = devideIntoTwo(forms.get(i).get(1));
            for (String slice : slices) {
                if (strSlices.containsKey(slice)) {
                    duplicatedIndexes.add(strSlices.get(slice));
                    duplicatedIndexes.add(i);
                } else {
                    strSlices.put(slice, i);
                }
            }
        }
        // 중복이 있는 인덱스의 이메일 반환하기
        for (int index : duplicatedIndexes) {
            answer.add(forms.get(index).get(0));
        }
        Collections.sort(answer);
        return answer;
    }

    private static List<String> devideIntoTwo(String nickname) {
        List<String> twoLetters = new ArrayList<>();
            for (int i = 0; i < nickname.length() - 1; i++) {
                String slicedStr = nickname.substring(i, i + 2);
                if (!twoLetters.contains(slicedStr)) {
                    twoLetters.add(slicedStr);
                }
            }
        return twoLetters;
    }
}
