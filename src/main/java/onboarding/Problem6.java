package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Problem6 {

    public static int stringChecker(String string1, String string2) {

        int idx = 0;
        int cnt = 0;
        int maxIdx = Math.min(string1.length(), string2.length());

        for (int i = 0; i < maxIdx; i++) {
            for (int j = 0; j < maxIdx; j++) {
                if (string1.charAt(i) == string2.charAt(j)) {
                    while (j + idx < maxIdx && string1.charAt(i + idx) == string2.charAt(j + idx)) {
                        idx++;
                        cnt++;
                    }
                    return cnt;
                }
            }
        }
        return cnt;
    }

    public static void nicknameSearch(int start,int depth,int depthLimit,List<List<String>> forms,List<String> duplicateEmail) {
        if (depth==depthLimit-1) {
            return;
        } else {
            for (int i=start+1; i<depthLimit; i++) {
                int cnt=stringChecker(forms.get(start).get(1),forms.get(i).get(1));
                if (cnt>=2) {
                    duplicateEmail.add(forms.get(start).get(0));
                    duplicateEmail.add(forms.get(i).get(0));
                }
            }
        }
        nicknameSearch(start+1,depth+1,forms.size(),forms,duplicateEmail);
    }

    public static List<String> duplication(List<String> arr) {
        List<String> afterDuplication = new ArrayList<String>();
        for (int i=0; i<arr.size(); i++) {
            if (!afterDuplication.contains(arr.get(i))) {
                afterDuplication.add(arr.get(i));
            }
        }
        return afterDuplication;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> duplicateEmail = new ArrayList<String>();
        nicknameSearch(0,0,forms.size(),forms,duplicateEmail);
        List<String> answer = duplication(duplicateEmail);
        Collections.sort(answer);
        return answer;
    }


}