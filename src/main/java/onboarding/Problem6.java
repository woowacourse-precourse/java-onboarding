package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * [o] 두 글자 이상의 문자가 연속적으로 순서에 맞추어 포함되는 경우 중복으로 간주한다.
 * [ ] 이메일은 이메일 형식에 부합하며, 전체 길이는 11자 이상 20자 미만이다.
 * [ ] 신청할 수 있는 이메일은 email.com 도메인으로만 제한한다.
 * [ ] 닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만이다.
 * [o] result는 이메일에 해당하는 부분의 문자열을 오름차순으로 정렬하고 중복은 제거한다.
 */
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = checkEmails(forms);
        return answer;
    }

    public static List<String> checkEmails(List<List<String>> forms) {

        HashSet<String> duplicatedEmails = new HashSet<>();
        HashMap<String, String> duplicatedInfo = new HashMap<>();

        for (int i = 0; i < forms.size(); i++) {
            String email = forms.get(i).get(0);
            String nickName = forms.get(i).get(1);


            if (nickName.length() < 2) {
                break;
            }

            for (int j = 0; j < nickName.length() - 1; j++) {
                String twoLetterWord = nickName.substring(j, j + 2);

                if (duplicatedInfo.containsKey(twoLetterWord)) {
                    String existEmail = duplicatedInfo.get(twoLetterWord);

                    if (!existEmail.equals(email)) {
                        duplicatedEmails.add(existEmail);
                        duplicatedEmails.add(email);
                    }
                }
                duplicatedInfo.put(twoLetterWord, email);
            }
        }

        List<String> collect = duplicatedEmails.stream().sorted().collect(Collectors.toList());

        return collect;
    }

}