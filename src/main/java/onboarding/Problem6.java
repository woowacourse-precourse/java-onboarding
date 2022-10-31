package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = null;
        TreeMap<String, String> map = new TreeMap<>();

        for(int i = 0; i < forms.size(); i++){

            String stdEmail = forms.get(i).get(0);
            String stdNm = forms.get(i).get(1);
            boolean chk = false;
            for(int j = 0; j < forms.size(); j++){
                if(j != i){
                    String trgNm = forms.get(j).get(1);
                    String trgEmail = forms.get(j).get(0);
                    if(kmp(trgNm, stdNm)){
                        if(!map.containsKey(trgEmail)){
                            chk = true;
                            map.put(trgEmail, trgNm);
                        }
                    }
                }
            }
            if(chk && !map.containsKey(stdEmail)){
                map.put(stdEmail, stdNm);
            }
        }
        if(map.size() > 0){
            answer = new ArrayList<>(map.keySet());
        }

        return answer;
    }

    private static boolean kmp(String trg, String std){
        boolean rtn = false;
        int[] table = makeTable(std);
        char[] trgList = trg.toCharArray();
        char[] stdList = std.toCharArray();
        int idx = 0;
        for (char c : trgList) {
            while (idx > 0 && c != stdList[idx]) {
                idx = table[idx - 1];
            }
            if (c == stdList[idx]) {
                if (idx > 0) {
                    rtn = true;
                    break;
                }
                if (idx == stdList.length - 1) {
                    idx = table[idx];
                } else {
                    ++idx;
                }
            }
        }
        return rtn;
    }


    private static int[] makeTable(String pattern){
        char[] patterns = pattern.toCharArray();
        int[] table = new int[patterns.length];
        int idx = 0;
        for(int i = 1; i< patterns.length; i++){
            while(idx > 0 && patterns[i] != patterns[idx]){
                idx = table[idx - 1];
            }
            if(patterns[i] == patterns[idx]){
                table[i] = ++idx;
            }
        }
        return table;
    }

}
