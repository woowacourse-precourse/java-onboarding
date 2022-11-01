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
            curIndex = getIndex(crew, i, curIndex);

            for(int j = 0;j<crew.size();j++){
                int compareIndex = 0;
                compareIndex = getIndex(crew, j, compareIndex);

                if (isCurIndexSameAsCompareIndex(curIndex, compareIndex)) continue;

                checkSameWords(forms, answer, crew, sliceStr, j, compareIndex);
            }
        }
        ArrayList<String> delOverlapAnswer = getDelOverlapAnswer(answer);

        return delOverlapAnswer;
    }

    private static ArrayList<String> getDelOverlapAnswer(List<String> answer) {
        HashSet<String> delOverlapHashSet = new HashSet<>(answer);
        ArrayList<String> delOverlapAnswer = new ArrayList<>(delOverlapHashSet);
        return delOverlapAnswer;
    }

    private static void checkSameWords(List<List<String>> forms, List<String> answer, List<Map<String, Integer>> crew, String sliceStr, int j, int compareIndex) {
        for (String key : crew.get(j).keySet()) {
            if(sliceStr.equals(key)){
                answer.add(forms.get(compareIndex).get(0));
            }
        }
    }

    private static boolean isCurIndexSameAsCompareIndex(int curIndex, int compareIndex) {
        if(curIndex == compareIndex){
            return true;
        }
        return false;
    }

    private static int getIndex(List<Map<String, Integer>> crew, int i, int curIndex) {
        for (Integer value : crew.get(i).values()) {
            curIndex = value;
            break;
        }
        return curIndex;
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
