package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();

        //전체 문자열 저장
        HashSet<String> splitStrList = new HashSet<String>();

        List<String> overlapStrList = new ArrayList<String>();;

        for(List<String> formsData : forms){
            for(int i=0; i<formsData.get(1).length()-1; i++){
                if(splitStrList.contains(formsData.get(1).substring(i, i+2))){
                    overlapStrList.add(formsData.get(1).substring(i, i+2));
                    continue;
                }
                splitStrList.add(formsData.get(1).substring(i, i+2));
            }
        }

        for(List<String> formsData : forms){
            for(int i=0; i<formsData.get(1).length()-1; i++){
                if(overlapStrList.contains(formsData.get(1).substring(i, i+2))){
                    answer.add(formsData.get(0));
                    break;
                }
            }
        }

        answer = answer.stream().sorted().collect(Collectors.toList());

        return answer;
    }
}
