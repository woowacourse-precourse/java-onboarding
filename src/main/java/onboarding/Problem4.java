package onboarding;

//성공
public class Problem4 {
    public static String solution(String word) {

        String answer = "";

        char a[] = word.toCharArray();

        for(int i=0;i<a.length;i++){
            if (65<=(int)a[i] && (int)a[i]<=90){
                answer+= (char)(155-(int)a[i]);
            } else if (97<=(int)a[i] && (int)a[i]<=122) {
                answer+= (char)(219-(int)a[i]);
            }
            else{
                answer+=" ";
            }
        }


        return answer;
    }
}
