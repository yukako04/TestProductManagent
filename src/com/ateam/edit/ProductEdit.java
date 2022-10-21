package com.ateam.edit;

import java.util.Scanner;

public class ProductEdit {
	public void execute() {
		System.out.println("▲商品情報を変更します");
		System.out.println("変更する商品IDを入力して下さい");
		System.out.println("----------------------------------");
		Scanner mode = new Scanner(System.in);
		String modeStr = mode.next();
		System.out.println("Keyword>>>");

	}

}



import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class shohinHenkou2 {
	public static void main(String[] args) {
		shohinHenkou2 shohin = new shohinHenkou2();
		Shohindata data = shohin.new Shohindata();
		data.dataLoad();

		data.changeInfoInput();

		data.updata();

	}

	public class Shohindata {
		File file_name = new File("\\12_サンプルデータ.csv");//入力ファイル
		BufferedReader br = null;

		//CSVファイルのデータを一行毎にコレクションに格納
		List<String> list = new ArrayList<String>();
		//商品情報毎にも分けたデータを格納
		List<String[]> list2 = new ArrayList<String[]>();

		//入力された商品IDの要素数を格納
		int number;
		
		//入力されたtextを格納するString
		String text;

		//入力された変更情報の格納String
		String tx1;
		String tx2;
		String tx3;
		String tx4;
		String tx5;
		String tx6;
		String tx7;
		String tx8;

		//入力された変更情報をコレクションに格納
		List<String> txT = new ArrayList<String>();
		
		//CSVファイルから商品情報を読み込むメソッド
		public void dataLoad() {
			try {
				String line;
				String[] data;
				br = new BufferedReader(new InputStreamReader(new FileInputStream(file_name), "Shift-JIS"));

				while ((line = br.readLine()) != null) {
					data = line.split(",");

					//リストにCSVの1行ごとのデータを追加
					list.add(line);
					//商品情報毎にも分けたデータを追加
					list2.add(line.split(","));

				}

				//確認用
				//System.out.println("list => " + list);

				//for (int i = 0; i < list2.size(); i++) {
				//System.out.println("list2(" + i + ") => " +Arrays.toString(list2.get(i)));
				//}

			} catch (Exception e) {
				System.out.println(e.getMessage());

			} finally {
				try {
					br.close();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}

		}

		//商品情報の変更する入力メソッド
		public void changeInfoInput() {
			System.out.println("商品情報を変更します。");
			System.out.println("変更する商品IDを入力してください。");
			System.out.println();

			//Scannerクラスのインスタンスを作成
			Scanner scanner = new Scanner(System.in);

			//入力を促すメッセージ
			System.out.print("商品ID > ");

			//入力された内容をインスタンスから取得
			text = scanner.nextLine();

			for (int i = 0; i < list2.size(); i++) {
				if (text.equals(list2.get(i)[0])) {

					System.out.print("商品コ-ド[" + list2.get(i)[1] + "] > ");
					tx1 = scanner.nextLine();
					System.out.print("商品名[" + list2.get(i)[2] + "] > ");
					tx2 = scanner.nextLine();
					System.out.print("商品分類[" + list2.get(i)[3] + "] > ");
					tx3 = scanner.nextLine();
					System.out.print("販売単価[" + list2.get(i)[4] + "] > ");
					tx4 = scanner.nextLine();
					System.out.print("仕入単価[" + list2.get(i)[5] + "] > ");
					tx5 = scanner.nextLine();
					System.out.print("登録日[" + list2.get(i)[6] + "] > ");
					tx6 = scanner.nextLine();
					System.out.println();
					
　　　　　　　　　　　　　　　　　　　　　　//入力された商品コードがある要素数iをnumberに代入
					number = i;
					
                                        //入力された商品情報の変更内容をコレクションtxTに追加
					txT.add(tx1);
					txT.add(tx2);
					txT.add(tx3);
					txT.add(tx4);
					txT.add(tx5);
					txT.add(tx6);

				}

			}
			
		}
		
                //商品情報を更新するメソッド
		public void updata() {
			System.out.print("商品情報を変更しますか？ Y/N >");
			Scanner scanner = new Scanner(System.in);
			tx7 = scanner.nextLine();
			System.out.println();

			if (tx7.equals("Y")) {
				for (int j = 0; j < txT.size(); j++) {
					if (txT.get(j).isEmpty()) {
					} else {　//空文字でない場合、入力された商品情報を上書き
						list2.get(number)[j + 1] = txT.get(j);
						if (txT.get(j).equals("null")) { //nullが入力されていると空文字で上書き(削除)
							list2.get(number)[j + 1] = "";

						}
					}

				}
				System.out.print("商品ID = " + list2.get(number)[0]);
				System.out.println();
				System.out.print("商品コ-ド = " + list2.get(number)[1]);
				System.out.println();
				System.out.print("商品名 = " + list2.get(number)[2]);
				System.out.println();
				System.out.print("商品分類 = " + list2.get(number)[3]);
				System.out.println();
				System.out.print("販売単価 = " + list2.get(number)[4]);
				System.out.println();
				System.out.print("仕入単価 = " + list2.get(number)[5]);
				System.out.println();
				System.out.print("登録日 = " + list2.get(number)[6]);
				System.out.println();
				System.out.println();

				System.out.println("続けて変更しますか？");
				System.out.print("1:続けて変更する　2:メニューへ戻る > ");
				tx8 = scanner.nextLine();
				System.out.println();

				if (tx8.equals("1")) {
					changeInfoInput();
					updata();

				} else if (tx8.equals("2")) {
					System.out.println("メニューに戻ります。");

				}

			} else if (tx7.equals("N")) {
				System.out.println("続けて変更しますか？");
				System.out.print("1:続けて変更する　2:メニューへ戻る > ");
				tx8 = scanner.nextLine();
				System.out.println();

				if (tx8.equals("1")) {
					changeInfoInput();
					updata();

				} else if (tx8.equals("2")) {
					System.out.println("メニューに戻ります。");
				}

			}
		}
		
		//入力された商品情報のチェックするメソッド
		public void condition() {
			

		}

	}

}
