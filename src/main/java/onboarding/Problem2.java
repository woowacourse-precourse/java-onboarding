package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        while (true){
            List<Integer> temp = new ArrayList<>();
            Boolean check = false;
            for (int i=0; i<cryptogram.length()-1;i++){
                if (check){
                    if (cryptogram.charAt(i)==cryptogram.charAt(i+1)){
                        temp.add(i);
                    }
                    else{
                        temp.add(i);
                        break;
                    }
                }else {
                    if (cryptogram.charAt(i)==cryptogram.charAt(i+1)){
                        temp.add(i);
                        if (cryptogram.length()-1 == i+1)
                            temp.add(i + 1);
                        check=true;
                    }
                }
            }
            if (!check)
                break;
            if (!temp.isEmpty()){
                String s1 = cryptogram.substring(0,temp.get(0));
                String s2 = cryptogram.substring(temp.get(temp.size() - 1)+1, cryptogram.length());
                cryptogram=s1+s2;
            }
        }
        answer= cryptogram;
        return answer;
    }

}
