package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        return continuous(forms);
    }

    public static List<String> continuous(List<List<String>> forms) {
        List<String> result = new ArrayList<>();
        Hashtable<String, Integer> ht = new Hashtable<>();
        String nickname, split;
        int count;

        for(List<String> form : forms) {
            nickname = form.get(1);
            if(nickname.length() < 2) continue;
            for(int i = 0; i < nickname.length() - 1; i++) {
                split = nickname.substring(i, i + 2);
                count = ht.containsKey(split) ? ht.get(split) : 0;
                ht.put(split, count + 1);
            }
        }
        // 2회 이상 중복인 닉네임을 result에 추가
        for(List<String> form : forms) {
            nickname = form.get(1);
            for(int i = 0; i < nickname.length() - 1; i++) {
                split = nickname.substring(i, i + 2);
                count = ht.get(split);
                if(count >= 2) {
                    result.add(form.get(0));
                    break;
                }
            }
        }
        Collections.sort(result);
        return result;
    }
}
