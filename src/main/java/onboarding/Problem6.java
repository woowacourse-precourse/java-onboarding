package onboarding;

import java.util.*;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        if (checkValidation(forms)) {
            answer = getDuplicateNickname(forms);
        }

        return answer;
    }

    private static boolean checkValidation(List<List<String>> inputForms) {
        int inputFormLength = inputForms.size();

        // 크루의 수는 1 이상 10,000 이하이다.
        if (!(1 <= inputFormLength && inputFormLength <= 10000)) {
            return false;
        }

        // 각 크루가 가지고 있는 정보는 길이가 2인 리스트이다.
        for(List<String> inputForm : inputForms) {
            if (inputForm.size() != 2) {
                return false;
            }
        }

        // 이메일의 길이는 11자 이상 20자 이하이다.
        for(List<String> inputForm : inputForms) {
            String email = inputForm.get(0);
            int emailLength = email.length();

            if (!(11 <= emailLength && emailLength <= 20)) {
                return false;
            }
        }

        // 이메일 도메인 주소는 @email.com으로 끝나야 한다.
        for(List<String> inputForm : inputForms) {
            String email = inputForm.get(0);
            String emailDomain = email.split("@")[1];

            if (!emailDomain.equals("email.com")) {
                return false;
            }
        }

        // 닉네임은 한글만 사용이 가능하다.
        for(List<String> inputForm : inputForms) {
            String nickname = inputForm.get(1);
            String pattern = "^[가-힣]*$";

            if (!Pattern.matches(pattern, nickname)) {
                return false;
            }
        }

        // 닉네임의 길이는 1자 이상 20자 미만이다.
        for(List<String> inputForm : inputForms) {
            String nickname = inputForm.get(1);
            int nicknameLength = nickname.length();

            if (!(1 <= nicknameLength && nicknameLength < 20)) {
                return false;
            }
        }

        return true;
    }

    private static Map<String, TreeSet<String>> getAllTwoLengthNameMap(List<List<String>> forms) {
        Map<String, TreeSet<String>> result = new TreeMap<>();

        for (List<String> form : forms) {
            String nickname = form.get(1);
            for(int i = 1; i <nickname.length(); i++) {
                String name = String.valueOf(nickname.charAt(i-1)) + nickname.charAt(i);
                TreeSet<String> nameTreeSet = result.getOrDefault(name, new TreeSet<>());
                nameTreeSet.add(nickname);
                result.put(name, nameTreeSet);
            }
        }

        return result;
    }
}
