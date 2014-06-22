package com.test;

//Find the most expensive path in a DAG starting from vertex s

import java.util.ArrayList;
import java.util.List;

public class DynamicDAG {
	public static List<List<AdjNode>> DAG;
	public static int[] M;
	public static void main(String[] args) {
	
		DAG = new ArrayList<List<AdjNode>>();
		DAG.add(0,null);
		
		List<AdjNode> temp = new ArrayList<AdjNode>();
		temp.add(new AdjNode(2,1));
		temp.add(new AdjNode(6,1));
		DAG.add(1,temp);
		
		temp = new ArrayList<AdjNode>();
		temp.add(new AdjNode(3,3));
		temp.add(new AdjNode(4,4));
		DAG.add(2,temp);
		
		temp = new ArrayList<AdjNode>();
		temp.add(new AdjNode(4,2));
		DAG.add(3,temp);
		
		temp = new ArrayList<AdjNode>();
		temp.add(new AdjNode(5,6));
		temp.add(new AdjNode(6,3));
		DAG.add(4,temp);
		
		temp = new ArrayList<AdjNode>();
		DAG.add(5,temp);
		
		temp = new ArrayList<AdjNode>();
		temp.add(new AdjNode(5,2));
		DAG.add(6,temp);
		
		M = new int[DAG.size()];
		for(int i=0;i<M.length;i++){
			M[i] = -1;
		}
		M[0] = 0;
		int s=3;
		for(int i=M.length -1;i>=s;i--){
			M[i] = Func(i);
		}
		int max = -1,ind=1;
		int t = M[s];
		System.out.print(s + " ");
		while(M[s]!=0){
			List<AdjNode> tempNode = DAG.get(s);
			for(AdjNode ad : tempNode){
				if(M[s]-M[ad.name] == ad.weight){
					System.out.print(ad.name + " ");
					s=ad.name;
					break;
				}
			}
		}

		
	}
	
	public static int Func(int v){
		
		List<AdjNode> tempNode = DAG.get(v);
		int max= -1;
		if(tempNode.size() == 0){
			return 0;
		}
		if(M[v]!=-1) {return M[v];}
		for(AdjNode ad : tempNode){
			int temp = ad.weight + Func(ad.name);
			if(temp > max){
				max = temp;
			}
		}
		M[v] = max;
		return max;
	}

}

class AdjNode{
	public int name;
	public int weight;
	
	AdjNode(int name,int weight){
		this.name = name;
		this.weight = weight;
	}
}
