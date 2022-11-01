package onboarding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        HashMap<String,List<String>> check = new HashMap<>();
        ArrayList<String> validKey = new ArrayList<>();
        for(int i = 0; i < forms.size(); i++){
            List<String> curCrew = forms.get(i);
            String eMail = curCrew.get(0);
            String nickName = curCrew.get(1);
            if(nickName.length() == 1) {
                continue;
            } else {
                for(int j = 2; j <= nickName.length(); j++) {
                    for(int k = 0; k <= nickName.length() - j; k++) {
                        String unitStr = nickName.substring(k, k + j);
                        if(check.get(unitStr) == null) {
                            List<String> list = new ArrayList<>();
                            list.add(eMail);
                            check.put(unitStr, list);
                        } else {
                            if(check.get(unitStr).size() == 1) {
                                validKey.add(unitStr);
                            }
                            check.get(unitStr).add(eMail);
                        }
                    }
                }
            }
        }
        for(int i = 0; i < validKey.size(); i++) {
            List<String> emailList = check.get(validKey.get(i));
            for(int j = 0; j < emailList.size(); j++) {
                if (!answer.contains(emailList.get(j))) {
                    answer.add(emailList.get(j));
                } else {
                    continue;
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }
}
