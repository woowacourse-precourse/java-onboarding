package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        String UpdateCryptogram = cryptogram;

        while (true){
            if(duplicate_check(UpdateCryptogram)){
                UpdateCryptogram = duplicate_delete(UpdateCryptogram);
            }
            else{
                break;
            }

            answer = UpdateCryptogram;
        }

        return answer;
    }

    public static boolean duplicate_check(String input){
        String afterCheck = "";

        for(int i=0;i<input.length();i++){
            if(i != 0 && input.charAt(i) == input.charAt(i-1)){
                return true;
            }
            if(i != input.length() - 1 && input.charAt(i) == input.charAt(i+1)){
                return true;
            }
        }

        return false;
    }

    public static String duplicate_delete(String input){
        String afterDelete = "";

        for(int i=0;i<input.length();i++){
            if(i != 0 && input.charAt(i-1) == input.charAt(i)) continue;
            if(i != input.length() - 1 && input.charAt(i) == input.charAt(i+1)) continue;
            afterDelete += input.charAt(i);
        }
        return afterDelete;
    }
}
