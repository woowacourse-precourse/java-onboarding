package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
    static String letterRemove(String temp1){
        if(temp1.length() != 1){
            return "";
        }
        return temp1;
    }
    static Object[] letterCheck(String crytogram){
        String temp1;
        String temp2;
        int check_remove = 0;
        String new_crytogram = "";
        Object[] check_result = new Object[2];

        if(crytogram.length()==0){
            check_result[0] = "";
            check_result[1] = check_remove;
            return check_result;
        }
        temp1 = String.valueOf(crytogram.charAt(0));
        for(int i=1; i<crytogram.length();i++){
            temp2 = String.valueOf(crytogram.charAt(i));
            if(temp1.equals(temp2)){
                temp1 = temp1 + temp2;
                temp2 = "";
                check_remove = 1;
            }else if(!temp1.equals(temp2)) {
                new_crytogram = new_crytogram + letterRemove(temp1);
                temp1 = temp2;
                temp2 = "";
            }
        }
        new_crytogram += letterRemove(temp1);
        check_result[0] = new_crytogram;
        check_result[1] = check_remove;
        return check_result;
    }
}
