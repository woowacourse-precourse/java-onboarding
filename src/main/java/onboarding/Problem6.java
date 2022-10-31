package onboarding;

import java.util.*;

public class Problem6 {
    static Map<String,String> maps = new HashMap<>();
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        fillToMap(forms);
        return answer;
    }
    static void fillToMap(List<List<String>> forms){
        for(List<String> data : forms) {fillToSet(data.get(1));}
    }
    static void fillToSet(String name){
        Set<String> set = new HashSet<>();
        for(int i=0; i< name.length()-1;i++){
            String check_name = "" ;
            check_name = check_name + name.charAt(i)+name.charAt(i+1);
            set.add(check_name);
        }
        for(String string : set){
            if(maps.get(string) == null){maps.put(string,"1");}
            else if(maps.get(string) == "1"){maps.put(string,"duplicate");}
        }
    }
}
