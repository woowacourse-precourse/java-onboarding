package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Problem6 {
    static int email = 0;
    static int name = 1;
    static int min = 1;
    static int max = 10000;

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        exceptionCheck(forms);
        answer = findEmail(sameUserSave(savaUser(forms)), forms);

        return answer;
    }

    //해당 닉네임의 이메일을 알아내는 함수
    public static List<String> findEmail(List<Integer> userList, List<List<String>> forms)
    {
        List<String> emailList = new ArrayList<>();

        for (int i = 0; i < userList.size(); i++)
            emailList.add(forms.get(userList.get(i)).get(email));

        Collections.sort(emailList);
        return emailList;
    }
    //닉네임만 저장하는 함수
    public static List<String> savaUser(List<List<String>> forms)
    {
        List<String> userList = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++)
            userList.add(forms.get(i).get(name));

        return userList;
    }

    //닉네임이 같은 유저 저징
    public static List<Integer> sameUserSave(List<String> nickname)
    {
        List<Integer> userMemo = new ArrayList<>();

        for (int i = 0; i < nickname.size() - 1; i++)
        {
            for (int j = i + 1; j < nickname.size(); j++)
            {
                if (findSameUser(nickname.get(i), nickname.get(j)))
                {
                    userMemo.add(i);
                    userMemo.add(j);
                }
            }
        }
        return userMemo;
    }

    public static boolean findSameUser(String first, String second)
    {
        for (int i = 0; i < first.length() - 1; i++)
        {
            for (int j = 0; j < second.length(); j++)
            {
                if (first.charAt(i) == second.charAt(j))
                {
                    //마지막 글자일 경우
                    if (j == second.length() - 1)
                        return false;
                    if (first.charAt(i + 1) == second.charAt(j + 1));
                        return true;
                }
            }
        }

        return false;
    }


    //연속적으로 닉네임이 포함되어 있는지 확인
    public static boolean isDuplicate(String first, String second)
    {
        int count = 0;
        int length = 0;

        length = Math.min(first.length(), second.length());
        for (int i = 0; i < length; i++)
        {
            if (first.charAt(i) == second.charAt(i))
            {
                count++;
                if (count >= 2)
                    return true;
            }
        }
        return false;
    }

    //이메일 형식에 부합하는지 체크
    public static boolean emailCheck(String email)
    {
        int address = 1;
        int user = 0;

        String [] emailAddress = email.split("@");

        if (email.length() >= 11 && email.length() < 20)
            return true;
        if (emailAddress[address].equals("email.com"))
            return true;

        return false;
    }

    //닉네임 형식에 부합하는지 체크
    public static boolean nicknameCheck(String name)
    {
        if (name.length() >= 1 && name.length() < 20)
            return true;
        if (Pattern.matches("^[가-힣]*$", name))
            return true;
        return false;
    }

    public static void exceptionCheck(List<List<String>> forms)
    {
        if (!(forms.size() >= min && forms.size() <= max))
            throw new IllegalArgumentException("크루 범위를 초과했습니다");
        for (int i = 0; i < forms.size(); i++)
        {
            if (!(emailCheck(forms.get(i).get(email))))
                throw new IllegalArgumentException("이메일 형식에 맞지 않습니다.");
            if (!(nicknameCheck(forms.get(i).get(name))))
                throw new IllegalArgumentException("닉네임 형식에 맞지 않습니다");
        }
    }
}
