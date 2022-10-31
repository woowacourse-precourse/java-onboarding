package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (List<String> form : forms) {
            if (!checkException(form)) {
                calc(map, form);
            }
        }
        checkDuplicateNickName(answer, map);

        List<String> newList = new ArrayList<>(answer);
        newList.sort(Comparator.naturalOrder());
        return removeDuplicateEmail(newList);
    }

    private static List<String> removeDuplicateEmail(List<String> list) {
        return list.stream().distinct().collect(Collectors.toList());
    }

    private static void checkDuplicateNickName(List<String> answer, Map<String, List<String>> map) {
        for (String key : map.keySet()) {
            if (map.get(key).size() >= 2) {
                answer.addAll(map.get(key));
            }
        }
    }

    private static void calc(Map<String, List<String>> map, List<String> form) {
        String subNickname;
        List<String> list;
        for (int j = 0; j < form.get(1).length() - 1; j++) {
            subNickname = getSubNickname(form.get(1), j);
            if (map.containsKey(subNickname)) {
                map.get(subNickname).add(form.get(0));
                continue;
            }
            list = new ArrayList<>();
            list.add(form.get(0));
            map.put(subNickname, list);
        }
    }

    private static String getSubNickname(String nickname, int index) {
        return nickname.substring(index, index + 2);
    }

    private static boolean checkException(List<String> form) {
        if (validateEmailLength(form.get(0))) {
            return true;
        }
        if (checkEmailType(form.get(0))) {
            return true;
        }
        if (checkNicknameLength(form.get(1))) {
            return true;
        }
        return checkNicknameKorean(form.get(1));
    }

    private static boolean validateEmailLength(String email) {
        return email.length() < 11
                || email.length() >= 20;
    }

    private static boolean checkEmailType(String email) {
        if (checkEmailFront(email.split("@")[0])) {
            return true;
        }
        return checkEmailFormat(email.split("@")[1]);
    }

    private static boolean checkEmailFront(String target) {
        return Pattern.matches("[^a-zA-Z0-9]*$", target);
    }

    private static boolean checkEmailFormat(String format) {
        return !Objects.equals(format, "email.com");
    }

    private static boolean checkNicknameLength(String nickname) {
        return nickname.length() < 1
                || nickname.length() >= 20;
    }

    private static boolean checkNicknameKorean(String nickname) {
        return !(nickname.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*"));
    }

}