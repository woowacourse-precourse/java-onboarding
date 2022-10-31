package onboarding;

import java.util.*;

public class Problem2 {
    public static String solution(String cryptogram) {
//      cryptogram 받아서 단일 문자 list에 넣기
        ArrayList<String> lst = new ArrayList<String>();

        for (String s : cryptogram.split("")) {
            lst.add(s);
        }
        String answer = sameLang(lst);;
        return answer;
    }

    //   쪼갠 문자 중복되는지 확인
    public static String sameLang(ArrayList<String> lst) {
        ArrayList<String> lstIns = new ArrayList<String>();
//      비교 완료 된 것은 lstIns에 넣기 첫번째 인자는 비교를 위해 미리 넣기
        lstIns.add(lst.remove(0));
        while (true) {
            String pickFirst = lst.remove(0);
//          lst[0],lst[1]이 같을 경우 lstIns가 없어서 비었으면 무조건 넣어주는 식 ex)aaaa
            if (lstIns.isEmpty()) {
                lstIns.add(pickFirst);
            }
//          lstIns가 차있는 정상적인 상황일 경우
            else {
                String pickIns = lstIns.get(lstIns.size() - 1);
//          lstIns라는 중간 배열에 임시 저장하고 lst 앞부터 하나씩 삽입하면서 비교
                if (pickFirst.equals(pickIns)) {
//              동일한 문자이면 lstIns도 삭제
                    lstIns.remove(lstIns.size() - 1);
                } else {
                    lstIns.add(pickFirst);
                }
            }
//          lst가 비었으면 종료
            if (lst.isEmpty()) {
                break;
            }
        }
        return String.join("",lstIns);
    }

}
