package com.test;

public class DynamicHW2 {
	//Elements are stored from 1 to n in array t, therefore don't put an element at t[0] otherwise it wont be counted
	public static int[] t= {0,28,3,16}; //Elements are 28,3,16
	public static int n =t.length;
	public static int M = 40;
	public static double[] c = new double[t.length +1];
	public static void main(String[] args) {
		
		
		for(int i=0;i<c.length;i++){
			c[i] = -1;
		}
		c[c.length-1] = 0;
		for(int i=0;i<c.length;i++){
			c[i] = Func(i,0);
		}
		//Print the total dissatisfaction
		System.out.print (c[1] + " ");

	}
	
	public static double Func(int i,int T){
		double result1=Double.MAX_VALUE,result2=Double.MAX_VALUE;
		
		if(i==n){return 0;}
		if(c[i]!=-1) return c[i];
		if(T==0){
			double temp=0;
			if(t[i] < (M-5)){
				temp= Math.pow((M-5) - (t[i]), 4);
			}
			result1 = temp+Func(i+1,0);
		}
		
		if(T+t[i] <= M){
			result2 = Func(i+1,T+t[i]);
		}
		else{
			double temp=0;
			if(T<(M-5)){
				temp= Math.pow((M-5) - T, 4);
			}
			result2 = temp + Func(i,0);
		}

		return Math.min(result1, result2);
	}


}
