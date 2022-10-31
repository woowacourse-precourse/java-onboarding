package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem6 {
    public static Map<Integer, String> userMap;
    public static Map<String, Integer> subStrIndexMap;
    public static List<Integer> duplicatedIndex;


    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        for(int index = 0; index<forms.size(); index++){
            String userNickName = forms.get(index).get(1);
        }
        return answer;
    }

    public static void initUserMap(List<List<String>> forms){
        for(int index = 0; index<forms.size(); index++){
            userMap.put(index, forms.get(index).get(0));
        }
    }

    public static void initSubStrIndexMap(){
        subStrIndexMap = new HashMap<>();
    }

    public static void initDuplicatedIndex(){
        duplicatedIndex = new ArrayList<>();
    }

    public static void findDuplicated(int index, String nickname){
        for(int i=0; i<nickname.length() -1; i++){
            String subStr = nickname.substring(i, i+2);
            if(subStrIndexMap.containsKey(subStr)){
                duplicatedIndex.add(index);
                duplicatedIndex.add(subStrIndexMap.get(subStr));
            }
            else{
                subStrIndexMap.put(subStr, index);
            }
        }
    }

    public static List<Integer> getDistinctIndexList(){
        return duplicatedIndex.stream().distinct().collect(Collectors.toList());
    }



}
