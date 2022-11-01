package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {

    private static boolean compareName(String s1, String s2) {

        for (int k=0; k< s1.length()-1; k++){
            if (s2.contains(s1.substring(k,k+2))){
                return true;
            }
        }

        return false;
    }
    public static List<String> solution(List<List<String>> forms) {

        boolean isSameList[] = new boolean[forms.size()];

        for (int i = 0; i< forms.size(); i++){

            if(isSameList[i] == true){
                continue;
            }else{
                for (int j = i+1; j< forms.size(); j++){
                    if (isSameList[j] == true){
                        continue;
                    }else{
                        if (compareName(forms.get(i).get(1), forms.get(j).get(1))){
                            isSameList[i] = true;
                            isSameList[j] = true;
                        }
                    }
                }
            }
        }

        List<String> answer = new ArrayList<>();
        for (int i = 0; i< isSameList.length; i++){
            if (isSameList[i] == true){
                answer.add(forms.get(i).get(0));
            }
        }
        Collections.sort(answer);
        
        return answer;
    }

}
