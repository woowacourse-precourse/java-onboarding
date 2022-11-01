package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        String s;
        String ss;
        List<String> arr = new ArrayList<>();
        List<String> a = new ArrayList<>();
        char[] c = new char[3];
        HashMap<String, Integer> m = new HashMap<>();
        TreeMap<String, String> map = new TreeMap<String, String>();
        for(int i = 0; i < forms.size(); i++) {
            map.put(forms.get(i).get(0), forms.get(i).get(1));
            for(int j = 0; j < forms.get(i).get(1).length() - 1; j++) {
                c[0] = forms.get(i).get(1).charAt(j);
                c[1] = forms.get(i).get(1).charAt(j+1);
                s = String.valueOf(c);
                a.add(s);
            }
            for(String st : a) {
                if (m.containsKey(st)) {
                    m.replace(st, 2);
                } else {
                    m.put(st, 1);
                }
            }
            a.clear();
        }

        for(String i : map.keySet()){ //저장된 key값 확인
            ss = map.get(i);
            for(int j = 0; j < ss.length() - 1; j++) {
                c[0] = ss.charAt(j);
                c[1] = ss.charAt(j+1);
                s = String.valueOf(c);
                if(m.containsKey(s)) {
                    if(m.get(s) == 2) {
                        answer.add(i);
                        break;
                    }
                }

            }
        }
        return answer;
    }

}
