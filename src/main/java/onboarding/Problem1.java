package onboarding;

import java.util.List;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int[] pobi_arr = pobi.stream().mapToInt(i->i).toArray(); // List to Array
		int[] crong_arr = crong.stream().mapToInt(i->i).toArray(); // List to Array
		int pobi1=0;
		int crong1=0;
		int pobi2=0;
		int crong2=0;
		int answer=10;

		// pobi 왼쪽 페이지 수들의 합
		if(pobi_arr[0]/10==0) {
			pobi1 = (int)pobi_arr[0];	// 한 자리수, 두자리수, 세자리수 일 때를 구분하여 계산

		}else if(pobi_arr[0]/100==0) {
			pobi1 = (int)pobi_arr[0]%10 + (int)(pobi_arr[0]/10)%10;
		}else {
			pobi1 = (int)pobi_arr[0]%10 + (int)(pobi_arr[0]/10)%10 + (int)pobi_arr[0]/100;
		}

		// crong 좌측 페이지 수들의 합
		if(crong_arr[0]/10==0) {
			crong1 = (int)crong_arr[0];

		}else if(crong_arr[0]/100==0) {
			crong1 = (int)crong_arr[0]%10 + (int)(crong_arr[0]/10)%10;
		}else {
			crong1 = (int)crong_arr[0]%10 + (int)(crong_arr[0]/10)%10 + (int)crong_arr[0]/100;
		}

		// pobi 우측 수들의 합
		if(pobi_arr[1]/10==0) {
			pobi2 = (int)pobi_arr[1];

		}else if(pobi_arr[1]/100==0) {
			pobi2 = (int)pobi_arr[1]%10 + (int)(pobi_arr[1]/10)%10;
		}else {
			pobi2 = (int)pobi_arr[1]%10 + (int)(pobi_arr[1]/10)%10 + (int)pobi_arr[1]/100;
		}

		// crong 우측 수들의 합
		if(crong_arr[1]/10==0) {
			crong2 = (int)crong_arr[1];

		}else if(crong_arr[1]/100==0) {
			crong2 = (int)crong_arr[1]%10 + (int)(crong_arr[1]/10)%10;
		}else {
			crong2 = (int)crong_arr[1]%10 + (int)(crong_arr[1]/10)%10 + (int)crong_arr[1]/100;
		}

		// 더한 수를 비교하여 큰 값을 pluspobi 변수에 대입
		int pluspobi = 0;
		if(pobi1>pobi2) {
			pluspobi = pobi1;
		}else {
			pluspobi = pobi2;
		}


		// 더한 수를 비교하여 큰 값을 pluscrong에 대입
		int pluscrong = 0;
		if(crong1>crong2) {
			pluscrong = crong1;
		}else {
			pluscrong= crong2;
		}


		int pobi3=0;
		// pobi 왼쪽 페이지 수들의 곱
		if(pobi_arr[0]/10==0) {
			pobi3 = (int)pobi_arr[0];	// 한 자리수, 두자리수, 세자리수 일 때를 구분하여 계산

		}else if(pobi_arr[0]/100==0) {
			pobi3 = ((int)pobi_arr[0]%10) * ((int)(pobi_arr[0]/10)%10);
		}else {
			pobi3 = ((int)pobi_arr[0]%10) * ((int)(pobi_arr[0]/10)%10) * ((int)pobi_arr[0]/100);
		}

		int crong3=0;

		// crong 좌측 페이지 수들의 곱
		if(crong_arr[0]/10==0) {
			crong3 = (int)crong_arr[0];

		}else if(crong_arr[0]/100==0) {
			crong3 = ((int)crong_arr[0]%10) * ((int)(crong_arr[0]/10)%10);
		}else {
			crong3 = ((int)crong_arr[0]%10) * ((int)(crong_arr[0]/10)%10) * ((int)crong_arr[0]/100);
		}

		int pobi4=0;
		// pobi 우측 페이지 수들의 곱
		if(pobi_arr[1]/10==0) {
			pobi4 = (int)pobi_arr[1];

		}else if(pobi_arr[1]/100==0) {
			pobi4 = ((int)pobi_arr[1]%10) * ((int)(pobi_arr[1]/10)%10);
		}else {
			pobi4 = ((int)pobi_arr[1]%10) * ((int)(pobi_arr[1]/10)%10) * ((int)pobi_arr[1]/100);
		}

		int crong4=0;

		// crong 우측 페이지 수들의 곱
		if(crong_arr[1]/10==0) {
			crong4 = (int)crong_arr[1];

		}else if(crong_arr[1]/100==0) {
			crong4 = ((int)crong_arr[1]%10) * ((int)(crong_arr[1]/10)%10);
		}else {
			crong4 = ((int)crong_arr[1]%10) * ((int)(crong_arr[1]/10)%10) * ((int)crong_arr[1]/100);
		}


		// 곱한 수를 비교하여 큰 값을 mulpobi 변수에 대입
		int mulpobi = 0;
		if(pobi3>pobi4) {
			mulpobi = pobi3;
		}else {
			mulpobi = pobi4;
		}

		// 곱한 수를 비교하여 큰 값을 mulcrong에 대입
		int mulcrong = 0;
		if(crong3>crong4) {
			mulcrong = crong3;
		}else {
			mulcrong= crong4;
		}


		// 곱한 수와 더한 수를 비교하여 둘 중 큰 수를 구한다
		int resultpobi = 0;
		if(pluspobi>mulpobi) {
			resultpobi = pluspobi;
		}else {
			resultpobi = mulpobi;
		}

		int resultcrong = 0;
		if(pluscrong>mulcrong) {
			resultcrong = pluscrong;
		}else {
			resultcrong = mulcrong;
		}




		// 승리자 선정
		if(pobi_arr[0]-pobi_arr[1]!=-1){
			answer = -1;
		}else if(crong_arr[0]-crong_arr[1]!=-1){
			answer = -1;
		}else if(resultpobi>resultcrong) {
			answer=1;
		}else if(resultpobi==resultcrong) {
			answer=0;
		}else if(resultpobi<resultcrong) {
			answer=2;
		}else {
			answer=-1;
		}

		return answer;
	}
}