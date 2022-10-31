package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String[] dan = {"Z","Y","X","W","V","U","T","S","R","Q","P","O","N","M","L","K","J","I","H","G","F","E","D","C","B","A"};
        String[] dan1 = {"z","y","x","w","v","u","t","s","r","q","p","o","n","m","l","k","j","i","h","g","f","e","d","c","b","a"};
        String[] tmp = word.split(" ");
        for(int i = 0;i < tmp.length; i++){
            String tmp3 = "";
            for(int j = 0; j < tmp[i].length(); j++){
                if((int)tmp[i].charAt(j) - 65 <= 25){
                    tmp3 += dan[(int)tmp[i].charAt(j) - 65];
                }
                else{
                    tmp3 += dan1[(int)tmp[i].charAt(j) - 97];
                }
            }
            tmp[i] = tmp3;
        }
        return String.join(" ",tmp);
    }
}
