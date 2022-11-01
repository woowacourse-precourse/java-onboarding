package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of();
        HashMap<String, List<String>> dupMap = new HashMap<String, List<String>>();
        HashSet<String> emailSet = new HashSet<String>();


        for(List<String> crew: forms){
            String email = crew.get(0);
            String name = crew.get(1);

            for(int i=0; i<name.length()-1; i++){
                String keyStr = name.substring(i, i+2);
                List<String> update = dupMap.get(keyStr);
                if(update == null){
                    update = new ArrayList<String>();
                }
                update.add(email);
                dupMap.put(name.substring(i, i+2), update);
            }
        } // 이름 내 연속된 두 문자를 key, 해당 문자들을 포함하는 user들의 email list를 value 로 삼는 HashTable 생성

        List<String> key = new ArrayList<String>(dupMap.keySet());

        for(String keyStr : key){
            List<String> email = dupMap.get(keyStr);
            if(dupMap.get(keyStr).size() > 1){
                emailSet.addAll(email);
            }
        } // 겹치는 이름이 하나 이상인 email을 모은 Set 생성

        answer = new ArrayList<String>(emailSet);

        answer.sort(Comparator.naturalOrder()); // set을 list로 전환 후 알파벳 순으로 정렬


        return answer;
    }
}
