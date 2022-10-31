package onboarding;

import java.util.*;

public class Problem6 {

    static Map<String, Set<Integer>> mymap = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {
        return pro(forms);
    }

    static List<String> pro(List<List<String>> forms) {
        List<String> answer;

        for(int i = 0; i < forms.size(); i++) {
            addTwoLetters(forms.get(i).get(1), i);
        }

        answer = getEmailList(forms);

        Collections.sort(answer);

        return answer;
    }

    static List<String> getEmailList(List<List<String>> forms) {
        Set<Integer> indexSet = new HashSet<>();
        for(Set<Integer> set : mymap.values()) {
            if(set.size() > 1) {
                indexSet.addAll(set);
            }
        }

        ArrayList<String> emailList = new ArrayList<>();
        for(int idx : indexSet) {
            emailList.add(forms.get(idx).get(0));
        }
        return emailList;
    }

    static void addTwoLetters(String nickname, int idx) {
        for(int i = 0; i < nickname.length() - 1; i++) {
            String s = nickname.substring(i, i + 2);
            add(s, idx);
        }
    }


    static void add(String letters, int idx) {
        if(!mymap.containsKey(letters)) {
            mymap.put(letters, new HashSet<>());
        }
        mymap.get(letters).add(idx);
    }

}
