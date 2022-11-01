package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        while(true){
            String TransStr = getAnswer(cryptogram);
            if(TransStr.equals("")) {
                answer = "";
                break;
            } else if (TransStr.equals(cryptogram)) {
                answer = cryptogram;
                break;
            } else {
                cryptogram = TransStr;
            }
        }
        return answer;
    }
    static String getAnswer(String Input){
        String Result = "";
        if(Input.length()==1) {
            return Input;
        }
        int Pointer1 = 0;
        int Pointer2 = 1;
        while(true){
            if(Pointer2==Input.length()) {
                Result += Input.charAt(Pointer1);
                break;
            }

            if(Input.charAt(Pointer1) == Input.charAt(Pointer2)) {
                Pointer2++;
                while(true){
                    if(Pointer2==Input.length()){
                        break;
                    }
                    if(Input.charAt(Pointer1) == Input.charAt(Pointer2)){
                        Pointer2++;
                    } else {
                        break;
                    }
                }
                if(Pointer2==Input.length()){
                    break;
                } else {
                    Pointer1 = Pointer2;
                    Pointer2++;
                }
            } else {
                Result += Input.charAt(Pointer1);
                Pointer1++;
                Pointer2++;
            }
        }
        return Result;
    }
}
