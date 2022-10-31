package onboarding;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Problem6 {

    public static boolean check_overlap(String target, String move){
        // encode string with ecu-kr.
        byte[] target_name = target.getBytes(Charset.forName("euc-kr"));
        byte[] move_name = move.getBytes(Charset.forName("euc-kr"));

        // find overlapping area
        // euc-kr encode a word into 2 byte
        // so checking 2 words mean checking 4 byte
        for(int i = 0; i < target_name.length - 3; i++){
            for(int j = 0; j < move_name.length - 3; j++){
                if((target_name[i] == move_name[j])
                        && (target_name[i + 1] == move_name[j + 1]) // first word
                        && (target_name[i + 2] == move_name[j + 2])
                        && (target_name[i + 3] == move_name[j + 3])){ // second word
                    return true; // overlapping part found
                }
                else{
                    continue;
                }
            }
        }
        return false; // no overlapping part
    }
    public static List<String> solution(List<List<String>> forms) { // list of list of string.
        List<String> answer = new ArrayList<String>();
        // get nickname from forms, using euc-kr encoding.
        int list_size = forms.size();
        for(int i = 0; i < list_size - 1; i++){
            for(int j = i + 1; j < list_size; j++){
                if(check_overlap(forms.get(i).get(1),forms.get(j).get(1))){
                    // to avoid overlapping, add content which is new.
                    if(!answer.contains(forms.get(i).get(0))){
                        answer.add(forms.get(i).get(0));
                    }
                    if(!answer.contains(forms.get(j).get(0))){
                        answer.add(forms.get(j).get(0));
                    }
                }
                else{
                    continue;
                }
            }
        }
        // sort the answer list.
        Collections.sort(answer);
        return answer;
    }
}
