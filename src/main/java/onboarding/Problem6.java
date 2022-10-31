package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        answer = makeList(forms);
        mailSort(answer);
        return answer;
    }
    public static boolean findRedundancy(String string1, String string2){
        char c1, c2;
        for(int i=0; i<string1.length() - 1; i++){
            c1 = string1.charAt(i);
            c2 = string1.charAt(i+1);
            for(int j=0; j<string2.length()-1; j++){
                if(c1 == string2.charAt(j)){
                    if(c2 == string2.charAt(j+1)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static List<String> makeList(List<List<String>> forms){
        List<List<String>> newForms = new ArrayList<>();
        for(int i=0; i<forms.size();i++){
            newForms.add(forms.get(i));
        }
        List<String> sol = new ArrayList<>();
        String string1, string2;
        boolean flag = false;
        for(int i=0; i<newForms.size()-1; i++){
            string1 = newForms.get(i).get(1);
            flag = false;
            for(int j=i+1; j<newForms.size(); j++){
                string2 = newForms.get(j).get(1);
                if(findRedundancy(string1,string2)){
                    sol.add(newForms.get(j).get(0));
                    newForms.remove(j);
                    j-=1;
                    flag = true;
                }
            }
            if(flag){
                sol.add(newForms.get(i).get(0));
                newForms.remove(i);
                i-=1;
            }

        }
        return sol;
    }
    public static void mailSort(List<String> anwser){
        Collections.sort(anwser);
    }
}
