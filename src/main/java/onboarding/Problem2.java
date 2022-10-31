package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        String before = " ";

        /**
         * 중복을 다 제거할 때까지 반복
         */
        while (!answer.equals("") && !before.equals(answer)){
            before = answer;
            answer = delete_eq(answer);
        }
        return answer;
    }

    /**
     * 연속된 문자를 지워주는 함수
     */
    private static String delete_eq(String cryptogram){
        int str_len = cryptogram.length();
        char stand = ' ';
        int stand_location = -1;
        String new_cryptogram = "";
        for(int i=0;i<str_len;i++){
            if ( ((i!=str_len-1) && cryptogram.charAt(i)==cryptogram.charAt(i+1)) || (stand == cryptogram.charAt(i) && stand_location == i)){
                stand = cryptogram.charAt(i);
                stand_location = i+1;
            }else{
                new_cryptogram=new_cryptogram + cryptogram.charAt(i);
            }
        }
        return new_cryptogram;
    }
}
