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

        HashMap<String, Integer> twoLetterHashMap = new HashMap<>();

        for (List<String> form : forms) {
            if (!verificationCheckAboutEmail(form) || !verificationCheckAboutNickname(form)) {
                return List.of("Check Restrictions");
            }
            twoLetterHashMap = putTwoLetters(form, twoLetterHashMap);
        }

        answer = getRepetitionEmail(forms, twoLetterHashMap);
        answer = deleteRepetition(answer);
        answer = sortASC(answer);

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

    public static HashMap<String, Integer> putTwoLetters(List<String> form, HashMap<String, Integer> twoLetterHashMap) {
        String targetNickname = form.get(NICKNAME);

        for (int i = 0; i < targetNickname.length() - 1; i++) {
            String twoLetter = targetNickname.substring(i, i + 2);
            twoLetterHashMap.put(twoLetter, twoLetterHashMap.getOrDefault(twoLetter, 0) + 1);
        }

        return twoLetterHashMap;
    }

    public static List<String> getRepetitionEmail(List<List<String>> forms, HashMap<String, Integer> twoLetterHashMap) {
        List<String> emailList = new ArrayList<>();

        String targetNickname;
        String targetEmail;

        for (List<String> form : forms) {
            targetNickname = form.get(NICKNAME);
            targetEmail = form.get(EMAIL);

            for (int i = 0; i < targetNickname.length() - 1; i++) {
                String twoLetter = targetNickname.substring(i, i + 2);
                if (twoLetterHashMap.get(twoLetter) > 1) {
                    emailList.add(targetEmail);
                }
            }
        }

        return emailList;
    }

    public static List<String> deleteRepetition(List<String> target) {
        Set<String> deleteRepetitionSet = new HashSet<>(target);
        return new ArrayList<>(deleteRepetitionSet);
    }

    public static List<String> sortASC(List<String> target) {
        Collections.sort(target);
        return target;
    }
}
