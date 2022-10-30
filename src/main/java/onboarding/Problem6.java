package onboarding;

import java.sql.Array;
import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<Map<String,Integer>> crew = new ArrayList<>();
        
        int index = 0;
        for (List<String> info : forms) {
            sliceName(crew, index, info);
            index++;
        }

        for(int i = 0;i<crew.size();i++){
            String sliceStr = "";
            int curIndex = 0;
            sliceStr = getSliceStr(crew, i, sliceStr);
        }

        return answer;
    }

    private static String getSliceStr(List<Map<String, Integer>> crew, int i, String sliceStr) {
        for (String key : crew.get(i).keySet()) {
            sliceStr = key;
            break;
        }
        return sliceStr;
    }

    private static void sliceName(List<Map<String, Integer>> crew, int index, List<String> info) {
        for(int i = 0; i< info.get(1).length() - 1; i++){
            Map<String,Integer> map = new HashMap<>();
            map.put(info.get(1).substring(i, i + 2), index);
            crew.add(map);
        }
    }
}
