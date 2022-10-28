package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {
    private static Map<String,String> nickEmailMapper = new HashMap<>();
    private static List<String> nickNameList = new ArrayList<>();
    private static final int EMAIL=0;
    private static final int NICKNAME=1;

    public static List<String> solution(List<List<String>> forms) {
        initNickEmailMapper(forms);
        initNickNameList(forms);

        return new ArrayList<>();
    }

    private static void initNickNameList(List<List<String>> forms) {
        nickNameList.clear();
        for (List<String> user : forms) {
            nickNameList.add(user.get(NICKNAME));
        }
    }

    private static void initNickEmailMapper(List<List<String>> forms) {
        nickEmailMapper.clear();
        for (List<String> user : forms) {
            nickEmailMapper.put(user.get(NICKNAME),user.get(EMAIL));
        }
    }
}
