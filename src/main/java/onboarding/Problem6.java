package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();
        HashMap<String, List<String>> nickNameChecker = new HashMap<>();

        for (int formsIterator = 0; formsIterator < forms.size(); formsIterator++){
            String nickName = forms.get(formsIterator).get(1);
            String email = forms.get(formsIterator).get(0);
            for (int startIdx = 0; startIdx < nickName.length(); startIdx++){
                for(int endIdx = startIdx + 1; endIdx < nickName.length(); endIdx++){
                    String namePart = nickName.substring(startIdx, endIdx + 1);
                    if (!nickNameChecker.containsKey(namePart)){
                        nickNameChecker.put(namePart, new ArrayList<String>());
                        nickNameChecker.get(namePart).add(email);
                    }
                    else if (nickNameChecker.get(namePart).isEmpty() || !nickNameChecker.get(namePart).contains(email)) {
                        nickNameChecker.get(namePart).add(email);
                    }
                }
            }
        }

        nickNameChecker.forEach((key, valueList) -> {
            if(valueList.size() > 1){
                valueList.forEach(email -> {
                    if(answer.isEmpty() || !answer.contains(email)) answer.add(email);
                });
            }
        });

        Collections.sort(answer);

        return answer;
    }
}
