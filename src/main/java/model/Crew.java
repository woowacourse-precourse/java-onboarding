package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Crew {
    private List<List<String>> forms;
    private HashMap<String, List<String>> test;

    public Crew(List<List<String>> forms){
        this.forms = forms;
        this.test = new HashMap<>();
    }

    public List<String> alarm(){
        for (List<String> form: this.forms) {
            getSplitContinuousNicknameList(form.get(0), form.get(1));
        }
        return getDuplicateNicknameToList();
    }

    void getSplitContinuousNicknameList(String email, String nickname){
        int interval = 2;
        int idx = 0;
        while(interval <= nickname.length()){
            makeDuplicatedDictionary(nickname.substring(idx,interval+idx), email);
            idx++;
            if (interval+idx > nickname.length()){
                idx = 0;
                interval++;
            }
        }
    }

    void makeDuplicatedDictionary(String split, String email){
        List<String> list;
        if (test.containsKey(split)){
            list = test.get(split);
        } else{
            list = new ArrayList<>();
        }
        list.add(email);
        test.put(split, list);
    }

    List<String> getDuplicateNicknameToList(){
        HashSet<String> hashSet = new HashSet<>();
        for (String s: test.keySet()) {
            List<String> emailList = test.get(s);
            if(emailList.size() >= 2){
                for (String email: emailList) {
                    hashSet.add(email);
                }
            }
        }
        return new ArrayList<>(hashSet);
    }
}
