package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        ArrayList<String> answer2 = new ArrayList<>();;

        int count = 0;

        int size = forms.size();
        String strName;
        String strName2;
        String strEmail;
        String strEmail2;

        for (int i = 0; i < size-1; i++) {
            for (int j = i+1; j < size; j++) {

                strName = forms.get(i).get(1).toString();
                strEmail = forms.get(i).get(0).toString();
                strName2 = forms.get(j).get(1).toString();
                strEmail2 = forms.get(j).get(0).toString();

                char[] sss = strName.toCharArray();
                char[] sss2 = strName2.toCharArray();

                for (int a = 0; a < sss.length; a++) {
                    count = 0;
                    for (int b = 0; b < sss2.length; b++) {
                        if (count == 1) {
                            a = a + 1;
                        }
                        if (a == sss.length || b == sss2.length) {
                            break;
                        }
                        if (sss[a] == sss2[b] && count == 2) {
                            a = a -1;
                            break;
                        }
                        if (sss[a] == sss2[b]) {
                            count++;
                            if(count ==2) {
                                answer2.add(strEmail);
                                answer2.add(strEmail2);
                                break;
                            }
                        }

                        if (sss[a] != sss2[b]) {
                            count--;
                            if(count<0) {
                                count++;
                            }
                        }

                    }

                }

            }
        }
        ArrayList<String> answer = new ArrayList<>();
        for(String data : answer2) {
            if(!answer.contains(data))
                answer.add(data);
        }
        Collections.sort(answer);
        return answer;
    }
}
