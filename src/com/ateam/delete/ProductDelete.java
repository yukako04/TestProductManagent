
package com.ateam.delete;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class ProductDelete {
	
	String FILE_PATH = "C:\\pleiades2022\\workspace\\TwiceProductManagent\\Sampledata.csv";

	@SuppressWarnings("finally")
	public void execute() {

		BufferedReader br = null;
		String str;
		boolean hasDeleteLineFlag = false;	//削除対象の行を処理したかどうかのフラグ
		List<String> productInfoList = new ArrayList<String>();	// ファイル上書き用リスト
		
		
		while (true) {
			
			System.out.println("----------------------------------");
			System.out.println("商品情報を削除します。");
			System.out.println("削除する商品IDを入力してください。");
			System.out.print("商品ID＞");
			//キーボードから商品IDの入力を受け付ける
			String deleteTargetId = new java.util.Scanner(System.in).next();
			
			// ファイルの読み込み
			try {
//				br = new BufferedReader(
//						new FileReader(FILE_PATH) );
				
				br = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_PATH),"Shift-JIS"));
				
				while ((str = br.readLine()) != null) {
					String[] productInfo = str.split(",");
					if(productInfo[0].equals(deleteTargetId)) {
						
						
						
						System.out.println("商品ID＝" + productInfo[0]);
						System.out.println("商品コード＝" + productInfo[1]);
						System.out.println("商品名＝" + productInfo[2]);
						System.out.println("商品分類＝" + productInfo[3]);
						System.out.println("販売単価＝" + productInfo[4]);
						System.out.println("仕入単価＝" + productInfo[5]);
						System.out.println("登録日" + productInfo[6]);
						System.out.println("----------------------------------");
						System.out.print("商品情報を削除しますか？Y/N＞");
						String inputConfirm = new java.util.Scanner(System.in).nextLine();
						
						if(inputConfirm.equals("Y")) {
							hasDeleteLineFlag = true;
							
							System.out.print("商品情報を削除しますた！！");
							System.out.println("商品ID＝" + productInfo[0]);
							System.out.println("商品コード＝" + productInfo[1]);
							System.out.println("商品名＝" + productInfo[2]);
							System.out.println("商品分類＝" + productInfo[3]);
							System.out.println("販売単価＝" + productInfo[4]);
							System.out.println("仕入単価＝" + productInfo[5]);
							System.out.println("登録日" + productInfo[6]);							
						} else {
							//削除をキャンセルする場合
							productInfoList = new ArrayList<>();
							break;
						}
						
					} else {
						//削除対象IDでない場合は上書き用リストに追加
						productInfoList.add(str);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			// ファイルの上書き
			if (hasDeleteLineFlag == true) {
				BufferedWriter bw = null;
				try {
					bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FILE_PATH, false), "Shift_JIS"));
					
					for (String productInfoLine : productInfoList) {
						bw.append(productInfoLine);
						bw.newLine();
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						bw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} else {
				System.out.println("該当の商品IDが存在しませんでした。");
			}
			
			hasDeleteLineFlag = false;
	        
			System.out.println();
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
