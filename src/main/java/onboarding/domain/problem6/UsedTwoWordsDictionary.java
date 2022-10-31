package onboarding.domain.problem6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
