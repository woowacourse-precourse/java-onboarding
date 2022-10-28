package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {
    private static Map<String,String> nickEmailMapper = new HashMap<>();
    private static final int EMAIL=0;
    private static final int NICKNAME=1;

    public static List<String> solution(List<List<String>> forms) {
        initNickEmailMapper(forms);

        return new ArrayList<>();
    }

    private static void initNickEmailMapper(List<List<String>> forms) {
        nickEmailMapper.clear();
        for (List<String> user : forms) {
            nickEmailMapper.put(user.get(NICKNAME),user.get(EMAIL));
        }
    }
}
