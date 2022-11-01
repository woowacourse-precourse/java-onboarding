package onboarding;


public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        String tmp = "";

        boolean check = false;
        while (true){
            tmp = "";
            for (int i = 0; i < cryptogram.length()-1; i++){
                String strNow = cryptogram.substring(i, i+1);
                String strNext = cryptogram.substring(i+1, i+2);

                if (strNow.equals(strNext)){      // 다음 글자와 같으면
                    check = true;
                } else if (check == true){  // 이전 글자와 같으면
                    check = false;
                } else {
                    tmp += strNow;
                }
            }

            if (check == false && cryptogram.length() != 0){     // 전 글자와 같고 길이가 0이 아니면
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















