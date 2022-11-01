package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = null;

        // 1.2. 크루의 모든 닉네임을 두글자씩 끊어 map에 있는지 비교하고, 이미 있는 값이라면 중복 문자열 리스트에 담아준고, 없는 값이라면 map에 담아준다.
        List<String> duplicateList = new ArrayList<>();
        Map<String,String> nickNameMap = new HashMap<>();
        for (List<String> form : forms){
            for(int i=0; i<form.get(1).length()-1;i++){
                if(nickNameMap.get(form.get(1).substring(i,i+2))!=null){
                    duplicateList.add(form.get(1).substring(i,i+2));
                } else {
                    nickNameMap.put(form.get(1).substring(i, i + 2), " ");
                }
            }
        }
        // System.out.println(duplicateList);
        // System.out.println(nickNameMap);

        // 3. 크루의 모든 닉네임을 중복문자열 리스트와 비교해주고 (contains), true 가 나온다면 이메일 리스트에 담아준다
        HashSet emailSet = new HashSet();

        for (List<String> form : forms){
            for(String duplicateNick : duplicateList){
                if(form.get(1).contains(duplicateNick)){
                    emailSet.add(form.get(0));
                    break;
                }
            }
        }

        // 4. 이메일 set을 리스트로 바꿔준다
        answer = new ArrayList<>(emailSet);

        // 5. 이메일리스트를 정렬해준다
        Collections.sort(answer);

        return answer;
    }

}
