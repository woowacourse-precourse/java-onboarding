package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        String before = answer;

        while (true){
            before = answer;
            answer = delete_eq(answer);
            if (answer == "")
                break;
            else if (before == answer) {
                break;
            }
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
        for(int i=0;i<str_len-1;i++){
            if (cryptogram.charAt(i)==cryptogram.charAt(i+1) || (stand == cryptogram.charAt(i) && stand_location == i)){
                stand = cryptogram.charAt(i);
                stand_location = i+1;
            }else{
                new_cryptogram=new_cryptogram + cryptogram.charAt(i);
            }
        }
        return new_cryptogram;
    }
}
