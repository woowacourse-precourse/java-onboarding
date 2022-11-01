package onboarding;

import java.util.*;

public class Problem6 {
    // 1. solution에서 List<List<String>>을 map으로 만들기
    // 2. 두글자씩 잘라서 중복확인용 메소드
    // 3. 중복된 값 찾고 정렬해서 return 하는 메소드

    public static List<String> solution(List<List<String>> forms) {

        if(!constraints(forms)){return Collections.EMPTY_LIST;}
        Map<String,String> mapFroms = new LinkedHashMap<>();
        for (int i =0; i<forms.size(); i++){
            mapFroms.put(forms.get(i).get(0), forms.get(i).get(1));
        }
        List<String> answer = duplicateCheck(mapFroms);
        List<String> result = findduplicateWord(mapFroms, answer);
        //print(forms,result);
        return result;
    }
//    public static  void print(List<List<String>> forms, List<String> result) {
//        System.out.println("| forms | result |");
//        System.out.println("| --- | --- |");
//        System.out.println("| "+forms+" | "+result+" | ");
//    }
    public static boolean constraints(List<List<String>> forms){ // 제한사항
        if(forms.size()<1 || forms.size() >10000) {System.out.println("크루가 1미만 혹은 10000초과 입니다."); return false;}
        for(int i =0; i<forms.size();i++) {
            if (!forms.get(i).get(0).contains("email.com")) {
                System.out.println("이메일 형식이 올바르지 않습니다"); return false;
            }
            if(forms.get(i).get(1).length() <1 || forms.get(i).get(1).length()>20){
                System.out.println("닉네임의 형식이 올바르지 않습니다"); return false;
            }
            if(forms.get(i).get(1).equals(forms.get(i).get(1).toUpperCase())){
                System.out.println("영문이 포함된 닉네임입니다.");return false;
            }

        }
        return true;

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
