package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem6 {

    public static List<String> solution(List<List<String>> info) {
        List<String> answer = new ArrayList<>();
        for(int i=0; i<info.size()-1; i++){
            //중복되는 문자열 확인하기 위한 비교 문자열
            String s ="";
            s += info.get(i).get(1).charAt(0);

            //비교 문자열의 길이가 2인 것 부터 시작
            for(int j=1; j<info.get(i).get(1).length(); j++){
                s += info.get(i).get(1).charAt(j);
                //만들어진 비교 문자열을 주어진 사람들 이름과 비교해서 비교 문자열이 포함되어 있는지 확인
                for(int k=i+1; k<info.size(); k++){
                    if(info.get(k).get(1).contains(s)){
                        answer.add(info.get(i).get(0));
                        answer.add(info.get(k).get(0));
                    }
                }
            }
        }
        //중복을 제거하고 정렬 해줌
        answer = answer.stream().distinct().sorted().collect(Collectors.toList());
        return answer;
    }
}
