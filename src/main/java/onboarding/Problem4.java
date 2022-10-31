package onboarding;

public class Problem4 {
    public static String solution(String word) {
        char[] wordArr = word.toCharArray();

        for(int i = 0; i < wordArr.length; i++){
            if(wordArr[i] != ' ')
                wordArr[i] = converted(wordArr[i]);
        }
        return new StringBuilder(new String(wordArr)).toString();
    }

    static char converted(char alpha){
        int num = alpha;
        if(65 <= num && num <= 90){
            num += num < 77.5? 2*(77.5 - num) : (-2)*(num - 77.5);
        }
        else{
            num += num < 109.5? 2*(109.5 - num) : (-2)*(num - 109.5);
        }
        return (char)num;
    }
}
