package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> set = new HashSet<String>(findSimilarNickName(forms));
        List<String> answer = new ArrayList<String>(set);
        Collections.sort(answer);
        return answer;
    }
    static List<String> findSimilarNickName(List<List<String>> forms){
        List<String> similarList = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            for (int j = i+1; j < forms.size(); j++) {
                if (checkSimilarNickName(forms.get(i).get(1), forms.get(j).get(1))) {
                    similarList.add(forms.get(i).get(0));
                    similarList.add(forms.get(j).get(0));
                    break;
                }
            }
        }
        return similarList;
    }
    static boolean checkSimilarNickName(String name1, String name2) {
        for (int i = 0; i < name1.length() - 1; i++) {
            for (int j = 0; j < name2.length() - 1; j++) {
                if (name1.charAt(i) == name2.charAt(j) && name1.charAt(i+1) == name2.charAt(j+1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
