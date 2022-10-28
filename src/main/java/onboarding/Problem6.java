package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
//        - 두 글자 이상의 문자가 연속적으로 순서에 맞추어 포함되어 있는 경우 중복으로 간주한다.
//        - 크루는 1명 이상 10,000명 이하이다.
//        - 이메일은 이메일 형식에 부합하며, 전체 길이는 11자 이상 20자 미만이다.
//        - 신청할 수 있는 이메일은 `email.com` 도메인으로만 제한한다.
//        - 닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만이다.
//        - result는 이메일에 해당하는 부분의 문자열을 오름차순으로 정렬하고 중복은 제거한다.

        // 1. 중복확인 메소드
        // 2. 이메일 형식 확인 메소드
        // 3. 닉네임 형식 확인 메소드
        // 4.
        // map을 이용해서 키, 값으로 만들기
        Map<String,String> mapFroms = new LinkedHashMap<>();


        for (int i =0; i<forms.size(); i++){
            mapFroms.put(forms.get(i).get(0), forms.get(i).get(1));
            }

        // Map 전체를 보내서 중복용 메소드 만들기

        List<String> answer = duplicateCheck(mapFroms);
        return answer;
    }

    public static List<String> duplicateCheck(Map<String, String> map){ // 제이엠, 0 |제이슨, 0|.....
        int count = 1;
        String first="";
        List<String> list = new ArrayList<>();
        List<String> emailList = new ArrayList<>();
        Set<String> checkSet = new LinkedHashSet<>();

        // 중복된 값찾고 해당값을 list에 넣기
        for (Map.Entry<String, String> pair : map.entrySet()) { // 제이엠 제이슨 워니 엠제이 이제엠
            String s = pair.getValue(); //제이엠

            if(count++==1)  first=s;
            for(int i =0; i<s.length()-1; i++){ //제이 이엠 제이 이슨 워니 엠제 이제 제엠
            if(!checkSet.add(s.substring(i,i+2))) {
                if(i==1) list.add(first);
                list.add(s);}
            }
        }
        // 중복된 값에 해당하는 key 찾기
        for (String key : map.keySet()) {
            String value = map.get(key);
            for(int c =0; c<list.size(); c++){
                if (value.equals(list.get(c))) {emailList.add(value);}
            }

        }

        Collections.sort(emailList);

        return emailList;
    }
}
