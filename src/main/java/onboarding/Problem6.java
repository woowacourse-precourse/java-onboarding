package onboarding;

import java.util.*;

public class Problem6 {
    static Set<String> duplicateNames=new HashSet<>();

    public static boolean isDuplicated(int index,String curName, List<List<String>> forms){
        for(int i=0;i<forms.size();i++){
            if(index==i)
                continue;
            String name=forms.get(i).get(1);
            if(name.contains(curName))
                return true;
        }
        return false;
    }

    public static List<String> solution(List<List<String>> forms) {
        for(int i=0;i<forms.size();i++){
            String email=forms.get(i).get(0);
            String name=forms.get(i).get(1);
            for(int j=0;j<name.length()-1; j++){
                String partName=name.substring(j, j+2);

                if(isDuplicated(i, partName, forms))
                    duplicateNames.add(email);
            }
        }
        List<String> answer = new ArrayList<>(duplicateNames);

        Collections.sort(answer);

        return answer;
    }
}
