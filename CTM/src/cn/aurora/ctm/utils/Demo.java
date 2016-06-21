package cn.aurora.ctm.utils;

import java.io.FileNotFoundException;

import cn.aurora.ctm.model.Project;

public class Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Project project = new ExcelUtils().readExcel("D:\\辅助管理用例.xls");
			ExcelUtils.toXML(project, "D:\\辅助管理用例.xml");
			
			
			
			
			
//			System.out.println(project);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
