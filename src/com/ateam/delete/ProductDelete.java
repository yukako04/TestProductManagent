package com.ateam.delete;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductDelete {

	@SuppressWarnings("finally")
	public void execute() {

		//public class 商品削除 {
		//	public static void main(String[] args) {
		//	del();
		//	}
		//
		//	    //ファイルの読み込み（動作しないので削除）
		//		public static void file(String[] args)throws IOException{
		//			FileReader fw = new FileReader("\\\\192.168.1.251\\第３教室生徒\\14_安仲弥生");
		//			System.out.println("すべてのデータを読んで表示します");
		//			int i = fw.read();
		//			while(i != -1) {
		//				char c = (char)i;
		//				System.out.println(c);
		//				i = fw.read();
		//			}
		//自動入力

		BufferedReader br = null;
		String str = "";
		String[] productInfo = null;
		List<String[]> productInfoList = new ArrayList<String[]>();
		try {
			br = new BufferedReader(
					new FileReader("C:\\pleiades2022\\workspace\\TwiceProductManagent\\Sampledata.csv"));
			while ((str = br.readLine()) != null) {
				productInfo = str.split(",");
				productInfoList.add(productInfo);
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

			while (true) {
				System.out.println("----------------------------------");
				System.out.println("商品情報を削除します。");
				System.out.println("削除する商品IDを入力してください。");
				System.out.print("商品ID＞");
				//キーボードから商品IDの入力を受け付ける
				String deleteTargetId = new java.util.Scanner(System.in).next();

				//ここにIDチェックの処理を書く
				//booleanでtrueかfalseかチェックしていく
				//要素でデータ格納して配列で細かいところをいれる
				String[] deleteProductInfo = null;
				for (String[] product : productInfoList) {
					if (product[0].equals(deleteTargetId)) {
						deleteProductInfo = product;
						break;
					}
				}

				if (deleteProductInfo == null) {
					System.out.println("該当する商品データがありません");
				} else {

					System.out.println("商品ID＝" + deleteTargetId);
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
						System.out.println("続けて商品を削除しますか？");
					} else {
						System.out.println("続けて商品を削除しますか？");
					}

					System.out.print("1:続けて削除する  2:メニューへ戻る＞");
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
}

//10月24日　編集分

package 商品管理システム;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductDelete {

	@SuppressWarnings("finally")
	public void execute() {

		
		BufferedReader br = null;
		String str;
		String[] productInfo;
		List<String> productInfoList = new ArrayList<String>();
		List<String[]> productInfoList2 = new ArrayList<String[]>();
		
		try {
			br = new BufferedReader(
					new FileReader("C:\\pleiades\\2022-06\\workspace\\商品管理システム\\12_サンプルデータ.csv"));
			while ((str = br.readLine()) != null) {
				productInfo = str.split(",");
				
				productInfoList.add(productInfo);
				productInfoList2.add(((String) productInfoList).split(","));
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

			while (true) {
				System.out.println("----------------------------------");
				System.out.println("商品情報を削除します。");
				System.out.println("削除する商品IDを入力してください。");
				System.out.print("商品ID＞");
				//キーボードから商品IDの入力を受け付ける
				String deleteTargetId = new java.util.Scanner(System.in).next();

				//ここにIDチェックの処理を書く
				//booleanでtrueかfalseかチェックしていく
				//要素でデータ格納して配列で細かいところをいれる
				String[] deleteProductInfo = null;
				for (String[] product : productInfoList) {
					if (product[0].equals(deleteTargetId)) {
						deleteProductInfo = product;
						break;
					}
				}

				if (deleteProductInfo == null) {
					System.out.println("該当する商品データがありません");
				} else {

					System.out.println("商品ID＝" + deleteTargetId);
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
						System.out.println("続けて商品を削除しますか？");
					} else {
						System.out.println("続けて商品を削除しますか？");
					}

					System.out.print("1:続けて削除する  2:メニューへ戻る＞");
					int input2 = new java.util.Scanner(System.in).nextInt();

					if (input2 == 1) {
						//１の場合delメソッドのはじめに戻る処理
						//		del();
						execute();
						
					}else{
						//２の場合メニュー画面に戻る処理
						return;

					}
				}
				
			return;
			
			}
				

		}

}
}
