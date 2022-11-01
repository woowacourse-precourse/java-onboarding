package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class Problem2 {
    public static String solution(String cryptogram) {
        String answer;
//      입력값을 한 글자씩 배열에 넣는다.
        String[] cryptoArray = cryptogram.split("");
//      배열 형식을 ArrayList 형식으로 변환
        List<String> cryptoList = new ArrayList<>(Arrays.asList(cryptoArray));
//      리스트에서 조건에 맞게 반복문 설정
        for(int i=0;i<cryptoList.size()-1;i++){
            if((cryptoList.get(i)).equals(cryptoList.get(i+1))){
                cryptoList.subList(i,i+2).clear();
//              첫 중복문자만 삭제하고 반복문이 끝나는 결과를 얻었다.
//              그러므로 i의 값을 -1로 설정해 반복문이 다시 시작되도록 설정한다.
                i = -1;
            }
        }
//      ArrayList를 다시 배열 형태로 변환
        cryptoArray = cryptoList.toArray(new String[0]);
//      배열 형태를 String 값으로 합치기 및 변환
        answer = String.join("",cryptoArray);
        return answer;
    }
}
