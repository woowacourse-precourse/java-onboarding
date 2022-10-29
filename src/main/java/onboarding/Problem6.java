package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        Map<String, String> studentMap = new HashMap<>();
        List<String> nicknameList = new ArrayList<>();

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);
            studentMap.put(nickname, email);

            boolean isAdd = false;
            for(String name : nicknameList) {
                if(isAdd) {
                    break;
                }

                for(int i = 0; i < nickname.length() - 1; i++) {
                    if(name.contains(nickname.substring(i, i+2))) {
                        answer.add(studentMap.get(nickname));
                        if(!answer.contains(studentMap.get(name))) {
                            answer.add(studentMap.get(name));
                        }
                        isAdd = true;
                        break;
                    }
                }
            }
            nicknameList.add(nickname);
        }
        answer.sort(Comparator.naturalOrder());

        return answer;
    }
}
