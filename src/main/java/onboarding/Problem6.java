package onboarding;

import java.util.*;

/*
##기능 목록

1. 각 닉네임으로 만들 수 있는 길이 2이상의 연속된 문자열을 Key로 HashMap에 저장 (Value는 List<String>)
2. HashMap의 Value(List<String>)의 크기가 2 이상인 경우, Value에 포함한 모든 Email을 answer에 저장
3. answer의 모든 중복 제거 및 정렬

 */
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for(int i=0;i<forms.size();i++){
            putAllSubstringInHashMap(forms.get(i),hashMap);
        }
        findRestrictedUser(answer,hashMap);
        answer = removeDuplicateAndSort(answer);
        return answer;
    }

    public static void putAllSubstringInHashMap(List<String> info, HashMap<String,List<String>> hashMap){
        String email = info.get(0);
        String nickname = info.get(1);
        for(int i=2;i<nickname.length();i++){
            for(int j =0;j<nickname.length()-i+1;j++){
                String substr = nickname.substring(j,j+i);
                if(!hashMap.containsKey(substr)){
                    List<String> list = new ArrayList<>();
                    hashMap.put(substr,list);
                }
                hashMap.get(substr).add(email);
            }
        }
    }

    public static void findRestrictedUser(List<String> answer, HashMap<String,List<String>> hashMap){
        for(String key : hashMap.keySet()){
            if(hashMap.get(key).size()>=2){
                answer.addAll(hashMap.get(key));
            }
        }
    }

    public static List<String> removeDuplicateAndSort(List<String> list){
        HashSet<String> hashSet = new HashSet<>(list);
        list = new ArrayList<>(hashSet);
        list.sort(Comparator.naturalOrder());
        return list;
    }
}
