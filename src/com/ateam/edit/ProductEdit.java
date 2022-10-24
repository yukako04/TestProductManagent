package ProductEdit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import Menu.Menu;

public class ProductEdit {
	public void execute() {
		Productdata data = new Productdata();
		data.dataLoad();
		data.edit();
		data.updata();

	}

	public class Productdata {
		//Scannerクラスのインスタンスを作成
		Scanner scanner = new Scanner(System.in);

		File file_name = new File("C:\\pleiades\\2022-06\\workspace\\ProductManage\\12_サンプルデータ.csv");//入力ファイル
		BufferedReader br = null;

		//CSVファイルのデータを一行毎にコレクションに格納
		List<String> list = new ArrayList<String>();
		//商品情報毎にも分けたデータを格納
		List<String[]> list2 = new ArrayList<String[]>();

		//入力された商品IDの要素数を格納
		int number;

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
		List<String> txT = new ArrayList<String>();

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

		public void edit() {
			System.out.println("商品情報を変更します。");

			checkId();

			for (int i = 0; i < list2.size(); i++) {
				if (productId.equals(list2.get(i)[0])) {
					number = i;

					checkCode();

					checkName();

					checkKind();

					checkPrice();

					checkPurchase();

					checkRegistDate();

					System.out.println();

					txT.add(productCode);
					txT.add(productName);
					txT.add(productKind);
					txT.add(productPrice);
					txT.add(productPurchase);
					txT.add(registDate);

				}

			}

		}

		public void updata() {
			System.out.print("商品情報を変更しますか？ Y/N >");

			text1 = scanner.nextLine();
			System.out.println();

			if (text1.equals("Y")) {
				for (int j = 0; j < txT.size(); j++) {
					if (txT.get(j).isEmpty()) {
					} else {
						list2.get(number)[j + 1] = txT.get(j);
						if (txT.get(j).equals("null")) {
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
				text2 = scanner.nextLine();
				System.out.println();

				try {
					FileWriter pw = new FileWriter(file_name);
					for (int i = 0; i < list2.size(); i++) {
						pw.append(String.join(",", list2.get(i)));
						{
						}

					}
				} catch (IOException e) {
					e.printStackTrace();
				}

				if (text2.equals("1")) {
					edit();
					updata();

				} else if (text2.equals("2")) {
					System.out.println("メニューに戻ります。");
					Menu.main(null);

				}

			} else if (text1.equals("N")) {
				System.out.println("続けて変更しますか？");
				System.out.print("1:続けて変更する　2:メニューへ戻る > ");
				text2 = scanner.nextLine();
				System.out.println();

				if (text2.equals("1")) {
					edit();
					updata();

				} else if (text2.equals("2")) {
					System.out.println("メニューに戻ります。");
					Menu.main(null);
				}

			}
		}

		public void checkId() {
			System.out.println("変更する商品IDを入力してください。");
			System.out.println();

			//入力を促すメッセージ
			System.out.print("商品ID > ");

			//入力された内容をインスタンスから取得
			productId = scanner.nextLine();

			//商品IDが存在するかどうか
			if (productId.equals(list2.get(number)[0])) {
			} else {
				System.out.println("存在しない商品IDです。商品IDを確認してください。");

			}
		}

		public void checkCode() {
			System.out.print("商品コ-ド[" + list2.get(number)[1] + "] > ");
			productCode = scanner.nextLine();

			//商品コードが半角数字であるかどうか
			if (!productCode.matches("^[0-9]*$")) {
				System.out.println("商品コードは半角数字で入力してください。");
				checkCode();
			}

			//商品コードが13桁であること
			if (productCode.isEmpty()) {

			} else if (!productCode.matches(".{13}")) {
				System.out.println("商品コードは13桁で入力してください。");
				checkCode();
			}

			//商品コードが重複していないこと
			if (!productCode.equals(list2.get(number)[1])) {
				for (int j = 0; j < list2.size(); j++) {
					if (productCode.matches(list2.get(j)[1])) {
						System.out.println("この商品コードはすでに使用されています。");
						checkCode();
					}

				}
			}

		}

		public void checkName() {
			System.out.print("商品名[" + list2.get(number)[2] + "] > ");
			productName = scanner.nextLine();

			if (!(productName.getBytes().length <= 100)) {
				System.out.println("商品名は１００バイト（全角５０文字）以下で入力してください。");
				checkName();
			}

		}

		public void checkKind() {
			System.out.print("商品分類[" + list2.get(number)[3] + "] > ");
			productKind = scanner.nextLine();

			if (!(productKind.getBytes().length <= 100)) {
				System.out.println("商品分類は１００バイト（全角５０文字）以下で入力してください。");
				checkName();
			}
		}

		public void checkPrice() {
			System.out.print("販売単価[" + list2.get(number)[4] + "] > ");
			productPrice = scanner.nextLine();

			if (!productPrice.matches("^[0-9]*$")) {
				System.out.println("販売単価は半角数字で入力してください。");
				checkPrice();
			}

			if (!productPrice.matches(".{0,8}")) {
				System.out.println("販売単価は８桁以下で入力してください。");
				checkPrice();
			}

		}

		public void checkPurchase() {
			System.out.print("仕入単価[" + list2.get(number)[5] + "] > ");
			productPurchase = scanner.nextLine();
			if (!productPurchase.matches("^[0-9]*$")) {
				System.out.println("仕入単価は半角数字で入力してください。");
				checkPrice();
			}

			if (!productPurchase.matches(".{0,8}")) {
				System.out.println("仕入単価は８桁以下で入力してください。");
				checkPrice();
			}

		}

		public void checkRegistDate() {
			System.out.print("登録日[" + list2.get(number)[6] + "] > ");
			registDate = scanner.nextLine();

			if (registDate.isEmpty()) {
			} else if (!registDate.matches(".{8}")) {
				System.out.println("登録日は８桁の日付で入力してくだい。");
				checkRegistDate();
			}

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
