package onboarding;

public class Problem2 {

    public static StringBuilder deleteDuplicate(StringBuilder str){
        int firstIndex = checkDuplicate(str);
        int sum = 0;
        if(firstIndex!=-1){
            for(int i = firstIndex+1; i < str.length(); i++){
                if (str.charAt(firstIndex) == str.charAt(i))
                    sum+=1;
                else break;
            }
            str.delete(firstIndex, firstIndex+sum+1);
        }else return str;
        return deleteDuplicate(str);
    }

    public static int checkDuplicate(StringBuilder str){
        for(int i = 0; i < str.length()-1; i++){
            if(str.charAt(i) == str.charAt(i+1)) return i;
        }return -1;
    }

    public static String solution(String cryptogram) {
        StringBuilder str = new StringBuilder(cryptogram);
        String answer = String.valueOf(deleteDuplicate(str));
        return answer;
    }
}
