package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
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
        Set<String> idSet = new HashSet<>();
        for (List<Integer> value : nickNameIdx.values()) {
            if(value.size()<2)
                continue;
            idSet.addAll(value.stream().map(x->forms.get(x).get(0)).collect(Collectors.toSet()));
        }
        return idSet.stream().sorted().collect(Collectors.toList());
    }
}
