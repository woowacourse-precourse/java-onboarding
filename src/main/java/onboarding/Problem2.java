package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<Character> checklist = new Stack<>();

        String answer = "";
        //check the line strength 1
        if(cryptogram.length() == 1){
            answer = cryptogram;
            return answer;
        }
        else{
            check_duplicate(checklist, cryptogram);
        }

        while(!checklist.isEmpty()){
            answer = Character.toString(checklist.pop()) + answer;
        }
        return answer;
    }

    static void check_duplicate(Stack<Character> checklist, String str){
        int start = 0; //start point
        int end = 1; //end point

        checklist.push(str.charAt(start));
        char spoint = checklist.peek();

        //check the same character in string
        while(end < str.length()){
            if(spoint != str.charAt(end)){
                start = end;
                end++;
                checklist.push(str.charAt(start));
                spoint = checklist.peek();
            }

            else {
                end++;
                //check the more same character in string
                while(end < str.length() && spoint == str.charAt(end)){
                    end++;
                }
                checklist.pop();  //remove same character
                //check stack empty and input the new character
                if(end < str.length() && checklist.empty()){
                    start = end;
                    end++;
                    checklist.push(str.charAt(start));
                    spoint = checklist.peek();
                }
                else if(end < str.length()){
                    spoint = checklist.peek();
                }
            }
        }
    }
}
