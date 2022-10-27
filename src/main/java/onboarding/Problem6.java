package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, List<Integer>> nickNameIdx = makePartNickNameIdx(forms);
        Set<String> idSet = getOverTwoSizeIdSet(forms, nickNameIdx);
        return idSet.stream().sorted().collect(Collectors.toList());
    }

    private static Set<String> getOverTwoSizeIdSet(List<List<String>> forms, Map<String, List<Integer>> nickNameIdx) {
        Set<String> idSet = new HashSet<>();
        for (List<Integer> value : nickNameIdx.values()) {
            if(value.size()<2)
                continue;
            idSet.addAll(value.stream().map(x-> forms.get(x).get(0)).collect(Collectors.toSet()));
        }
        return idSet;
    }

    private static Map<String, List<Integer>> makePartNickNameIdx(List<List<String>> forms) {
        Map<String,List<Integer>> nickNameIdx = new HashMap<>();
        for (int i = 0; i < forms.size(); i++) {
            List<String> form = forms.get(i);
            String nickName = form.get(1);
            for (int j = 0; j <nickName.length()-1 ; j++) {
                String partNickName = nickName.substring(j,j+2);
                nickNameIdx.putIfAbsent(partNickName,new ArrayList<>());
                nickNameIdx.get(partNickName).add(i);
            }
        }
        return nickNameIdx;
    }
}
