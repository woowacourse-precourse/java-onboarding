package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(checkPageValidationException(pobi) || checkPageValidationException(crong)){
            answer = -1;
            return answer;
        }else if(checkPageSequenceException(pobi) || checkPageSequenceException(crong)){
            answer = -1;
            return answer;
        }else if(checkPagePositionException(pobi) || checkPagePositionException(crong)){
            answer = -1;
            return answer;
        }

        List<Integer> pobiNums = new ArrayList<>();
        List<Integer> crongNums = new ArrayList<>();
        for(int i = 0; i < 2; i++){
            pobiNums.add(plusDigits(pobi.get(i)));
            pobiNums.add(multiplyDigits(pobi.get(i)));

            crongNums.add(plusDigits(crong.get(i)));
            crongNums.add(multiplyDigits(crong.get(i)));
        }
        int pobiMax = max(pobiNums);
        int crongMax = max(crongNums);

        if(pobiMax > crongMax){
            answer = 1;
        }else if(pobiMax < crongMax){
            answer = 2;
        }else{
            answer = 0;
        }

        return answer;
    }

    private static int plusDigits(int number){
        int sum = 0;
        while(number > 0){
            sum += number%10;
            number /= 10;
        }
        return sum;
    }

    private static int multiplyDigits(int number){
        int sum = 1;
        while(number > 0){
            sum *= number%10;
            number /= 10;
        }
        return sum;
    }

    private static boolean checkPageValidationException(List<Integer> pages){
        for(int i = 0; i < pages.size(); i++){
            if(pages.get(i) < 1 || pages.get(i) > 400){
                return true;
            }
        }
        return false;
    }

    private static boolean checkPageSequenceException(List<Integer> pages){
        if(pages.get(0)+1 != pages.get(1)){
            return true;
        }
        return false;
    }

    private static boolean checkPagePositionException(List<Integer> pages){
        if(pages.get(0)%2 == 0 || pages.get(1)%2 == 1){
            return true;
        }
        return false;
    }

    private static int max(List<Integer> numbers){
        Collections.sort(numbers, Collections.reverseOrder());
        return numbers.get(0);
    }
}