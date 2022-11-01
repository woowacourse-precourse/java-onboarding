package onboarding;

import java.util.*;

public class Problem6 {
    /**
     * 첫번째 글자를 key로 둔 해쉬맵을 반환한다.
     *
     * @param overallHash 첫번째 글자 해쉬맵을 가지고 있는 해쉬맵
     * @param firstLetter 첫번째 글자
     * @return 첫번째 글자를 key로 둔 해쉬맵
     * */
    private static HashMap<Character, HashSet<String>> hashOfFirstLetter(
            HashMap<Character, HashMap<Character, HashSet<String>>> overallHash, Character firstLetter
    ){
        if(!overallHash.containsKey(firstLetter))
            overallHash.put(firstLetter, new HashMap<Character, HashSet<String>>());
        return overallHash.get(firstLetter);
    }

    /**
     * 이메일을 담을 hashSet 반환
     *
     * @param firstHash 첫번째 글자 key로 반환 받은 해쉬맵
     * @param secondLetter 두번째 글자
     * @return 이메일을 넣을 해쉬셋
     * */
    private static HashSet<String> hashOfSecondLetter(
            HashMap<Character, HashSet<String>> firstHash, Character secondLetter
    ){
        if (!firstHash.containsKey(secondLetter))
            firstHash.put(secondLetter, new HashSet<String>());
        return firstHash.get(secondLetter);
    }

    /**
     * Crew의 닉네임을 쪼개어 2글자를 key, email을 value로 갖는 해쉬맵에 추가한다.
     *
     * @param crew 쪼갤 닉네임과 추가할 email을 가진 list
     * @param overallHash email을 추가할 해쉬맵
     * */
    private static void putEmailInHashMap(
            List<String> crew, HashMap<Character, HashMap<Character, HashSet<String>>> overallHash) {
        if (crew.size() < 2) {
            return;
        }
        String nickname = crew.get(1);
        String email = crew.get(0);

        for (int index = 0; index + 1 < nickname.length(); index++){
            Character firstLetter = nickname.charAt(index);
            Character secondLetter = nickname.charAt(index + 1);

            HashMap<Character, HashSet<String>> firstHash = hashOfFirstLetter(overallHash, firstLetter);
            HashSet<String> secondHash = hashOfSecondLetter(firstHash, secondLetter);
            secondHash.add(email);
        }
    }

    /**
     * set의 값을 resultSet에 추가한다. 넘겨줄 set의 크기가 1이하라면 수행하지 않는다.
     *
     * @param resultSet 값을 추가할 set
     * @param set 값을 넘겨줄 set
     * */
    private static void appendToSet(HashSet<String> resultSet, HashSet<String> set){
        if (set.size() <= 1)
            return;
        for (String email : set){
            resultSet.add(email);
        }
    }

    public static List<String> solution(List<List<String>> forms) {
        /**
         * 첫번째 글자를 key로 둔 해쉬맵의 value는 두번째 글자를 key로 둔 해쉬맵을 이루고 있다.
         * 두번째 글자를 key로 둔 해쉬맵의 value는 해쉬셋을 이루고 있다.
         * 이 해쉬셋은 첫번째 글자와 두번째 글자로 닉네임으로 이루는 email을 저장하고 있다.
         * "제이엠"일 경우 첫번째글자: '제' 두번째글자: '이', 첫번째글자: '이' 두번째글자 '엠'
         */
        HashMap<Character, HashMap<Character, HashSet<String>>> emailsOfLetters = new HashMap<>();

        for (List<String> crew : forms){
            putEmailInHashMap(crew, emailsOfLetters);
        }

        HashSet<String> resultSet = new HashSet<>();
        for (HashMap<Character, HashSet<String>> firstHash : emailsOfLetters.values()){
            for (HashSet<String> secondHash : firstHash.values()){
                appendToSet(resultSet, secondHash);
            }
        }
        ArrayList<String> result = new ArrayList<>(resultSet);
        Collections.sort(result);
        return result;
    }
}
