package onboarding;
//65 - 90
public class Problem4 {
    public static String changeString(String str){
        String newstr="";
        for (int i=0; i<str.length(); i++){
            if (97<=(int)str.charAt(i) && (int)str.charAt(i)<110){
                newstr+=(char)(122-(int)str.charAt(i)+97);
            }
            else if (78<=(int)str.charAt(i) && (int)str.charAt(i)<=122){
                newstr+=(char)(97+122-(int)(str.charAt(i)));
            }
            else if (65<=(int)str.charAt(i) && (int)str.charAt(i)<78){
                newstr+=(char)(90-(int)str.charAt(i)+65);
            }
            else if (78<=(int)str.charAt(i) && (int)str.charAt(i)<=90){
                newstr+=(char)(65+(int)(str.charAt(i))-90);
            }
            else{
                newstr+=str.charAt(i);
            }
        }
        return newstr;
    }

    public static String solution(String word) {
        String answer = "";

        answer=changeString(word);
        return answer;
    }
}