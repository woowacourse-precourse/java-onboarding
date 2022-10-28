package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Problem6 {
    private static ArrayList<String> twoLetterSplitNicknames = new ArrayList<>();

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    /**
     * 폼 검증
     * @param forms 폼
     * @return 검증 결과 값
     */
    private static boolean validateForm(List<List<String>> forms) {
        int sizeForms = forms.size();
        return sizeForms > 0 && sizeForms <= 10_000;
    }

    /**
     * 크루 검증
     * @param crew 등록된 크루
     * @return 검증 결과 값
     */
    private static boolean validateCrew(List<String> crew) {
        String email = crew.get(0);
        String nickname = crew.get(1);

        if(!Pattern.matches("^[.A-Za-z0-9_-]{1,9}+@email.com$", email)) {
            return false;
        }

        if (!Pattern.matches("^[가-힣]{1,19}$", nickname)) {
            return false;
        }

        if (isNeedChangeNickname(nickname)) {
            return false;
        }

        return true;
    }

    /**
     * 닉네임 중복 확인
     * @param nickname 닉네임
     * @return 중복 여부 반환
     */
    private static boolean isNeedChangeNickname(String nickname) {
        String[] splitNicknames = splitAndBindNickname(nickname);
        ArrayList<String> tempSplitNicknames = new ArrayList<>();

        for (String twoLetterNickname : splitNicknames) {
            if (!tempSplitNicknames.contains(twoLetterNickname)) {
                tempSplitNicknames.add(twoLetterNickname);

                if (existTwoLetterNickname(twoLetterNickname)) {
                    return true;
                }

                addTwoLetterNickname(twoLetterNickname);
            }
        }

        return false;
    }

    /**
     * 글자 분할
     * @param nickname 닉네임
     * @return 2글자씩 묶인 글자 집합을 반환
     */
    private static String[] splitAndBindNickname(String nickname) {
        String[] splitNickname = nickname.split("");
        int lengthSplitNickname = splitNickname.length;
        String[] splitAndBindNickname = new String[lengthSplitNickname - 1];

        for (int i = 1; i < splitNickname.length; i++) {
            splitAndBindNickname[i - 1] = splitNickname[i - 1] + splitNickname[i];
        }

        return splitAndBindNickname;
    }


    /**
     * 분할 된 글자 검색
     * @param twoLetterNickname 2글자씩 묶인 닉네임
     * @return 존재 여부
     */
    private static boolean existTwoLetterNickname(String twoLetterNickname) {
        return twoLetterSplitNicknames.contains(twoLetterNickname);
    }

    /**
     * 분할 된 글자 저장
     * @param twoLetterNickname 2글자씩 묶인 글자
     */
    private static void addTwoLetterNickname(String twoLetterNickname) {
        twoLetterSplitNicknames.add(twoLetterNickname);
    }

}
