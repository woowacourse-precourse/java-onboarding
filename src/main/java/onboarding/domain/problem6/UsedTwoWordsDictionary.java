package onboarding.domain.problem6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * Problem number : 6
 * Comment : 복수 개의 신청폼 닉네임에 사용된 모든 "연속된 2글자 문자열"에 대한 정보를 제공한다.
 * @author doyoung
 */
public class UsedTwoWordsDictionary {
    private final Map<String, List<Form>> usedTwoWordsDictionary = new HashMap<>();

    public UsedTwoWordsDictionary(List<Form> forms) {
        initDictionary(forms);
    }

    private void initDictionary(List<Form> forms) {
        for (Form form : forms) {
            updateDictionary(form);
        }
    }

    private void updateDictionary(Form form) {
        for (String twoWord : form.getAllUsedTwoWordsByNickname()) {
            List<Form> usingForms = (usedTwoWordsDictionary.containsKey(twoWord)) ?
                    usedTwoWordsDictionary.get(twoWord) : new ArrayList<Form>();
            usingForms.add(form);
            usedTwoWordsDictionary.put(twoWord, usingForms);
        }
    }
    
    public Set<String> getAllUsedTwoWords() {
        return usedTwoWordsDictionary.keySet();
    }
    
    public List<Form> getFormsByTwoWords(String twoWords) {
        return usedTwoWordsDictionary.get(twoWords);
    }
}
