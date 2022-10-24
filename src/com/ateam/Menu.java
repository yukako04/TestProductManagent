package com.ateam;

import java.util.Scanner;

import com.ateam.create.ProductCreate;
import com.ateam.delete.ProductDelete;
import com.ateam.edit.ProductEdit;
import com.ateam.search.ProductSearch;

public class Menu {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		while (true) {
			System.out.println("【メニュー】");
			System.out.println("----------------------------------");
			System.out.print("1:検索 ");
			System.out.print("2:登録 ");
			System.out.print("3:変更 ");
			System.out.print("4:削除 ");
			System.out.print("0:終了 ");
			System.out.println();
			System.out.println("----------------------------------");
			System.out.println(">>>");
			Scanner mode = new Scanner(System.in);
			String modeStr = mode.next();
			System.out.println(">>>選択" + modeStr);

			if (modeStr.equals("0")) {
				System.out.println("プログラムを終了します");
				System.exit(0);
			} else if (modeStr.equals("1")) {
				ProductSearch productSearch = new ProductSearch();
				productSearch.execute();

			} else if (modeStr.equals("2")) {
				ProductCreate productCreate = new ProductCreate();
				productCreate.execute();

			} else if (modeStr.equals("3")) {
				ProductEdit productEdit = new ProductEdit();
				productEdit.execute();

			} else if (modeStr.equals("4")) {
				ProductDelete productDelete = new ProductDelete();
				productDelete.execute();

			} else {
				System.out.println("メニュー番号が間違っています。正しい値を入力してください。");
			}
		}

	}

}
