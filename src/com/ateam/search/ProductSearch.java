package com.ateam.search;

import java.util.Scanner;

public class ProductSearch {
	public void execute() {
		
	
	while(true) {
		System.out.println("★商品検索を実行します");
		System.out.println("検索キーワードを入力してください");
		System.out.println("-------------------------------");
		System.out.println(">>>");
		Scanner search = new Scanner(System.in);
		String searchStr = search.next();
		System.out.print(">>>選択" + searchStr);
	
		if (searchStr.equals("")) {
			
		}
	
	}
	}

}
