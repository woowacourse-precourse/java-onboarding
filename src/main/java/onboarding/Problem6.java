package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        
        ArrayList<String> repeats = new ArrayList<>();
    
        ArrayList<String> names = new ArrayList<>();
    
        ArrayList<String> emails = new ArrayList<>();
        
        for(List<String> pairs : forms){
            for(String entries : pairs){
                if (entries.contains("@email.com")){
                    emails.add(entries);
                }
                else {
                    names.add(entries);
                }
            }
        }
        System.out.println(names);
        System.out.println(emails);
        
        for(int n = 1; n < names.size(); n++){
            String cname = names.get(n-1);
            for (int p = 1; p < cname.length(); p++){
                String compare = "" + cname.charAt(p-1) + cname.charAt(p);
                for (int l = n; l < names.size(); l++){
                    if (names.get(l).contains(compare)){
                        System.out.println(compare + l);
                        if(repeats.contains(emails.get(n-1)) == false){
                            repeats.add(emails.get(l));
                            repeats.add(emails.get(l-1));
                        }
                        if(repeats.contains(emails.get(l)) == false){
                            repeats.add(emails.get(l));
                        }
                    }
                }
            }
        }
        
        return repeats;
    }
}