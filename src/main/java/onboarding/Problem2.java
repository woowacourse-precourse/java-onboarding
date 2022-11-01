package onboarding;
import java.lang.String;
public class Problem2 {

    public static String solution(String cryptogram) {
        String answer = "";
        Problem2 p2 = new Problem2();
        //만약 초기 데이터가 더블이 아니면 바로 리턴
        if(p2.isDouble(cryptogram)){
            answer = p2.findAnswer(cryptogram);
        }
        return answer;
    }

    public String findAnswer(String cryptogram) {
        StringBuilder tempAnswer = new StringBuilder();
        boolean EndOfPairIsDouble = false;
        boolean pairIsDouble = false;
        int cryptogramArrlen = cryptogram.length()-1;

        for (int i = 0; i < cryptogramArrlen; i++) {
            pairIsDouble = (cryptogram.charAt(i) == cryptogram.charAt(i+1)); // 중복인지 체크

            //만약 중복이 아니면 정답 저장
            if (!pairIsDouble) {

                if(!EndOfPairIsDouble){ //저번쌍이 중복이 아니었으면 요번도 저장
                    tempAnswer.append(cryptogram.charAt(i));
                } else{  //저번쌍이 중복이었으면 이번턴은 지나가고 대신 다음에는 중복아니라고 신호주고 끝
                    EndOfPairIsDouble = false;
                }

            }else{ //만약 중복이면
                EndOfPairIsDouble = true;
            }
        }

        if(!pairIsDouble){ //범위 마지막 1개
            tempAnswer.append(cryptogram.charAt(cryptogramArrlen));
        }

        String whetherRecursion = tempAnswer.toString();
        if(isDouble(whetherRecursion)){
            return findAnswer(whetherRecursion);
        }else{
            return whetherRecursion;
        }
    }

    public boolean isDouble(String cryptogram) {
        for (int i = 0; i < cryptogram.length()-1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }



}
