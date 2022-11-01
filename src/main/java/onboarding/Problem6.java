package onboarding;

import java.util.*;

public class Problem6 {
    //중복된 닉네임인지 확인
    public static boolean IsOverlap(String s1, String s2){

        //같은 문자일 경우, 연속한 문자도 같아야함
        for(int i = 0; i<s1.length()-1; i++){
           for(int j = 0; j<s2.length()-1; j++){
               if(s1.charAt(i) == s2.charAt(j)){
                   if(s1.charAt(i+1) == s2.charAt(j+1))
                       return true;
               }
           }
        }
        return false;
    }

    public static List<String> compareNicknames(List<List<String>> forms){
        List<Integer> overlapCrews = new ArrayList<>();

        for(int i = 0; i<forms.size(); i++){
            for(int j =i+1; j<forms.size(); j++){
                if(IsOverlap(forms.get(i).get(1), forms.get(j).get(1))){
                    overlapCrews.add(i);
                    overlapCrews.add(j);
                }
            }
        }

        return makeEmailList(overlapCrews, forms);
    }

    public static List<String> makeEmailList(List<Integer> overlapCrews ,List<List<String>> forms){
        Set<Integer> overlapCrewsSet = Set.copyOf(overlapCrews);

        List<String> overlapEmails = new ArrayList<>();

        Iterator<Integer> iter = overlapCrewsSet.iterator();

        while(iter.hasNext()){
            overlapEmails.add(forms.get(iter.next()).get(0));
        }

        Collections.sort(overlapEmails);
        return overlapEmails;

    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        answer = compareNicknames(forms);
        return answer;
    }
}
