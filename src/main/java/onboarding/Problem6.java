package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String,Integer> Id = new HashMap<>();
        List<String> answer  = new ArrayList<>();
        for (int idx = 0; idx<forms.size();idx++) {
            for(int i=2 ;i<forms.get(idx).get(1).length();i++){
                for (int q=0;q<forms.get(idx).get(1).length()-i+1;q++) {
                    if(Id.containsKey(forms.get(idx).get(1).substring(q, q+i))==false){
                        Id.put(forms.get(idx).get(1).substring(q, q+i),0);
                    }
                    else if(Id.containsKey(forms.get(idx).get(1).substring(q, q+i))==true){
                        //해당 키가 이미 있다면
                        for (int x= 0; x<forms.size();x++){
                            if( forms.get(x).get(1).contains(forms.get(idx).get(1).substring(q, q+i))==true){
                                answer.add(forms.get(x).get(0));
                            }
                        }
                    }
                }
            }
            //풀넴임 넣는 코드
            if(Id.containsKey(forms.get(idx).get(1))==false ) {
                Id.put(forms.get(idx).get(1),0);
            }
            else if(Id.containsKey(forms.get(idx).get(1))==true ) {
                for (int x= 0; x<forms.size();x++){
                    if( forms.get(x).get(1).contains(forms.get(idx).get(1))==true){
                        answer.add(forms.get(x).get(0));
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
