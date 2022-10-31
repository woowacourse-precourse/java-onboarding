/*
 * Problem6.java
 *
 * 2022-10-31
 *
 */
package onboarding;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 우아한 테크코스 - 프리코스 1주차 중복되는 닉네임 구하기
 *
 * @author 이준현
 * @version 1.00 2022년 10월 31일
 */
public class Problem6 {

    /**
     * 입력받은 input의 유효성을 검증하는 기능
     *
     * @param list 검증될 List
     * @return input이 정상이면 true, 비정상일시 false
     */
    public static boolean validCheck(List<List<String>> list) {
        if (list.size() < 1 || list.size() > 10000) {
            return false;
        }
        for (List<String> user : list) {
            if (user.get(0).length() < 11 || user.get(0).length() >= 20) {
                return false;
            }
            if (!user.get(0).substring(user.get(0).length() - 9, user.get(0).length()).equals("email.com")) {
                return false;
            }
            if (!isItKorean(user.get(1))) {
                return false;
            }
            if (user.get(1).length() < 1 || user.get(1).length() >= 20) {
                return false;
            }
        }
        return true;
    }

    /**
     * 문자들이 한글로 구성되어 있는지 확인하는 기능
     *
     * @param s 확인할 문자열
     * @return 한글이 아닌 문자로 구성되어 있으면 false, 한글로 구성되어있으면 true
     */
    private static boolean isItKorean(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.getType(s.charAt(i)) != 5) {
                return false;
            }
        }
        return true;
    }

    /**
     * List내 모든 이름을 2글자씩 나누어 Set에 추가후 2개이상 나타나는 이름목록 추출
     *
     * @param list 모든 사람들의 이메일과 이름이 담긴 List
     * @return 중복된 사람들의 이름이 담긴 Name Set
     */
    public static HashSet<String> nameSeparation(List<List<String>> list) {
        HashMap<String, Integer> nameMap = new HashMap<>();
        HashSet<String> duplicateNameSet = new HashSet<>();

        for (List<String> user : list) {
            String name = user.get(1);
            for (int i = 0; i < name.length() - 1; i++) {
                String twoLetters = name.substring(i, i + 2);
                if (!nameMap.containsKey(twoLetters)) {
                    nameMap.put(twoLetters, 1);
                } else {
                    duplicateNameSet.add(twoLetters);
                }
            }
        }
        return duplicateNameSet;
    }

    /**
     * 문제에 주어진 중복된 닉네임을 나타내는 사람을 찾고, 해당 사람의 이메일들을 추출해 return
     *
     * @param list 중복여부를 확인할 사람들 form
     * @return 닉네임이 2글자 이상 중복일시 이메일을 추출하여 중복제거 후, 정렬하여 return
     */
    public static List<String> getDuplicateEmail(List<List<String>> list) {
        HashSet<String> duplicateNameSet = nameSeparation(list);
        List<String> duplicateEmail = new ArrayList<>();

        for (List<String> user : list) {
            String email = user.get(0);
            String name = user.get(1);
            for (int i = 0; i < name.length() - 1; i++) {
                String twoLetters = name.substring(i, i + 2);
                if (duplicateNameSet.contains(twoLetters)) {
                    duplicateEmail.add(email);
                }
            }
        }
        duplicateEmail = duplicateEmail.stream().distinct().collect(Collectors.toList());
        Collections.sort(duplicateEmail);
        return duplicateEmail;
    }

    /**
     * 최종적으로 제출되는 solution
     *
     * @param forms 중복여부를 확인할 정보가 담긴 List
     * @return 중복된 닉네임을 가진 사람들의 email정보가 담긴 List
     */
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        if (!validCheck(forms)) {
            throw new IllegalStateException("잘못된 입력입니다.");
        }
        answer = getDuplicateEmail(forms);
        return answer;
    }
}
