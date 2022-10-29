package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {
        List<String> strList = new ArrayList<>(Arrays.asList(cryptogram.split("")));
        String answer = "answer";
        while (true) {
            List<Integer> delete_index = new ArrayList<Integer>();

            for (int ind = 0; ind < strList.size()-1; ind++) {
                if (strList.get(ind).equals(strList.get(ind+1))) {
                    delete_index.add(ind);
                    delete_index.add(ind+1);
                    int tmp_index = ind+1;
                    while (tmp_index < strList.size() && strList.get(ind).equals(strList.get(tmp_index))) {
                        tmp_index ++;
                    }

                }
            }
            if (delete_index.size() == 0) {
                break;
            }
            for (int ind = delete_index.size()-1; ind >= 0; ind--) {
                strList.remove((int)delete_index.get(ind));
            }
        }
        answer = String.join("", strList);
        return answer;
    }
}
