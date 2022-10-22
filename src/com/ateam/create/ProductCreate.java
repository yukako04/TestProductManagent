
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
		Scanner mode = new Scanner(System.in);
		String modeStr = mode.next();

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
			br = new BufferedReader(new FileReader("C:\\\\pleiades2022\\\\workspace\\\\TwiceProductManagent\\\\Sampledata.csv"));
//			while ((productInfo = br.readLine().split(",")) != null) {
			while ((str= br.readLine()) != null) {
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
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}			
		}
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\pleiades2022\\workspace\\TwiceProductManagent\\Sampledata.csv", true));
		  	bw.newLine();
			bw.append("shohinid,shohincode,shohinmei,shohinnbunnrui,hannbaitanka,shiiretannka,tourokubi");
			bw.newLine();
			bw.append("商品ID,商品コード,商品名,商品分類,販売単価,仕入単価,登録日");
			bw.newLine();
			bw.append("5,4,3,2,1,,");
			bw.newLine();
			bw.append("-,-,-,-,-,-");
			//			bw.append(s+ ",");
			bw.close();
			
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