package onboarding;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class Problem6 {
    private static final int UTF_8_KOR_BYTE = 3;
    public static List<String> solution(List<List<String>> forms) {

        Map<String, List<String>> categorizedMap =
                categorizeEmailByPossibleContinuous2WordOfNickName(forms);

        Set<String> duplicatedEmailOfNickName = getDuplicateNickNameSet(categorizedMap);

        List<String> answer = getDeduplicateAndAscendingList(duplicatedEmailOfNickName);

        return answer;
    }

    /**
     *
     *  Nickname에 같은 글자가 연속적으로 포함된 email을 골라내기 위한 전처리 작업을 진행하는 method. <br/><br/>
     *
     *
     *  map key로 nickname을 차례로 잘라 만들 수 있는 두 글자, value에는 email list 추가<br/>
     *  - key ex) 안녕하세요 -> 안녕, 녕하, 하세, 세요<br/>
     *  - 한글은 3bytes로 취급
     * @param forms 이메일과 닉네임이 담긴 nested list
     * @return nickname을 잘라 만들 수 있는 모든 두 글자를 key, 해당 nickname에 해당하는 email list를 value로 한 map
     */
    private static Map<String, List<String>>
        categorizeEmailByPossibleContinuous2WordOfNickName (List<List<String>> forms){

        Map<String, List<String>> map = new HashMap<>();

        for(List<String> list:forms){
            String currentEmail = list.get(0);
            String currentNickName = list.get(1);

            int currentOffset = 0;

            while(currentOffset <
                    currentNickName.getBytes(StandardCharsets.UTF_8).length - UTF_8_KOR_BYTE){

                // Current offset을 참조하여 두 글자 생성
                String possibleKorean2Word =
                        new String(currentNickName.getBytes(), currentOffset, UTF_8_KOR_BYTE * 2);

                if(map.containsKey(possibleKorean2Word)) { // 이미 key에 해당 단어가 있는 경우
                    List<String> newList = new ArrayList<>();

                    newList.addAll(map.get(possibleKorean2Word));
                    newList.add(currentEmail);

                    map.replace(possibleKorean2Word, newList);
                } else { // 해당 key가 없는 경우
                    map.put(possibleKorean2Word, Arrays.asList(currentEmail));
                }
                currentOffset += UTF_8_KOR_BYTE;
            }

        }
        return map;
    }

    /**
     *
     * Nickname에 같은 글자가 연속적으로 포함된 email을 골라내는 method. <br/><br/>
     *
     *
     * Value에 두 개 이상의 email이 들어있는 email을 추출, set을 통해 중복 제거
     * @param map
     * @return nickname에 같은 글자가 연속적으로 포함된 email set
     */
    private static Set<String> getDuplicateNickNameSet(Map<String, List<String>> map) {
        Set<String> duplicatedEmailOfNickName = new HashSet<>();

        for( String strKey : map.keySet() ){
            List<String> emailList = map.get(strKey);

            if(emailList.size() > 1) {
                duplicatedEmailOfNickName.addAll(emailList);
            }
        }
        return duplicatedEmailOfNickName;
    }

    /**
     *
     * 오름차순으로 정렬 된 email list을 만드는 method. <br/><br/>
     *
     * Set을 list로 바꾼 후 오름차순으로 정렬
     * @param duplicatedEmailOfNickName
     * @return 오름차순으로 정렬 된 email list
     */
    private static List<String> getDeduplicateAndAscendingList(Set<String> duplicatedEmailOfNickName) {
        List<String> setToList = new ArrayList<>(duplicatedEmailOfNickName);

        Collections.sort(setToList);

        return setToList;
    }
}
