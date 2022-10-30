package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 제한사항 :
 *  1. 두 글자 이상의 문자가 연속적으로 순서에 맞추어 포함되어 있는 경우 중복으로 간주한다.
 *  2. 크루는 1명 이상 10,000명 이하이다.
 *  3. 이메일은 이메일 형식에 부합하며, 전체 길이는 11자 이상 20자 미만이다.
 *  4. 신청할 수 있는 이메일은 email.com 도메인으로만 제한한다.
 *  5. 닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만이다.
 *  6. result는 이메일에 해당하는 부분의 문자열을 오름차순으로 정렬하고 중복은 제거한다.
 */
public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        return memberLimit(forms)
                ? List.of()
                : formCheck(forms);
    }

    private static boolean memberLimit(List<List<String>> forms) {
        return forms.size() < 1 || forms.size() > 10000;
    }

    private static List<String> formCheck(List<List<String>> forms) {
        ArrayList<String> duplicatedMembers = new ArrayList<>();

        for (int i = 0; i < forms.size() - 1; i++) {
            String email1 = forms.get(i).get(0);
            String nickName1 = forms.get(i).get(1);

            if (emailValidation(email1) || nickNameValidation(nickName1))
                return List.of();

            for (int j = i + 1; j < forms.size(); j++) {
                String email2 = forms.get(j).get(0);
                String nickName2 = forms.get(j).get(1);
                if(duplicatedLetter(nickName1, nickName2)) {
                    duplicatedMembers.add(email1);
                    duplicatedMembers.add(email2);
                }
            }
        }

        return duplicatedMembers.stream()
                .distinct()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }

    private static boolean emailValidation(String email) {
        return email.length() >= 20 || email.length() < 11 || !email.matches("^\\w+@email\\.com$");
    }

    private static boolean nickNameValidation(String nickName) {
        return nickName.length() >= 20 || nickName.length() < 1 || !nickName.matches("^[가-힣]+$") || nickName.matches("^[가-힣]*([가-힣])\\1[가-힣]*$");
    }

    private static boolean duplicatedLetter(String nickName1, String nickName2) {
        for (int i = 0; i < nickName1.length() - 1; i++) {
            String tmp = nickName1.substring(i, i + 2);
            if(nickName2.contains(tmp))
                return true;
        }
        return false;
    }
}
