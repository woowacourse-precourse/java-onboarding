package onboarding;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem2 {
    public static String solution(String cryptogram) {
        return crypto(cryptogram);
    }
    public static String crypto(String s){
        ArrayList<String> strList = new ArrayList<>(Arrays.asList(s.split("")));
        return String.join("", deleteSameStr(strList));
    }

    public static ArrayList<String> deleteSameStr(ArrayList<String> strList) {

        int cnt = 0, indexNum = 0;
        for (int i = 0; i < strList.size() - 1; i++) {
            if(strList.get(i).equals(strList.get(i + 1))) {
                cnt++;
                indexNum = i + 1;
            }
            if (cnt >= 1) {
                int start = indexNum - cnt;
                while(cnt >= 0) {
                    strList.remove(start);
                    cnt--;
                }
                cnt = 0;
                indexNum = 0;
                i = 0;
            }
        }
        if (strList.size() > 1) {
            for (int i = 0; i < strList.size() - 1; i++) {
                if(strList.get(i).equals(strList.get(i + 1))) {
                    cnt++;
                    indexNum = i + 1;
                }
                if (cnt >= 1) {
                    int start = indexNum - cnt;
                    while(cnt >= 0) {
                        strList.remove(start);
                        cnt--;
                    }
                    cnt = 0;
                    indexNum = 0;
                    i = 0;
                }
            }
        }
        return strList;
    }
}
