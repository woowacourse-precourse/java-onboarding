package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 크루들의 닉네임 신청 폼 목록에 대하여 유효하지 않은 신청 폼을 검증하는 클래스
 * @author yoondgu
 *
 */
public class CrewFormValidator {
	private Map<String, List<Crew>> usedTwoWordsInfo;
	private Set<Crew> invalidCrews;
	
	public CrewFormValidator(List<Crew> crewForms) {
		initUsedTwoWordsInfo(crewForms);
		setInvalidCrews();
	}
	
	public Set<Crew> getInvalidCrews() {
		return invalidCrews;
	}
	
    private void initUsedTwoWordsInfo(List<Crew> crewForms) {
    	usedTwoWordsInfo = new HashMap<>();
    	for (Crew crew : crewForms) {
    		updateUsedTwoWordsInfo(crew); 
    	}
    }
    
    private void updateUsedTwoWordsInfo(Crew crew) {
		for (String twoWord : crew.getAllUsedTwoWordsByNickname()) {
			// twoWord가 result의 key로 이미 존재하면 리스트값을 가져오고, 존재하지 않으면 새 리스트를 생성한다.
			List<Crew> duplicatedCrews = (usedTwoWordsInfo.containsKey(twoWord)) ? usedTwoWordsInfo.get(twoWord) : new ArrayList<Crew>();
			duplicatedCrews.add(crew);
			usedTwoWordsInfo.put(twoWord, duplicatedCrews);
		}
    }
    
    private void setInvalidCrews() {
    	Set<Crew> invalidCrews = new HashSet<>();
    	for (String twoWord: usedTwoWordsInfo.keySet()) {
    		List<Crew> usingCrews = usedTwoWordsInfo.get(twoWord);
    		if (usingCrews.size() > 1) {
    			invalidCrews.addAll(usingCrews);
    		}
    	}
    	this.invalidCrews = invalidCrews;
    }
}
