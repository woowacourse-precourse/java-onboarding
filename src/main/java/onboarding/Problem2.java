package onboarding;

import java.util.ArrayList;
import java.util.List;
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        String[] str = cryptogram.split("");
        List<String> strList = new ArrayList<>();
        List<Integer> startList = new ArrayList<>();
        List<Integer> endList = new ArrayList<>();

        int cnt=1;
        int temp=0;

        for(int i=0; i<str.length; i++){
            strList.add(str[i]);
        }

        while(cnt>0){
            cnt=0;
            // IndexList reset
            for (int i = startList.size()-1; i >=0 ; i--) {
                endList.remove(i);
                startList.remove(i);
            }

            // duplicate value start Index list
            for (int i = 0; i < strList.size() - 1; i++) {
                if (strList.get(i).equals(strList.get(i + 1))) {
                    cnt++;
                    startList.add(i);
                }
            }

            // exit if there are no duplication
            if(cnt==0){
                break;
            }

            // duplicate value end Index list
            for (int i = 0; i < cnt; i++) {
                for (int j = startList.get(i) + 1; j < strList.size(); j++) {
                    if (strList.get(startList.get(i)).equals(strList.get(j)) && !endList.contains(j)) {
                        endList.add(j);
                    }
                    else {
                        break;
                    }
                }
            }

            // prevent overlapping delete
            for (int i = 0; i < startList.size(); i++) {
                for (int j = 0; j < endList.size(); j++) {
                    if(startList.get(i).equals(endList.get(j))){
                        startList.remove(i);
                        endList.remove(j);
                    }
                }
            }

            // remove duplicate value
            for (int i = startList.size()-1; i >= 0; i--) {
                for (int k = 0; k <= endList.get(i) - startList.get(i); k++) {
                    temp= startList.get(i);
                    strList.remove(temp);
                }
            }
            answer=strList.toString().join("",strList);
        }
        return answer;
    }
}