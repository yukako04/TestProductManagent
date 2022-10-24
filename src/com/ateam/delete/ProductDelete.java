package com.ateam.delete;

import java.io.FileReader;
import java.io.IOException;

public class ProductDelete {
	/*public void execute() {
		System.out.println("「！商品情報を削除します！」");
		System.out.println("削除する商品IDを入力して下さい");
		System.out.println("----------------------------------");
		Scanner mode = new Scanner(System.in);
		String modeStr = mode.next();
		System.out.println("Keyword>>>");
	}
}
	 */

//public class 商品削除 {
//	public static void main(String[] args) {

	public void execute() {
	del();
	}

	    //ファイルの読み込み（動作しないので削除）
		public static void file(String[] args)throws IOException{
			FileReader fw = new FileReader("\\\\192.168.1.251\\第３教室生徒\\14_安仲弥生");
			System.out.println("すべてのデータを読んで表示します");
			int i = fw.read();
			while(i != -1) {
				char c = (char)i;
				System.out.println(c);
				i = fw.read();
			}
			
			
		
	}
	//自動入力
	public static void productinf() {
		System.out.println("商品コード＝");
		System.out.println("商品名＝");
		System.out.println("商品分類＝");
		System.out.println("販売単価＝");
		System.out.println("仕入単価＝");
		System.out.println("登録日");
	}
	
	public static void del() {
		System.out.println("商品情報を削除します。");
		System.out.println("削除する商品IDを入力してください。");
		System.out.print("商品ID＞");
		//キーボードから商品IDの入力を受け付ける
		int input = new java.util.Scanner(System.in).nextInt();
		
		//ここにIDチェックの処理を書く
		//booleanでtrueかfalseかチェックしていく
		//要素でデータ格納して配列で細かいところをいれる
		
		System.out.println("商品ID＝" + input);
		System.out.println("商品コード＝");
		System.out.println("商品名＝");
		System.out.println("商品分類＝");
		System.out.println("販売単価＝");
		System.out.println("仕入単価＝");
		System.out.println("登録日");
		System.out.print("商品情報を削除しますか？Y/N＞");
		String ｓ = new java.util.Scanner(System.in).nextLine();
		if(ｓ.equals ("Y")) {
			System.out.println("商品情報を削除しました。");
			System.out.println("続けて商品を削除しますか？");
		} else {
			System.out.println("続けて商品を削除しますか？");
		}
		
		System.out.print("1:続けて削除する  2:メニューへ戻る＞");
		int input2 = new java.util.Scanner(System.in).nextInt();
		
		if(input2 == 1) {
			//１の場合delメソッドのはじめに戻る処理
			del();
		} else {
			//２の場合メニュー画面に戻る処理
			
		}
		
		
	

	}

		
	}

