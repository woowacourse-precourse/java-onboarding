package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        List<String> compare1 = new ArrayList<>(Arrays.asList(null,null));
        List<String> compare2 = new ArrayList<>(Arrays.asList(null,null));
        List<String> index = new ArrayList<>();
        int i,j,k,l, len1, len2;

        for(i=0;i<forms.size() - 1;i++){
            len1 = forms.get(i).get(1).length();
            String a = forms.get(i).get(1);
            String[] stra = a.split("");
            for(j=0; j<len1-1; j++){
                compare1.set(0, stra[j]);
                compare1.set(1, stra[j + 1]);
                for(k=i+1;k< forms.size();k++){
                    len2 = forms.get(k).get(1).length();
                    String b = forms.get(k).get(1);
                    String[] strb = b.split("");
                    for(l=0;l<len2-1;l++){
                        compare2.set(0, strb[l]);
                        compare2.set(1, strb[l + 1]);
                        if(Arrays.equals(compare1.toArray(),compare2.toArray())==true){
                            index.add(forms.get(i).get(0));
                            index.add(forms.get(k).get(0));
                            l = len2;
                        }
                    }
                }
            }
        }

        TreeSet<String> trans = new TreeSet<String>(index);
        answer = new ArrayList<>();
        answer.addAll(trans);

        return answer;
    }
}
