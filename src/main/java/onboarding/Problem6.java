package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {

    static Map<String, Integer> nicknameMap = new HashMap<>();


    public static List<String> nicknameList(String nickname) {

        List<String> list = new ArrayList<>();

        for (int i = 0; i < nickname.length() - 1; ++i) {
            for (int j = i + 2; j <= nickname.length(); ++j) {

                String subStr = nickname.substring(i, j);// ???
                if (!list.contains(subStr)) {
                    list.add(subStr);
                }
            }
        }
        return list;
    }


    public static List<String> solution(List<List<String>> forms) {

        List<String> answer = new ArrayList<>();
        List<List<String>> allNicknameList = new ArrayList<>();

        for (List<String> list : forms) {

            String nickname = list.get(1);
            List<String> nicknameList = nicknameList(nickname);
            allNicknameList.add(nicknameList);
            for (String s : nicknameList) {
                nicknameMap.put(s, nicknameMap.getOrDefault(s, 0) + 1);
            }

        }

        for (int i = 0; i < allNicknameList.size(); ++i) {

            List<String> list = allNicknameList.get(i);
            for (String s : list) {
                int value = nicknameMap.get(s);
                if (value >= 2) {
                    answer.add(forms.get(i).get(0));
                    break;
                }
            }
        }

        Collections.sort(answer);
        return answer;


    }
}
