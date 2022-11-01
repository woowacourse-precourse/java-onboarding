package onboarding;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Problem6 {


    private static HashMap<String, String> list2map(List<List<String>> forms){
        HashMap<String, String> map = new HashMap<String, String>();

        for(List<String> f:forms) { map.put(f.get(1), f.get(0)); }

        return map;
    }

    private static List<String> splitNickname(String nickname){
        List<String> splitedList = new ArrayList<>();

        int len = nickname.length();
        for(int i=0;i<len-1;i++) splitedList.add(nickname.substring(i, i+2));

        return splitedList;
    }

    private static Set<String> findSimilar(List<String> names, String nickname){
        Set<String> checked = new HashSet<String>();

        List<String> splitedList = splitNickname(nickname);
        for(String name:names){
            for(String s:splitedList){
                if(name.contains(s) && !name.equals(nickname)){
                    checked.add(name);
                    break;
                }
            }
        }

        if(checked.size()>0) checked.add(nickname);

        return checked;
    }

    private static List<String> getEmailList(HashMap<String, String> forms, List<String> checked){
        List<String> emailList = new ArrayList<>();

        checked.forEach(name -> emailList.add(forms.get(name)));
        return emailList;
    }

    public static List<String> solution(List<List<String>> forms) {

        HashMap<String, String> mapForms = list2map(forms);
        List<String> nameList = new ArrayList<>(mapForms.keySet());

        Set<String> checked = new HashSet<String>();

        for(String name:nameList){
            checked.addAll(findSimilar(nameList, name));
        }

        List<String> colelctedName = new ArrayList<>(checked);

        List<String> emailList = getEmailList(mapForms, colelctedName);
        Collections.sort(emailList);

        List<String> answer = emailList;

        return answer;
    }
}
