package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 기능 1: 이메일, 이름을 가져와 주는 함수 작성
 * 기능 2: 중복 닉네임을 판단하여 이메일을 담는 함수 작성
 * 기능 3: 담긴 이메일 중에 중복을 제거하고 정렬해주는 함수 작성
 */
public class Problem6 {

    public static String getEmail(List<String> userInfoList) {
        return userInfoList.get(0);
    }

    public static String getName(List<String> userInfoList) {
        return userInfoList.get(1);
    }

    public static void checkDuplicateName(List<String> answer, Map<String, String> keyWithEmailMap, List<String> userInfoList) {
        String name = getName(userInfoList);
        for (int j = 0; j < name.length() - 1; j++) {
            String word = name.substring(j, j + 2);
            if (keyWithEmailMap.containsKey(word)) {
                String email = keyWithEmailMap.get(word);
                if (!answer.contains(getEmail(userInfoList))) {
                    answer.add(email);
                    answer.add(getEmail(userInfoList));
                }
            }
            keyWithEmailMap.put(word, getEmail(userInfoList));
        }
    }

    public static List<String> removeDuplicate(List<String> answer) {
        List<String> result = answer.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        return result;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        Map<String, String> keyWithEmailMap = new HashMap<>();

        for (int i = 0; i < forms.size(); i++) {
            checkDuplicateName(answer, keyWithEmailMap, forms.get(i));
        }

        answer = removeDuplicate(answer);

        return answer;
    }
}
