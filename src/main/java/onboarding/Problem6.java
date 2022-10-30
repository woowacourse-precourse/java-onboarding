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
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i<forms.size(); i++){
            for(int j =i+1; j<forms.size(); j++){
                if(IsOverlap(forms.get(i).get(1), forms.get(j).get(1))){
                    result.add(i);
                    result.add(j);
                }
            }
        }

        return makeEmailList(result, forms);
    }

    public static List<String> makeEmailList(List<Integer> list ,List<List<String>> forms){
        Set<Integer> set = Set.copyOf(list);

        List<String> result = new ArrayList<>();

        Iterator<Integer> iter = set.iterator();

        while(iter.hasNext()){
            result.add(forms.get(iter.next()).get(0));
        }

        Collections.sort(result);
        return result;

    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        answer = compareNicknames(forms);
        return answer;
    }
}
