package onboarding;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        String tmp = "";

        int check = 1;
        while (true){
            tmp = "";
            for (int i = 0; i < cryptogram.length()-1; i++){
                String str = cryptogram.substring(i, i+1);
                String strAfter = cryptogram.substring(i+1, i+2);

                if (str.equals(strAfter)){     // 이후 글자와 같으면
                    check = 0;
                } else if (check == 0){
                    check = 1;
                } else {
                    tmp += str;
                }
            }

            if (check == 1 && cryptogram.length() != 0){     // 전 글자와 같고 길이가 0이 아니면
                tmp += cryptogram.substring(cryptogram.length()-1, cryptogram.length());    // 마지막 글자
            }

            if (tmp.equals(cryptogram)){
                break;
            } else{
                cryptogram = tmp;
            }
        }

        answer = cryptogram;

        return answer;
    }


}


