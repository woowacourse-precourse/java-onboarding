package onboarding;

import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        while(true){
//버블소트로 확인하기
            int cryptogramLen = cryptogram.length();
            char[] cryptogramList = new char[cryptogramLen];
            int breakCheak = cryptogram.length();
    //입력받은 문자열을 배열에 한글자씩 저장
            for (int i = 0; i < cryptogram.length(); i++) {
                cryptogramList[i] = cryptogram.charAt(i);
            }
    //두개의 문자가 같고 그게 공백이 아니라면 공백으로 치환
            for (int i = 1; i < cryptogramList.length; i++) {
                if (cryptogramList[i - 1] == cryptogramList[i] && cryptogramList[i] != ' ') {
                    cryptogramList[i] = ' ';
                    cryptogramList[i - 1] = ' ';
                }
            }
            String temp = new String();
            for (int i = 0; i < cryptogramList.length; i++) {
                if (cryptogramList[i] != ' ') {
                    temp = temp + cryptogramList[i];
                }
            }
            cryptogram = temp;
            cryptogramLen = 0;
            for (int i = 0; i < cryptogramList.length; i++) {
                if (cryptogramList[i] != ' ') {
                    cryptogramLen++;
                }
            }
            if(cryptogramLen == breakCheak){
                answer = cryptogram;
                break;
            }
        }
        return answer;
    }
}
