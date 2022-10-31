package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        HashMap<String, List<Integer>> checkList = new HashMap<>();
        List<Integer> duplicatedLists = new ArrayList<>();
        for (int f=0;f<forms.size();f++) {

            String name = forms.get(f).get(1);
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < name.length()-1; i++) {
                String substring = name.substring(i, i + 2);
                if (!temp.contains(substring)) {
                    temp.add(substring);
                }
            }
            for (String s : temp) {
                if (!checkList.containsKey(s)) {
                    List<Integer> putList = new ArrayList<>();
                    putList.add(f);
                    checkList.put(s, putList);
                } else {
                    if (checkList.get(s).size() == 1) {
                        duplicatedLists.add(checkList.get(s).get(0));
                        duplicatedLists.add(f);
                        checkList.get(s).add(f);
                    } else {
                        duplicatedLists.add(f);
                        checkList.get(s).add(f);
                    }
                }
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for(Integer item : duplicatedLists){
            set.add(item);
        }
        for (int i=0;i<forms.size();i++) {
            if (set.contains(i)) {
                String email = forms.get(i).get(0);
                answer.add(email);
            }
        }
        Collections.sort(answer);
        return answer;
    }
}
