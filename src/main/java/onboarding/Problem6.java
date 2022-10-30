package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashMap<String, Integer> count = new HashMap<String, Integer>();
        int[] duplicated = new int[forms.size()];
        List<String> ans = new ArrayList<String>();

        for(int i = 0; i<forms.size(); i++){
            String nickname = forms.get(i).get(1);
            for(int j = 0; j<nickname.length()-1; j++){
                String key = nickname.substring(j, j+2);

                if (count.containsKey(key)){
                    count.put(key, count.get(key) + 1);
                    duplicated[i] = 1;
                    break;
                }
                else {
                    count.put(key, 1);
                }
            }
        }

        String nickname = forms.get(0).get(1);
        for(int i = 0; i<nickname.length()-1; i++){
            String key = nickname.substring(i, i+2);
            if (count.containsKey(key)){
                duplicated[i] = 1;
                break;
            }
        }

        for(int i = 0; i<forms.size(); i++){
            if (duplicated[i] == 1) ans.add(forms.get(i).get(0));
        }

        Collections.sort(ans, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String o1_sub = o1.substring(0, o1.length()-10);
                String o2_sub = o2.substring(0, o2.length()-10);

                return o1.compareTo(o2);
            }
        });

        return ans;
    }
}
