package com.test;

public class DynamicSubsetSum {

	public static int[] w = {0,2,2,3};
	public static int W = 6;
	public static void main(String[] args) {

		
		System.out.println(ComputeOpt(3,0));

	}
	
	public static int ComputeOpt(int i,int t){
		int val1 = -1,val2=-1;
		if(i==0){
			return t;
		}
		if(t+w[i] <=W){
			val1 = ComputeOpt(i-1,t+w[i]);
		}
		val2 = ComputeOpt(i-1,t);
		return Math.max(val1, val2);
	}
	

}
