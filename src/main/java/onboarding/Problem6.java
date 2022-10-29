package onboarding;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>(List.of());
        int[] memoIfChecked = new int[forms.size()];

        for (int i=0; i<forms.size(); i++){
            //System.out.println(forms.get(i));
            if (memoIfChecked[i]==1) continue;
            for (int j=i+1; j<forms.size(); j++){
                //System.out.println(forms.get(i).get(1) + " " +forms.get(j).get(1));
                int sw=0;
                for (int k=2; k<=forms.get(i).get(1).length(); k++){
                    for (int l=0; l+k<=forms.get(i).get(1).length(); l++) {
                        //System.out.println(j + " : " + forms.get(i).get(1).substring(l, l + k));
                        if (forms.get(j).get(1).contains(forms.get(i).get(1).substring(l, l + k))) {

                            sw = 1;
                            break;
                        }
                    }
                    if (sw==1) {
                        if (memoIfChecked[i]!=1) {
                            memoIfChecked[i]=1;
                            answer.add(forms.get(i).get(0));
                        }
                        answer.add(forms.get(j).get(0));
                        memoIfChecked[j]=1;
                        break;
                    }
                }
            }
        }
        answer.sort(String.CASE_INSENSITIVE_ORDER);
        return answer;
    }
}
