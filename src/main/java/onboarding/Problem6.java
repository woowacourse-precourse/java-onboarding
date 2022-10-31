package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        List<String> duplicateSubStrList = getDuplicateSubStr();
        List<String> hasDuplicateNickNameEmailList =
            generateHasDuplicateNickNameEmailList(duplicateSubStrList);
        Collections.sort(hasDuplicateNickNameEmailList);

        return hasDuplicateNickNameEmailList;
    }

    private static List<String> generateHasDuplicateNickNameEmailList(List<String> duplicateSubStrList) {
        List<String> hasDuplicateNickNameEmailList = Collections.emptyList();
        for (String duplicateSubStr : duplicateSubStrList) {
            hasDuplicateNickNameEmailList = nickNameList.stream().filter(str -> str.contains(duplicateSubStr))
                .map(str -> nickEmailMapper.get(str)).collect(Collectors.toList());
        }
        return hasDuplicateNickNameEmailList;
    }

    private static List<String> getDuplicateSubStr() {
        return continuousSubStrList.stream()
            .filter(str -> Collections.frequency(continuousSubStrList, str) > 1)
            .collect(Collectors.toList());
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
