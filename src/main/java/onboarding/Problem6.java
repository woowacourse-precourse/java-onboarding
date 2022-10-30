package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = getEmails(forms);
        answer = getDeduplicationAndSortEmails(answer);
        return answer;
    }

    /**
     * 두 글자 이상인 닉네임중 연속 된 두 글자가 포함된 유저의 이메일 목록을 얻는다.
     *
     * @param forms 유저들의 정보
     * @return 신청받은 닉네임 중 같은 글자가 연속적으로 포함 되는 닉네임을 작성한 유저의 이메일 목록을 반환한다.
     */
    private static List<String> getEmails(List<List<String>> forms) {
        List<List<String>> twoWordForms = new ArrayList<>();    // {{이메일, 두 글자 이상의 문자}, ...}
        List<String> emails = new ArrayList<>();
        for (List<String> user : forms) {
            hasTwoWord(twoWordForms, emails, user);
        }
        return emails;
    }

    /**
     * 오브젝트에서 중복을 제거한 뒤 오름차순으로 정렬한다.
     *
     * @param emails 유저들의 이메일
     * @return 중복 제거와 오름차순으로 정렬된 오브젝트
     */
    private static List<String> getDeduplicationAndSortEmails(List<String> emails) {
        emails = emails.stream().distinct().collect(Collectors.toList());
        Collections.sort(emails);
        return emails;
    }

    /**
     * 유저의 닉네임에 두 글자가 포함하는지 탐색한뒤 포함하면 오브젝트에 추가한다.
     *
     * @param twoWordForms 두 글자의 정보 {{email, twoWord}, ...}
     * @param emails       유저의 이메일
     * @param user         유저의 정보 {email, nickname}
     */
    private static void hasTwoWord(List<List<String>> twoWordForms, List<String> emails, List<String> user) {
        String nickname = user.get(1);
        if (nickname.length() != 1) {
            for (int i = 0; i <= nickname.length() - 2; i++) {
                String twoWord = nickname.substring(i, i + 2);
                for (List<String> twoWordForm : twoWordForms) {
                    if (twoWordForm.contains(twoWord)) {
                        emails.add(user.get(0));
                        emails.add(twoWordForm.get(0));
                    }
                }
                twoWordForms.add(new ArrayList<>(List.of(user.get(0), twoWord)));
            }
        }
    }

}
