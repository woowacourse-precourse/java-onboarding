package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem6 {
    public static boolean compStr(String str1, String str2) {
        for(int i = 0; i<str1.length()-1; i++) {
            if(str2.contains(str1.substring(i, i+2))) {
                return true;
            }
        }
        return false;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answerTmp = new ArrayList<>();

        int len = forms.size();
        int arr[] = new int[len];
        for(int i = 0; i < len; i++) {
            arr[i] = 0;
        }
        for(int i = 0; i< len; i++) {
            if(arr[i] == 1) {
                continue;
            }
            for(int j = i + 1; j<len; j++) {
                if(arr[j] == 1) {
                    continue;
                }
                if(compStr(forms.get(i).get(1), forms.get(j).get(1) )) {
                    arr[i] = 1;
                    arr[j] = 1;
                }
            }
        }

        for(int i = 0; i<len; i++) {
            if(arr[i] == 1) {
                answerTmp.add(forms.get(i).get(0));
            }
        }

        answerTmp.sort(Comparator.naturalOrder());

        List<String> answer = answerTmp;
        return answer;
    }
}
