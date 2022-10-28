package onboarding;

import java.util.List;

public class Problem2 {
    public static String deleteRepeation(String crypt){
        String deleteCrypt = crypt;

        int i = 0;
        StringBuilder temp = new StringBuilder();
        while(i<deleteCrypt.length()){
            if((i+2) < deleteCrypt.length() && deleteCrypt.charAt(i) == deleteCrypt.charAt(i+1))
            {
                i += 2;
                continue;
            }
            temp.append(deleteCrypt.charAt(i));
            i += 1;
        }
        deleteCrypt = temp.toString();
        return deleteCrypt;

    }


    public static String solution(String cryptogram) {
        String answer = "answer";

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(deleteRepeation("browoon"	));
    }
}
