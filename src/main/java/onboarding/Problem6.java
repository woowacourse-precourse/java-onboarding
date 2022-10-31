package onboarding;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class Problem6 {
    private static final int UTF_8_KOR_BYTE = 3;
    public static List<String> solution(List<List<String>> forms) {

        Map<String, List<String>> categorizedMap = categorizeEmailByPossibleContinuous2WordOfNickName(forms);

        Set<String> duplicatedEmailOfNickName = getDuplicateNickNameSet(categorizedMap);

        List<String> answer = getDeduplicateAndAscendingList(duplicatedEmailOfNickName);

        return answer;
    }

    private static Map<String, List<String>>
        categorizeEmailByPossibleContinuous2WordOfNickName (List<List<String>> forms){

        Map<String, List<String>> map = new HashMap<>();

        for(List<String> list:forms){
            String currentEmail = list.get(0);
            String currentNickName = list.get(1);

            int currentOffset = 0;
            // tokenize and add email
            // map key로 nickname을 차례로 잘라 만들 수 있는 두 글자, value에는 email list 추가
            // key ex) 안녕하세요 -> 안녕, 녕하, 하세, 세요
            while(currentOffset < currentNickName.getBytes(StandardCharsets.UTF_8).length - UTF_8_KOR_BYTE){

                // 두 글자 생성
                String possibleKorean2Word = new String(currentNickName.getBytes(), currentOffset, UTF_8_KOR_BYTE * 2);

                if(map.containsKey(possibleKorean2Word)){
                    List<String> newList = new ArrayList<>();

                    newList.addAll(map.get(possibleKorean2Word));
                    newList.add(currentEmail);

                    map.replace(possibleKorean2Word,newList);
                } else{
                    map.put(possibleKorean2Word,Arrays.asList(currentEmail));
                }
                currentOffset += UTF_8_KOR_BYTE;
            }

        }
        return map;
    }

    private static Set<String> getDuplicateNickNameSet(Map<String, List<String>> map) {
        Set<String> duplicatedEmailOfNickName = new HashSet<>();

        for( String strKey : map.keySet() ){
            List<String> emailList = map.get(strKey);
            if(emailList.size()>1) {
                duplicatedEmailOfNickName.addAll(emailList);
            }
        }
        return duplicatedEmailOfNickName;
    }

    private static List<String> getDeduplicateAndAscendingList(Set<String> duplicatedEmailOfNickName) {
        List<String> setToList = new ArrayList<>(duplicatedEmailOfNickName);

        Collections.sort(setToList);

        return setToList;
    }
}
