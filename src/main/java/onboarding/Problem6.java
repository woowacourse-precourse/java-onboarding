package onboarding;

import java.util.*;

public class Problem6 {
    /**
     - 목표:
     닉네임 중 같은 글자가 연속적으로 포함된 경우 지원자의 이메일 목록을 리턴

     - 제한사항:
     1) 두 글자 이상의 문자가 연속적으로 순서에 맞춰 포함되있는 경우
     2) 1~10,000
     3) 이메일 형식에 부합하며, 11~20자
     4) email.com 이메일만 가능
     5) 닉네임은 한글만 가능
     6) 이메일에 해당하는 부분의 문자열을 오름차순으로 정렬하고 중복 제거

     - 해결 방법:
     1) 리스트를 해시맵으로 저장
     2) 중복 체크해 해당 부분 해시맵2로 저장
     3) 해시맵2를 스트림을 활용해 정렬

     **/
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        HashMap<String, String> hashMap = new HashMap<>();
        HashMap<String, String> hashMap2 = new HashMap<>();

        for (List<String> i : forms) {
            System.out.println("input: "+i.get(0) + " " + i.get(1));
            hashMap.put(i.get(0), i.get(1)); // 해시에 키와 값을 넣어줌

        }
        String prev = " ";
        String next = " ";
        ArrayList<String> arr = new ArrayList<>();
        for (String key : hashMap.keySet()) {
            String s = hashMap.get(key);
            arr.add(s);
        }

        /**
         - 해결 해야 하는 부분 :
         1) 두 문자열을 반복해서 비교해 다음 해쉬 값과 비교하고
         2) 입력
         **/




        hashMap.entrySet().stream() // hashmap을 스트림을 이용해 정렬
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));

        return answer;
    }
}
