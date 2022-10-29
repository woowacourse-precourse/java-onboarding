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
public class FormValidator {
	private Map<String, List<Form>> usedTwoWordsInfo;
	private Set<Form> invalidForms;
	
	public FormValidator(List<Form> forms) {
		initUsedTwoWordsInfo(forms);
		setInvalidForms();
	}
	
	public Set<Form> getInvalidForms() {
		return invalidForms;
	}
	
    private void initUsedTwoWordsInfo(List<Form> forms) {
    	usedTwoWordsInfo = new HashMap<>();
    	for (Form form : forms) {
    		updateUsedTwoWordsInfo(form); 
    	}
    }
    
    private void updateUsedTwoWordsInfo(Form form) {
		for (String twoWord : form.getAllUsedTwoWordsByNickname()) {
			// twoWord가 result의 key로 이미 존재하면 리스트값을 가져오고, 존재하지 않으면 새 리스트를 생성한다.
			List<Form> duplicatedForms = (usedTwoWordsInfo.containsKey(twoWord)) ? usedTwoWordsInfo.get(twoWord) : new ArrayList<Form>();
			duplicatedForms.add(form);
			usedTwoWordsInfo.put(twoWord, duplicatedForms);
		}
    }
    
    private void setInvalidForms() {
    	Set<Form> invalidForms = new HashSet<>();
    	for (String twoWord: usedTwoWordsInfo.keySet()) {
    		List<Form> usingForms = usedTwoWordsInfo.get(twoWord);
    		if (usingForms.size() > 1) {
    			invalidForms.addAll(usingForms);
    		}
    	}
    	this.invalidForms = invalidForms;
    }
}
