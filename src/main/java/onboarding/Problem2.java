package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        boolean[] erase = new boolean[cryptogram.length()];
        boolean flag = true;
        int j = 0;

        for(int i = 0; i < cryptogram.length() - 1; i++){
            flag = true;
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                erase[i] = true;
                erase[i + 1] = true;
                j = i + 1;
                while(flag){
                    if (cryptogram.charAt(j) == cryptogram.charAt(j + 1)) {
                        erase[j] = true;
                        erase[j + 1] = true;
                        j++;
                    }
                    else{
                        flag = false;
                    }
                }
            }
        }

        for(int i = 0; i < cryptogram.length(); i++){
            if(!erase[i]){
                answer = answer + erase[i];
            }
        }

        return answer;
    }
}
