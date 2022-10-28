package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {
    private static Map<String,String> nickEmailMapper = new HashMap<>();
    private static List<String> nickNameList = new ArrayList<>();
    private static List<String> continuousSubStrList = new ArrayList<>();
    private static final int EMAIL=0;
    private static final int NICKNAME=1;

    public static List<String> solution(List<List<String>> forms) {
        initNickEmailMapper(forms);
        initNickNameList(forms);
        generateContinuousSubStrList();

        return Collections.emptyList();
    }

    private static void generateContinuousSubStrList() {
        for (String nickName : nickNameList) {
            for(int i = 0; i < nickName.length()-1; i++){
                String continuousStr = nickName.substring(i, i + 2);
                continuousSubStrList.add(continuousStr);
            }
        }
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
