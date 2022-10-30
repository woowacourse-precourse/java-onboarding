package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    static HashMap<String, List<String>> map = new HashMap();
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

// 닉네임을 두글자씩 나눠 HashMap에 기록하는 함수 구현("oo", [이메일, 이메일, ... ])
    static List<String> recordNick(String nick, String email) {
        List<String> result = new ArrayList();
        String[] strArr = nick.split("");
        String twoCharOfNick;
        for (int i=0;i<strArr.length-1;i++) {
            twoCharOfNick = String.join("", Arrays.copyOfRange(strArr, i, i+2));
            if (map.containsKey(twoCharOfNick)) {
                if (map.get(twoCharOfNick).size() == 1) {
                    result.add(map.get(twoCharOfNick).get(0));
                }
                map.get(twoCharOfNick).add(email);
                result.add(email);
            } else {
                map.put(twoCharOfNick, new ArrayList<>(Arrays.asList(email)));
            }
        }
        return result;
    }
    public static void main(String args[]) {
        System.out.println(recordNick("제이슨", "jm@email.com"));
        System.out.println(recordNick("엠제이", "mj@email.com"));
        System.out.println(map);
    }
}
