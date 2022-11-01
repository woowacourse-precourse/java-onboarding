package onboarding;

import java.util.*;

public class Problem6 {
    static Map<String,String> maps = new HashMap<>();
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        fillToMap(forms);
        for(List<String> data : forms) {
            if(checkMap(data.get(1))){answer.add(data.get(0));}
        }
        Collections.sort(answer);
        return answer;
    }
    static boolean checkMap(String string){
        for(int i=0; i<string.length()-1;i++) {
            String check_name = "";
            check_name = check_name+ string.charAt(i) + string.charAt(i+1);
            if (maps.get(check_name).equals("duplicate")) {return true;}
        }
        return false;
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
