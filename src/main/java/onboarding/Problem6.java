package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    static int email = 0;
    static int name = 1;

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        System.out.println(forms.get(0).get(0));
        userCheck(savaUser(forms));
        return answer;
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
    public static void userCheck(List<String> nickname)
    {
        List<Integer> userMemo = new ArrayList<>();

        for (int i = 0; i < nickname.size() - 1; i++)
        {
            //한 단어라도 포함되어 있는 경우
            if (nickname.get(i).contains(nickname.get(i + 1)))
            {
                //중복인 경우
                if (isDuplicate(nickname.get(i), nickname.get(i + 1)))
                {
                    userMemo.add(i);
                    userMemo.add(i + 1);
                }
            }
        }
    }

    //연속적으로 닉네임이 포함되어 있는지 확인
    public static boolean isDuplicate(String first, String second)
    {
        int count = 0;

        for (int i = 0; i < first.length(); i++)
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
