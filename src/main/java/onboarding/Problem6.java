package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();

        // 닉네임만 추출
        List<String> nicknames = new ArrayList<String>();
        for (int i=0; i<forms.size(); i++) {
            nicknames.add(forms.get(i).get(1));
        }

        // 닉네임에서 부분 문자열 추출
        List<List<String>> partialStringNickname = new ArrayList<List<String>>();       // 닉네임별 부분 문자열
        Set<String> partialStrings = new HashSet<String>();             // 전체 부분 문자열
        Set<String> duplicationString = new HashSet<String>();       // 중복이 있는 문자열
        for (String nickname : nicknames) {
            List<String> partialString = new ArrayList<String>();
            for (int i=0; i<nickname.length(); i++) {
                for (int j=i+1; j<nickname.length(); j++) {
                    partialString.add(nickname.substring(i, j+1));
                    if (partialStrings.contains(nickname.substring(i, j+1))) {
                        duplicationString.add(nickname.substring(i, j+1));
                    }
                    partialStrings.add(nickname.substring(i, j+1));
                }
            }
            partialStringNickname.add(partialString);
        }

        // 중복 문자열 있는 이메일, answer에 추가
        for (int i=0; i<partialStringNickname.size(); i++) {
            List<String> partialString = partialStringNickname.get(i);
            for (int j=0; j<partialString.size(); j++) {
                if (duplicationString.contains(partialString.get(j))) {
                    answer.add(forms.get(i).get(0));
                }
            }
        }

        // 정렬
        Collections.sort(answer);

        return answer;
    }
}
