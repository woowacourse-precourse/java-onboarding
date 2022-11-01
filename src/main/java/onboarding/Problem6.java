package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String,Integer> Id = new HashMap<>();
        List<String> answer  = new ArrayList<>();
        for (int idx = 0; idx<forms.size();idx++) {
            for(int i=0 ;i<forms.get(idx).get(1).length()-1;i++){
                if(Id.containsKey(forms.get(idx).get(1).substring(i,i+2))==false){
                    Id.put(forms.get(idx).get(1).substring(i, i+2),0);
                }
                else if(Id.containsKey(forms.get(idx).get(1).substring(i, i+2))==true){
                    //해당 키가 이미 있다면
                    for (int x= 0; x<forms.size();x++){
                        if( forms.get(x).get(1).contains(forms.get(idx).get(1).substring(i, i+2))==true){
                            answer.add(forms.get(x).get(0));
                        }
                    }
                }
            }
        }
        Set<String> set = new HashSet<String>(answer);//중복제거
        List<String> newList =new ArrayList<String>(set);
        Collections.sort(newList);
        return newList;
    }
}
