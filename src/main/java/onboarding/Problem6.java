package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        if(validateCheck(forms)) {
            answer = findDuplicateName(forms);
        }
        return answer;
    }
    private static boolean validateCheck(List<List<String>> forms){
        for(List<String> list : forms){
            String email = list.get(0);
            String id = list.get(1);
            if(list.size() < 1 || list.size() > 10000){
                return false;
            }
            else if(!id.matches("^[ㄱ-ㅎ가-힣]*$")){
                return false;
            }
            else if(!email.contains("@email.com")){
                return false;
            }
            else if(email.length() < 11 | email.length() >= 20){
                return false;
            }
            else {
                return true;
            }
        }
        return true;
    }
    private static List<String> findDuplicateName(List<List<String>> forms){
        HashMap<String,String> hashMap = new HashMap<>();
        TreeSet<String> treeSet = new TreeSet<>();
        for(List<String> list : forms){
            HashSet<String> hashSet = new HashSet<>();
            String id = list.get(1);
            for(int i=0; i<id.length()-1; i++){
                hashSet.add(id.substring(i,i+2));
            }
            for(String cmp : hashSet){
                if(!hashMap.containsKey(cmp)){
                    hashMap.put(cmp,list.get(0));
                }
                else{
                    treeSet.add(list.get(0));
                    treeSet.add(hashMap.get(cmp));
                }
            }
        }
        List<String> answer = new ArrayList<>(treeSet);
        Collections.sort(answer);
        return answer;
    }
}
