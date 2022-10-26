package com.ateam.edit;

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

public class ProductEdit {

	//Scannerクラスのインスタンスを作成
	Scanner scanner = new Scanner(System.in);
	//入力ファイル
	File file_name = new File("C:\\pleiades2022\\workspace\\TwiceProductManagent\\Sampledata.csv");
	BufferedReader br = null;

	//CSVファイルのデータを一行毎にコレクションに格納
	List<String> list = new ArrayList<String>();

	//商品情報毎にも分けたデータを格納
	List<String[]> list2 = new ArrayList<String[]>();

	//入力された商品IDの要素数を格納
	int number;

	//入力された商品IDを格納するString
	String productId;

	//入力された変更情報の格納String
	String productCode;
	String productName;
	String productKind;
	String productPrice;
	String productPurchase;
	String registDate;
	String text1;
	String text2;

	//入力された変更情報をコレクションに格納
	List<String> editInfo = new ArrayList<String>();

	//detaLoad、edit、updataを処理するメソッド
	public void execute() {

		dataLoad();
		edit();
		updata();

	}

	//csvファイルを読み込むメソッド
	public void dataLoad() {
		try {
			String line;
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file_name), "Shift-JIS"));//"UTF-8"

			while ((line = br.readLine()) != null) {

				//リストにCSVの1行ごとのデータを追加
				list.add(line);
				//商品情報毎にも分けたデータを追加
				list2.add(line.split(",", -1));
			}

			//確認用
			System.out.println("list => " + list);

			for (int i = 0; i < list2.size(); i++) {
				System.out.println("list2(" + i + ") => " + Arrays.toString(list2.get(i)));
			}

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

	//変更する情報を入力するメソッド
	public void edit() {
		System.out.println("商品情報を変更します。");

		//IDを入力するメソッド呼び出し
		checkId();

		//入力されたIDに基づいた商品情報を変更する各メソッド呼び出し
		checkCode();

		checkName();

		checkKind();

		checkPrice();

		checkPurchase();

		checkRegistDate();

		System.out.println();

		//入力された情報をArrayListに追加
		editInfo.add(productCode);
		editInfo.add(productName);
		editInfo.add(productKind);
		editInfo.add(productPrice);
		editInfo.add(productPurchase);
		editInfo.add(registDate);

	}

	//商品情報を更新するメソッド
	public void updata() {
		System.out.print("商品情報を変更しますか？ Y/N >");
		text1 = scanner.nextLine();
		System.out.println();

		//変更する場合の処理
		if (text1.equals("Y")) {

			//入力情報を格納したeditInfoの要素の中を全て確認
			for (int j = 0; j < editInfo.size(); j++) {

				//editInfoの中に空文字出なかった場合に、list2に変更した情報を上書きする
				if (editInfo.get(j).isEmpty()) {
				} else {
					list2.get(number)[j + 1] = editInfo.get(j);

					//nullが入力されていた場合、空文字を代入(元のデータ削除)
					if (editInfo.get(j).equals("null")) {
						list2.get(number)[j + 1] = "";
					}
				}
			}

			//入力された更新情報を出力
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
			
			

			//※要修正箇所
			//csvに変更情報を書き出す処理
			try {
				// 出力ファイルの作成
				FileWriter fw = new FileWriter(
						"C:\\pleiades2022\\workspace\\TwiceProductManagent\\Sampledata.csv",
						false);

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

			//次の処理についての入力を促すメッセージ
			System.out.println("続けて変更しますか？");
			System.out.print("1:続けて変更する　2:メニューへ戻る > ");
			text2 = scanner.nextLine();
			System.out.println();

			//続けて変更するを選択した場合、再度edit、updataメソッドを呼び出す
			if (text2.equals("1")) {
				edit();
				updata();

				//メニューに戻るを選択した場合、Menuクラスmainメソッドを呼び出す
			} else if (text2.equals("2")) {
				System.out.println("メニューに戻ります。");
			    Menu.main(null);
			}

			//変更しない場合の処理
		} else if (text1.equals("N")) {

			//次の処理について入力を促すメッセージ
			System.out.println("続けて変更しますか？");
			System.out.print("1:続けて変更する　2:メニューへ戻る > ");
			text2 = scanner.nextLine();
			System.out.println();

			//続けて変更するを選択した場合、再度edit、updataメソッドを呼び出す
			if (text2.equals("1")) {
				edit();
				updata();

				//メニューに戻るを選択した場合、Menuクラスmainメソッドを呼び出す
			} else if (text2.equals("2")) {
				System.out.println("メニューに戻ります。");
				//●Menu.main(null);
			}
		}
	}

	//商品IDに関するメソッド
	public void checkId() {

		//商品IDの入力を促すメッセージ
		System.out.println("変更する商品IDを入力してください。");
		System.out.println();
		System.out.print("商品ID > ");

		//入力された内容をインスタンスから取得
		productId = scanner.nextLine();

		//商品IDが存在するか
		//入力されたIDと一致するものlist2から探すfor文処理
		for (int i = 0; i < list2.size(); i++) {

			//一致すればその行の情報を出力・入力するメソッド呼び出し
			if (productId.equals(list2.get(i)[0])) {

				//変更処理しているlist2.get(i)の要素数をnumberに代入
				number = i;
			}
		}

		//一致する商品IDが存在しない場合
		if (!productId.equals(list2.get(number)[0])) {
			System.out.println("存在しない商品IDです。商品IDを確認してください。");
			checkId();
		}

	}

	//商品コードに関するメソッド
	public void checkCode() {

		//変更情報を入力する処理
		System.out.print("商品コ-ド[" + list2.get(number)[1] + "] > ");
		productCode = scanner.nextLine();

		//nullと入力されていない場合
		if (!productCode.matches("null")) {

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
		}

		//商品コードが重複していないこと
		//入力された商品コードと変更したい箇所の商品コードが異なるか
		if (!productCode.equals(list2.get(number)[1])) {

			//異なる場合、list2の商品コードのデータを全て確認する
			for (int j = 0; j < list2.size(); j++) {

				//その中で入力したものと一致する商品コードがあれば重複とみなす
				if (productCode.matches(list2.get(j)[1])) {
					System.out.println("この商品コードはすでに使用されています。");
					checkCode();
				}
			}
		}
	}

	//商品名に関するメソッド
	public void checkName() {

		//変更情報を入力する処理
		System.out.print("商品名[" + list2.get(number)[2] + "] > ");
		productName = scanner.nextLine();

		//商品名が100バイトを超えていないか
		if (!(productName.getBytes().length <= 100)) {
			System.out.println("商品名は１００バイト（全角５０文字）以下で入力してください。");
			checkName();
		}
	}

	//商品分類に関するメソッド
	public void checkKind() {

		//変更情報を入力する処理
		System.out.print("商品分類[" + list2.get(number)[3] + "] > ");
		productKind = scanner.nextLine();

		//商品分類が100バイト超えていないか
		if (!(productKind.getBytes().length <= 100)) {
			System.out.println("商品分類は１００バイト（全角５０文字）以下で入力してください。");
			checkKind();
		}
	}

	//販売単価に関するメソッド
	public void checkPrice() {

		//変更情報を入力する処理
		System.out.print("販売単価[" + list2.get(number)[4] + "] > ");
		productPrice = scanner.nextLine();

		//nullと入力されてない場合
		if (!productPrice.matches("null")) {

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
	}

	//仕入単価に関するメソッド
	public void checkPurchase() {

		//入力を促すメッセージ
		System.out.print("仕入単価[" + list2.get(number)[5] + "] > ");
		productPurchase = scanner.nextLine();

		//nullと入力されていない場合
		if (!productPurchase.matches("null")) {

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
	}

	//登録日に関するメソッド
	public void checkRegistDate() {

		//入力を促すメッセージ
		System.out.print("登録日[" + list2.get(number)[6] + "] > ");
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