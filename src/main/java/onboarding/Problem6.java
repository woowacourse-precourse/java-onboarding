package onboarding;

import java.util.List;
import java.util.HashMap;
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of();
        HashMap<String, String> map = new HashMap<>();
        doMapping(forms,map);

        return List.of("answer");

    }
    /**닉네임을 키로 하여 이메일을 값으로 매핑**/
    private static void doMapping(List<List<String>> forms,HashMap<String,String> map) {
        for (List<String> val : forms) { /*닉네임을 k, 이메일을 v로 저장*/
            map.put(val.get(1), val.get(0));
        }
    }
}
