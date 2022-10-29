package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        checkException(forms);
        answer = findEmail(saveSameUser(savaUser(forms)), forms);

        return answer;
    }

    //해당 닉네임의 이메일을 알아내는 함수
    public static List<String> findEmail(List<Integer> user_list, List<List<String>> forms) {
        int email = 0;
        List<String> email_list = new ArrayList<>();

        for (int i = 0; i < user_list.size(); i++)
        {
            if (user_list.contains(forms.get(user_list.get(i)).get(email)))
                continue;
            email_list.add(forms.get(user_list.get(i)).get(email));
        }

        Collections.sort(email_list);

        return email_list;
    }
    //중복 닉네임 찾기
    //char형으로 비교하면 값이 안같아도 조건문을 넘어감..
    public static boolean findSameUser(String first, String second) {
        int firstName;
        int secondName;

        for (int i = 0; i < first.length() - 1; i++) {
            for (int j = 0; j < second.length() - 1; j++) {
                firstName = first.charAt(i);
                secondName = second.charAt(j);

                if (firstName == secondName) {
                    firstName = first.charAt(i + 1);
                    secondName = second.charAt(j + 1);

                    if (firstName == secondName)
                        return true;
                }
            }
        }
        return false;
    }

    public static boolean isSameUser(List<Integer> user_list, int value) {
        for (int i = 0; i < user_list.size(); i++) {
            if (user_list.get(i) == value)
                return false;
        }

        return true;
    }

    public static List<String> savaUser(List<List<String>> forms) {
        int name = 1;

        List<String> user_list = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++)
            user_list.add(forms.get(i).get(name));

        return user_list;
    }
    //닉네임이 같은 유저 저장
    public static List<Integer> saveSameUser(List<String> name) {
        List<Integer> userMemo_list = new ArrayList<>();

        for (int i = 0; i < name.size() - 1; i++) {
            for (int j = i + 1; j < name.size(); j++) {
                if (findSameUser(name.get(i), name.get(j))) {
                    //userMemo 중복 처리하기
                    if (isSameUser(userMemo_list,i))
                        userMemo_list.add(i);
                    if (isSameUser(userMemo_list, j))
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
        for (int i = 0; i < forms.size(); i++) {
            if (!(checkEmail(forms.get(i).get(email))))
                throw new IllegalArgumentException("이메일 형식에 맞지 않습니다.");
            if (!(checkName(forms.get(i).get(name))))
                throw new IllegalArgumentException("닉네임 형식에 맞지 않습니다");
        }
    }
    public static boolean checkEmail(String email) {
        int address = 1;
        int user = 0;

        String [] emailAddress = email.split("@");

        if (email.length() >= 11 && email.length() < 20)
            return true;
        if (emailAddress[address].equals("email.com"))
            return true;

        return false;
    }
    public static boolean checkName(String name) {
        if (name.length() >= 1 && name.length() < 20)
            return true;
        if (Pattern.matches("^[가-힣]*$", name))
            return true;
        return false;
    }
}
