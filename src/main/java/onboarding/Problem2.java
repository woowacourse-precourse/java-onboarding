package onboarding;

public class Problem2 {

    public static String decipher(String ciphertext){
        String answer = "";
        int len = ciphertext.length(), count = 0;

        for (int i =0; i < len; i++ ){
            if ( i == len-1 ){
                answer += ciphertext.charAt(i);
                continue;
            }
            if ( ciphertext.charAt(i) == ciphertext.charAt(i+1) ) {
                i += 1;
                count++;
                continue;
            }
            answer = answer + ciphertext.charAt(i);
        }

        if(count == 0)
            return answer;
        return decipher(answer);
    }

    public static String solution(String cryptogram) {
        String answer = decipher(cryptogram);
        return answer;
    }
}
