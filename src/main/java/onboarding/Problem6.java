package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        int sizeOfForm = forms.size();
        boolean[] boolArray = new boolean[sizeOfForm];

        for (List<String> data : forms){
            String dataName = data.get(1);
            int size = dataName.length();
            for (int i = 0; i < size - 1; i++){
                String word = dataName.substring(i, i + 2);
                int j = 0;
                for (List<String> other : forms){
                    String otherName = other.get(1);
                    if(boolArray[j] || otherName.equals(dataName)){
                        j++;
                        continue;
                    }
                    if (otherName.contains(word)){
                        boolArray[j] = true;
                    }
                    j++;
                }
            }
        }

        List<String> answer = new ArrayList<>();
        for (int i = 0; i < sizeOfForm; i++){
            if (boolArray[i]){
                answer.add(forms.get(i).get(0).replace("@email.com",""));
            }
        }
        Collections.sort(answer);
        int sizeOfAnswer = answer.size();
        for (int i = 0; i < sizeOfAnswer; i++){
            answer.set(i,answer.get(i) + "@email.com");
        }
        return answer;
    }
}
