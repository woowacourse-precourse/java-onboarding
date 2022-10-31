package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Problem6 {
    enum User {
        email(0),
        name(1),
        address(1),
        min(1),
        max(10_000);
        private final int info;
        User(int info) {
            this.info = info;
        }
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer;

        checkException(forms);

        answer = saveUser(forms);
        answer = findEmailByName(saveSameUser(answer), forms);

        return answer;
    }

    public static List<String> findEmailByName(List<Integer> user_list, List<List<String>> forms) {
        List<String> email_list = new ArrayList<>();

        for (Integer integer : user_list) {
            String emailTxt = forms.get(integer).get(User.email.info);
            if (email_list.contains(emailTxt))
                continue;
            email_list.add(forms.get(integer).get(User.email.info));
        }

        Collections.sort(email_list);

        return email_list;
    }
    public static List<String> saveUser(List<List<String>> forms) {
        List<String> user_list = new ArrayList<>();

        for (List<String> form : forms)
            user_list.add(form.get(User.name.info));

        return user_list;
    }
    //닉네임이 같은 유저 저장
    public static List<Integer> saveSameUser(List<String> name) {
        List<Integer> userMemo_list = new ArrayList<>();

        for (int i = 0; i < name.size() - 1; i++) {
            for (int j = i + 1; j < name.size(); j++) {
                if (findSameUser(name.get(i), name.get(j))) {
                    userMemo_list.add(i);
                    userMemo_list.add(j);
                }
            }
        }

        return userMemo_list;
    }
    public static boolean checkSameUser(int first, int second) {
        return first == second;
    }
    public static boolean findSameUser(String first, String second) {
        for (int i = 0; i < first.length() - 1; i++) {
            for (int j = 0; j < second.length() - 1; j++) {
                if (checkSameUser(first.charAt(i), second.charAt(j))) {
                    if (checkSameUser(first.charAt(i + 1), second.charAt(j + 1)))
                        return true;
                    if (!checkSameUser(first.charAt(i + 1), second.charAt(j + 1)))
                        break;
                }
            }
        }
        return false;
    }

    /*
    예외 처리
     */
    public static void checkException(List<List<String>> forms) {
        if (!(forms.size() >= User.min.info && forms.size() <= User.max.info))
            throw new IllegalArgumentException("ERROR");
            for (List<String> form : forms) {
                if (!(checkEmail(form.get(User.email.info))))
                    throw new IllegalArgumentException("ERROR");
            if (!(checkName(form.get(User.name.info))))
                throw new IllegalArgumentException("ERROR");
        }
    }
    public static boolean checkEmail(String email) {
        String [] emailAddress = email.split("@");

        if (email.length() >= 11 && email.length() < 20)
            return true;
        return emailAddress[User.address.info].equals("email.com");
    }
    public static boolean checkName(String name) {
        if (name.length() >= 1 && name.length() < 20)
            return true;
        return Pattern.matches("^[가-힣]*$", name);
    }
}
