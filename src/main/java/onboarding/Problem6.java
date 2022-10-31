package onboarding;

import java.util.ArrayList;
import java.util.List;

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
    }


}