package com.ateam.create;

import java.util.Scanner;

public class ProductCreate {
	public void execute() {
		System.out.println("■商品情報を登録します");
		System.out.println("登録データを入力して下さい");
		System.out.println("----------------------------------");
		Scanner mode = new Scanner(System.in);
		String modeStr = mode.next();
		System.out.println("Keyword>>>");

	
	}

}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class create {

	Map<String, Member> memberMap;
	private static long id = 0;

	public create() {
		memberMap = new HashMap<String, Member>();
	}

	public static void main(String[] args) {
		Member member = new Member();

		create ms = new create();
		BufferedReader br = null;
		String[] productInfo = null;
		try {
			br = new BufferedReader(new FileReader("C:\\Users\\sn\\Desktop\\sample.csv"));
			while ((productInfo = br.readLine().split(",")) != null) {
				System.out.println(java.util.Arrays.toString(productInfo));
			}
		} catch (Exception e) {
			addShohin();
		} finally {
			try {
				br.close();
				
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}			
		}
	}

	public static void addShohin() {

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\sn\\Desktop\\sample.csv", true));
			bw.newLine();
			bw.append("1,2,3,4,5,");
			bw.newLine();
			bw.append("5,4,3,2,1,");
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
