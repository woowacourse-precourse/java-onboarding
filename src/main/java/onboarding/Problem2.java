package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        answer = check_duplication(cryptogram);

        return answer;
    }

    static String check_duplication(String str){
        int i,j,check=0;
        String result = "";

        for (i = 0; i < str.length()-1; i++) {
           for(j = i+1; j < str.length();j++){
               if(str.charAt(i)!=str.charAt(j)) break;
               else check=1;
            }

           if(check==1){
               for(int z = 0; z < str.length();z++){
                   if(z < i || z >= j) result += str.charAt(z);
               }
               if(!result.equals("")) result = check_duplication(result);
               break;
           }

        }

        if(check!=1) return str;
        else return result;
    }
}
