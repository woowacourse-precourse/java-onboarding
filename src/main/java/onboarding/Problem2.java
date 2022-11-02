package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem2 {

    public static String solution(String cryptogram) {
        String answer = "answer";

        answer = decoding(cryptogram);

        return answer;
    }

    public static String decoding(String cryptogram){
        List<Integer> overlapIndexList = new ArrayList<Integer>();

        List<String> singleCryptogramList = new ArrayList<String>(List.of(cryptogram.split("")));

        for(int i=1; i<singleCryptogramList.size(); i++){

            if(singleCryptogramList.get(i).equals(singleCryptogramList.get(i-1))){
                // 이전 문자열과 일치한다면 index저장
                overlapIndexList.add(i);
                overlapIndexList.add(i-1);
            }
        }
        // 암호문 재설정
        cryptogram = "";

        for(int i=0; i < singleCryptogramList.size(); i++){
            if(!overlapIndexList.contains(i)){
                cryptogram += singleCryptogramList.get(i);
            }
        }

        if(overlapIndexList.size() > 0){
            return decoding(cryptogram);
        }else{
            return cryptogram;
        }
    }

}
