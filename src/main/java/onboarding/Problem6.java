package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        Map<String,List<String>> Duplicatemap=new HashMap<>();
        for (int i=0;i<forms.size();i++) {
            String Email = forms.get(i).get(0);
            String Name = forms.get(i).get(1);
            for (int j=0; j<Name.length()-1;j++) {
                String TmpString = Name.substring(j,j+2);
                if (Duplicatemap.containsKey(TmpString)) {
                    List<String> Tmp = Duplicatemap.get(TmpString);
                    Tmp.add(Email);
                    Duplicatemap.put(TmpString,Tmp);
                }
                else {
                    List<String> Tmp = new ArrayList<>();
                    Tmp.add(Email);
                    Duplicatemap.put(TmpString,Tmp);
                }
            }
        }
        for (String str : Duplicatemap.keySet()) {
            List<String> Tmp =  Duplicatemap.get(str);
            if (Tmp.size()>=2) {
                for (String j : Tmp) {
                    if (!answer.contains(j)) answer.add(j);
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }
}
