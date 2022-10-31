package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> set = new HashSet<>();
        HashMap<String, String> map = new HashMap<>();

        for(int i = 0; i < forms.size(); i++){
            String[] nameArr = makeNameArr(forms.get(i).get(1));

            for(String name : nameArr) {
                for(String checkName : map.keySet()){
                    if(name.equals(checkName)){
                        set.add(map.get(checkName));
                        set.add(forms.get(i).get(0));
                    }
                }
                map.put(name, forms.get(i).get(0));
            }
        }
        List<String> answer = new ArrayList<>(set);
        Collections.sort(answer);

        return answer;
    }

    static String[] makeNameArr(String name){
        String[] result = new String[name.length() - 1];
        char[] nameArr = name.toCharArray();

        for(int i = 0; i < nameArr.length - 1; i++) {
            result[i] = "" + nameArr[i] + nameArr[i + 1];
        }
        return result;
    }
}
