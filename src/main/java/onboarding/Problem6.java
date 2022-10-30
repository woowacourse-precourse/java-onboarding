package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    /**
     * 같은 글자가 연속적으로 포함된 지원자의 이메일 목록을 정렬해서 반환
     * @param forms : 지원자들의 이메일,닉네임 리스트
     * @return 같은 글자가 연속적으로 포함된 지원자들의 정렬된 이메일 목록
     */
    private static List<String> getDuplicatedCrewEmails(List<List<String>> forms){
        // 제출 폼 중 닉네임만 추출한 리스트를 만듦
        List<String> nicknameList = new ArrayList<>();
        for(List<String> form : forms){
            nicknameList.add(form.get(1));
        }

        // 닉네임 리스트에서 같은 글자가 연속적으로 포함된 인덱스로 이메일 리스트를 만듦
        Set<Integer> duplicatedIndexSet = getDuplicatedIndexSet(nicknameList);
        List<String> emailList = new ArrayList<>();
        duplicatedIndexSet.forEach((index)->{
            emailList.add(forms.get(index).get(0));
        });

        // 이메일 리스트를 정렬
        sortEmailList(emailList);

        return emailList;
    }

    /**
     * 이름 목록 중 같은 글자가 연속적으로 포함된 이름의 인덱스 집합을 반환
     * @param nicknameList : 같은 글자가 연속적으로 포함되어있는지 확인할 닉네임 목록
     * @return 같은 글자가 연속적으로 포함된 이름의 인덱스 집합
     */
    private static Set<Integer> getDuplicatedIndexSet(List<String> nicknameList){
        // 연속글자가 포함된 닉네임들의 인덱스 집합
        Set<Integer> result = new HashSet<>();
        // 2개의 문자(charSet)를 키로 갖고, 해당 문자열을 갖는 닉네임의 인덱스 집합을 value로 갖는 hashMap
        Map<String, Set<Integer>> charSetCountMap = new HashMap<>();
        // 닉네임 별로 charSet을 분석하여 hashMap에 할당
        int index = 0;
        for(String nickname : nicknameList){
            putCharSet(index, nickname, charSetCountMap);
            index ++;
        }
        // hashMap에서 2개의 문자가 여러 인덱스에서 발견될 경우 결과 집합에 추가
        charSetCountMap.forEach((strKey, setValue) -> {
            System.out.println(strKey + " : " + setValue);
            if(setValue.size() >= 2){
                result.addAll(setValue);
            }
        });

        return result;
    }

    /**
     * 주어진 닉네임을 2글자씩 분해하여 해당 문자열을 갖는 닉네임의 인덱스 집합을 charSetCountMap에 할당
     * @param index : 주어진 닉네임의 인덱스
     * @param nickname : 주어진 닉네임
     * @param charSetCountMap : "닉네임이 가진 2글자문자(charSet)":"인덱스"를 할당할 Map
     */
    private static void putCharSet(int index, String nickname, Map<String, Set<Integer>> charSetCountMap){
        // 2개의 문자별로 charSet을 만들어 charSetCountMap에 할당
        for(int node = 0; node < nickname.length() -1; node++){
            String charSet = nickname.substring(node, node+2);
            if(charSetCountMap.containsKey(charSet)){
                // 이미 검사해본 charSet일 경우 기존 charSet에 인덱스를 추가함
                charSetCountMap.get(charSet).add(index);
            } else {
                // 새로운 charSet일 경우 새로운 set을 만들고 인덱스를 추가함
                Set<Integer> indexSet = new HashSet<>();
                indexSet.add(index);
                charSetCountMap.put(charSet,indexSet);
            }
        }
    }

    /**
     * 이메일 리스트를 도메인을 제외한 부분으로 정렬
     * @param emailList 정렬할 이메일 리스트
     */
    private static void sortEmailList(List<String> emailList){

    }
}
