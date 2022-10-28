package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if(!(bookCheck(pobi)&&bookCheck(crong))){
            return -1;
        }
        int pobiMaxNumber = maxNumber(pobi);
        int crongMaxNumber = maxNumber(crong);
        int answer=-1;
        if(pobiMaxNumber>crongMaxNumber)answer=1;
        else if(pobiMaxNumber==crongMaxNumber)answer=0;
        else answer=2;
        return answer;
    }
    public static boolean bookCheck(List<Integer> book){
        if (book.get(0)==(book.get(1)-1)){
            return true;
        }
        return false;
    }
    public static int maxNumber(List<Integer> book){
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Integer integer : book) {
            String str=integer.toString();
            int total=0;
            for (int i = 0; i < str.length(); i++) {
                total+=(str.charAt(i)-'0');
            }
            arrayList.add(total);
            total=1;
            for (int i = 0; i <str.length() ; i++) {
                total*=(str.charAt(i)-'0');
            }
            arrayList.add(total);
        }
        return Collections.max(arrayList);
    }
}