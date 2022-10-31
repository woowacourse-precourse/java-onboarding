package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobi_left_num = pobi.get(0);
        int pobi_right_num = pobi.get(1);
        int crong_left_num = crong.get(0);
        int crong_right_num = crong.get(1);
        if(checkValidationOfPage(pobi_left_num, pobi_right_num)==-1) return -1;
        if(checkValidationOfPage(crong_left_num, crong_right_num)==-1)return -1;

        ArrayList<Integer> pobi_seperated_left_score = seperated_left_score(pobi_left_num);
        ArrayList<Integer> pobi_seperated_right_score = seperated_right_score(pobi_right_num);

        int pobi_left_max_score = return_max_score(pobi_seperated_left_score);
        int pobi_right_max_score = return_max_score(pobi_seperated_right_score);
        int pobi_max_score = (pobi_left_max_score < pobi_right_max_score) ? pobi_right_max_score : pobi_left_max_score;

        ArrayList<Integer> crong_seperated_left_score = seperated_left_score(crong_left_num);
        ArrayList<Integer> crong_seperated_right_score = seperated_right_score(crong_right_num);

        int crong_left_max_score = return_max_score(crong_seperated_left_score);
        int crong_right_max_score = return_max_score(crong_seperated_right_score);
        int crong_max_score = (crong_left_max_score < crong_right_max_score) ? crong_right_max_score : crong_left_max_score;


        if(crong_max_score > pobi_max_score) return 2;
        else if (crong_max_score == pobi_max_score)  return 0;
        else return 1;
    }

    public static ArrayList<Integer> seperated_left_score(int left_num) {
        ArrayList<Integer> seperated_left_num = new ArrayList<>();

        while(left_num>0) {
            seperated_left_num.add(left_num%10);
            left_num /= 10;
        }

        return seperated_left_num;
    }

    public static ArrayList<Integer> seperated_right_score(int right_num) {
        ArrayList<Integer> seperated_right_num = new ArrayList<>();

        while(right_num>0) {
            seperated_right_num.add(right_num%10);
            right_num /= 10;
        }
        return seperated_right_num;
    }

    public static int return_max_score(ArrayList<Integer> seperated_score){
        ArrayList<Integer> score_candidate = new ArrayList<Integer>();
        int sum = 0;
        for(int i=0; i< seperated_score.size(); i++) {
            sum += seperated_score.get(i);
        }
        int multiple=1;
        for(int i=0; i< seperated_score.size(); i++) {
            multiple *= seperated_score.get(i);
        }
        score_candidate.add(sum);
        score_candidate.add(multiple);
        return Collections.max(score_candidate);
    }

    public static int checkValidationOfPage(int left_page, int right_page){
        if(right_page-left_page !=1) return -1;
        if(left_page%2 != 1) return -1;
        if(right_page % 2 != 0) return -1;
        return 1;
    }
}