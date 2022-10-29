package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Problem6 {
    public static void main(String[] args) {
        System.out.println(solution(List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        )));
    }

    private class Constants {
        protected static final int EMAIL = 0;
        protected static final int NICKNAME = 1;
    }

    public static List<List<String>> users = new ArrayList<>();
    public static List<String> result = new ArrayList<>();

    public static List<String> solution(List<List<String>> forms) {
        initList(forms);
        return test(forms);
    }

    private static void initList(List<List<String>> forms) {
        users.add(forms.get(0));
    }
    // 제이엠
    // 엠제이
    // substring 으로 앞에서 부터 2글짜씩 짤라서 비교하면 될 듯
    private static List<String> test(List<List<String>> forms) {
        for (int i = 1; i < forms.size(); i++) {
            List<String> user = forms.get(i);
            boolean b = isLetterWordsInAlreadyExistsNicknames(forms.get(i).get(Constants.NICKNAME));
            if (b) {
                if (!isAlreadyExistsEmailInResult(user.get(Constants.EMAIL))) {
                    result.add(user.get(Constants.EMAIL));
                }
            } else {
                users.add(user);
            }
        }

        sortList();
        return result;
    }

    // 이미 있는 닉네임 중에서 글자가 연속적으로 포함되는 닉네임이 있는가
    private static boolean isLetterWordsInAlreadyExistsNicknames(String nickname) {
        for (int i = 0; i < nickname.length() - 1; i++) {
            for (List<String> user : users) {
                String alreadyExistsNickname = user.get(Constants.NICKNAME);
                if (alreadyExistsNickname.contains(nickname.substring(i, i + 2))) {
                    if (!isAlreadyExistsEmailInResult(user.get(Constants.EMAIL))) {
                        result.add(user.get(Constants.EMAIL));
                    }
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isAlreadyExistsEmailInResult(String email) {
        for (String alreadyExistsEmail : result) {
            if (Objects.equals(alreadyExistsEmail, email)) {
                return true;
            }
        }
        return false;
    }

    private static void sortList() {
        Collections.sort(result);
    }
}
