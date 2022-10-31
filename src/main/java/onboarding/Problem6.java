package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {

    public static final int EMAIL = 0;
    public static final int NICKNAME = 1;

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        if (!verificationCheckAboutCrews(forms)) {
            return List.of("Check Restrictions");
        }

        for (List<String> form : forms) {
            if (!verificationCheckAboutEmail(form) || !verificationCheckAboutNickname(form)) {
                return List.of("Check Restrictions");
            }
        }

        TwoLetters twoLetters = new TwoLetters(forms);
        answer = twoLetters.getAnswer();

        return answer;
    }

    public static boolean verificationCheckAboutCrews(List<List<String>> forms) {
        int crews = forms.size();
        if (crews < 1 || crews > 10000) {
            return false;
        }
        return true;
    }

    public static boolean verificationCheckAboutEmail(List<String> form) {
        String email = form.get(EMAIL);
        String emailRegex = "^.*@email.com$";
        int emailLength = email.length();

        if (emailLength < 11 || emailLength >= 20) {
            return false;
        }
        if (!email.matches(emailRegex)) {
            return false;
        }
        return true;
    }

    public static boolean verificationCheckAboutNickname(List<String> form) {
        String nickname = form.get(NICKNAME);
        String nicknameRegex = "^[가-힣]*$";
        int nicknameLength = nickname.length();

        if (nicknameLength < 1 || nicknameLength >= 20) {
            return false;
        }
        if (!nickname.matches(nicknameRegex)) {
            return false;
        }
        return true;
    }

    public static class TwoLetters {
        List<List<String>> forms;
        HashMap<String, Integer> twoLetterHashMap;
        List<String> emailList;
        List<String> answer;

        TwoLetters(List<List<String>> forms) {
            this.forms = forms;
            twoLetterHashMap = new HashMap<>();
            emailList = new ArrayList<>();
        }

        private void setTwoLetterHashMap() {
            for (List<String> form : forms) {
                putTwoLetters(form);
            }
        }

        private void putTwoLetters(List<String> form) {
            String targetNickname = form.get(NICKNAME);

            for (int i = 0; i < targetNickname.length() - 1; i++) {
                String twoLetter = targetNickname.substring(i, i + 2);
                this.twoLetterHashMap.put(twoLetter, twoLetterHashMap.getOrDefault(twoLetter, 0) + 1);
            }
        }

        private void setRepetitionEmail() {
            for (List<String> form : forms) {
                addRepetitionEmailToEmailList(form);
            }
        }

        private void addRepetitionEmailToEmailList(List<String> form) {
            String nickname = form.get(NICKNAME);
            String email = form.get(EMAIL);

            for (String twoLetterNickname : twoLetterHashMap.keySet()) {
                if (nickname.contains(twoLetterNickname) && twoLetterHashMap.get(twoLetterNickname) > 1) {
                    this.emailList.add(email);
                }
            }
        }

        private void deleteRepetition() {
            Set<String> deleteRepetitionSet = new HashSet<>(emailList);
            answer = new ArrayList<>(deleteRepetitionSet);
        }

        private void sortASC() {
            Collections.sort(answer);
        }

        private List<String> getAnswer() {
            setTwoLetterHashMap();
            setRepetitionEmail();
            deleteRepetition();
            sortASC();
            return answer;
        }
    }
}
