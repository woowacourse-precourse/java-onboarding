package onboarding;

public class Problem4 {

    public static boolean is_upper(char charecter){
        if((int)charecter > 64 && (int)charecter < 91){
            return true;
        }
        return false;

    }



    public static String solution(String word) {
        //공백처리만 한번 해주고

        String answer = "";
        //A : 65 Z : 90 , a : 97 z : 122
        //A 면 Z 로 65 + (25 - 0) , B면 (65+1) + (25-1)
        char[] answer_c = word.toCharArray();

        int index_c =0;
        //1. 대문자인지 소문자인지 check 대문자면 true , 소문자면 false
        int index = 0;
        while(index < word.length()){
            if(is_upper(answer_c[index])){
                if(answer_c[index]==' '){
                    index++;
                    continue;
                }
                index_c = (int)answer_c[index] - 65; //대문자중 몇번째 문자인지
                answer_c[index] = (char)(65 + (25-index_c));
            }
            else{
                if(answer_c[index]==' '){
                    index++;
                    continue;
                }
                index_c = (int)answer_c[index] - 97; //대문자중 몇번째 문자인지
                answer_c[index] = (char)(97 + (25-index_c));

            }
            index++;
        }
        System.out.println(answer_c);



        answer = String.valueOf(answer_c);
        System.out.println(answer);

        return answer;
    }

    public static void main(String[] args) {
        int b = 67;
        char a = (char)b;
        solution("I love you");
        System.out.println();
    }
}
