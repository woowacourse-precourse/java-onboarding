package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> overlap = new ArrayList<String>();
        for(int i=0; i<forms.size()-1;i++){
            for(int j = i+1;j<forms.size();j++){
                if(isOverlap(forms.get(i).get(1),forms.get(j).get(1))){
                    overlap.add(forms.get(i).get(0));
                    overlap.add(forms.get(j).get(0));
                }
            }

        }
        HashSet<String> set = new HashSet<String>(overlap);
        List<String> answer = new ArrayList<String>(set);
        answer.sort(Comparator.naturalOrder());
        return answer;
    }
    static boolean isOverlap(String letter_A, String letter_B){
        char[] arrA = letter_A.toCharArray();
        char[] arrB = letter_B.toCharArray();

        for (int i=0; i < arrA.length-1; i++){
            for (int j=0; j < arrB.length-1; j++){
                if (arrA[i] == arrB[j]){
                    if (arrA[i+1] == arrB[j+1]){return true;}
                }
            }
        }
        return false;

    }
}
