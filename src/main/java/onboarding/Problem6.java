package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    static int email = 0;
    static int name = 1;

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        System.out.println(forms.get(email).get(1));
        answer = findEmail(userCheck(savaUser(forms)), forms);

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
    //닉네임이 같은 유저가 있는지 확인
    public static List<Integer> userCheck(List<String> nickname)
    {
        List<Integer> userMemo = new ArrayList<>();

        for (int i = 0; i < nickname.size() - 1; i++)
        {
            for (int j = i + 1; j < nickname.size(); j++)
            {
                if (isDuplicate(nickname.get(i), nickname.get(j)))
                {
                    userMemo.add(i);
                    userMemo.add(j);
                }
            }
        }

        System.out.println(userMemo);

        return userMemo;
    }

    //연속적으로 닉네임이 포함되어 있는지 확인
    public static boolean isDuplicate(String first, String second)
    {
        int count = 0;
        int length = 0;
        System.out.println(first + " " + second);

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
}
