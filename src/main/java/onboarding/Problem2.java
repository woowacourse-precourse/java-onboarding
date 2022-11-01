package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        while(true){
            List<int[]> removeList = check(answer);
            if (removeList.size() == 0){
                break;
            }
            answer = remove(removeList,answer);
            if (answer.length() ==0){
                break;
            }
        }
        return answer;
    }

    public static String remove(List<int[]> removeList,String cryptogram){
        StringBuffer stringBuffer = new StringBuffer(cryptogram);
        for (int i=0; i<removeList.size();i++){ //마지막 수 까지 반복되는 글자인 경우는 전부 삭제
            if (cryptogram.length() <= removeList.get(i)[1]){
                return "";
            }
            stringBuffer.delete(removeList.get(i)[0], removeList.get(i)[1]);
        }
        return stringBuffer.toString();
    }

    //반복되는 문자 위치 + 갯수 찾기
    public static List<int[]> check(String cryptogram){
        List<int[]> result = new ArrayList<>();
        char tmp = cryptogram.charAt(cryptogram.length()-1);;
        int cnt = 0;
        for (int i=cryptogram.length()-1; i>0; i--){
            if (tmp == cryptogram.charAt(i-1)){;
                cnt += 1;
            }
            if (cnt !=0 && tmp!= cryptogram.charAt(i-1)) {
                result.add(new int[]{i, i+cnt + 1});
                cnt = 0;
            } else if (cnt !=0 && i-1 ==0) { //중간에 문자가 끝나버린 경우
                result.add(new int[]{0, cnt+1 });
                break;
            }
            tmp = cryptogram.charAt(i-1);

        }

        return result;
    }
}
