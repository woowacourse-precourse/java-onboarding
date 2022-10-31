package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {

    public static void decompose(String nickName, HashMap<String, List<String>> overlap) {
        int cutLength = 2;

        for (int j = 0; j <= nickName.length() - cutLength; j++) {
            String subNickName = nickName.substring(j, j + cutLength);

            if (overlap.containsKey(subNickName)) { // 이미 키가 존재하는 경우, List 에다가 닉네임만 추가해주면 된다.
                List<String> getList = overlap.get(subNickName);
                getList.add(nickName);
                overlap.put(subNickName, getList);
            } else {
                List<String> addList = new ArrayList<>();
                addList.add(nickName);
                overlap.put(subNickName, addList);
            }
        }
    }

    public static List<String> solve(List<List<String>> forms) {
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, List<String>> overlap = new HashMap<>();

        for (int i = 0; i < forms.size(); i++) {
            List<String> info = forms.get(i);

            map.put(info.get(1), info.get(0)); // NickName -> Email
        }

        for (int i = 0; i < forms.size(); i++) {
            List<String> info = forms.get(i);

            String nickName = info.get(1);
            // 닉네임 분해하면서, HashMap 에다가 담아줄 것임
            decompose(nickName, overlap);
        }

        HashSet<String> emailList = new HashSet<>();

        for (String key : overlap.keySet()) {
            List<String> getList = overlap.get(key);
            if (getList.size() >= 2) {
                for (String nickName : getList) {
                    emailList.add(map.get(nickName));
                }
            }
        }

        return emailList.stream().collect(Collectors.toList());
    }

    public static List<String> solution(List<List<String>> forms) {
        return solve(forms);
    }
}
