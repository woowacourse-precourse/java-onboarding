package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        Integer temp1 = 0;
        Integer temp2 = 1;
        int check = 1;
        while(check != 0) {
            check = 0;
            for (int i = 0; i < cryptogram.length() -1; i++) {
                if (cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
                    cryptogram = MyDelete(cryptogram, i+1);
                    cryptogram = MyDelete(cryptogram, i);
                    answer = cryptogram;
                    check = 1;
                    break;
                }
                temp1++;
                temp2++;
            }
        }

        return answer;
    }

    public static String MyDelete(String str, int index){
        String result= "";
        for(int i = 0; i<index; i++){
            result += str.charAt(i);
        }
        for(int i = index +1; i<str.length(); i++){
            result += str.charAt(i);
        }
        return result;
    }
}