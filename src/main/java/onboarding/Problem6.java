package onboarding;

import java.util.*;

public class Problem6 {
        public static List<String> solution(List<List<String>> forms) {

            List<String> result = new ArrayList<>();
            HashMap<String, Integer> setOfTwoLengthWordsAndIndex = new HashMap<>();
            Set<Integer> willBeRemovedNickNameIndex = new HashSet<>();

            for(int idx=0; idx<forms.size(); idx++) {
                String nickName = forms.get(idx).get(1);
                for (int j=0; j<nickName.length()-1; j++) {
                    String subString = nickName.substring(j, j+2);

                    boolean isAlreadyInHashMap = setOfTwoLengthWordsAndIndex.containsKey(subString);
                    if (isAlreadyInHashMap) {
                        Integer existingIndex = setOfTwoLengthWordsAndIndex.get(subString);
                        if (existingIndex != idx) {
                            willBeRemovedNickNameIndex.add(idx);
                            willBeRemovedNickNameIndex.add(setOfTwoLengthWordsAndIndex.get(subString));
                        }
                    } else {
                        setOfTwoLengthWordsAndIndex.put(subString, idx);
                    }
                }
            }

            for(Integer removedIdx : willBeRemovedNickNameIndex) {
                String shouldBeRemovedEmail = forms.get(removedIdx).get(0);
                if (result.contains(shouldBeRemovedEmail)) {
                    continue;
                }
                result.add(shouldBeRemovedEmail);
            }

            Collections.sort(result);

            return result;
        }
}
