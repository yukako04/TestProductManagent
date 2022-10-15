package com.ateam.comon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class CsvUtil {

	FileInputStream fi = null;
	InputStreamReader is = null;
	BufferedReader br = null;
	{

		try {
			//読み込みファイルのインスタンス生成
			//ファイル名を指定
			fi = new FileInputStream("Sampledata.csv");
			is = new InputStreamReader(fi);
			br = new BufferedReader(is);

			//読み込み
			String line;

			int i = 0;

			String[] arr = null;

			while ((line = br.readLine()) != null) {

				if (i == 0) {
					//	arr = {"shohinid","shohincode","shohinmei","shohinbunrui,",
					//			"hanbaitanka","shiiretanka","torokubi"};
					arr = line.split(",");

				} else {
					System.out.println("---------------------------");
					System.out.println("データ" + i + "件目");
					String[] data = line.split(",");
					int colno = 0;
					for(String column : arr) {
						System.out.println(column + ":" + data[colno]);
						colno++;
						
					}
				}
			
				i++;
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
