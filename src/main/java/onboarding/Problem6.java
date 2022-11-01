package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> checkNickname(List<List<String>> info) {
        List<String> res = new ArrayList<String>();

        for (int i = 0; i < info.size() - 1; i++) {
            String i_name = info.get(i).get(1);
            String i_email = info.get(i).get(0);
            for (int j = i + 1; j < info.size(); j++) {
                int count = 0;
                String j_name = info.get(j).get(1);
                String j_email = info.get(j).get(0);
                while (count <= (i_name.length()) - 2) {
                    String cut_name = i_name.substring(count, count + 2);
                    if (j_name.contains(cut_name) && !res.contains(j_email) && !res.contains(i_email)) {
                        res.add(i_email);
                        res.add(j_email);
                    } else if (j_name.contains(cut_name) && !res.contains(j_email)) {
                        res.add(j_email);
                    }
                    count++;
                }
            }
        }
        return res;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = checkNickname(forms);
        return answer;
    }
}