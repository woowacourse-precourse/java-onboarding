package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> answer_set = new HashSet<>(); // 정답 set
        Map<String, Set<String>> nick_words=new HashMap<>(); // (이메일: 닉네임을 두 글자씩 쪼갠 단어들의 집합) 형태의 Map
        for(List<String> list:forms){
            Set<String> words=new HashSet<>();
            for(int j=0; j<=list.get(1).length()-2; j++){
                words.add(list.get(1).substring(j,j+2));
            }
            nick_words.put(list.get(0),words);
        }
        for(String i:nick_words.keySet()){
            for(String j:nick_words.keySet()){
                if(!i.equals(j)){
                    HashSet<String> intersection = new HashSet<>(nick_words.get(i)); // intersection은 두 (닉네임을 두 글자씩 쪼갠)집합간의 교집합
                    intersection.retainAll(nick_words.get(j));
                    if(intersection.size()>0) // 교집합이 존재하면 두 닉네임간 같은 글자가 연속적으로 포함된다는 것이다.
                        answer_set.add(i);
                }
            }
        }
        List<String> answer=new ArrayList<>(answer_set);
        answer.sort(Comparator.naturalOrder());
        return answer;
    }
}
