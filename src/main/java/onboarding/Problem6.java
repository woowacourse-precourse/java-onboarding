package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Problem6 {
    final static int name = 1;
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer;

        checkException(forms);
        answer = findEmail(saveSameUser(saveUser(forms)), forms);

        return answer;
    }

    //해당 닉네임의 이메일을 알아내는 함수
    public static List<String> findEmail(List<Integer> user_list, List<List<String>> forms) {
        int email = 0;
        List<String> email_list = new ArrayList<>();

        for (Integer integer : user_list) {
            String emailTxt = forms.get(integer).get(email);
            if (email_list.contains(emailTxt))
                continue;
            email_list.add(forms.get(integer).get(email));
        }

        Collections.sort(email_list);

        return email_list;
    }
    public static boolean checkSameUser(int first, int second) {
        return first == second;
    }
    //중복 닉네임 찾기
    //char형으로 비교하면 값이 안같아도 조건문을 넘어감..
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
    public static List<String> saveUser(List<List<String>> forms) {
        List<String> user_list = new ArrayList<>();

        for (List<String> form : forms)
            user_list.add(form.get(name));

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

    /*
    예외 처리
     */
    public static void checkException(List<List<String>> forms) {
        int email = 0;
        int name = 1;
        int min = 1;
        int max = 10000;

        if (!(forms.size() >= min && forms.size() <= max))
            throw new IllegalArgumentException("크루 범위를 초과했습니다");
        for (List<String> form : forms) {
            if (!(checkEmail(form.get(email))))
                throw new IllegalArgumentException("이메일 형식에 맞지 않습니다.");
            if (!(checkName(form.get(name))))
                throw new IllegalArgumentException("닉네임 형식에 맞지 않습니다");
        }
    }
    public static boolean checkEmail(String email) {
        int address = 1;

        String [] emailAddress = email.split("@");

        if (email.length() >= 11 && email.length() < 20)
            return true;
        return emailAddress[address].equals("email.com");
    }
    public static boolean checkName(String name) {
        if (name.length() >= 1 && name.length() < 20)
            return true;
        return Pattern.matches("^[가-힣]*$", name);
    }
}
