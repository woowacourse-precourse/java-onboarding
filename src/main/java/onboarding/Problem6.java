package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> nameList = new ArrayList<>();
        List<String> sameList = new ArrayList<>();
        List<String> result = new ArrayList<>();

        String temp="";
        int cnt = 0;

        for(int i=0; i<forms.size(); i++){
            nameList.add(forms.get(i).get(1));
        }

        // sameList value's len is more than 2
        for (int i = 0; i < nameList.size(); i++) {
            for (int j = 0; j < nameList.get(i).length()-1; j++) {
                for (int k = j+1; k < nameList.get(i).length(); k++) {
                    temp=nameList.get(i).substring(j,k+1);
                    if(!sameList.contains(temp)){
                        sameList.add(temp);
                    }
                }
            }
        }

        // remove the full nickname
        for (int i = 0; i < sameList.size(); i++) {
            for(int j = 0; j < nameList.size(); j++){
                if(sameList.get(i).equals(nameList.get(j))){
                    sameList.remove(i);
                }
            }
        }

        return result;
    }
}
