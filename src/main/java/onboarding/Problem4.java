package onboarding;

public class Problem4 {
    public static String solution(String word) {

        final int num = 25;
        char[] words = word.toCharArray();

        for(int i = 0; i< words.length; i++){
            if(64<words[i] && words[i]<91){
                if(64<words[i] && words[i] <= 78){
                    words[i] = (char) (words[i]+(num - ((words[i] + num) - 90) * 2));
                }else{
                    words[i] = (char) (words[i] - (num - (65 - (words[i] - num)) * 2));
                }
            }else if(96<words[i] && words[i]<123){
                if(96<words[i] && words[i] <= 109){
                    words[i] = (char) (words[i]+(num - ((words[i] + num) - 122) * 2));
                }else{
                    words[i] = (char) (words[i] - (num - (97 - (words[i] - num)) * 2));
                }
            }
        }

        return String.valueOf(words);
    }

    public static void main(String[] args) {
        System.out.println(solution("I love you"));
    }
}
