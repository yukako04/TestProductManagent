package com.ateam.create;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.ateam.Menu;

/*
	public void execute() {
		System.out.println("Keyword>>>");
 */
public class ProductCreate {
	//Scannerクラスのインスタンスを作成
	Scanner scanner = new Scanner(System.in);
	
	//CSVファイルのデータを一行毎にコレクションに格納
	List<String> list = new ArrayList<String>();

	//商品情報毎にも分けたデータを格納
	List<String[]> list2 = new ArrayList<String[]>();
	
	File file_name = new File("C:\\pleiades2022\\workspace\\TwiceProductManagent\\Sampledata.csv");
	BufferedReader br = null;

	String productId;
	String productCode;
	String productName;
	String productKind;
	String productPrice;
	String productPurchase;
	String registDate;

	public void execute() {
		dataLoad();
		create();

		//Map<String, Member> memberMap;
		//private static long id = 0;

		//	memberMap = new HashMap<String, Member>();
		//}

		//public static void main(String[] args) {
		//Member member = new Member();
	}

	public void dataLoad() {
		
		String str = "";
		String[] productInfo = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file_name), "Shift-JIS"));

			//↓while ((productInfo = br.readLine().split(",")) != null) {
			//処理を分けました
			while ((str = br.readLine()) != null) {
				productInfo = str.split(",");
				//リストにCSVの1行ごとのデータを追加
				list.add(str);
				//商品情報毎にも分けたデータを追加
				list2.add(str.split(",", -1));

			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				br.close();

			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
	}

	
	
	public void create() {

		System.out.println("商品情報を登録します。");
		System.out.println("商品情報を入力してください。");
		System.out.println();

		checkId();

		checkCode();

		checkName();

		checkKind();

		checkPrice();

		checkPurchase();

		checkRegistDate();

		//入力された変更情報をコレクションに格納
		String[] inputInfo = { productId, productCode, productName, productKind, productPrice, productPurchase,
				registDate };

		System.out.println();

		System.out.println("商品情報を登録しますか？Y/N > ");
		String text1 = scanner.nextLine();
		System.out.println();

		if (text1.equals("Y")) {

			//editInfoをlist2に追加
			list2.add(inputInfo);

			//確認用
			for (int i = 0; i < list2.size(); i++) {
				System.out.println("list2(" + i + ") => " + Arrays.toString(list2.get(i)));
			}
			
			//csvに変更情報を書き出す処理
			try {
				// 出力ファイルの作成
				FileWriter fw = new FileWriter(file_name, false);

				// PrintWriterクラスのオブジェクトを生成
				PrintWriter pw = new PrintWriter(new BufferedWriter(fw));

				// データを書き込む
				for (int i = 0; i < list2.size(); i++) {
					for (int j = 0; j < list2.get(i).length; j++) {
						pw.print(list2.get(i)[j]);

						//※要修箇所
						if (!list2.get(i)[j].matches(".{8}")) {
							pw.print(",");
						}
					}
					//一行読み込み終わったら改行
					pw.println();
				}
				// ファイルを閉じる
				pw.close();

				// 出力に失敗したときの処理
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			

			System.out.println("続けて商品を登録しますか？");
			System.out.print("1:続けて登録する 2:メニューへ戻る > ");
			String text2 = scanner.nextLine();

			if (text2.equals("1")) {
				create();

			} else if (text2.equals("2")) {
				Menu.main(null);
			}

		} else if (text1.equals("N")) {
			System.out.println("続けて商品を登録しますか？");
			System.out.print("1:続けて登録する 2:メニューへ戻る > ");
			String text2 = scanner.nextLine();

			if (text2.equals("1")) {
				create();

			} else if (text2.equals("2")) {
				Menu.main(null);
			}

		}
	}

	//商品IDに関するメソッド
	public void checkId() {

		//商品IDの入力を促すメッセージ

		System.out.print("商品ID > ");

		//入力された内容をインスタンスから取得
		productId = scanner.nextLine();

		if (!productId.matches(".{10}")) {
			System.out.println("商品コードは10桁で入力してください。");
			checkId();
		}

		//商品IDが半角英数字,半角ハイフン、半角アンダースコアであるか
		if (!productId.matches("[0-9a-zA-Z\\\\-\\\\_]+")) {
			System.out.println("商品IDは半角英数字で入力してください。");
			checkId();
		}

		//商品IDが重複していないこと
		//list2の商品コードのデータを全て確認する
		for (int j = 0; j < list2.size(); j++) {

			//その中で入力したものと一致する商品コードがあれば重複とみなす
			if (productId.matches(list2.get(j)[1])) {
				System.out.println("この商品IDはすでに使用されています。");
				checkId();
			}
		}

	}

	//商品コードに関するメソッド
	public void checkCode() {

		//変更情報を入力する処理
		System.out.print("商品コ-ド > ");
		productCode = scanner.nextLine();

		//商品コードが半角数字であるか
		if (!productCode.matches("^[0-9]*$")) {
			System.out.println("商品コードは半角数字で入力してください。");
			checkCode();
		}

		//商品コードが13桁であるか(空文字はtrueになるように)
		if (productCode.isEmpty()) {
		} else if (!productCode.matches(".{13}")) {
			System.out.println("商品コードは13桁で入力してください。");
			checkCode();
		}

		//商品コードが重複していないこと
		//list2の商品コードのデータを全て確認する
		for (int j = 0; j < list2.size(); j++) {

			//その中で入力したものと一致する商品コードがあれば重複とみなす
			if (productCode.matches(list2.get(j)[1])) {
				System.out.println("この商品コードはすでに使用されています。");
				checkCode();
			}
		}
	}

	//商品名に関するメソッド
	public void checkName() {

		//変更情報を入力する処理
		System.out.print("商品名 > ");
		productName = scanner.nextLine();

		//商品名が入力されているか
		if (productName.isEmpty()) {
			System.out.println("商品名を入力してください");
			checkName();
		}

		//商品名が100バイトを超えていないか
		if (!(productName.getBytes().length <= 100)) {
			System.out.println("商品名は１００バイト（全角５０文字）以下で入力してください。");
			checkName();
		}
	}

	//商品分類に関するメソッド
	public void checkKind() {

		//変更情報を入力する処理
		System.out.print("商品分類 > ");
		productKind = scanner.nextLine();

		//商品分類が入力されているか
		if (productKind.isEmpty()) {
			System.out.println("商品分類を入力してください");
			checkName();
		}

		//商品分類が100バイト超えていないか
		if (!(productKind.getBytes().length <= 100)) {
			System.out.println("商品分類は１００バイト（全角５０文字）以下で入力してください。");
			checkKind();
		}
	}

	//販売単価に関するメソッド
	public void checkPrice() {

		//変更情報を入力する処理
		System.out.print("販売単価 > ");
		productPrice = scanner.nextLine();

		//販売単価が半角数字で入力されているか
		if (!productPrice.matches("^[0-9]*$")) {
			System.out.println("販売単価は半角数字で入力してください。");
			checkPrice();
		}

		//販売単価が8桁以下で入力されているか
		if (!productPrice.matches(".{0,8}")) {
			System.out.println("販売単価は８桁以下で入力してください。");
			checkPrice();
		}
	}

	//仕入単価に関するメソッド
	public void checkPurchase() {

		//入力を促すメッセージ
		System.out.print("仕入単価 > ");
		productPurchase = scanner.nextLine();

		//仕入単価が半角数字で入力されているか
		if (!productPurchase.matches("^[0-9]*$")) {
			System.out.println("仕入単価は半角数字で入力してください。");
			checkPrice();
		}

		//仕入単価が8桁以下で入力されているか
		if (!productPurchase.matches(".{0,8}")) {
			System.out.println("仕入単価は８桁以下で入力してください。");
			checkPrice();
		}
	}

	//登録日に関するメソッド
	public void checkRegistDate() {

		//入力を促すメッセージ
		System.out.print("登録日 > ");
		registDate = scanner.nextLine();

		//nullまたは空文字で入力されていない場合
		if (!registDate.matches("null")) {
			if (!registDate.isEmpty()) {

				//8桁の日付で入力されているか
				if (!registDate.matches(".{8}")) {
					System.out.println("登録日は８桁の日付で入力してくだい。");
					checkRegistDate();
				}

				//日付で入力されているか
				try {
					DateTimeFormatter.ofPattern("uuuuMMdd").withResolverStyle(ResolverStyle.STRICT)
							.parse(registDate, LocalDate::from);
				} catch (DateTimeParseException e) {
					System.out.println("登録日は日付ではありません。８桁の日付で入力してくだい。");
					checkRegistDate();
				}
			}
		}
	}
}
