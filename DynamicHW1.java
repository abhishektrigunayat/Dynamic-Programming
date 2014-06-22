package com.test;

class Project{
	public int nos;
	public int nob;
	public int g;
	Project(int nos,int nob,int g){
		this.nos = nos;
		this.nob = nob;
		this.g = g;
	}
}

public class DynamicHW1 {
	public static int NOS = 20,BOS=50;
	public static int[][][] OPT = new int[6][NOS+1][BOS+1];
	public static Project[] arr = new Project[6];
	public static void main(String[] args) {
		
		Project p = new Project(2,2,2);
		arr[1] = p;
		p = new Project(8,2,7);
		arr[2] = p;
		p = new Project(5,2,5);
		arr[3] = p;
		p = new Project(10,2,60);
		arr[4] = p;
		p = new Project(10,20,3);
		arr[5] = p;
		
		int S=NOS,B=BOS;
		
		for(int i=0;i<6;i++){
			for(int j=0;j<S+1;j++){
				for(int k=0;k<B+1;k++){
					OPT[i][j][k]=-1;
				}
			}
		}
		
		for(int j=0;j<NOS+1;j++){
			OPT[0][j][0] = 0;
		}
		for(int i=0;i<6;i++){
			OPT[i][0][0] = 0;
		}
		for(int k=0;k<BOS+1;k++){
			OPT[0][0][k] = 0;
		}
		
		for(int i=5;i>0;i--){
			for(int j=NOS;j>0;j--){
				for(int k=BOS;k>0;k--){
					OPT[i][j][k]= Func(i,j,k);
				}
			}
		}
		
		System.out.println(OPT[5][NOS][BOS]);

		for(int i=5;i>0;i--){
			System.out.println(" i = " + i);
			for(int j=NOS;j>0;j--){
				for(int k=BOS;k>0;k--){
					System.out.print(OPT[i][j][k] + " ");
				}
				System.out.println("");
			}
		}

		int i=5,j=NOS,k=BOS;
		System.out.println("Printing projects");
		i=5;j=NOS;k=BOS;
		while(i>0&& j>0&&k>0){
			int result1=-1,result2=-1;
			if(j-arr[i].nos >=0 && k-arr[i].nob >=0){
				result1 = OPT[i][j][k];
			}
			result2 = OPT[i-1][j][k];
			if(result1 > result2){
				System.out.println(i);
				j=j-arr[i].nos;
				k=k-arr[i].nob;
				i--;
			}
			else{
				i--;
			}
		}

	}
	
	public static int Func(int i,int S,int B){
		int result1=0,result2=0;
		if(i<1 || S<1 || B<1)return 0;
		if(OPT[i][S][B] !=-1) return OPT[i][S][B];
		if(S-arr[i].nos >=0 && B-arr[i].nob >=0){
			result1=  arr[i].g + Func(i-1,S-arr[i].nos,B-arr[i].nob); 
		}
		result2= Func(i-1,S,B);
			
		return Math.max(result1, result2);

	}	
	
	public static int FuncCopy(int i,int S,int B){
		int result1=0,result2=0;
		if(i>5 || S<1 || B<1){
			return 0;
		}

		if(S-arr[i].nos >=0 && B-arr[i].nob >=0){
			result1=  arr[i].g + FuncCopy(i+1,S-arr[i].nos,B-arr[i].nob); 
		}
		result2= FuncCopy(i+1,S,B);
			
		return Math.max(result1, result2);

	}
	


}
