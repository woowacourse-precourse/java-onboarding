package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> AnswerEmails = findAnswerEmailSet(forms);
        List<String> answer = new ArrayList<>(AnswerEmails);
        Collections.sort(answer);

        return answer;
    }
    public static HashSet<String> findAnswerEmailSet(List<List<String>> forms){
        HashMap<String,String> allPartialNicknameWithEmail = new HashMap<>();
        HashSet<String> answerEmails = new HashSet<>();
        String nickname;
        String email;

        for(int i=0;i < forms.size();i++){
            nickname = forms.get(i).get(1);
            email = forms.get(i).get(0);
            putAllPartialNicknameWithEmail(allPartialNicknameWithEmail,answerEmails,nickname,email);
        }

        return answerEmails;
    }
    public static void putAllPartialNicknameWithEmail(HashMap<String,String> allPartialNicknameWithEmail
            , HashSet<String> answerEmails,String nickname,String email){
        String partialNickname;
        for(int i=0;i <= nickname.length()-2;i++) {
            partialNickname = nickname.substring(i,i+2);
            if(allPartialNicknameWithEmail.containsKey(partialNickname) == true) {
                String newlyAddedEmail = allPartialNicknameWithEmail.get(partialNickname);
                addEmailsToAnswerSet(answerEmails,email,newlyAddedEmail);
            }
            allPartialNicknameWithEmail.put(partialNickname,email);
        }
    }
    public static void addEmailsToAnswerSet(HashSet<String> answerEmails, String email, String newlyAddedEmail) {
        if (email != newlyAddedEmail) {
            answerEmails.add(email);
            answerEmails.add(newlyAddedEmail);
        }
    }
}

