package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem6 {
    public static boolean check(String cmp1, String cmp2){
        for(int i=0;i<cmp1.length()-1;i++){
            for(int j=0;j<cmp2.length()-1;j++){
                if(cmp1.charAt(i) == cmp2.charAt(j)){
                    if(cmp1.charAt(i+1)==cmp2.charAt(j+1)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static ArrayList<String> solution(List<List<String>> forms) {
        ArrayList<String> answer = new ArrayList<>();
        for(int i=0;i<forms.size();i++){
            for(int j=i+1;j< forms.size();j++){
                String cmp1 = forms.get(i).get(1);
                String cmp2 = forms.get(j).get(1);
                if(check(cmp1,cmp2)){
                    if(!answer.contains(forms.get(i).get(0))){
                        answer.add(forms.get(i).get(0));
                    }
                    if(!answer.contains(forms.get(j).get(0))){
                        answer.add(forms.get(j).get(0));
                    }
                }
            }
        }
        answer.sort(Comparator.naturalOrder());
        return answer;
    }
}
