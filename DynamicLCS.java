package com.test;
//Delete characters to make two strings same - Longest Common Subsequence
public class DynamicLCS {

	private static char[] S ={'A','B','A','Z','D','C'};
	private static char[] T ={'B','A','C','B','A','D'};
	private static int[][] LCS = new int[S.length + 1][T.length + 1];
	
	public static void main(String[] args) {

		
		
		for(int i=0;i<=S.length;i++){
			for(int j=0;j<=T.length;j++){
				LCS[i][j]= -1;
			}
		}
		for(int j=1;j<=S.length;j++){
			LCS[0][j] = 0;
		}
		for(int i=0;i<=T.length;i++){
			LCS[i][0] = 0;
		}
		for(int i=1;i<=S.length;i++){
			for(int j=1;j<=T.length;j++){
				LCS[i][j]= getLCS(i,j);
			}
		}
		
		for(int i=1;i<=S.length;i++){
			for(int j=1;j<=T.length;j++){
				System.out.print(LCS[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	public static int getLCS(int i,int j){
		int result;
		if(i==0 || j==0) {return 0;}
		if(LCS[i][j] != -1) {return LCS[i][j];}
		if(S[i-1] == T[j-1]){ result = 1+ getLCS(i-1,j-1);}
		else {result = Math.max(getLCS(i-1,j), getLCS(i,j-1));}
		return result;	
	}

}
