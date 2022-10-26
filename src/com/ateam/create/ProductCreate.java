
package com.ateam.create;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
	public void execute() {
		System.out.println("Keyword>>>");
 */
public class ProductCreate {
	//public class create {

	public void execute() {
		System.out.println("■商品情報を登録します");
		System.out.println("商品情報を入力して下さい");
		System.out.println("----------------------------------");

		//Map<String, Member> memberMap;
		//private static long id = 0;

		//	memberMap = new HashMap<String, Member>();
		//}

		//public static void main(String[] args) {
		//Member member = new Member();

		BufferedReader br = null;
		String str = "";
		String[] productInfo = null;
		try {
			br = new BufferedReader(
					new FileReader("C:\\pleiades2022\\workspace\\TwiceProductManagent\\Sampledata.csv"));
			//↓while ((productInfo = br.readLine().split(",")) != null) {
			//処理を分けました
			while ((str = br.readLine()) != null) {
				productInfo = str.split(",");
				//				System.out.println(java.util.Arrays.toString(productInfo));
				//				System.out.println(productInfo);
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

		try {
			BufferedWriter bw = new BufferedWriter(
					new FileWriter("C:\\pleiades2022\\workspace\\TwiceProductManagent\\Sampledata.csv", true));
			Scanner mode = new Scanner(System.in);
			//			ID,Code,Product Name,Classification,Sales Price,purchase price,Registration Date
			//			A000000001,1000000000001,シャツ1,衣服,1000,100,20200818
			System.out.println("商品ID>>>");
			String productId = mode.next();

			System.out.println("商品コード>>>");
			String productCode = mode.next();

			System.out.println("商品名>>>");
			String productName = mode.next();

			System.out.println("商品分類>>>");
			String productKind = mode.next();

			System.out.println("販売単価>>>");
			String productPrice = mode.next();

			System.out.println("仕入単価>>>");
			String productPurchase = mode.next();

			System.out.println("登録日>>>");
			String registDate = mode.next();

			String newLineStr = productId + "," + productCode + "," + productName + "," + productKind + ","
					+ productPrice + "," + productPurchase + "," + registDate;

			bw.newLine();
			bw.append(newLineStr);

			/*
			bw.newLine();
			bw.append("A999999999,9999999999999,まりも,未分類,1000,0,20220101");
			bw.newLine();
			bw.append("");
			bw.newLine();
			bw.append("");
			bw.newLine();
			bw.append("");
			bw.newLine();
			bw.append("");
			bw.newLine();
			bw.append("");
			bw.append("-,-,-,-,-,-");
			*/

			bw.close();

			while (true) {
				System.out.println("続けて商品を登録しますか？");
				System.out.println("1:続けて登録する　2:メニューへ戻る>>>");
				String modeStr = mode.next();

				if (modeStr.equals("2")) {
					System.out.println("");
					System.exit(2);
				} else if (modeStr.equals("1")) {

				}

			}

			//			bw.append(s+ ",");

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return;
	}

}
----------------------------------------------------------------------------------------------------------
//商品クラスを作成してリストに入れ込んで重複確認しようとしたけど、無理でした
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Shohin {
	Path path = Paths.get("C:\\\\pleiades\\\\2022-06\\\\workspace\\\\9999_登録用\\\\12_サンプルデータ.csv");
	//	 List<String> csvList = new ArrayList<>();
	//	 csvList = Files.readAllLines(path, Charset.forName("UTF-8"));

	try
	{
		// CSVファイルの読み込み
		List<String> lines = Files.readAllLines(path, Charset.forName("UTF-8"));
		for (int i = 1; i < lines.size(); i++) {
			String[] data = lines.get(i).split(",");

			if (data.length > 3) {
				// 読み込んだCSVファイルの内容を出力
				System.out.print(data[0] + ",");
				System.out.print(data[1] + ",");
				System.out.print(data[2] + ",");
				System.out.println(data[3]);
			}
		}
	}catch(
	Exception e)
	{
		System.out.println("ファイル読み込みに失敗");
	}
}}


-----------------------------------------------------------------------------------------------------------------------





//		create c = new create();
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in
//				));
//		String str = "";
//		boolean end = false;
//////		try {
////			while(!end) {
////				System.out.println();		
////			}
////		}
//	}

/*	 public void entry(BufferedReader br) throws IOException{
		 
		 
		System.out.println("商品IDを入力してください。");	
		
		Member.setName(br.readLine());
		while(true) {
		if (!member.matches("[0-9a-zA-Z\\-\\_]+")) {
			System.out.print("半角英数とハイフン、アンダースコアのみ入力できます");
			continue;
		if (member.length != 10) {
			System.out.println("商品IDは10桁で入力してください。");
			continue;
		} else {
			System.out.println("商品ID >" + member);
			break;
//		}
		}}
	 }}}*/
//		}	catch (IOException e) {
//			System.out.println(e);
//		}




package register;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
	public void execute() {
		System.out.println("Keyword>>>");
 */
public class ProductCreate {
	//public class create {

	public void execute() {
		System.out.println("■商品情報を登録します");
		System.out.println("商品情報を入力して下さい");
		System.out.println("----------------------------------");

		//Map<String, Member> memberMap;
		//private static long id = 0;

		//	memberMap = new HashMap<String, Member>();
		//}

		//public static void main(String[] args) {
		//Member member = new Member();

		BufferedReader br = null;
		String str = "";
		String[] productInfo = null;
		try {
			br = new BufferedReader(
					new FileReader("C:\\pleiades\\2022-06\\workspace\\GroupWork\\12_サンプルデータ.csv"));
			//↓while ((productInfo = br.readLine().split(",")) != null) {
			//処理を分けました
			while ((str = br.readLine()) != null) {
				productInfo = str.split(",");
				//				System.out.println(java.util.Arrays.toString(productInfo));
				//				System.out.println(productInfo);
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

		try {
			BufferedWriter bw = new BufferedWriter(
					new FileWriter("C:\\pleiades\\2022-06\\workspace\\GroupWork\\12_サンプルデータ.csv", true));
			Scanner mode = new Scanner(System.in);
			//			ID,Code,Product Name,Classification,Sales Price,purchase price,Registration Date
			//			A000000001,1000000000001,シャツ1,衣服,1000,100,20200818

			System.out.println("商品ID>>>");
			String productId = mode.next();
　　　　　　　　　　　　　
			while (true) {
				System.out.println("商品コード>>>");
				String productCode = mode.next();
				if (productCode.matches("[0-9]{13}")) {
				} else {
					System.out.println("半角数字13桁で入力してください");
					continue;
				}
　　　　　　　　　　　　　　　　　//まだわからず出来ていません
				System.out.println("商品名>>>");
				String productName = mode.next();
				//	if (productName.length() != 0) {
				//	} else {
				//		System.out.println("一文字以上入力してください。");
				//	}

				System.out.println("商品分類>>>");
				String productKind = mode.next();

				while (true) {
					System.out.println("販売単価>>>");
					String productPrice = mode.next();
					if (productPrice.matches("[0-9]{0,8}")) {
					} else {
						System.out.println("半角数字8桁以下を入力してください");
						continue;
					}

					while (true) {
						System.out.println("仕入単価>>>");
						String productPurchase = mode.next();
						if (productPrice.matches("[0-9]{0,8}")) {
						} else {
							System.out.println("半角数字8桁以下を入力してください");
						}
						
　　　　　　　　　　　　　　　　　　　　　　　　　　//ここもまだわからず出来ていません
						System.out.println("登録日>>>");
						String registDate = mode.next();
						//[0-9]{4}/([1-9]|[0-2])/([1-9]|[12][0-9]|[01])

						String newLineStr = productId + "," + productCode + "," + productName + "," + productKind + ","
								+ productPrice + "," + productPurchase + "," + registDate;

						bw.newLine();
						bw.append(newLineStr);

						/*
						bw.newLine();
						bw.append("A999999999,9999999999999,まりも,未分類,1000,0,20220101");
						bw.newLine();
						bw.append("");
						bw.newLine();
						bw.append("");
						bw.newLine();
						bw.append("");
						bw.newLine();
						bw.append("");
						bw.newLine();
						bw.append("");
						bw.append("-,-,-,-,-,-");
						*/

						bw.close();

						while (true) {
							System.out.println("続けて商品を登録しますか？");
							System.out.println("1:続けて登録する　2:メニューへ戻る>>>");
							String modeStr = mode.next();

							if (modeStr.equals("2")) {
								System.out.println("");
								System.exit(2);
							} else if (modeStr.equals("1")) {
							}
						}
					}

				}

			}
			//			bw.append(s+ ",");

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

}

//		create c = new create();
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in
//				));
//		String str = "";
//		boolean end = false;
//////		try {
////			while(!end) {
////				System.out.println();		
////			}
////		}
//	}

/*	 public void entry(BufferedReader br) throws IOException{
		 
		 
		System.out.println("商品IDを入力してください。");	
		
		Member.setName(br.readLine());
		while(true) {
		if (!member.matches("[0-9a-zA-Z\\-\\_]+")) {
			System.out.print("半角英数とハイフン、アンダースコアのみ入力できます");
			continue;
		if (member.length != 10) {
			System.out.println("商品IDは10桁で入力してください。");
			continue;
		} else {
			System.out.println("商品ID >" + member);
			break;
//		}
		}}
	 }}}*/
//		}	catch (IOException e) {
//			System.out.println(e);
//		}
