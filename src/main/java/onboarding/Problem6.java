package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Members members = new Members();

        if (forms.size() < 1 || forms.size() > 10000)
            throw new IllegalArgumentException("크루는 1명 이상 10,000명 이하여야 합니다.");

        for (int i = 0; i < forms.size(); i++) {
            String email = forms.get(i).get(0);
            String nickName = forms.get(i).get(1);
            Member member = new Member(nickName, email);

            members.add(member);
        }

        return members.emailsForDuplicateMembers();
    }
}
