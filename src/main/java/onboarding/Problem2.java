package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        String answer  = deleteDuplicate(cryptogram);
        return answer;
    }

    private static String deleteDuplicate(String crytogram) {
        char[] charArray = crytogram.toCharArray();
        char preChar = charArray[0];
        int continueLength = 1;
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < charArray.length; i++){
            if(preChar == charArray[i]){
                continueLength++;
                continue;
            }
            else if(continueLength == 1){
                sb.append(preChar);
                preChar = charArray[i];
                continueLength = 1;
            }
            else{
                preChar = charArray[i];
                continueLength = 1;
            }
        }
        return sb.toString();
    }
}
