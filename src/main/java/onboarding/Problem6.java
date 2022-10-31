package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = getDuplicatedCrewEmails(forms);
        return answer;
    }

    /**
     * 같은 글자가 연속적으로 포함된 지원자의 이메일 목록을 정렬해서 반환
     * @param forms : 지원자들의 이메일,닉네임 리스트
     * @return 같은 글자가 연속적으로 포함된 지원자들의 정렬된 이메일 목록
     */
    private static List<String> getDuplicatedCrewEmails(List<List<String>> forms){

        // 닉네임 리스트에서 같은 글자가 연속적으로 포함된 인덱스로 이메일 리스트를 만듦
        Set<String> duplicatedEmailSet = getDuplicatedEmailSet(forms);
        List<String> emailList = new ArrayList<>();
        duplicatedEmailSet.forEach((email)->{
            emailList.add(email);
        });

        // 이메일 리스트를 정렬
        sortEmailList(emailList);

        return emailList;
    }

    /**
     * 이름 목록 중 같은 글자가 연속적으로 포함된 이름의 인덱스 집합을 반환
     * @param forms : 같은 글자가 연속적으로 포함되어있는지 확인할 폼 목록
     * @return 같은 글자가 연속적으로 포함된 이름의 인덱스 집합
     */
    private static Set<String> getDuplicatedEmailSet(List<List<String>> forms){
        // 연속글자가 포함된 닉네임들의 인덱스 집합
        Set<String> result = new HashSet<>();
        // 2개의 문자(charSet)를 키로 갖고, 해당 문자열을 갖는 닉네임의 이메일 집합을 value로 갖는 hashMap
        // "key: 닉네임이 가진 2글자문자(charSet)의 해시코드"="value: 해당 charSet을 가진 email"
        Map<Integer, Set<String>> charSetEmailMap = new HashMap<>();
        // CharSetEmail map에 데이터를 담아줌
        for(List<String> form : forms){
            putCharSet(form, charSetEmailMap);
        }
        // hashMap에서 2개의 문자가 여러 이메일에서 발견될 경우 결과 집합에 추가
        charSetEmailMap.forEach((strKey, setValue) -> {
            if(setValue.size() >= 2){
                result.addAll(setValue);
            }
        });

        return result;
    }

    /**
     * 주어진 닉네임을 2글자씩 분해하여 해당 문자열을 갖는 닉네임의 인덱스 집합을 charSetCountMap에 할당
     * @param form : 이메일과 닉네임 정보가 담긴 리스트
     * @param charSetEmailMap : "닉네임이 가진 2글자문자(charSet)의 해시코드":"해당 charSet을 가진 email"를 할당할 Map
     */
    private static void putCharSet(List<String> form, Map<Integer, Set<String>> charSetEmailMap){
        // form을 분해 할당
        String nickname = form.get(1);
        String email = form.get(0);
        // 2개의 문자별로 charSet을 만들어 charSetEmailMap에 할당
        for(int node = 0; node < nickname.length() -1; node++){
            // 문자를 2개씩 쪼개어 charSet생성
            String charSet = nickname.substring(node, node+2);
            //검색 속도 향상을 위해 hashCode를 키로 갖도록 함
            int charSetHashCode = charSet.hashCode();

            if(charSetEmailMap.containsKey(charSetHashCode)){
                // 이미 검사해본 charSet일 경우 기존 charSet에 이메일 추가함
                charSetEmailMap.get(charSetHashCode).add(email);
            } else {
                // 새로운 charSet일 경우 새로운 set을 만들고 인덱스를 추가함
                Set<String> emailSet = new HashSet<>();
                emailSet.add(email);
                charSetEmailMap.put(charSetHashCode,emailSet);
            }
        }
    }

    /**
     * 이메일 리스트를 도메인을 제외한 부분으로 오름차순 정렬
     * @param emailList 정렬할 이메일 리스트
     */
    private static void sortEmailList(List<String> emailList){
        // inline Comparator
        Collections.sort(emailList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //도메인 부분을 빼고 정렬
                return o1.split("@")[0].compareTo(o2.split("@")[0]);
            }
        });
    }
}
