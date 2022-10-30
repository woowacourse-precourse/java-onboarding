package onboarding;

import java.util.List;

public class Problem2 {
    public static String deleteRepeation(String crypt){
        StringBuilder deleteCrypt = new StringBuilder();;
        if (crypt.equals("")) return "";
        deleteCrypt.append(crypt.charAt(0));
        int i = 0;
        while(i<crypt.length()-1){

            if(crypt.charAt(i) == crypt.charAt(i+1))
            {
                if (deleteCrypt.charAt(deleteCrypt.length()-1) == crypt.charAt(i))
                {
                    deleteCrypt.delete(deleteCrypt.length()-1,deleteCrypt.length());
                }
                i += 1;
                continue;
            }

            deleteCrypt.append(crypt.charAt(i+1));
            i += 1;
        }

        return deleteCrypt.toString();

    }


    public static String solution(String cryptogram) {
        String answer = "answer";
        String deleteCrypt  = deleteRepeation(cryptogram);
        while(true)
        {
            if(deleteCrypt.equals(cryptogram)) break;
            cryptogram = deleteCrypt;
            deleteCrypt = deleteRepeation(cryptogram);
        }
        answer = cryptogram;
        return answer;
    }


}
