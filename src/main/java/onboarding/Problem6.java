package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        //이메일을 저장할 공간
        //인덱스를 알고 있다면 O(1)로 빠르게 찾기 위함
        String[] emails = new String[forms.size()];
        int index = 0;
        //중복 검사를 빨리 하기 위해 Map에 닉네임을 쪼개서 저장
        Map<String, Integer> pieceStorage = new HashMap<>();
        //중복된 이메일 체크하는 boolean배열
        boolean[] emailsDuplicateCheck = new boolean[forms.size()];
        //중복된 이메일을 담는 리스트
        List<String> duplicatedEmails = new ArrayList<>();


        //쪼개서 저장하며, 중복 비교
        for(List<String> user : forms) {
            emails[index] = user.get(0);
            savePieces(user.get(1), index, pieceStorage, emailsDuplicateCheck, duplicatedEmails, emails);
            index++;
        }
        //이메일 리스트 정렬
        Collections.sort(duplicatedEmails);
        return duplicatedEmails;
    }

    private static void savePieces(String nickname, int emailIndex, Map<String, Integer> pieceStorage,
                                   boolean[] emailsDuplicateCheck, List<String> duplicatedEmails,
                                   String[] emails) {
        List<String> currentPieces = new ArrayList<>();

        for(int i = 1; i < nickname.length(); i++) {
            String piece = nickname.substring(i -1, i + 1);
            //중복 검사(Map은 equals를 가지고 중복 검사를 한다)
            //만약 중복한다면,
            if(pieceStorage.containsKey(piece)) {
                //현재 검사하고 있는 닉네임의 이메일을 추가
                duplicatedEmails.add(emails[emailIndex]);
                emailsDuplicateCheck[emailIndex] = true;
                //현재 검사하고 있는 것과 중복되는 피스를 가지고 있는 닉네임의 이메일을 추가
                int duplicatedEmailIndex = pieceStorage.get(piece);
                //이전에 이메일을 중복 이메일 리트스에 추가하지 않을 때만 추가
                if(!emailsDuplicateCheck[duplicatedEmailIndex]) {
                    duplicatedEmails.add(emails[duplicatedEmailIndex]);
                    emailsDuplicateCheck[duplicatedEmailIndex] = true;
                }
                //중복되면 검사 끝
                return;
            //중복하지 않다면, 리스트에 추가
            } else {
                currentPieces.add(piece);
            }
        }
        //이 이메일이 중복이 아님이 확인되면, pieceStorage 에 저장해둔 piece 추가
        for(String piece : currentPieces) {
            pieceStorage.put(piece, emailIndex);
        }
    }



}
