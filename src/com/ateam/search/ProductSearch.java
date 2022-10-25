package com.ateam.search;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ProductSearch {
	private String[][] productInfoList;

	public void execute() {
		while (true) {
			System.out.println("----------------------------------");
			System.out.println("★商品検索を実行します");
			System.out.println("検索キーワードを入力して下さい");
			System.out.println("----------------------------------");
			System.out.println("Keyword>>>");
			Scanner mode = new Scanner(System.in);
			String modeStr = mode.next();

			//キーボードからキーワードの入力を受け付ける
			//String searchTargetId = new java.util.Scanner(System.in).next();

			//csvファイルの読み込み
			BufferedReader br = null;
			String str = "";
			String[] productInfo = null;
			try {
				br = new BufferedReader(
						new FileReader("C:\\pleiades2022\\workspace\\TwiceProductManagent\\Sampledata.csv"));
				while ((str = br.readLine()) != null) {
					productInfo = str.split(",");
					//★商品データを表示				
					System.out.println(java.util.Arrays.toString(productInfo));
					//				System.out.println(productInfo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					br.close();

				} catch (IOException e) {
				}
			}
			System.out.println("----------------------------------");
			System.out.println("続けて商品を削除しますか？");
			System.out.print("1:続けて削除する 2:メニューへ戻る＞");
			//キーボードから商品IDの入力を受け付ける
			String inputNextMenu = new java.util.Scanner(System.in).next();
			
			if(inputNextMenu.equals("2")) {
				break;
			}
			}

		}
	}

