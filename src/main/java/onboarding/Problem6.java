package onboarding;

import java.util.*;

public class Problem6 {
    // 두 글자씩 잘라서 nicknameMap에 두글자-이메일리스트 로 저장
    private static HashMap<String, List<String>> getWordMap(List<List<String>> forms) {
        HashMap<String, List<String>> wordMap = new HashMap<>();
        for (int i = 0; i < forms.size(); i++) {
            for (int j = 0; j < forms.get(i).get(1).length() - 1; j++) {
                String tmp = forms.get(i).get(1).substring(j, j + 2);
                List<String> emailList = wordMap.get(tmp);
                if (emailList == null) {
                    emailList = new ArrayList<>();
                    emailList.add(forms.get(i).get(0));
                    wordMap.put(tmp, emailList);
                }
                else {
                    emailList.add(forms.get(i).get(0));
                    wordMap.put(tmp, emailList);
                }
            }
        }
        return wordMap;
    }

    // 이메일리스트의 요소의 수가 1개보다 많은 것만 뽑음
    private static Set<String> getResultSet(HashMap<String, List<String>> wordMap) {
        Set<String> resultSet = new HashSet<>();
        for(String key : wordMap.keySet()) {
            List<String> emailList = wordMap.get(key);
            if (emailList.size() > 1) {
                for (String email : emailList)
                    resultSet.add(email);
            }
        }
        return resultSet;
    }

    public static List<String> solution(List<List<String>> forms) {
        HashMap<String, List<String>> wordMap = getWordMap(forms);
        
        // 정렬
        List<String> resultList = new ArrayList<>(getResultSet(wordMap));
        Collections.sort(resultList);
        
        return resultList;
    }
}
