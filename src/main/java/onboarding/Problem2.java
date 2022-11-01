package onboarding;

public class Problem2 {
    public static int start = 0;
    public static int end = 0;
    public static boolean delete_flag = false; // decide delete or not

    public static boolean check_continuous(String input){
        // check the continuous part
        char cont_char = 0;
        int max_size = input.length();
        int i = 0;
        for(; i < max_size - 1; i++){
            if(input.charAt(i) == input.charAt(i + 1)){ // check existance of the continuous part
                delete_flag = true;
                cont_char = input.charAt(i);
                start = i++;
                end = i;
                break;
            }
            else {
                continue; // do nothing
            }
        }
        // update the end position
        if(delete_flag){
            while(i < max_size - 1){
                if(cont_char == input.charAt(i + 1)){ // still continuous
                    i++;
                    end++;
                }
                else{ // new character, not continuous
                    break;
                }
            }
        }
        return delete_flag;
    }
    public static String delete_continuous(String input){
        delete_flag = false;
        // check the continuous part of the input string
        if(check_continuous(input)){
            // if there is a such part, cut and concat
            if(end == input.length() - 1){
                // check it again
                // use substring() to get the part to save, abandon the rest
                return delete_continuous(input.substring(0, start)); // from 0 to start-1
            }
            else{
                // check it again
                // use substring() to get the part to save, abandon the rest
                // use + operator to combine two string, operator over loading
                return delete_continuous(input.substring(0, start) // from 0 to before start of delete section
                        + input.substring(end + 1, input.length())); // from after the end of delete section to the end
            }
        }
        else{// else, return the input. end of the recursion.
            return input;
        }
    }
    public static String solution(String cryptogram) {
        String answer = delete_continuous(cryptogram); // get the answer.
        return answer;
    }
}
