package onboarding;

import problem5.moneyRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static problem5.BankNoteCounter.countBankNote;
import static problem5.moneyRepository.postMoney;


public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        List<Integer> answerList = new ArrayList<Integer>(answer);

        // 화폐 저장소
        int[] postMoney = postMoney();

        // 지폐 계수기 -> answer
        answer = countBankNote((ArrayList<Integer>) answerList, postMoney, money);

        return answerList;
    }



}
