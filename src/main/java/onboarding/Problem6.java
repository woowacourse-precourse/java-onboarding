package onboarding;

import java.util.*;

public class Problem6 {
    // 1. solution에서 List<List<String>>을 map으로 만들기
    // 2. 두글자씩 잘라서 중복확인용 메소드
    // 3. 중복된 값 찾고 정렬해서 return 하는 메소드

    public static List<String> solution(List<List<String>> forms) {
        Map<String,String> mapFroms = new LinkedHashMap<>();

        for (int i =0; i<forms.size(); i++){
            mapFroms.put(forms.get(i).get(0), forms.get(i).get(1));
        }
        List<String> answer = duplicateCheck(mapFroms);
        return findduplicateWord(mapFroms, answer);
    }
    public static List<String> duplicateCheck(Map<String, String> map) { // 제이엠, 0 |제이슨, 0|.....
        int count = 1;
        String first = "";
        List<String> twowordList = new ArrayList<>();

        Set<String> checkSet = new LinkedHashSet<>();

        // 중복된 값찾고 해당값을 list에 넣기
        for (Map.Entry<String, String> pair : map.entrySet()) { // 제이엠 제이슨 워니 엠제이 이제엠
            String s = pair.getValue(); //제이엠

            if (count++ == 1) first = s;
            for (int i = 0; i < s.length() - 1; i++) { //제이 이엠 제이 이슨 워니 엠제 이제 제엠
                if (!checkSet.add(s.substring(i, i + 2))) {
                    if (i == 1) twowordList.add(first);

                    twowordList.add(s);
                }
            }
        }
        return twowordList;
    }

    public static List<String> findduplicateWord(Map<String, String> map, List<String> list){
        // 중복된 값에 해당하는 key 찾기
        List<String> emailList = new ArrayList<>();
        for (String key : map.keySet()) {
            String value = map.get(key);
            for(String ss : list) {
                if (value.equals(ss)) {emailList.add(key);}
            }

        }
        Collections.sort(emailList);

        return emailList;

    }



}
