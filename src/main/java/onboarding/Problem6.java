package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = emailSetToResultList(forms);
        return answer;
    }

    public static List<String> emailSetToResultList(List<List<String>> forms) {

        Map<String, ArrayList<Integer>> userMap = getUserMap(forms);
        Set<String> emailSet = getEmailSet(forms, userMap);

        ArrayList<String> result = new ArrayList<>(emailSet);
        Collections.sort(result);

        return result;
    }

    public static Map<String, ArrayList<Integer>> getUserMap(List<List<String>> forms){
        Map<String, ArrayList<Integer>> userMap = new HashMap<>();
        int idx = 0;

        for (List<String> user : forms) {
            String userName = user.get(1);
            int userNameLength = userName.length();
            idx++;

            for (int i = 0; i < userNameLength - 1; i++) {
                String subUserName = userName.substring(i, i + 2);
                ArrayList<Integer> list = new ArrayList<>();

                if (userMap.containsKey(subUserName)) {
                    list = userMap.get(subUserName);
                    list.add(idx);
                } else {
                    list.add(idx);
                }

                userMap.put(subUserName, list);
            }
        }

        return userMap;
    }

    public static Set<String> getEmailSet(List<List<String>> forms, Map<String, ArrayList<Integer>> userMap){
        Set<String> emailSet = new HashSet<>();

        for (String key : userMap.keySet()) {
            ArrayList<Integer> userMapValue = userMap.get(key);
            if (userMapValue.size() == 1) {
                continue;
            }
            for (Integer data : userMapValue) {
                emailSet.add(forms.get(data - 1).get(0));
            }
        }

        return emailSet;
    }
}
