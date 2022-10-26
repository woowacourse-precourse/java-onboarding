package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        HashMap<String, String> map = new HashMap<>();
        HashMap<String, Integer> nick = new HashMap<>();

        for (int i = 0; i < forms.size(); i++) {
            map.put(forms.get(i).get(1), forms.get(i).get(0));
            for (int j = 0; j < forms.get(i).get(1).length() - 1; j++) {
                String tmp = forms.get(i).get(1).substring(j, j + 2);
                nick.put(tmp, nick.getOrDefault(tmp, 0) + 1);
            }
        }

        for (int i = 0; i < forms.size(); i++) {
            String name = forms.get(i).get(1);
            for (int j = 0; j < name.length() - 1; j++) {
                if (nick.get(name.substring(j, j + 2)) - 1 > 1) {
                    answer.add(map.get(name));
                    break;
                }
            }
        }

        Collections.sort(answer);
        return answer;
    }
}
//List<String> tmp1 = new ArrayList<>();
//        List<List<String>> forms = new ArrayList<>();
//
//        tmp1.add("jm@email.com");
//        tmp1.add("제이엠");
//        forms.add(tmp1);
//
//        List<String> tmp2 = new ArrayList<>();
//        tmp2.add("jason@email.com");
//        tmp2.add("제이슨");
//        forms.add(tmp2);
//
//        List<String> tmp3 = new ArrayList<>();
//        tmp3.add("woniee@email.com");
//        tmp3.add("워니");
//        forms.add(tmp3);
//
//        List<String> tmp4 = new ArrayList<>();
//        tmp4.add("mj@email.com");
//        tmp4.add("엠제이");
//        forms.add(tmp4);
//
//        List<String> tmp5 = new ArrayList<>();
//        tmp5.add("nowm@email.com");
//        tmp5.add("이제엠");
//        forms.add(tmp5);