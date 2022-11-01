package onboarding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem6 {

    List<List<String>> forms = new ArrayList<>();
    Map<String, String> map = new HashMap<String, String>();
    Set<String> result = new HashSet<>();
    public static List<String> solution(List<List<String>> forms) {
        Problem6 p6 = new Problem6();
        p6.forms = forms;
        p6.iterate();
        return p6.sortingSet();
    }

    private void iterate(){
        for(List<String> form : forms){
            searchNickName(form.get(0), form.get(1));
        }
    }

    private void searchNickName(String email, String nickName){
        for(int i = 0; i < nickName.length()-1; i++){
            String substring = nickName.substring(i, i + 2);
            whetherExisted(email, substring);
        }
    }

    private void whetherExisted(String email, String subStr){
        if(!map.containsKey(subStr)) map.put(subStr, email);
        else{
            result.add(email);
            result.add(map.get(subStr));
        }
    }

    private ArrayList<String> sortingSet(){
        return result.stream().sorted().collect(Collectors.toCollection(ArrayList::new));
    }
}
