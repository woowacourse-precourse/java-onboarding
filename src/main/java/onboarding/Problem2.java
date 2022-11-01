package onboarding;

import java.util.*;


public class Problem2 {
    public static String solution(String cryptogram) {
        List<String> letters = List.of(cryptogram.split(""));
        ArrayList<String> next_letters = new ArrayList<>();
        int cnt = -1;
        while(cnt != 0){
            cnt = 0;
            for(int i = 0; i < letters.size() ; i++){
                if(i==0){
                    if(!Objects.equals(letters.get(i), letters.get(i+1))){
                        next_letters.add(letters.get((i)));
                        continue;
                    }else{
                        cnt += 1;
                        continue;
                    }
                }
                if(i == letters.size()-1){
                    if(!Objects.equals(letters.get(i), letters.get((i-1)))){
                        next_letters.add(letters.get(i));
                        continue;
                    }else{
                        cnt += 1;
                        continue;
                    }
                }

                if(!Objects.equals(letters.get(i), letters.get(i-1)) && !Objects.equals(letters.get(i), letters.get(i+1))){
                    next_letters.add(letters.get(i));
                }else{
                    cnt += 1;
                }
            }
            letters = (List<String>) next_letters.clone();
            next_letters = new ArrayList<>();
        }
    return String.join("", letters);

    }
}
