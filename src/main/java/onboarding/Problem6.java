package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        return answer;
    }


    private static List<String> seperateNickName(String nickname){
        List<String> nickNamePieces = new ArrayList<>();
        String piece;
        for(int i = 0; i < nickname.length()-1; i++){
            piece = nickname.substring(i,i+2);
            nickNamePieces.add(piece);
        }
        return nickNamePieces;
    }

    private static boolean checkNicknameLength(String nickname){
        if(nickname.length() < 2){
            return true;
        }
        return false;
    }
}
