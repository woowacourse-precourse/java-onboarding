package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        List<int[]> answer = check(cryptogram);
        return "answer";
    }


    //반복되는 문자 위치 + 갯수 찾기
    public static List<int[]> check(String cryptogram){
        int tmpCount = 0;
        List<int[]> result = new ArrayList<>();
        char tmp = cryptogram.charAt(cryptogram.length()-1);;
        int cnt = 0;
        for (int i=cryptogram.length()-2; i>=0; i--){

            if (tmp == cryptogram.charAt(i)){
                cnt += 1;
            }
            if (cnt !=0 && tmp!= cryptogram.charAt(i)) {
                result.add(new int[]{i+1, cnt + 1});
                System.out.println("Arrays.toString(result.get(0)) = " + Arrays.toString(result.get(tmpCount)));
                tmpCount++;
                cnt = 0;
            }
            tmp = cryptogram.charAt(i);

        }

        return result;
    }
}
