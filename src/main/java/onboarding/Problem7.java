package onboarding;

import onboarding.P7.IdLengthVerification;
import onboarding.P7.IdVerification;
import onboarding.P7.ListLengthVerification;
import onboarding.P7.RecomendRank;

import java.util.*;


public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        IdVerification idVerification = new IdVerification();
        IdLengthVerification idLengthVerification = new IdLengthVerification();
        ListLengthVerification listLengthVerification = new ListLengthVerification();
        RecomendRank recomendRank = new RecomendRank();

        if(!idVerification.friendsSmallIdCheck(friends, visitors)){
            throw new IllegalArgumentException("소문자로 입력해주세요");
        }
        if(!idLengthVerification.idLengthCheck(friends, visitors)){
            throw new IllegalArgumentException("아이디 길이 확인해주세요");
        }
        if(!listLengthVerification.listLengthCheck(user, friends, visitors)){
            throw new IllegalArgumentException("리스트들 길이 확인해주세요");
        }

        return recomendRank.rankFive(user, friends, visitors);


    }




}
