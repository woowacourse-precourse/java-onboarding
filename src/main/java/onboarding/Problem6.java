package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = nickCheck(forms);
        return answer;
    }
    public static List<String> nickCheck(List<List<String>> forms){
        List<List<String>> form = new ArrayList<>(forms);
        List<String> result = new ArrayList<>();
        List<String> nickList = new ArrayList<>();
        for (List<String> user:
                form) {
            nickList.add(user.get(1));
        }

        for (int i = 0; i < nickList.size(); i++) {
            String nick=nickList.get(i);
            boolean checkI= false;
            for (int j = i+1; j <nickList.size(); j++) {
                for (int k = 0; k < nick.length()-1; k++) {
                    String checkNick=nick.substring(k,k+2);
                    if (nickList.get(j).contains(checkNick)){
                        checkI=true;
                        result.add(form.get(j).get(0));
                        nickList.remove(j);
                        form.remove(j);
                    }
                }
            }if (checkI){
                result.add(form.get(i).get(0));
            }
        }

        return result;
    }

}
