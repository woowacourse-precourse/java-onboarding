package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> result = new ArrayList<String>();
        HashMap<String, Boolean> over_map = new HashMap();
        HashMap<String,String> map = new HashMap();
        for(int i=0; i<forms.size();i++){
            map.put((forms.get(i)).get(0),(forms.get(i)).get(1));
        }
        for(String key : map.keySet()){
            over_map.put(key, false);
        }
        for(String name : map.values()){

            for(int i=0; i<name.length()-1;i++){
                String sub = name.substring(i,i+2);
                for(int j=0; j<forms.size(); j++){
                    if(!name.equals((forms.get(j)).get(1)) && check(forms.get(j),sub)){
                        over_map.replace((forms.get(j)).get(0),true);
                    }
                }
            }
        }
        for(int i=0;i<forms.size();i++){
            if(over_map.get(forms.get(i).get(0))){
                result.add(forms.get(i).get(0));
            }
        }
        result.sort(Comparator.naturalOrder());
        return result;
    }
    public static boolean check(List<String> list, String name){
        if(list.get(1).contains(name)){
            return true;
        }
        else return false;
    }
}
