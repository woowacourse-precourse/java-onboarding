package onboarding;

import java.util.*;
import onboarding.problem6.Validation;


public class Problem6 {

    private static HashMap<String, String> notices = new HashMap<>();

    /*
    * 닉네임 글자가 연속적으로 포함되는지 검증 기능
    */
    private static boolean containConsecutiveLetters(String name1, String name2) {

        for (int i = 2; i <= name2.length(); i++) {
            String subString = name2.substring(i - 2, i);

            if (name1.contains(subString))
                return true;
        }

        return false;
    }

    /*
     * notices map에 닉네임 중복의 교육생 추가
     */
    private static void putDuplicateCrewInNoticesMap(List<String> currentCrew,
            List<List<String>> forms,
            int currentIndex) {

        for (int index = 0; index < forms.size(); index++) {
            if (index == currentIndex)
                continue;

            List<String> otherCrew = forms.get(index);
            String otherCrewEmail = otherCrew.get(0), otherCrewNickName = otherCrew.get(1);
            String currentCrewEmail = currentCrew.get(0), currentCrewNickname = currentCrew.get(1);

            if (containConsecutiveLetters(currentCrewNickname, otherCrewNickName)) {
                notices.putIfAbsent(currentCrewEmail, currentCrewNickname);
                notices.putIfAbsent(otherCrewEmail, otherCrewNickName);
            }
        }
    }

    /*
    * HashMap 키 기반의 오름차순 정렬 기능
    */
    private static List<String> sortByKey(List<String> keyList) {
        keyList.sort(String::compareTo);
        return keyList;
    }

    /*
    * 중복된 닉네임의 교육생을 찾는 함수
    */
    private static List<String> findCrewsHavingDuplicateNickName(List<List<String>> forms) {
        for (int index = 0; index < forms.size(); index++)
            putDuplicateCrewInNoticesMap(forms.get(index), forms, index);

        return sortByKey(new ArrayList<>(notices.keySet()));
    }

    /*
    * forms의 이메일 및 닉네임 검증 함수
    */
    private static void validateEmailAndNickname(List<List<String>> forms) {
        for (List<String> form : forms) {
            Validation.isValidEmail(form.get(0));
            Validation.isValidNickName(form.get(1));
        }
    }

    public static List<String> solution(List<List<String>> forms) {
        validateEmailAndNickname(forms);
        return findCrewsHavingDuplicateNickName(forms);
    }
}
