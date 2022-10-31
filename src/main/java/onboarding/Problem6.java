package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        HashMap<String,String> map = new HashMap<>();
        HashMap<String,Integer> nickCnt = new HashMap<>();

        for(int i = 0; i < forms.size(); i++){
            map.put(forms.get(i).get(1),forms.get(i).get(0));
            for(int j = 0; j < forms.get(i).get(1).length() - 1; j++){
                String twoWord = forms.get(i).get(1).substring(j, j + 2);
                nickCnt.put(twoWord, nickCnt.getOrDefault(twoWord,0) + 1);
                //System.out.println(nickCnt);
                //System.out.println(forms.get(i).get(1).substring(j,j+2));
            }

        }

        for(int i = 0; i < forms.size(); i++){
            String name = forms.get(i).get(1);
            for(int j = 0; j < name.length() - 1; j++){
//                System.out.println(nickCnt);
//                System.out.println(name);
//                System.out.println(nickCnt.get(name.substring(j,j+2))-1);
                if(nickCnt.get(name.substring(j, j+2)) - 1 > 1){
                    answer.add(map.get(name));
//                    System.out.println(answer);
                    break;
                }
            }
        }

        Collections.sort(answer);
        return answer;
    }
}
