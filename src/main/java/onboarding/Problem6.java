package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> emails = new ArrayList<>();

        for(int i=0; i<forms.size()-1; i++){
            for(int j=i+1; j<forms.size();j++){
                if(isOverlap(forms.get(i).get(1), forms.get(j).get(1))) {
                    if (!emails.contains(forms.get(i).get(0))) emails.add(forms.get(i).get(0));
                    if (!emails.contains(forms.get(j).get(0))) emails.add(forms.get(j).get(0));
                }
            }
        }
        emails.sort(Comparator.naturalOrder());
        return emails;
    }

    public static boolean isOverlap(String name1, String name2){
        for(int i=0; i<name1.length()-1;i++){
            for(int j=0; j<name2.length()-1;j++){
                if(name1.charAt(i)==name2.charAt(j)){
                    if(name1.charAt(i+1)==name2.charAt(j+1)) return true;
                }
            }
        }
        return false;
    }
}
