package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer=new ArrayList<>();
        String [] names = new String[forms.size()];
        for(int i=0;i<forms.size();i++)
            names[i] = forms.get(i).get(1);

        int n=0; //현재 비교 기준
        String tmp,t;
        List<Integer> k = new ArrayList<>();
        for(int i=n+1;i<names.length;i++){
            tmp = names[n];
            for(int l=0;l<names[i].length()-2;l++){
                t = tmp.substring(l,l+2);
                for(int j=i;j<names.length;j++){
                    if(forms.get(j).get(1).contains(t)){
                        if(!k.contains(n)){
                            k.add(n);
                            answer.add(forms.get(n).get(0));
                        }
                        if(!k.contains(j)){
                            k.add(j);
                            answer.add(forms.get(j).get(0));
                        }
                    }
                }
            }
            n++;
        }
        Collections.sort(answer);
        return answer;
    }
}
