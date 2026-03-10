package com.battle;

import java.util.Scanner;

public class Main {
	public static boolean canWin(int start,int[]villains,int m,int h) {
		int hero=1;
		int heroHealth=h;
		
		for(int i=start;i< villains.length;i++) {
			int v= villains[i];
			while(v>0&& hero<=m) {
				if(heroHealth>v) {
					heroHealth-=v;
					v=0;
				}
				else if(heroHealth<v) {
					v-=heroHealth;
					hero++;
					heroHealth=h;
					
				}
				else {
					hero++;
					heroHealth=h;
					v=0;
				}
			}
			if(hero>m && v>0)
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int h=sc.nextInt();
		
		int[] villains=new int[n];
		for(int i=0;i<n;i++) {
			villains[i]=sc.nextInt();
		}
		for(int remove=0;remove<n;remove++) {
			if(canWin(remove,villains,m,h)) {
				System.out.println(remove);
				return;
			}
		}
		System.out.println(n);

	}

}
