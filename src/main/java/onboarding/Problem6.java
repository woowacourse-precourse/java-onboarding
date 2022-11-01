package onboarding;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<List<String>> availableForms = getAvailableForm(forms);
        Map<String, Integer> checkMap = createCheckMap(availableForms);
        List<String> duplicatedTable = createDuplicatedTable(checkMap);
        List<String> duplicatedNicknameList = findDuplicatedNickname(availableForms, duplicatedTable);

        return duplicatedNicknameList;
    }

    //중복된 닉네임을 가진 멤버의 이메일 리스트 반환
    private static List<String> findDuplicatedNickname(List<List<String>> forms, List<String> duplicatedTable) {
        List<String> list = new ArrayList<>();

        for (List<String> form : forms) {
            checkingNickname(form, duplicatedTable, list);
        }
        return list.stream()
                .sorted()
                .distinct()
                .collect(Collectors.toList());
    }

    //멤버리스트 중에서 중복된 테이블의 단어가 있는지 확인
    private static void checkingNickname(List<String> form, List<String> duplicatedTable, List<String> list) {
        for (String duplicatedWord : duplicatedTable) {
            if (form.get(1).contains(duplicatedWord)) {
                list.add(form.get(0));
            }
        }
    }

    //연속된 2글자들 중 두 개 이상 있는 것은 중복이기에 List로 따로 추출하는 메소드
    private static List<String> createDuplicatedTable(Map<String, Integer> checkMap) {
        List<String> duplicateList = new ArrayList<>();
        for (String twoWord : checkMap.keySet()) {
            if (checkMap.get(twoWord) >= 2) {
                duplicateList.add(twoWord);
            }
        }
        return duplicateList;
    }

    //연속된 2글자의 모든 가지 수 맵
    private static Map<String, Integer> createCheckMap(List<List<String>> forms) {
        Map<String, Integer> checkMap = new HashMap<>();

        for (List<String> form : forms) {
            String nickName = form.get(1);
            countingWords(nickName, checkMap);
        }

        return checkMap;
    }

    private static void countingWords(String nickName, Map<String, Integer> checkMap) {
        for (int i = 0; i < nickName.length() - 1; i++) {
            String twoWord = nickName.charAt(i) + "" + nickName.charAt(i + 1);
            checkMap.put(twoWord, checkMap.getOrDefault(twoWord, 0) + 1);
        }
    }

    //제한 사항에 맞는지 확인하는 메소드(이메일 체크 + 닉네임 체크)
    private static List<List<String>> getAvailableForm(List<List<String>> forms) {
        List<List<String>> list = new ArrayList<>();
        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);

            if (isAvailableEmail(email) && isAvailableNickname(nickname)) {
                list.add(form);
            }
        }

        return list;
    }


    private static boolean isAvailableNickname(String nickname) {
        return isKorean(nickname) && isAvailableNickSize(nickname);
    }
    private static boolean isKorean(String nickname) {
        return Pattern.matches("^[가-힣]*$", nickname); //닉네임이 한글인지 확인
    }

    private static boolean isAvailableNickSize(String nickname) {
        if (1 <= nickname.length() && nickname.length() < 20) {
            return true;
        }
        return false;
    }

    private static boolean isAvailableEmail(String email) {
        return isEmailForm(email) && hasRightDomain(email);
    }
    private static boolean hasRightDomain(String email) {
        String domain = email.split("@")[1];
        if (domain.equals("email.com")) {
            return true;
        }
        return false;
    }
    private static boolean isEmailForm(String email) {
        if (email.contains("@")) {
            return true;
        }
        return false;
    }
}
