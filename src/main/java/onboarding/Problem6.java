package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
조건
닉네임 길이 : 1~19 , 크루 : 1~10000
기능
닉네임이 한글자인 경우 hashMap에 넣으면서 걸러짐
2글자씩 Hashmap형태의 checkDup에 추가해 중복체크
 */

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new java.util.ArrayList<>();

        HashMap<String,String> hashMap = new HashMap<>();
        HashMap<String,String> checkDup = new HashMap<>();
        HashSet<String> emails = new HashSet<>();

        for(List<String> form :forms){
            if(hashMap.containsKey(form.get(1))){
                emails.add(form.get(0));
                emails.add(hashMap.get(form.get(1)));
            }
            hashMap.put(form.get(1),form.get(0));
        }

        for(String name:hashMap.keySet()){
            for(int i=0;i<name.length()-1;i++){
                String subName=name.substring(i,i+2);
                if(checkDup.containsKey(subName)){
                    emails.add(hashMap.get(name));
                    emails.add(hashMap.get(checkDup.get(subName)));
                }
                checkDup.put(subName,name);
            }
        }

        answer.addAll(emails);

        return answer;
    }
}
