package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();
        for(int i = 0; i < forms.size(); i++ )  {
            List<String> tmp = forms.get(i);
            for(int j = i + 1; j < forms.size(); j ++) {
                List<String> tmp2 = forms.get(j);
                String tmpId = tmp.get(1);
                String tmp2Id = tmp2.get(1);
                for(int k = 1; k < tmpId.length(); k++){
                    String tmpSubstr = tmpId.substring(k-1, k);
                    if(tmp2Id.contains(tmpSubstr)){
                        answer.add(tmp2.get(0));
                    }
                }
            }
        }
        Set<String> set = new HashSet<String>(answer);
        List<String> newAnswer =new ArrayList<String>(set);
        return newAnswer;
    }
}
