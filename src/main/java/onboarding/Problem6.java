package onboarding;

import java.util.*;

public class Problem6 {
    public static Set<String> set = new HashSet<String>();

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        for(int i=0; i<forms.size()-1; i++)
            for(int j=i+1; j<forms.size();j++)
                checkDuplicated(forms.get(i), forms.get(j));

        answer = new ArrayList<String>(set);
        Collections.sort(answer);

        return answer;
    }
    private static boolean checkDuplicated(List<String> first,List<String> second){
        String firstName = first.get(1);
        String secondName = second.get(1);
        for(int i=0; i<firstName.length()-1; i++){
            String subFirstName = firstName.substring(i,i+2);
            for(int j=0; j<secondName.length()-1; j++){
                String subSecondName = secondName.substring(j,j+2);
                if(subFirstName.equals(subSecondName)){
                    set.add(first.get(0));
                    set.add(second.get(0));
                }
            }
        }
        return true;
    }
}
