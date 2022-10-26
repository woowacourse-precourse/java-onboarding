package onboarding;

import java.util.*;

public class Problem6 {
    static Map<String, Integer> map = new HashMap<>();
    public static List<String> solution(List<List<String>> forms) {
        //가능한 모든 부분 닉네임(두글자)을 <닉네임 : 중복 수>쌍으로 map에 저장
        for(List<String> form : forms)
            processSubName(form.get(1));

        //TreeSet : 중복을 허용하지 않으며, 오름차순 정렬
        Set<String> set = new TreeSet<>();

        for(List<String> x : forms) {
            String mail = x.get(0);
            String name = x.get(1);
            for(String y : map.keySet())
                if (map.get(y)>1 && name.contains(y)) set.add(mail);
        }

        return new ArrayList<>(set);
    }

    static void processSubName(String name){
        for(int i=0; i<name.length()-1; i++){
            String subName = name.substring(i,i+2);
            map.put(subName, map.getOrDefault(subName,0)+1);
        }
    }
}
