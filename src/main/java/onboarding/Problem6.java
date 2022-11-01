package onboarding;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> ans = new ArrayList<>();
        Hashtable<String, Integer> ht = new Hashtable<>();
        String s, subs;
        int len, count;
        for(List<String> f : forms) {
            s = f.get(1);
            len = s.length();
            if(len < 2) continue;
            for(int i = 0; i < len - 1; i++) {
                subs = s.substring(i, i + 2);
                count = ht.containsKey(subs) ? ht.get(subs) : 0;
                ht.put(subs, count + 1);
            }
        }
        for(List<String> f : forms) {
            s = f.get(1);
            len = s.length();
            for(int i = 0; i < len - 1; i++) {
                subs = s.substring(i, i + 2);
                count = ht.get(subs);
                if(count >= 2) {
                    ans.add(f.get(0));
                    break;
                }
            }
        }
        Collections.sort(ans);

        List<String> answer = new ArrayList<>();
        int asz = ans.size();
        answer.add(ans.get(0));
        for(int i = 1; i < asz; i++) {
            if(ans.get(i).equals(ans.get(i-1))) continue;
            else answer.add(ans.get(i));
        }
        return answer;
    }
}