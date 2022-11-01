package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {

    List<List<String>> forms = new ArrayList<>();
    Map<String, String> map = new HashMap<String, String>();
    public static List<String> solution(List<List<String>> forms) {
        Problem6 p6 = new Problem6();
        p6.forms = forms;
        p6.iterate();
        return null;
    }

    private void iterate(){
        for(List<String> form : forms){
            searchNickName(form.get(0), form.get(1));
        }
    }

    private void searchNickName(String email, String nickName){
        for(int i = 0; i < nickName.length()-1; i++){
            String substring = nickName.substring(i, i + 1);
            if(!map.containsKey(substring)) map.put(substring, email);
        }
    }
}
