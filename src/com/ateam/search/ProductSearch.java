package com.ateam.search;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ProductSearch {
	public void execute() {
		System.out.println("★商品検索を実行します");
		System.out.println("検索キーワードを入力して下さい");
		System.out.println("----------------------------------");
		System.out.println("Keyword>>>");
		Scanner mode = new Scanner(System.in);
		String modeStr = mode.next();

		BufferedReader br = null;
		String str = "";
		String[] productInfo = null;
		try {
			br = new BufferedReader(
					new FileReader("C:\\pleiades2022\\workspace\\TwiceProductManagent\\Sampledata.csv"));
			while ((str = br.readLine()) != null) {
				productInfo = str.split(",");
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

//			ID,Code,Product Name,Classification,Sales Price,purchase price,Registration Date
//			A000000001,1000000000001,シャツ1,衣服,1000,100,20200818

			
			
			
			
			
			
		}

	}
}