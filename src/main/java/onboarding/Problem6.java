package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> dpRow = new ArrayList<>();


        makeDpRow(forms, dpRow);
        int[][] dp = new int[dpRow.size()][forms.size()];
        int count = 0;
        for (List<String> form : forms) {
            String f = form.get(1);
            for (int i = 0; i < f.length() - 1; i++) {
                String two = f.charAt(i) + String.valueOf(f.charAt(i + 1));
                for (int t = 0; t < dpRow.size(); t++) {
                    if (two.equals(dpRow.get(t))) {
                        dp[t][count] = 1;
                        break;
                    }
                }
            }
            count++;
        }
        Set<Integer> ans = new HashSet<>();
        for (int i = 0; i < dpRow.size(); i++) {
            List<Integer> r = new ArrayList<>();
            for (int t = 0; t < forms.size(); t++) {
                if (dp[i][t] == 1) {
                    r.add(t);
                }
            }
            if (r.size() > 1) {
                for (Integer integer : r) {
                    ans.add(integer);
                }
            }
        }
        for (Integer an : ans) {
            answer.add(forms.get(an).get(0));
        }
        Collections.sort(answer);
        return answer;
    }

    private static void makeDpRow(List<List<String>> forms, List<String> dpRow) {
        for (List<String> form : forms) {
            //제이엠
            String f = form.get(1);
            for (int i = 0; i < f.length() - 1; i++) {
                //제이, 이엠
                String two = f.charAt(i) + String.valueOf(f.charAt(i + 1));
                int col = 0;

                for (; col < dpRow.size(); col++) {
                    if (dpRow.get(col).equals(two)) {
                        break;
                    }
                }
                if (col == dpRow.size()) dpRow.add(two);
            }
        }
    }
}
