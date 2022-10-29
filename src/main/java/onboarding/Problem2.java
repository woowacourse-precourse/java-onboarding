package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {
        List<Integer> remove_range;
        String removed_cryptogram = cryptogram;

        while(true){
            remove_range = makeRemoveRange(removed_cryptogram);
            if(remove_range.isEmpty()){
                break;
            }
            removed_cryptogram = removeLetter(remove_range, removed_cryptogram);
        }
        return removed_cryptogram;
    }

    static List<Integer> makeRemoveRange(String cryptogram){
        CheckLetter checkletter = new CheckLetter(cryptogram);
        List<Integer> remove_range;

        if(cryptogram.equals("")){ // 빈 문자열이 입력될 때 빈 리스트 반환
            return Collections.emptyList();
        }
        while(checkletter.checkLoop()){
            checkletter.letterCheck();
        }
        remove_range = checkletter.getRemove_range();
        return remove_range;
    }

    static String removeLetter(List<Integer> remove_range, String cryptogram){
        StringBuilder removed_cryptogram = new StringBuilder(cryptogram);

        for(int i=0; i<remove_range.size(); i+=2){
            removed_cryptogram.delete(remove_range.get(i),remove_range.get(i+1));
            remove_range = remove_rangeUpdate(remove_range,remove_range.get(i+1)-remove_range.get(i)); // remove_range 업데이트해
        }
        return removed_cryptogram.toString();
    }
/*
removeLetter를 진행하면서 문자열의 길이가 줄어든다. 이에 따라 인덱스의 값도 달라지게 되므로,
remove_range 값을 짧아진 길이만큼 줄여주는 업데이트 진행이 필요하다.
이를 수행해주는 메서드가 아래 remove_rangeUpdate 이다.
 */
    static List<Integer> remove_rangeUpdate(List<Integer> remove_range, int update_number){
        return remove_range.stream()
                .map(i ->i-update_number)
                .collect(Collectors.toList());
    }

    static class CheckLetter {
        int front = 0;
        int back = 1;
        List<Integer> remove_range = new ArrayList<>();
        String cryptogram;

        CheckLetter(String cryptogram) {
            this.cryptogram = cryptogram;
        }
        List<Integer> getRemove_range() {
            return remove_range;
        }
        boolean checkLoop() {
            return back != cryptogram.length();
        }
        void letterCheck () {
            if (cryptogram.charAt(front) != cryptogram.charAt((back))) {
                this.workMismatch();
            } else if (cryptogram.charAt(front) == cryptogram.charAt(back)) {
                this.workMatch();
            }
        }
        void workMismatch() {
            if (back - front == 1) {
                back += 1;
                front += 1;
            } else if (back - front > 1) {
                remove_range.add(back);
                back += 1;
                front = back - 1;
            }
        }
        void workMatch() {
            if(cryptogram.length()==2){ // "zz" 와 같이 길이 2의 동일한 글자가 들어오면 수행
                back += 1;
                remove_range.add(front);
                remove_range.add(back);
                return;
            }
            if(back - front ==1){
                remove_range.add(front);
                back += 1;
                if(back == cryptogram.length()){ // 문자의 제일 끝에 2개만 동일한 경우를 판단하기 위한 조건문
                    remove_range.add(back);
                }
            }else if(back == cryptogram.length()-1){
                back +=1;
                remove_range.add(back);
            } else if (back - front > 1) {
                back += 1;
            }
        }
    }
}
