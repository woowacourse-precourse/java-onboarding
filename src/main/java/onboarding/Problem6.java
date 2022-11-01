package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        for (int i = 0; i < forms.size(); i++) {
            String nickname = forms.get(i).get(1);

            map = findDuplicateNickname(nickname, forms, map);
        }

        return answer;
    }

    private static HashMap<String, ArrayList<String>> findDuplicateNickname(String nickname, List<List<String>> forms, HashMap<String, ArrayList<String>> map) {
        for (int i = 0; i < nickname.length() - 1; i++) {
            String partialNickname = getPartialNicknameToValidate(i, nickname);

            if (isAlreadyChecked(map, partialNickname))
                continue;

            map = duplicateCheck(forms, partialNickname, map);

            map = removeNoDuplicateNicknameFromMap(map, partialNickname);
        }

        return map;
    }

    private static String getPartialNicknameToValidate(int idx, String nickname) {
        StringBuilder sb = new StringBuilder();

        for (int i = idx; i < idx + 2; i++) {
            sb.append(nickname.charAt(i));
        }

        String partialNicknameToValidate = sb.toString();
        return partialNicknameToValidate;
    }

    private static boolean isAlreadyChecked(HashMap<String, ArrayList<String>> map, String partialNickname) {
        if (map.containsKey(partialNickname))
            return true;
        return false;
    }

    private static HashMap<String, ArrayList<String>> duplicateCheck(List<List<String>> forms, String partialNickname, HashMap<String, ArrayList<String>> map) {
        ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < forms.size(); i++) {
            String email = forms.get(i).get(0);
            String nickname = forms.get(i).get(1);

            if (nickname.contains(partialNickname)) {
                map = addNicknameAndEmailIntoMap(map, list, partialNickname, email);
            }
        }

        return map;
    }

    private static HashMap<String, ArrayList<String>> addNicknameAndEmailIntoMap(HashMap<String, ArrayList<String>> map, ArrayList<String> list, String partialNickname, String email) {
        if (map.containsKey(partialNickname)) {
            list = map.get(partialNickname);
            list.add(email);
            map.put(partialNickname, list);

            return map;
        }

        if (!map.containsKey(partialNickname)) {
            list.add(email);
            map.put(partialNickname, list);
        }
        return map;
    }

    private static HashMap<String, ArrayList<String>> removeNoDuplicateNicknameFromMap(HashMap<String, ArrayList<String>> map, String partialNickname) {
        if (map.get(partialNickname).size() == 1) {
            map.remove(partialNickname);
        }

        return map;
    }
}
