package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {
        List<String> strList = new ArrayList<>(Arrays.asList(cryptogram.split("")));
        String answer = "";
        while (true) {
            List<Integer> delete_index = new ArrayList<Integer>();

            addDeleteIndex(strList, delete_index);
            if (delete_index.size() == 0) {
                break;
            }
            deleteDuplicatedElement(strList, delete_index);
        }
        answer = String.join("", strList);
        return answer;
    }
    public static void addDeleteIndex(List<String> strList, List<Integer> delete_index) {
        for (int ind = 0; ind < strList.size()-1; ind++) {
            if (strList.get(ind).equals(strList.get(ind+1))) {
                delete_index.add(ind);
                delete_index.add(ind+1);
                int tmp_index = ind+2;
                while (tmp_index < strList.size() && strList.get(ind).equals(strList.get(tmp_index))) {
                    delete_index.add(tmp_index);
                    tmp_index ++;
                }
                ind = tmp_index;
            }
        }
    }

    public static void deleteDuplicatedElement(List<String> strList, List<Integer> delete_index) {
        for (int ind = delete_index.size()-1; ind >= 0; ind--) {
            strList.remove((int)delete_index.get(ind));
        }
    }
}
