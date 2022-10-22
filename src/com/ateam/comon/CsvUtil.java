package com.ateam.comon;

public class CsvUtil {
	public class End {
		public void main(String[] args) {
			System.out.println("現在の処理を終了したい場合は、exitか\\qを入力してください");
			String s1 = "exit";
			String s2 = "\\q";
			String s = new java.util.Scanner(System.in).nextLine();
			{
				if (s1.equals(s) || s2.equals(s)) {
					System.out.println("プログラムを終了します。");
					System.exit(0);
				} else {
					System.out.println("正しく入力してください。");
				}
			}
		}

		public class Canma {
			public void main(String[] args) {
				String s = new java.util.Scanner(System.in).nextLine();
				if (s.contains(",") || s.contains("、")) {
					System.out.println("カンマは使用できません。");
				}
			}

		}
	}
}