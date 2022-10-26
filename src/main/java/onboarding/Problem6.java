package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        return answer;
    }

    //닉네임이 같은 유저가 있는지 확인
 

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
