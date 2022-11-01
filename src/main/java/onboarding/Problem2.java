package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        for(int ii=0;ii<cryptogram.length();ii++){
            char curr = cryptogram.charAt(0);
            int currint = 0;
            int check = 1;
            for (int i = 1; i < cryptogram.length(); i++) {

                if (curr == cryptogram.charAt(i)) {// 중복 발생 경우
                    check++;

                    //
                }else if (check >1) {// 중복이 아닐경우 browoanoommnaonbrowoanmmnaon
                    cryptogram = cryptogram.substring(0, currint) + cryptogram.substring(currint + check, cryptogram.length());
                    curr = cryptogram.charAt(i-check);
                    currint = i-check;
                    check = 1;

                } else {
                    curr = cryptogram.charAt(i);
                    currint = i;
                    check = 1;

                }

            }
        }

        if(cryptogram.charAt(0)==cryptogram.charAt(1)){
            return "";

        }


        answer = cryptogram;

        return answer;
    }
}
