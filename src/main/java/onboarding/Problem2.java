package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        boolean check = true;

        while (check) {
            check = false;
            char[] crypto_array = answer.toCharArray();
            char over_char = ' ';
            for(int i = 0; i < crypto_array.length; i++) {
                if(crypto_array[i] == over_char) {
                    crypto_array[i] = '*';
                    crypto_array[i - 1] = '*';
                    check = true;
                }
                else over_char = crypto_array[i];
            }

            answer = String.valueOf(crypto_array).replace("*", "");
            System.out.println(answer);
        }
        return answer;
    }
}
