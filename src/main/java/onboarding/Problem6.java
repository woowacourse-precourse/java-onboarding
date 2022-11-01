package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        if(input_exception(forms)) return List.of("input error");
//        List<String> answer = List.of("");
//        System.out.println(forms.get(0).get(0));
        List<String> answer=getList(forms);
        return List.of("true");
    }

    private static List<String> getList(List<List<String>> forms){
        List<String> result=getOverlap(forms);
        Collections.sort(result);
        return result;
    }

    private static List<String> getOverlap(List<List<String>> forms){
        List<String> nickname= new ArrayList<>();
        HashSet<String> overlapList=new HashSet<>();
        List<String> result=new ArrayList<>();
        for(int i=0;i<forms.size();i++){
            nickname.add(forms.get(i).get(1));
        }
        for(int i=0;i<nickname.size()-1;i++){
            for(int j=i+1;j<nickname.size();j++){
                if(isOverlap(nickname.get(i),nickname.get(j))){
                    overlapList.add(forms.get(i).get(0));
                    overlapList.add(forms.get(j).get(0));
                }
            }
        }
        Iterator<String> iter=overlapList.iterator();
        while(iter.hasNext()){
            result.add(iter.next());
        }
        return result;
    }

    private static boolean isOverlap(String fomrer,String latter){

    }

    private static boolean input_exception(List<List<String>> forms){
        //true is 'exception excution'
        return false;
    }
}
