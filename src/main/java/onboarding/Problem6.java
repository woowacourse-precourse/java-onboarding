package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        int sizeList = forms.size();
        for (int i = 0; i < sizeList; ++i) {
            temp.add(forms.get(i).get(1));
        }
        for (int i=0;i<sizeList;++i)
            if (arrayOverlap(temp).get(i) == true) {
                answer.add(forms.get(i).get(0));
            }
        answer.sort(Comparator.naturalOrder());
        return answer;
    }

    public static List<Boolean> arrayOverlap(List<String> temp) {
        List<String> dest = new ArrayList<>();
        List<Boolean> visited = new ArrayList<>();
        int sizeTemp = temp.size();
        for (int i=0;i<sizeTemp;++i)
            visited.add(false);
        for (int i = 0; i < sizeTemp; ++i) {
            for (int j = i + 1; j < sizeTemp; ++j) {
                if ((comfileStr(temp.get(i), temp.get(j)) == 1) && visited.get(i) == false) {
                    dest.add(temp.get(i));
                    dest.add(temp.get(j));
                    visited.set(i, true);
                    visited.set(j, true);
                }
                else if ((comfileStr(temp.get(i), temp.get(j)) == 1)
                        && visited.get(i) == true && visited.get(j) == false) {
                    dest.add(temp.get(j));
                    visited.set(j, true);
                }
            }
        }
        return visited;
    }
    public static int comfileStr (String str1, String str2){
        int lenStr1 = lengthStr(str1);
        int lenStr2 = lengthStr(str2);
        int i = 0;
        while (i + 1 < lenStr1) {
            String temp = "";
            temp = temp + str1.charAt(i) + str1.charAt(i + 1);
            int j = 0;
            while (j + 1 < lenStr2) {
                String dest = "";
                dest = dest + str2.charAt(j) + str2.charAt(j + 1);
                if (temp.equals(dest)) {
                    return 1;
                }
                j++;
            }
            i++;
        }
        return 0;
    }
    public static int lengthStr (String str){
        int len = str.length();
        return len;
    }
}
