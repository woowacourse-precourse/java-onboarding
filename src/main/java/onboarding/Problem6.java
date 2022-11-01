package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> nickName = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        HashSet set = new HashSet();
        List<String> overlap = new ArrayList<>();

        // 닉네임 리스트 추가
        for(int i=0; i<forms.size(); i++) {
            nickName.add(forms.get(i).get(1));
        }

        // 2글자씩 맵에 추가
        for(int i=0; i<nickName.size(); i++) {
            for(int j=0; j<nickName.get(i).length()-1; j++) {
                String key = nickName.get(i).substring(j, j+2);
                map.put(key, map.getOrDefault(key, 0)+1);
            }
        }

        // 중복되는 닉네임 추가
        map.forEach((key, value) -> {
            if(1 < value)
                overlap.add(key);
        });
        
        // 중복 닉네임 이메일 추가
        for (int i=0; i<overlap.size(); i++) {
            for(int j=0; j<forms.size(); j++) {
                if(forms.get(j).get(1).contains(overlap.get(i)))
                    set.add(forms.get(j).get(0));
            }
        }

        // set을 List에 담기
        List<String> answer = new ArrayList<>(set);

        return answer;
    }
}
