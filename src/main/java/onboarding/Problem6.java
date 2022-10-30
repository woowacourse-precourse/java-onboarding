package onboarding;

import java.util.*;

public class Problem6 {

    private static final int EMAIL=0;
    private static final int NICKNAME=1;

    private static final boolean YES_DUPLICATE=true;
    private static final boolean NO_DUPLICATE=false;

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = duplicateUserMailList(forms);
        return answer;
    }
    private static Map<String, Integer> mapSetting(List<List<String>> forms) {
        Map<String, Integer> nickMap = new HashMap<>();
        for(int index=0;index<forms.size();index++){
            String nowNick = forms.get(index).get(NICKNAME);
            mapAdd(nickMap, nowNick);
        }
        return nickMap;
    }
    private static void mapAdd(Map<String,Integer> nickMap, String nowNick) {
        for(int index=0;index<nowNick.length()-1;index++){
            String tmp = nowNick.substring(index,index+2);
            nickMap.put(tmp,nickMap.getOrDefault(tmp,0)+1);
        }
    }
    private static List<Integer> duplicateIndex(List<List<String>> forms) {
        Map<String, Integer> nickMap = mapSetting(forms);
        List<Integer> duplicateIndex = new ArrayList<>();
        for (int index = 0; index < forms.size(); index++) {
            String nowNick = forms.get(index).get(NICKNAME);
            if (isDuplicate(nowNick, nickMap)) {
                duplicateIndex.add(index);
            }
        }
        return duplicateIndex;
    }
    private static boolean isDuplicate(String now, Map<String, Integer> nickMap){
        for(int index=0;index<now.length()-1;index++){
            String tmp = now.substring(index,index+2);
            if(nickMap.get(tmp)>1)return YES_DUPLICATE;
        }
        return NO_DUPLICATE;
    }
    private static Set<String> duplicateUserMail(List<List<String>> forms, List<Integer> duplicateUserIndex) {
        Set<String> duplicateUserEmail = new TreeSet<>();
        for(int index =0;index<duplicateUserIndex.size();index++){
            duplicateUserEmail.add(forms.get(duplicateUserIndex.get(index)).get(EMAIL));
        }
        return duplicateUserEmail;
    }
    private static List<String> duplicateUserMailList(List<List<String>> forms) {
        Set<String> duplicateUserMailSet = duplicateUserMail(forms, duplicateIndex(forms));
        List<String> setToList = new ArrayList<>();
        Iterator<String> iterator = duplicateUserMailSet.iterator();
        while(iterator.hasNext())setToList.add(iterator.next());
        return setToList;
    }
}
