package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> checkedNicknames = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            String email = forms.get(i).get(0);
            String nickname = forms.get(i).get(1);

            if (nickname.length() < 2) {
                continue;
            }

            List<String> toCheckSubNicknames = getSubNicknames(nickname);

            for (String subNickname : toCheckSubNicknames) {
                if (!checkedNicknames.contains(subNickname)) {
                    for (int j = i + 1; j < forms.size(); j++) {
                        String eemail = forms.get(j).get(0);
                        String nnickname = forms.get(j).get(1);

                        if (nnickname.contains(subNickname)) {
                            System.out.println("nnickname:" + nnickname + " subNickname:" + subNickname);
                            if (!answer.contains(eemail)) {
                                answer.add(eemail);
                            }
                            if (!answer.contains(email)) {
                                answer.add(email);
                            }
                        }
                    }
                    checkedNicknames.add(subNickname);
                }
            }
        }

        answer.sort(String.CASE_INSENSITIVE_ORDER);

        return answer;
    }

    private static List<String> getSubNicknames(String name) {
        List<String> subNicknames = new ArrayList<>();

        for (int i = 0; i <= name.length() - 2; i++) {
            subNicknames.add(name.substring(i, 2 + i));
        }

        return subNicknames;
    }
}
