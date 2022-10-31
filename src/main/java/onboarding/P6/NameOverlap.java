package onboarding.P6;

import java.util.*;
import java.util.stream.Collectors;

public class NameOverlap {

    public static List<String> OverlapResult(List<List<String>> forms) {
        NameSplit(forms);
        List<String> nameoverlapresult = NameOverlap();
        return EmailSort(nameoverlapresult);
    }
    private static Map<String, List<String>> map1 = new HashMap<>();

    private static void NameSplit(List<List<String>> name){
        for(List<String>form : name){
            String username = form.get(1);
            for(int i=0; i < username.length()-1; i++){
                String splitword = username.substring(i, i+2);                     //닉네임을 2개씩 쪼개기

                List<String> list = map1.getOrDefault(splitword, new ArrayList<>()); // (쪼갠문자열들getordefault = 찾는키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본값을 반환하는 매서드
                list.add(form.get(0));
                map1.put(splitword, list);                                           // {쪼갠문자열들=[이메일], 쪼갠문자열들=[이메일,이메일]}

            }
        }

    }
    private static List<String> NameOverlap(){
        return map1.values().stream()
                .filter(list -> list.size() >=2)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    } // stream=> 데이터의 흐름 flatmap => 평면화, collection::stream => 데이터들을 컬렉션 자료구조로 만들기 , coolect는 stream의 데이터를 변형등의 처리를 하고 원하는 자료형으로 변환

    private static List<String> EmailSort(List<String> overlapemail){
        return overlapemail.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        // distinct => 스트림에서 중복되는 요소들을 제거하고 새로운 스트림을 반환
    }
}
