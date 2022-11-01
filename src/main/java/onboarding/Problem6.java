package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> list = new ArrayList<>(List.of());
        for(int i = 0; i < forms.size(); i++){
            String nickname1 = forms.get(i).get(1);
            for(int j = i+1; j < forms.size(); j++){
                String nickname2 = forms.get(j).get(1);
                if(checkDuplicate(nickname1, nickname2)){
                    list.add(forms.get(i).get(0));
                    list.add(forms.get(j).get(0));
                }
            }
        }
        List<String> answer = printEmail(list);
        return answer;
    }

    public static List<String> printEmail(List<String> list) {
        // 중복 제거
        Set<String> set = new HashSet<>(list);
        List<String> answer = new ArrayList<>(set);
        // 오름차순 정렬
        Collections.sort(answer);
        return answer;
    }

    private static boolean checkDuplicate(String n1, String n2) {
        for(int i = 0; i < n1.length(); i++){
            char ch1 = n1.charAt(i);
            for(int j = 0; j < n2.length(); j++){
                char ch2 = n2.charAt(j);
                if(n1.length() > i+1 && n2.length() > j+1){
                    if(ch1 == ch2 && n1.charAt(i+1) == n2.charAt(j+1)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
