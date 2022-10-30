package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = translate(cryptogram);
        return answer;
    }

    public static boolean checkDup(String cryptogram){
        for(int i=0; i<cryptogram.length()-1; i++){
            if(cryptogram.charAt(i) == cryptogram.charAt(i+1))
                return true;
        }
        return false;
    }

    public static String translate(String cryptogram){
        String result= cryptogram;
        int count=0;


        while(checkDup(cryptogram)){
            int dupNum=1;
            int lastIndex=cryptogram.length();

            if(cryptogram.charAt(count)==cryptogram.charAt(count+1)) {
                for (int i = count; i < lastIndex-1; i++) {
                    char charDup = cryptogram.charAt(count);
                    if (charDup == cryptogram.charAt(i + 1)) {
                        dupNum++;
                    }
                    else{
                        break;
                    }
                }
                cryptogram = cryptogram.substring(0, count) + cryptogram.substring(count + dupNum, lastIndex);
                result = cryptogram;
                count--;
            }
            count++;

            lastIndex=cryptogram.length()-1;
            if(checkDup(cryptogram)==true && lastIndex==count){
                count=0;
            }
        }
        return result;
    }
}

