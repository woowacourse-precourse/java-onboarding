package onboarding;

import java.util.*;

public class Problem6 {
    static boolean Check_Error(List<String> list){
        String name = list.get(1);
        int name_length = name.length();
        String email = list.get(0);

        if(name_length < 0 || name_length > 20) return false;

        if(!email.contains("email.com")) return false;

        if(email.length() > 20 || email.length() <11) return false;


        return true;
    }
    static List<String> Cut_The_Name(String name){
        List<String> cut_name = new ArrayList<String>();
        for(int i = 0 ; i < name.length() -1; i++){
            cut_name.add(name.substring(i , i+2 ));
        }
        return cut_name;
    }

    static Set<String> Extract_Email(List<String> cut_name , Set<String> same , List<List<String>> list , int i){
        List<String> temp;
        String temp_name;
        for(int j = 0 ; j < list.size(); j++){
            if( j == i) continue;
            for(Iterator<String > name = cut_name.iterator();name.hasNext();){
                temp = list.get(j);
                temp_name = temp.get(1);
                if(temp_name.contains(name.next())){
                    if(Check_Error(temp)){
                        same.add(temp.get(0));
                    }
                }
            }
        }
        return same;
    }
    static Set<String> Find_Same(List<List<String>> list){
        List<String> cut_name;
        Set<String > same = new HashSet<String>();
        List<String> info;
        for (int i = 0 ; i < list.size() ; i++){
            info = list.get(i);
            if(Check_Error(info)) {
                cut_name = Cut_The_Name(info.get(1));
                same = Extract_Email(cut_name, same, list, i);
            }
        }
        return same;
    }

    static List<String> StoL(Set<String> before){
        List<String> after = new ArrayList<>();
        for(Iterator<String> i = before.iterator() ; i.hasNext() ;){
            after.add(i.next());
        }
        after.sort(Comparator.naturalOrder());
        return  after;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = StoL(Find_Same(forms));

        return answer;
    }
}
