package onboarding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {
    public static Map<String, String> makeHashMap(List<List<String>> forms) {
        Map<String, String> hash = new HashMap<>();
        for(int i = 0; i < forms.size(); i++) {
            List<String> data = forms.get(i);
            hash.put(data.get(1), data.get(0));
        }
        return hash;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        //해시 테이블 생성
        Map<String, String> hash = makeHashMap(forms);



        return answer;
    }
}
