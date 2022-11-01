package onboarding;

import java.util.*;

public class Problem6 {
    // list for store forms
    private static List<List<String>> storage = new ArrayList<>();
    // list for store similar index
    private static List<Integer> idx = new ArrayList<>();
    // func : compare with prior nicknames, return Boolean
    private static Boolean isSimilar(String nick1, String nick2) {
        int firstLen = nick1.length();
        int secondLen = nick2.length();
        if (firstLen == 1 || secondLen == 1)
            return false;

        for(int i=0;i<firstLen-1;i++){
            String check = nick1.substring(i,i+2);
            if (nick2.contains(check))
                return true;
        }
        return false;
    }
    // func : found similar nicknames, return List<String> email
    private static List<String> check(List<List<String>> forms){
        List<String> res = new ArrayList<>();
        int formLen = forms.size();
        for (int i=0;i<formLen-1;i++){
            for (int j=i+1;j<formLen;j++){
                String first = forms.get(i).get(1);
                String second = forms.get(j).get(1);

                if (isSimilar(first,second)){
                    idx.add(i);
                    idx.add(j);
                }
            }
        }
        // for delete duplicated data
        Set<Integer> set = new HashSet<>(idx);
        List<Integer> newIdx = new ArrayList<>(set);

        // store result in res
        for (int i=0;i<newIdx.size();i++){
            res.add(forms.get(newIdx.get(i)).get(0));
        }
        Collections.sort(res);
        return res;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = check(forms);
        return answer;
    }
}
