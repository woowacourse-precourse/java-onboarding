package onboarding;

import java.lang.Object;

public class Problem4 {
    public static char check_and_switch(char input){
        int ascii_value = (int)input; // convert character to integer by casting.
        // check the range of the ascii value
        if(65 <= ascii_value && ascii_value <= 90){ // if the character is Capital letter
            // symmetrically move its value according to the ASCII code table. like mirror
            final float axis = 77.5f;
            if(ascii_value < axis){
                float distance = axis - ascii_value;
                return (char)(ascii_value + distance * 2);
            }
            else{
                float distance = ascii_value - axis;
                return (char)(ascii_value - distance * 2);
            }
        }
        else if(97 <= ascii_value && ascii_value <= 122){ // else if the character is small letter
            // symmetrically move its value according to the ASCII code table.
            final float axis = 109.5f;
            if(ascii_value < axis){
                float distance = axis - ascii_value;
                return (char)(ascii_value + distance * 2);
            }
            else{
                float distance = ascii_value - axis;
                return (char)(ascii_value - distance * 2);
            }
        }
        else{ // not an alphabet
            return (char)ascii_value;
        }
    }
    public static String solution(String word) {
        // small to capital
        char temp[] = new char[word.length()];
        for(int i = 0; i < word.length(); i++){
            temp[i] = check_and_switch(word.charAt(i));
        }
        String answer = new String(temp);
        return answer;
    }
}
