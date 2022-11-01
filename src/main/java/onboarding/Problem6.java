package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Problem6 {
    private static List<String> GetPossibleExample(String nickname){
        List<String> ret_variable = new ArrayList<>();

        for (int i = 0; i < nickname.length() - 1; i++){
            String truncated = nickname.substring(i, i+2);
            ret_variable.add(truncated);
        }
        return ret_variable;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        for (List<String> obj:forms) {
            List<String> truncates = GetPossibleExample(obj.get(1));

            for (List<String> otherobj:forms) {
                if (obj.get(0) == otherobj.get(0))// 다른사람과만 검사하기
                    continue;

                for (String  mytruncated : truncates){// 닉네임 조합을 포함하는 닉네임 찾기
                    if (otherobj.get(1).contains(mytruncated))
                        answer.add(otherobj.get(0));
                }
            }
        }
        Set<String> duplicateDelete = new TreeSet<>(answer);
        return new ArrayList<>(duplicateDelete);
    }
}
