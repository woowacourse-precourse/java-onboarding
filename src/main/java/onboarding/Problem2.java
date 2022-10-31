package onboarding;
import java.util.ArrayList;
import java.util.Iterator;
public class Problem2 {

    static boolean isEqual(String char_in_passcode, char new_char) {
        return char_in_passcode.equals(String.valueOf(new_char));
    }

    static void addCharToPasscode(ArrayList<String> passcode, char character){
        passcode.add(String.valueOf(character));
    }

    static String getAnswer(ArrayList<String> passcode){
        Iterator<String> character_of_passcode = passcode.iterator();
        String answer = "";
        while (character_of_passcode.hasNext()){
            answer += character_of_passcode.next();
        }
        return answer;
    }

    static void decryption_of_cryptogram(ArrayList<String> passcode, String cryptogram){
        passcode.add(String.valueOf(cryptogram.charAt(0)));
        for (int i=1;i<cryptogram.length();i++){
            if (isEqual(passcode.get(passcode.size()-1),cryptogram.charAt(i))){
                passcode.remove(passcode.size()-1);
            }
            else addCharToPasscode(passcode,cryptogram.charAt(i));
        }
    }

    public static String solution(String cryptogram) {
        ArrayList<String> passcode = new ArrayList<>(1000);
        decryption_of_cryptogram(passcode, cryptogram);
        String answer = getAnswer(passcode);

        return answer;
    }
}
