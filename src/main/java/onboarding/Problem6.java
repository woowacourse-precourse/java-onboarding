package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

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

        // 두글자씩 잘라서 set에 넣기
//        for (Map.Entry<String, String> pair : map.entrySet()) { // 제이엠 제이슨 워니 엠제이 이제엠
//            String value = pair.getValue(); //제이엠
//
//            if(count++==1)  first=value; // 첫번째 글자만 따로 저장해 뒨다.
//            for(int i =0; i<value.length()-1; i++){ //제이 이엠 제이 이슨 워니 엠제 이제 제엠
//            if(!checkSet.add(value.substring(i,i+2))) { // 두글자씩 잘라서 넣는다.
//                if(i==1) list.add(first); // 첫번째 글자는 중복확인이 안된다. 그래서 두번째 글자가 이미 중복이라면 첫번쨰글자와 두번째 글자는 이미 중복이라는것
//                list.add(value);}
//            }
//        }
//
//        // 중복된 값에 해당하는 key(email값) 찾기
//        for (String key : map.keySet()) {
//            String value = map.get(key);
//            for(String depuli : list) {
//                if (value.equals(depuli)) {emailList.add(key);}
//            }
//
//        }
//
//        Collections.sort(emailList);

        return emailList;
    }
}
