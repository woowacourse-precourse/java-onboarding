package onboarding;

import java.util.*;

public class Problem6 {
    public static Set<String> result_set = new HashSet<>();

    public static List<String> result(List<List<String>> forms, Set<String> set){
        List<String> list = new ArrayList<>();
        for(int i=0; i<forms.size(); i++){
            String name = forms.get(i).get(1);
            Iterator<String> it = set.iterator();
            while(it.hasNext()){
                if(name.equals(it.next())) {
                    String email = forms.get(i).get(0);
                    list.add(email);
                }
            }
        }
        return list;
    }

    public static Set<String> compare(int index, List<String> list1, List<String> list2){ //list1은 nickname 차출, list2는 쪼갠걸 모음
        for(int i=0; i<list1.size(); i++){
            if(i==index) continue;
            String name = list1.get(i);
            for(int j=0; j<list2.size(); j++){
                if(name.contains(list2.get(j)))
                    result_set.add(name);
            }
        }
        return result_set;
    }

    public static List<String> piece(String name){ //문자열의 부분집합들을 구해주는 함수
        List<String> sub = new ArrayList<>();
        int len = name.length();
        for(int k=0; k<len; k++){
            int i = k+2;
            while(i<=len){
                sub.add(name.substring(k,i++));
            }
        }
        return sub;
    }

    public static List<String> members(List<List<String>> forms){ //닉네임만 차출하여 nickname 리스트에 넣는다
        List<String> nicknames = new ArrayList<>();
        for(int i=0; i<forms.size(); i++){
            String name = forms.get(i).get(1);
            nicknames.add(name);
        }
        return nicknames;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        Set<String> set = new HashSet<>();
        List<String> nicknames = members(forms); //닉네임만 차출함.

        for(int i=0; i< nicknames.size(); i++){
            String name = nicknames.get(i);
            List<String> sublist = piece(name); //닉네임 하나를 가능한 여러 경우로 쪼갠 걸 list에 넣음
            set = compare(i, nicknames, sublist);
        }
        answer = result(forms, set);
        Collections.sort(answer);

        return answer;
    }
}