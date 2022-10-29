package onboarding;

import java.util.ArrayList;
import java.util.List;
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        String[] str = cryptogram.split("");
        List<String> strList = new ArrayList<>();

        int cnt=1;
        int startIdx=0;
        int endIdx=0;

        for(int i=0; i<str.length; i++){
            strList.add(str[i]);
        }

        while(cnt>0) {
            cnt=0;
            
            // duplication start Index
            for (int i = 0; i < strList.size() - 1; i++) {
                if (strList.get(i).equals(strList.get(i + 1))) {
                    cnt++;
                    startIdx = i;
                    break;
                }
            }

            // exit if there are no duplication
            if(cnt==0){
                break;
            }

            // duplication end Index
            for (int i = startIdx + 1; i < strList.size(); i++) {
                if (strList.get(startIdx).equals(strList.get(i))) {
                    endIdx = i;
                } else {
                    break;
                }
            }

            // remove the duplication characters
            for (int k = 0; k <= endIdx - startIdx; k++) {
                strList.remove(startIdx);
            }

            answer=strList.toString().join("",strList);
        }
        return answer;
    }
}