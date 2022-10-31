package onboarding;

import java.util.List;

class Compare {
	int pobi1, pobi2, crong1, crong2;
	int result_plus, result_div;

	Compare(int a, int b, int c, int d) {
		this.pobi1 = a;
		this.pobi2 = b;
		this.crong1 = c;
		this.crong2 = d;
	}
	Compare(int a, int b) {
		this.pobi1 = a;
		this.pobi2 = a + 1;
		this.crong1 = b;
		this.crong2 = b + 1;
	}
	Compare(){};
	
	public int pobi_max() {
		int max1, max2, max3, max4;
		int result_max;
		max1 = plus_max(pobi1);
		max2 = plus_max(pobi2);
		max3 = div_max(pobi1);
		max4 = div_max(pobi2);
		if( max1 >= max2 ){
			result_plus = max1;
		}
		else if( max1 < max2 ){
			result_plus = max2;
		}
		if( max3 >= max4 ){
			result_div = max3;
		}
		else if( max3 < max4 ){
			result_div = max4;
		}
		
		if( result_plus >= result_div) {
			result_max = result_plus;
			return result_max;
		}
		else if( result_plus < result_div) {
			result_max = result_div;
			return result_max;
		}
		return -1;
		
	}
	public int crong_max() {
		int max1, max2, max3, max4;
		int result_max;
		max1 = plus_max(crong1);
		max2 = plus_max(crong2);
		max3 = div_max(crong1);
		max4 = div_max(crong2);
		if( max1 > max2 ){
			result_plus = max1;
		}
		else if( max1 < max2 ){
			result_plus = max2;
		}
		if( max3 > max4 ){
			result_div = max3;
		}
		else if( max3 < max4 ){
			result_div = max4;
		}
		
		if( result_plus >= result_div) {
			result_max = result_plus;
			return result_max;
		}
		else if( result_plus < result_div) {
			result_max = result_div;
			return result_max;
		}
		return -1;
	}
	
	public int plus_max(int plus_int) {
		int hund, ten, one;
		if(plus_int > 99) {
			hund = plus_int / 100;
			ten = plus_int % 100 / 10;
			one = plus_int % 10;
			return hund + ten + one;
		}
		else if(plus_int > 9) {
			ten = plus_int % 100 / 10;
			one = plus_int % 10;
			return ten + one;
		}
		else if(plus_int > 0 && plus_int < 10) {
			return plus_int % 10;
		}
		return -1;
	}
	
	public int div_max(int div_int) {
		int hund, ten, one;
		if(div_int > 99) {
			hund = div_int / 100;
			ten = div_int % 100 / 10;
			one = div_int % 10;
			return hund * ten * one;
		}
		else if(div_int > 9) {
			ten = div_int % 100 / 10;
			one = div_int % 10;
			return ten * one;
		}
		else if(div_int > 0 && div_int < 10) {
			return div_int % 10;
		}
		return -1;
	}
	
	public int getResult() {
		int a, b;
		a = pobi_max();
		b = crong_max();
		
		if(a > b) {
			return 1;
		}
		else if(a < b) {
			return 2;
		}
		else if(a == b) {
			return 0;
		}
		return -1;
	}
}

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        
        List<Integer> pobi_number = pobi;
        List<Integer> crong_number = crong;
        
        Compare vs = new Compare(pobi.get(0),crong.get(0));
        
        int a, b;
        
        a = pobi_number.get(0);
        b = pobi_number.get(1);//器厚 公搬己
        
        int result1 = a - b;
        
        a = crong_number.get(0);
        b = crong_number.get(1);//农氛 公搬己
        int result2 = a - b;
        
        if(result1 == -1)
        	return vs.getResult();
        else {
        	return -1;
        }
    }
}
