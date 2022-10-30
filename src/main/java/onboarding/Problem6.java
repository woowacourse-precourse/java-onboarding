package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Problem6 {

    /**
     * 정규식을 통해 @email.com을 만족하는지 확인
     * @param input
     * @return
     */
    private static boolean inspectEmailCondition(String input) {
        return input.matches("/^.*@email.com$/");
    }

    /**
     * 정규식을 통해 한글로만 이루어져 있는지 확인
     * @param input
     * @return
     */
    private static boolean inspectNicknameCondition(String input) {
        return input.matches("/^[ㄱ-ㅎ|가-힣]+$/");
    }

    /**
     * 이메일의 username 부분만 추출한다
     * @param input
     * @return
     */
    private static String getEmailUsername(String input) {
        String temp = "";
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '@') {
                temp = input.substring(0, i);
            }
        }
        return temp;
    }

    /**
     * 주어진 이메일 목록 중 조건을 만족하는 항목을 선별한다.
     * @param forms
     * @return
     */
    private static List<List<String>> collectValidInputs(List<List<String>> forms) {
        List<List<String>> result = new ArrayList<>();

        for (List<String> next : forms) {
            if (inspectEmailCondition(next.get(0)) || inspectNicknameCondition(next.get(1))) {
                continue;
            }
            List<String> temp = new ArrayList<>();
            temp.add(getEmailUsername(next.get(0)));
            temp.add(next.get(1));
            result.add(temp);
        }

        return result;
    }

    /**
     * 문자열 a와 문자열 b가 '유사'한지 확인
     * @param a
     * @param b
     * @return
     */
    private static boolean twoStringsAreAlike(String a, String b) {
        for (int i = 0; i < a.length() - 1; i++) {
            String temp = a.substring(i, i + 2);
            if (b.contains(temp)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 서로 비슷한 닉네임을 찾아, 그 닉네임의 이메일을 기록한 목록을 리턴한다
     * @param newForms
     * @return
     */
    private static List<String> checkAlikeNicknames(List<List<String>> newForms) {
        TreeSet<String> duplicates = new TreeSet<>();

        // 두 닉네임이 유사하면, 두 이메일 주소를 기록한다.
        for (int i = 0; i < newForms.size() - 1; i++) {
            for (int j = i + 1; j < newForms.size(); j++) {
                if(twoStringsAreAlike(newForms.get(i).get(1), newForms.get(j).get(1))) {
                    duplicates.add(newForms.get(i).get(0));
                    duplicates.add(newForms.get(j).get(0));
                }
            }
        }

        List<String> result = new ArrayList<>();
        for (String next : duplicates) {
            StringBuilder sb = new StringBuilder();
            sb.append(next);
            sb.append("@email.com");
            result.add(sb.toString());
        }
        return result;
    }

    /**
     * 주어진 목록을 검사하여 조건에 맞는 입력들 중에서, 서로 유사한 닉네임을 가지는 사람들의 이메일을 오름차순으로 리턴
     * @param input
     * @return
     */
    private static List<String> getAlikeNicknamesList(List<List<String>> input) {
        List<List<String>> validLists = collectValidInputs(input);
        return checkAlikeNicknames(validLists);
    }

    public static List<String> solution(List<List<String>> forms) {
        return getAlikeNicknamesList(forms);
    }
}
