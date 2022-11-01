package onboarding;

import java.util.*;

public class Problem6 {
    public static Set<String> Name = new HashSet<String>();
    public static List<String> Same = new ArrayList<String>();
    public static int setSame(String str){
        int l=str.length();
        String tmp;
        for(int i=0; i<l-1; i++){
            tmp=str.substring(i,i+2);
            if(!Name.add(tmp)) {
                if(!Same.contains(tmp)) Same.add(tmp);
            }
        }
        return 0;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();
        int emailSize=forms.size();
        int sameSize;
        for(int i=0; i<emailSize; i++){
            setSame(forms.get(i).get(1));
        }
        sameSize=Same.size();
        for(int i=0; i<emailSize; i++){
            for(int j=0; j<sameSize; j++){
                if(forms.get(i).get(1).contains(Same.get(j))){
                    answer.add(forms.get(i).get(0));
                }
            }
        }
        answer.sort(Comparator.naturalOrder());
        return answer;
    }
}
