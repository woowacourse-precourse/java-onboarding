package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    private static String decoding(String str){
        boolean check = true;
        String result = str;
        do{
            result = deleteDuplication(result);
            boolean isCheck = isDuplicated(result);
            if(isCheck == false){
                check = false;
            }
        }while (check == true);
        return result;
    }

    private static String deleteDuplication(String str){
        String result = "";
        char preCh = ' ';
        for(int index = 0; index < str.length(); index++){
            char ch = str.charAt(index);
            if(preCh == ch){
                preCh = ' ';
                continue;
            }
            if(index == str.length() - 1){
                result += ch;
            }
            if(preCh == ' ' && index != 0){
                preCh = ch;
                continue;
            }
            result += preCh;
            preCh = ch;
        }
        return result;
    }

    private static boolean isDuplicated(String str){
        char prech = ' ';
        boolean isCheck = false;
        for(int index = 0; index < str.length(); index++){
            char ch = str.charAt(index);
            if(ch == prech){
                isCheck = true;
                break;
            }
            prech = ch;
        }
        return (isCheck == true) ? true : false;
    }
}