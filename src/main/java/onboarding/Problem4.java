package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        //save alphabet array
        char [] save = new char[26];
        int Z = 90;
        int i = 0;
        //make alphabet array
        for(i =0; i < 26; i++){
            save[i] = (char)Z;
            Z--;
        }
        StringBuilder strBuilder = new StringBuilder();
        int check = 0;
        char small = ' ';
        //change the letters
        for(i = 0; i < word.length(); i++){
            check = (int)(word.charAt(i));
            if(check >= 65 && check <= 90){ //upper letter
                strBuilder.append(save[check-65]);
            }
            else if(check >= 97 && check <= 122){ //lower letter
                small = Character.toLowerCase(save[check-97]);
                strBuilder.append(small);
            }
            else{
                strBuilder.append(word.charAt(i));
            }
        }
        answer = strBuilder.toString();
        return answer;
    }
}
