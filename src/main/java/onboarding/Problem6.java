package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        HashSet<String> emails = new HashSet<>();
        List<String> nameList = new ArrayList<>();

        //이름을 2글자로 나눈 리스트 생성
        for (int i = 0; i < forms.size(); i++) {
            nameList = MakeTwoWordList(nameList, forms.get(i).get(1));
        }

        //이름이 중복되는지 체크
        for (int i = 0; i < forms.size(); i++) {
            Boolean check = CheckReduplication(nameList, forms.get(i).get(1));
            //중복되면 값 추가
            if (check) {
                emails.add(forms.get(i).get(0));
            }
        }

        answer = SetToArray(emails);
        return answer;
    }

    public static List<String> SetToArray(HashSet<String> set){
        return set.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    //이름을 2글자로 나눠서 리스트에 저장
    public static List<String> MakeTwoWordList(List<String> nameList, String name) {
        for (int j = 0; j < name.length() - 1; j++) {
            String key = name.substring(j, j+2);
            nameList.add(key);
        }
        return nameList;
    }

    //중복되는지 체크
    public static Boolean CheckReduplication(List<String> nameList, String name){
        for (int j = 0; j < name.length() - 1; j++) {
            String key = name.substring(j, j+2);
            if (Collections.frequency(nameList, key) >= 2) {
                return true;
            }
        }
        return false;
    }
}
