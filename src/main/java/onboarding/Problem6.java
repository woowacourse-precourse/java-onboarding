package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> name = new ArrayList<>();
        List<String> same = new ArrayList<>();
        List<String> isOverlap = new ArrayList<>();
        List<String> resultName = new ArrayList<>();
        List<String> result = new ArrayList<>();

        String temp="";
        int cnt = 0;

        for(int i=0; i<forms.size(); i++){
            name.add(forms.get(i).get(1));
        }

        // sameList value's len is more than 2
        for (int i = 0; i < name.size(); i++) {
            for (int j = 0; j < name.get(i).length()-1; j++) {
                for (int k = j+1; k < name.get(i).length(); k++) {
                    temp=name.get(i).substring(j,k+1);
                    if(!same.contains(temp)){
                        same.add(temp);
                    }
                }
            }
        }

        // remove the full nickname
        for (int i = 0; i < same.size(); i++) {
            for(int j = 0; j < name.size(); j++){
                if(same.get(i).equals(name.get(j))){
                    same.remove(i);
                }
            }
        }

        // add the name if there is duplication about samelist value
        for(int i = 0; i < same.size(); i++){
            cnt=0;
            for(int j = 0; j < name.size(); j++){
                if(name.get(j).contains(same.get(i))){
                    cnt++;
                    isOverlap.add(name.get(j));
                }
            }
            // cnt==1 means there is no duplication
            if(cnt==1){
                isOverlap.remove(isOverlap.size()-1);
            }
        }

        // remove duplicate value
        for (int i = 0; i < isOverlap.size(); i++) {
            if(!resultName.contains(isOverlap.get(i))){
                resultName.add(isOverlap.get(i));
            }
        }

        // add the email in the resultList
        for(int i=0; i < forms.size(); i++){
            for(int j=0; j < resultName.size(); j++){
                if(forms.get(i).get(1).equals(resultName.get(j))){
                    result.add(forms.get(i).get(0));
                }
            }
        }
        // sort in ascending order
        for(int i=0; i<result.size(); i++){
            for(int j=0; j<result.size(); j++){
                if(result.get(i).compareTo(result.get(j))<0){
                    temp=result.get(i);
                    result.set(i,result.get(j));
                    result.set(j,temp);
                }

            }
        }

        return result;
    }
}
