package com.test;
//Remove characters from a string to make it palindrome and print them
public class DynamicPalindrome {

	private static char[] S ={'A','B','C','E','D','E','C','F','B','A'};
	private static int[][] Palin = new int[S.length + 1][S.length + 1];
	
	public static void main(String[] args) {
		for(int i=0;i<=S.length;i++){
			for(int j=0;j<=S.length;j++){
				Palin[i][j]= -1;
			}
		}
		for(int j=1;j<=S.length;j++){
			Palin[0][j] = 0;
		}
		for(int i=0;i<=S.length;i++){
			Palin[i][0] = 0;
		}
		for(int i=1;i<=S.length;i++){
			for(int j=S.length;j>=1;j--){
				Palin[i][j]= checkPAL(i,j);
			}
		}

		int i=1,j=S.length;
		while(i<j){
			if(S[i-1]==S[j-1]){
				i=i+1;
				j=j-1;
			}
			else if(Palin[i+1][j] < Palin[i][j-1]){
				System.out.print(S[i-1] + " ");
				i=i+1;
				
			}
			else{
				System.out.print(S[j-1] + " ");
				j=j-1;
				
			}
		}
	}
	
	public static int checkPAL(int i,int j){
		int result;
		if(i >j) return 0;
		if(Palin[i][j] != -1) {return Palin[i][j];}
		if(S[i-1] == S[j-1]){ result = checkPAL(i+1,j-1);}
		else {result = Math.min(1+ checkPAL(i+1,j), 1+ checkPAL(i,j-1));}
		return result;	
	}

}
