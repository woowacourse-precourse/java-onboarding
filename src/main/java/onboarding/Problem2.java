package onboarding;

import java.util.*;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        String[] crptoArray = cryptogram.split("");
        List<String> crptoList =  Arrays.asList(crptoArray);

        int nowCrptoNum = crptoList.size() + 1;
        int newCrptoNum = crptoList.size();

        while(nowCrptoNum != newCrptoNum){

            nowCrptoNum = newCrptoNum;

            int[] check = new int[nowCrptoNum];

            String prev = "";
            int idx = 0;
            for(String crpto : crptoList){
                if( Objects.equals(prev, crpto) ){
                    check[idx] ++;
                    check[idx-1] ++;
                }
                prev = crpto;
                idx ++;
            }

            List<String> temp = new ArrayList<>();
            for(int i = 0; i < nowCrptoNum; i++){
                if(check[i] == 0){
                    temp.add(crptoList.get(i));
                }
            }

            crptoList = temp;
            newCrptoNum = crptoList.size();
        }

        for(String crpto : crptoList){
            answer += crpto;
        }

        return answer;
    }
}
