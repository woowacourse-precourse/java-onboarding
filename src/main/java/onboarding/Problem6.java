package onboarding;

import java.util.*;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer;
        Map<String, String> map = new TreeMap<>();
        Set<String> emailSet = new HashSet<>();

        //for-each문을 사용하여 forms의 List<String> 요소를 findDuplicatedName 메서드로 전달
        for (List<String> form : forms) {
            findDuplicatedName(form, map, emailSet);
        }

        answer = new ArrayList<>(emailSet);

        Collections.sort(answer);

        return answer;
    }

    //중복되는 이름을 찾는다
    public static void findDuplicatedName(List<String> form, Map<String, String> map, Set<String> emails) {
        String email = form.get(0);
        String name = form.get(1);
        int nameLen = name.length();

        for (int i = 0; i < nameLen - 1; i++) {
            String subName = name.substring(i, i + 2);
            if (map.containsKey(subName)) {
                //중복된 이메일을 넣어야 하기 때문에 중복되는 이름이 기존의 map에 존재하면 그 이름의 이메일도 가져와야한다.
                emails.add(map.get(subName));
                emails.add(email);
            } else {
                map.put(subName, email);
            }
        }
    }

}
