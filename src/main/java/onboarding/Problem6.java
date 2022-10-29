package onboarding;

import java.util.*;

public class Problem6 {

    private static final int EMAIL=0;
    private static final int NICKNAME=1;

    private static final boolean YES_DUPLICATE=true;
    private static final boolean NO_DUPLICATE=false;

    public static List<String> solution(List<List<String>> forms) {
        Map<String,Integer> nickMap = mapSetting(forms);
        List<Integer> duplicateUserIndex = duplicateIndex(forms, nickMap);
        Set<String> duplicateUserMailSet= mailSetting(forms, duplicateUserIndex);
        List<String> answer =setToList(duplicateUserMailSet);
        return answer;
    }
    private static Map<String, Integer> mapSetting(List<List<String>> forms) {
        Map<String, Integer> nickMap = new HashMap<>();
        for(int i=0;i<forms.size();i++){
            String nowNick = forms.get(i).get(NICKNAME);
            mapAdd(nickMap, nowNick);
        }
        return nickMap;
    }
    private static void mapAdd(Map<String,Integer> nickMap, String nowNick) {
        for(int i=0;i<nowNick.length()-1;i++){
            String tmp = nowNick.substring(i,i+2);
            nickMap.put(tmp,nickMap.getOrDefault(tmp,0)+1);
        }
    }
    private static List<Integer> duplicateIndex(List<List<String>> forms,Map<String, Integer> nickMap) {
        List<Integer> duplicateIndex = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            String nowNick = forms.get(i).get(NICKNAME);
            if (isDuplicate(nowNick, nickMap)) {
                duplicateIndex.add(i);
            }
        }
        return duplicateIndex;
    }
    private static boolean isDuplicate(String now, Map<String, Integer> nickMap){
        for(int i=0;i<now.length()-1;i++){
            String tmp = now.substring(i,i+2);
            if(nickMap.get(tmp)>1)return YES_DUPLICATE;
        }
        return NO_DUPLICATE;
    }
    private static Set<String> mailSetting(List<List<String>> forms, List<Integer> duplicateUserIndex) {
        Set<String> duplicateUserEmail = new TreeSet<>();
        for(int index =0;index<duplicateUserIndex.size();index++){
            duplicateUserEmail.add(forms.get(duplicateUserIndex.get(index)).get(EMAIL));
        }
        return duplicateUserEmail;
    }
    private static List<String> setToList(Set<String> mailSet) {
        List<String> setToList = new ArrayList<>();
        Iterator<String> iterator = mailSet.iterator();
        while(iterator.hasNext())setToList.add(iterator.next());
        return setToList;
    }
}
