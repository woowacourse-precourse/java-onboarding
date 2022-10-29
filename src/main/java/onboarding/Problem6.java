package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import onboarding.vo.Crew;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
    	HashSet<String> answerSet = new HashSet<>();
        List<Crew> crews = getCrewList(forms);
        // 두 글자 문자열에 대한 크루 정보를 이용하여, 사용불가한 닉네임을 가진 크루의 이메일을 answer에 저장한다.
        HashMap<String, List<Crew>> twoWordMap = getTwoWordMapByCrews(crews);
        for (String twoWord : twoWordMap.keySet()) {
        	List<Crew> duplicatedCrews = twoWordMap.get(twoWord);
        	if (duplicatedCrews.size() > 1) {
        		for (Crew crew : duplicatedCrews) {
        			answerSet.add(crew.getEmail());
        		}
        	}
        }
        return new ArrayList<>(answerSet);
    }

    /**
     * 신청목록(forms)을 신청한 크루 정보를 표현하는 vo객체에 대한 리스트로 바꾸어 반환한다.
     * @param forms
     * @return Crew 타입의 ArrayList
     */
    private static List<Crew> getCrewList(List<List<String>> forms) {
    	List<Crew> crews = new ArrayList<>();
        for (List<String> form : forms) {
        	crews.add(new Crew(form.get(0), form.get(1)));
        }
        return crews;
    }
    
    /**
     * 주어진 복수 개의 닉네임에 대하여 구성된 모든 두 글자 문자열에 대한 정보를 반환한다.
     * @param crews
     * @return key값이 두 글자 문자열, value값이 해당 문자열이 중복된 크루 리스트인 HashMap
     */
    private static HashMap<String, List<Crew>> getTwoWordMapByCrews(List<Crew> crews) {
    	HashMap<String, List<Crew>> twoWordMap = new HashMap<>();
    	for (Crew crew : crews) {
    		// 해당 닉네임의 모든 twoWord에 대해 result 정보 갱신
    		for (String twoWord : crew.getAllUsedTwoWordsByNickname()) {
    			// twoWord가 result의 key로 이미 존재하면 리스트값을 가져오고, 존재하지 않으면 새 리스트를 생성한다.
    			List<Crew> duplicatedCrews = (twoWordMap.containsKey(twoWord)) ? twoWordMap.get(twoWord) : new ArrayList<Crew>();
    			duplicatedCrews.add(crew);
    			twoWordMap.put(twoWord, duplicatedCrews);
    		}
    	}
    	return twoWordMap;
    }
}
