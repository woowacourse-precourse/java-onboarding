package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return new ArrayList<>(answer);
    }
    
    /**
     * 주어진 닉네임을 이루는 모든 두 글자 문자열을 반환한다.
     * @param nickname
     * @return 중복 없는 모든 두 글자 문자열
     */
    private static HashSet<String> getAllTwoWordsByNickname(String nickname) {
    	HashSet<String> twoWords = new HashSet<>();
    	for (int i = 0; i < nickname.length()-1; i++) {
    		twoWords.add(nickname.substring(i, i+2));
    	}
    	return twoWords;
    }
    
    /**
     * 주어진 복수 개의 닉네임에 대하여 구성된 모든 두 글자 문자열에 대한 정보를 반환한다.
     * @param nicknames
     * @return key값이 두 글자 문자열, value값이 해당 문자열을 닉네임에 사용한 사용자의 인덱스 리스트인 HashMap
     */
    private static HashMap<String, List<Integer>> getUserIdxMapByTwoWords(List<String> nicknames) {
    	HashMap<String, List<Integer>> result = new HashMap<>();
    	for (int i = 0; i < nicknames.size(); i++) {
    		String nickname = nicknames.get(i);
    		HashSet<String> twoWords = getAllTwoWordsByNickname(nickname);
    		// 해당 닉네임의 모든 twoWord에 대해 result 정보 갱신
    		for (String twoWord : twoWords) {
    			// twoWord가 result의 key로 이미 존재하면 리스트값을 가져오고, 존재하지 않으면 새 리스트를 생성한다.
    			List<Integer> userIdx = (result.containsKey(twoWord)) ? result.get(twoWord) : new ArrayList<Integer>();
    			// TODO 리스트에 현재 인덱스를 담는다. => user 정보를 담는 것으로 수정할 것
    			userIdx.add(i);
    			result.put(twoWord, userIdx);
    		}
    	}
    	return result;
    }
}
