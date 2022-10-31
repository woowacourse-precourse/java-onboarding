package model;

import java.util.*;

public class Crew {
    private List<List<String>> forms;
    private HashMap<String, List<String>> duplicatedDic;

    public Crew(List<List<String>> forms) {
        this.forms = forms;
        this.duplicatedDic = new HashMap<>();
    }

    public List<String> alarm() {
        for (List<String> form : this.forms) {
            getSplitContinuousNicknameList(form.get(0), form.get(1));
        }
        return getDuplicateNicknameToList();
    }

    void getSplitContinuousNicknameList(String email, String nickname) {
        int interval = 2;
        int idx = 0;
        while (interval <= nickname.length()) {
            makeDuplicatedDictionary(nickname.substring(idx, interval + idx), email);
            idx++;
            if (interval + idx > nickname.length()) {
                idx = 0;
                interval++;
            }
        }
    }

    void makeDuplicatedDictionary(String split, String email) {
        List<String> list;
        if (duplicatedDic.containsKey(split)) {
            list = duplicatedDic.get(split);
        } else {
            list = new ArrayList<>();
        }
        list.add(email);
        duplicatedDic.put(split, list);
    }

    List<String> getDuplicateNicknameToList() {
        HashSet<String> hashSet = new HashSet<>();
        for (String s : duplicatedDic.keySet()) {
            List<String> emailList = duplicatedDic.get(s);
            if (emailList.size() >= 2) {
                for (String email : emailList) {
                    hashSet.add(email);
                }
            }
        }
        List<String> list = new ArrayList<>(hashSet);
        Collections.sort(list);
        return list;
    }
}
