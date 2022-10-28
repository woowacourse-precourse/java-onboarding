package onboarding;
import java.lang.String;
public class Problem2 {

    public static String solution(String cryptogram) {
        String answer = "";
        return answer;
    }

    public static String findAnswer(String cryptogram) {
        StringBuilder tempAnswer = new StringBuilder();
        boolean noticeDoubleToEnd = false;
        boolean checkPairDouble = false;
        int cryptogramArrlen = cryptogram.length()-1;

        for (int i = 0; i < cryptogramArrlen; i++) {
            checkPairDouble = (cryptogram.charAt(i) == cryptogram.charAt(i+1)); // 중복인지 체크

            //만약 중복이 아니면 정답 저장
            if (!checkPairDouble) {

                if(!noticeDoubleToEnd){ //저번쌍이 중복이 아니었으면 요번도 저장
                    tempAnswer.append(cryptogram.charAt(i));
                } else{  //저번쌍이 중복이었으면 이번턴은 지나가고 대신 다음에는 중복아니라고 신호주고 끝
                    noticeDoubleToEnd = false;
                }

            }else{ //만약 중복이면
                noticeDoubleToEnd = true;
            }
        }

        if(!checkPairDouble){ //범위 마지막 1개
            System.out.println("store>"+ (cryptogramArrlen)+" : "+cryptogram.charAt(cryptogramArrlen));
        }

        return tempAnswer.toString();
    }

    public static boolean checkDouble(String cryptogram) {
        for (int i = 0; i < cryptogram.length()-1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }



}
