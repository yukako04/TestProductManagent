package com.ateam.search;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ProductSearch {
//	private String[][] productInfoList;

	String FILE_PATH = "C:\\pleiades2022\\workspace\\TwiceProductManagent\\Sampledata.csv";

	public void execute() {
		while (true) {
			//Scanner mode = new Scanner(System.in);
			//String modeStr = mode.next();
			System.out.println("----------------------------------");
			System.out.println("★商品検索を実行します");
			System.out.println("検索キーワードを入力して下さい");
			System.out.println("----------------------------------");
			System.out.println("Keyword>>>");
			//キーボードからキーワードの入力を受け付ける
			@SuppressWarnings("resource")
			String searchTargetKeyword = new java.util.Scanner(System.in).nextLine();
			
			//csvファイルの読み込み
			BufferedReader br = null;
			String csvLineStr = "";
			String[] productInfo = null;
			List<String> searchTargetList = new ArrayList<String>();//検索にヒットした該当行を格納するためのリスト
			
			try {
				br = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_PATH),"Shift-JIS"));
				while ((csvLineStr = br.readLine()) != null) {
					productInfo = csvLineStr.split(",");
					
					if(productInfo[0].contains(searchTargetKeyword)) {
						searchTargetList.add(csvLineStr);
					} else if(productInfo[1].contains(searchTargetKeyword)) {
						searchTargetList.add(csvLineStr);
						
					} else if(productInfo[2].contains(searchTargetKeyword)) {
						searchTargetList.add(csvLineStr);
					}
					
					
					/*
					//★商品データを表示				
					//System.out.println(java.util.Arrays.toString(productInfo));
					//System.out.println(productInfo);
					String inputConfirm = new java.util.Scanner(System.in).nextLine();
					if(inputConfirm.equals("null")) {
						System.out.println("------------------------------");
											}else  {
						//System.out.println("該当の商品IDが存在しませんでした。");
						System.out.println(java.util.Arrays.toString(productInfo));
						break;

					}
					*/
				}
				
				if(searchTargetList.size() > 0) {
					System.out.println("検索結果：" + searchTargetList);
				} else {
					System.out.println("検索キーワードに該当しません。" );
					System.out.println(productInfo);
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
			System.out.println("----------------------------------");
			System.out.println("続けて商品を検索しますか？");
			System.out.print("1:続けて検索する 2:メニューへ戻る＞");
			//キーボードから商品IDの入力を受け付ける
			String inputNextMenu = new java.util.Scanner(System.in).next();
			
			if(inputNextMenu.equals("2")) {
				break;
			}
			

		}
	}
}

