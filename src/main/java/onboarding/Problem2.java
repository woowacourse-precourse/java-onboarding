package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {

        char[] charArr = cryptogram.toCharArray();
        int i = 1;
        int j = 0;
        boolean isSerial;

        while(true){
            isSerial = false;
            while(i<charArr.length){
                if(charArr[i] != 32 && charArr[j] != 32 && charArr[i] == charArr[j]){
                    charArr[i] = 32;
                    charArr[j] = 32;
                    isSerial = true;
                    i++;
                    j = i-1;
                }else if(charArr[i] == 32 && charArr[j] != 32){
                    i++;
                }else{
                    i++;
                    j++;
                }
            }

            if(!isSerial){
                break;
            }else{
                i = 1; j = 0;
            }
        }

        String answer = "";
        for(i=0; i<charArr.length; i++){
            if(charArr[i] != 32){
                answer += charArr[i];
            }
        }

        return answer;
    }
}
