package com.ateam.search;

import java.util.Scanner;

public class ProductSearch {
	public void execute() {
		System.out.println("★商品検索を実行します");
		System.out.println("検索キーワードを入力して下さい");
		System.out.println("----------------------------------");
		Scanner mode = new Scanner(System.in);
		String modeStr = mode.next();
		System.out.println("Keyword>>>");

		
	
	}

}
package common;

public class End {
	public static void main(String[] args) {
		System.out.println("現在の処理を終了したい場合は、exitか\\qを入力してください");
		String s1 = "exit";
		String s2 = "\\q";
		String s = new java.util.Scanner(System.in).nextLine();
		if (s1.equals(s) || s2.equals(s)) {
			System.out.println("プログラムを終了します。");
			System.exit(0);
		} else {
			System.out.println("正しく入力してください。");
		}
	}
}
