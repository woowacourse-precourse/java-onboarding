package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        ArrayList<String> answer_names = new ArrayList<>();
        ArrayList<String> answer = new ArrayList<>();

        ArrayList<ArrayList<String>> name_partitions = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        for(List<String> person : forms){
            String name = person.get(1);
            names.add(name);
            ArrayList<String> p = new ArrayList<>();
            for(int i=0;i<name.length()-1;i++){
                String tmp = name.substring(i,i+2);
                p.add(tmp);
            }
            name_partitions.add(p);
        }
        for(int i=0;i<name_partitions.size();i++){
            ArrayList<String> cnp = name_partitions.get(i);
            for(int j=i+1;j<name_partitions.size();j++){
                ArrayList<String> nnp = name_partitions.get(j);
                for(int c=0; c<cnp.size(); c++){
                    String cp = cnp.get(c);
                    boolean chk = false;
                    for(int n=0; n<nnp.size(); n++){
                        String np = nnp.get(n);
                        if(cp.equals(np)){
                            answer_names.add(names.get(i));
                            answer_names.add(names.get(j));
                            chk = true;
                            break;
                        }
                    }
                    if(chk) break;
                }
            }
        }
        Set<String> set = new HashSet<>(answer_names);
        ArrayList<String> lst = new ArrayList<>(set);
        for(int i=0;i<forms.size();i++){
            if(lst.contains(forms.get(i).get(1))){
                answer.add(forms.get(i).get(0));
            }
        }
        Collections.sort(answer);
        return answer;
    }
}
