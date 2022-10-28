package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer;

        if(bookGame(pobi) == -1 || bookGame(crong) == -1){
            answer = -1;
        }
        else if(bookGame(pobi) < bookGame(crong)){
            answer = 2;
        }
        else if(bookGame(pobi) > bookGame(crong)){
            answer = 1;
        }
        else{
            answer = 0;
        }

        return answer;
    }

    public static int bookGame(List<Integer> palyer){

        List<Integer> bookPages = new ArrayList<>();
        int result = 0;


        if(palyer.get(1) - palyer.get(0) != 1){
            return -1;
        }
        if(palyer.get(0) < 1 || palyer.get(1) > 400){
            return -1;
        }


        for(int i = 0; i < palyer.size(); i++){

            int page = palyer.get(i);
            int sum = 0;
            int mul = 1;

            while (page > 0){
                bookPages.add(page%10);
                page /= 10;
            }


            for(int j = 0; j < bookPages.size(); j++){
                sum += bookPages.get(j);
                mul *= bookPages.get(j);
            }

            if(result <= Integer.max(sum,mul)){
                result = Integer.max(sum,mul);
            }
            bookPages.clear();

        }

        return result;

    }
}