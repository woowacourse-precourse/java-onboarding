package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    /*
    포인터로 찍고 연속적으로 중복인것들 제거하고 지운 다음
    직전 index로 포인터로 다시 옮겨 재탐색
     */
    public static String solution(String cryptogram) {
        int pointer = 0 ;
        //Array.asList 로 생성한 리스트는 고정되어 있어 원소를 제거 할 수 없다고 한다.
        List<String> charList = new ArrayList<>(Arrays.asList(cryptogram.split("")));
        while (pointer>=0 && pointer < charList.size()-1){
            String now = charList.get(pointer);
            if(!now.equals(charList.get(pointer+1))){
                pointer += 1 ;
            }else {
                charList.remove(pointer);
                charList.remove(pointer);
                pointer -= 1;
            }
        }
        return String.join("",charList);
    }

}
