package onboarding.problem6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NicknameDuplicationManage {
    private List<List<String>> forms;
    private HashMap<String, Set<String>> nickNameMap = new HashMap<>();

    public NicknameDuplicationManage(List<List<String>> forms){
        this.forms = forms;
    }

    private void saveSubstringNickname(){
        for(List<String> form : forms){
            String email = form.get(0);
            String nickName = form.get(1);

            if(nickName.length() >= 2){
                for(int endIdx = 2; endIdx <= nickName.length(); endIdx++){
                    int startIdx = 0;
                    while(startIdx + endIdx <= nickName.length()){
                        String nameSubstring = nickName.substring(startIdx, startIdx + endIdx);
                        if(nickNameMap.containsKey(nameSubstring)){
                            Set<String> emailSet = nickNameMap.get(nameSubstring);
                            emailSet.add(email);
                        }
                        else{
                            Set<String> emailSet = new HashSet<>();
                            emailSet.add(email);
                            nickNameMap.put(nameSubstring, emailSet);
                        }
                        startIdx++;
                    }
                }
            }
        }
    }
    
}
