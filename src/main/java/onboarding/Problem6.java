package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();
        HashSet<String> set = overlapEmail(forms);
        answer = hashSort(set);

        return answer;
    }
    public static HashSet<String> overlapEmail(List<List<String>> form){ // 중복되는 닉네임을 가지는 크루들의 이메일을 저장하는 함수
        HashSet<String> set = new HashSet<String>();
        for(int i = 0; i < form.size(); i++){
            for(int j = 0; j < form.get(i).get(1).length()-1; j++){
                String s = "";
                s += form.get(i).get(1).charAt(j);
                s += form.get(i).get(1).charAt(j+1);
                for(int k = 0; k < form.size(); k++){
                    if(i == k) continue;
                    if(form.get(k).get(1).contains(s)){
                        set.add(form.get(i).get(0));
                    }
                }
            }
        }
        return set;
    }

    public static ArrayList<String> hashSort(HashSet<String> set){ // Set을 받아서 정렬해주는 기능
        ArrayList<String> ret = new ArrayList<String>(set);
        Collections.sort(ret);
        return ret;
    }


}
