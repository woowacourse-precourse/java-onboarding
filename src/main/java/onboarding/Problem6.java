package onboarding;

import java.util.*;

public class Problem6 {

    private static final int EMAIL=0;
    private static final int NICKNAME=1;

    public static List<String> solution(List<List<String>> forms) {

        Map<String,Integer> nickMap = new HashMap<>();
        mapSetting(forms, nickMap);
        List<String> answer =List.of("answer");
        return answer;
    }
    private static void mapSetting(List<List<String>> forms, Map<String, Integer> nickMap) {
        for(int i=0;i<forms.size();i++){
            String nowNick = forms.get(i).get(NICKNAME);
            mapAdd(nickMap, nowNick);
        }
    }
    private static void mapAdd(Map<String,Integer> nickMap, String nowNick) {
        for(int i=0;i<nowNick.length()-1;i++){
            String tmp = nowNick.substring(i,i+2);
            nickMap.put(tmp,nickMap.getOrDefault(tmp,0)+1);
        }
    }

}
