package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();
        List<String> istring1 = forms.get(0); //초기화
        List<String> istring2 = forms.get(0); //초기화
        String jstring1, jstring2;
        int cnt = 0;
        int a = 0, b = 0;

        for (int i = 0; i < forms.size() - 1; i++) {
            istring1 = forms.get(i);
            cnt = 0;

            for (int j = i + 1; j < forms.size(); j++) {
                a = 0;
                b = 0;
                istring2 = forms.get(j);
                jstring1 = istring1.get(1).toString();
                jstring2 = istring2.get(1).toString();
                String[] num1 = jstring1.split("");
                String[] num2 = jstring2.split("");

                while (a < jstring1.length() && b < jstring2.length()) {

                    if (num1[a].equals(num2[b])) {
                        //System.out.println("\"" + num1[a] + "\"가 같다");
                        cnt++;
                        a++;
                        if (cnt == 2) {
                            answer.add(istring1.get(0));
                            answer.add(istring2.get(0));
                        }
                    }
                    b++;
                }
            }
        }

        // List를 Set으로 변경
        Set<String> set = new HashSet<String>(answer);
        // Set을 List로 변경
        answer = new ArrayList<String>(set);

        Collections.sort(answer);

        return answer;
    }
}