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
        ArrayList<String> arr = new ArrayList<>();

        for (List<String> i : forms) {
            hashMap.put(i.get(1), i.get(0)); // 해시에 키와 값을 넣어줌
            arr.add(i.get(1)); // 리스트에 닉네임 담기
        }

        String prev = "";
        String next = "";
        int cnt = -1;
        boolean canCal = false;

        for (int i = 0; i < arr.size(); i++) {
            if(cnt+1 < arr.get(i).length()){
                cnt++;
                canCal = false;
            } else continue;

            // 비교 대상 명단의 두 글자
            prev += arr.get(i).charAt(cnt);
            prev += arr.get(i).charAt(cnt+1);

            for (int j = i+1; j < arr.size(); j++) {
                if (cnt+1 >= arr.get(j).length()) {
                    continue;
                }
                else {
                    canCal = true;
                    // 다음 명단의 두 글자
                    next += arr.get(j).charAt(cnt);
                    next += arr.get(j).charAt(cnt+1);

                    if (prev.equals(next)) {
                        String inputNext = arr.get(j);
                        answer.add(hashMap.get(inputNext));
                    }
                    next = "";
                }
            }

            prev = "";

            if(canCal==false) break; // 순환할 수 있는 배열 원소가 없음
        }

        hashMap.entrySet().stream() // hashmap을 스트림을 이용해 정렬, add완료 후 마다 정렬
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));

        return answer;
    }
}
