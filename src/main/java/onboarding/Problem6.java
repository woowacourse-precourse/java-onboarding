package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> AnswerEmails = findAnswerEmailSet(forms);
        List<String> answer = new ArrayList<>(AnswerEmails);
        Collections.sort(answer);

        return answer;
    }

    public static HashSet<String> findAnswerEmailSet(List<List<String>> forms) {
        HashMap<String, String> allPartialNicknameWithEmail = new HashMap<>();
        HashSet<String> answerEmails = new HashSet<>();
        String nickname;
        String email;

        for (int i = 0; i < forms.size(); i++) {
            nickname = forms.get(i).get(1);
            email = forms.get(i).get(0);
            putAllPartialNicknameWithEmail(allPartialNicknameWithEmail, answerEmails, nickname, email);
        }

        return answerEmails;
    }
}

