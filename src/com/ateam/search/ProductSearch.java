package com.ateam.search;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ProductSearch {
	private String[][] productInfoList;

	public void execute() {

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
		while (true) {
			System.out.println("----------------------------------");
			System.out.println("★商品検索を実行します");
			System.out.println("検索キーワードを入力して下さい");
			System.out.println("----------------------------------");
			System.out.println("Keyword>>>");
			Scanner mode = new Scanner(System.in);
			String modeStr = mode.next();
			//キーボードから商品IDの入力を受け付ける
			//String searchTargetId = new java.util.Scanner(System.in).next();

			
			String[] searchProductInfo = null;
			String searchTargetKeyword = null;
			for (String[] product : productInfoList) {
				if (product[0].equals(searchTargetKeyword)) {
					searchProductInfo = product;
					break;
				}
			}

			if (searchProductInfo == null) {
				System.out.println("該当する商品データがありません");
			} else {

				System.out.println("商品ID＝" + searchTargetKeyword);
				System.out.println("商品コード＝");
				System.out.println("商品名＝");
				System.out.println("商品分類＝");
				System.out.println("販売単価＝");
				System.out.println("仕入単価＝");
				System.out.println("登録日");

				System.out.println("----------------------------------");
				
				System.out.print("商品情報を削除しますか？Y/N＞");
				String ｓ = new java.util.Scanner(System.in).nextLine();
				if (ｓ.equals("Y")) {
					System.out.println("商品情報を削除しました。");
					System.out.println();
					System.out.println("続けて商品を検索しますか？");
				} else {
					System.out.println("続けて商品を検索しますか？");
				}

				System.out.print("1:続けて検索する 2:メニューへ戻る > 1");
				int input2 = new java.util.Scanner(System.in).nextInt();

				if (input2 == 1) {
					//１の場合delメソッドのはじめに戻る処理
					//		del();
				}
				{
					//２の場合メニュー画面に戻る処理

				}
			}
			return;
		}

	}
}