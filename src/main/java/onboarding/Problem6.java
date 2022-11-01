package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        checkForm_email(forms);
        checkForm_nickname(forms);

        for (int i = 0; i < forms.size(); i++) {
            List<String> currentUser = forms.get(i);
            for (List<String> compareUser : forms) {
                if (!currentUser.equals(compareUser)) {
                    String currentUserStr = currentUser.get(1);
                    String compareUserStr = compareUser.get(1);
                    for (int k = 0; k < currentUserStr.length() - 1; k++) {
                        //두 글자 이상의 문자가 연속적으로 순서에 맞추어 포함되어 있는 경우 중복으로 간주한다.
                        String duplicateStr = currentUserStr.substring(k, k + 2);
                        if (compareUserStr.contains(duplicateStr)) {
                            answer.add(currentUser.get(0));
                        }
                    }
                }
            }
        }
        answer = checkAnswer(answer);

        return answer;
    }

    public static void checkForm_email(List<List<String>> forms) {
        //이메일은 이메일 형식에 부합하며, 전체 길이는 11자 이상 20자 미만이다.
        //신청할 수 있는 이메일은 email.com 도메인으로만 제한한다.
        String pattern = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@email.com";
        for (List<String> form : forms) {
            String email = form.get(0);
            if (email.length() < 11 || email.length() > 20 || !Pattern.matches(pattern, email)) {
                forms.remove(form);
            }
        }
        if (forms.size() < 1 || forms.size() > 10_000) {
            //크루는 1명 이상 10,000명 이하이다.
            throw new IllegalStateException("크루는 1명 이상, 10,000명 이하여야 합니다.");
        }
    }

    public static void checkForm_nickname(List<List<String>> forms) {
        //닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만이다.
        String pattern = "^[ㄱ-ㅎ가-힣]*$";
        for (List<String> form : forms) {
            String nickname = form.get(1);
            if (nickname.length() < 1 || nickname.length() > 20 || !Pattern.matches(pattern, nickname)) {
                forms.remove(form);
            }
        }
    }

    public static List<String> checkAnswer(List<String> answer) {
        //result는 이메일에 해당하는 부분의 문자열을 오름차순으로 정렬하고 중복은 제거한다.
        answer = answer.stream().distinct().sorted().collect(Collectors.toList());
        return answer;
    }

}
