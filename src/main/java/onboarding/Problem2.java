package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        while(true){
            String removedCryptogram = removeRepeatedCharacters(cryptogram);
            if(removedCryptogram.equals(cryptogram)){
                answer = cryptogram;
                break;
            }else{
                cryptogram = removedCryptogram;
            }
        }
        return answer;
    }

    private static String removeRepeatedCharacters(String inputStr){
        char a = ' ';
        if(inputStr.length()> 0){
            a = inputStr.charAt(0);
        }
        StringBuffer str = new StringBuffer(inputStr);
        for(int i = 1; i < inputStr.length(); i++){
            char b = inputStr.charAt(i);
            if(a == b) {
                str.setCharAt(i-1, '1');
                str.setCharAt(i, '1');
            }
            a = b;
        }
        String outputStr = str.toString().replaceAll("1", "");

        return outputStr;
    }

}
