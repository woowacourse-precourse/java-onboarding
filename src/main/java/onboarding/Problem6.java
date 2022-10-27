package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        int listSize = forms.size();
        boolean flag = false;
        boolean[] result = new boolean[10010];

        for(int i=0; i<listSize; ++i){
            String string1 = forms.get(i).get(1);
            int string1Size = string1.length();

            for(int j=0; j<listSize; ++j){
                if(i==j) continue;
                String string2= forms.get(j).get(1);
                int string2Size = string2.length();

                for(int a=0; a<string1Size; ++a){
                    for(int b=0; b<string2Size; ++b){
                        if(Character.compare(string1.charAt(a), string2.charAt(b)) == 0){
                            if(flag) result[i] = result[j] = true;
                            flag = true;
                        }
                        else flag = false;
                    }
                }
            }
        }

        for(int i=0; i<listSize; ++i)
            if(result[i]) answer.add(forms.get(i).get(0));

        answer.sort(Comparator.naturalOrder());
        answer = answer.stream().distinct().collect(Collectors.toList());

        return answer;
    }
}
