package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    private static void putDuplicateMap(HashMap<String,Integer> duplicateMap,List<String> dividiedNameList ){
        for (String dividedName : dividiedNameList){
            Integer nameCount = duplicateMap.getOrDefault(dividedName,0);
            if (nameCount == 0){
                duplicateMap.put(dividedName,1);
            }
            if (nameCount > 0 ){
                duplicateMap.put(dividedName,nameCount+1);
            }
        }
    }
    private static List<String> getDivideName(String name){
        List<String> divideName = new ArrayList<>();
        for (int nameIndex = 0;nameIndex<name.length()-1;nameIndex++){
            String dividedName = name.substring(nameIndex,nameIndex+2);
            divideName.add(dividedName);
        }
        return divideName;
    }
    private static HashMap<String , Integer> getDuplicatedMap(List<List<String>> forms){
        HashMap<String,Integer> duplicateMap = new HashMap<>();
        for(int formsIndex =0 ; formsIndex<forms.size();formsIndex++){
            String name = forms.get(formsIndex).get(1);
            List<String> dividiedNameList = getDivideName(name);
            putDuplicateMap(duplicateMap,dividiedNameList);
        }

        return duplicateMap;

    }
    private static void putResult(String email , HashMap<String, Integer> duplicateMap ,List<String> dividiedNameList,List<String> getResult){
        for(String divideName: dividiedNameList){
            if(duplicateMap.get(divideName)>1){
                getResult.add(email);
                break;
            }
        }
    }
    private static List<String> getResult(List<List<String>> forms){
        HashMap<String, Integer> duplicateMap = getDuplicatedMap(forms);
        List<String> result = new ArrayList<>();
        for(int formsIndex =0 ; formsIndex<forms.size();formsIndex++){
            String name = forms.get(formsIndex).get(1);
            String email = forms.get(formsIndex).get(0);
            List<String> dividiedNameList = getDivideName(name);
            putResult(email,duplicateMap,dividiedNameList,result);
        }
        Collections.sort(result);
        return result;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        answer = getResult(forms);
        return answer;
    }
}
