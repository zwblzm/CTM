package cn.aurora.ctm.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

import cn.aurora.ctm.model.CaseStep;
import cn.aurora.ctm.model.Project;
import cn.aurora.ctm.model.TestCase;
import cn.aurora.ctm.model.TestSuite;

public class ExcelUtils {
	public static TestSuite getTestSuite() {
		TestSuite testSuite = new TestSuite();
		List<TestCase> testCases = testSuite.getTestCases();
		
		return null;
	}
	
	public static void toXML(Project project, String path) throws Exception {
		Element root = DocumentHelper.createElement("testsuite");
		root.addElement("details").addCDATA("");
		Document document = DocumentHelper.createDocument(root);
		for (TestSuite suite : project.getSuite()) {
			
			root.addAttribute("name", suite.getName());
			List<TestCase> testCases = suite.getTestCases();
			for (TestCase yongli : testCases) {
				Element testCase = root.addElement("testcase");
				testCase.addAttribute("name", yongli.getName());
//				testCase.addElement("details").addText("<!CDATA[<p>"+yongli.getDescription()+"</p>]>");
				testCase.addElement("summary").addCDATA("<p>"+yongli.getDescription()+"</p>");
//				testCase.addElement("version").addText(yongli.getVersion());
				String[] nodes = yongli.getPremise();
				String preconditions = "";
				for (String string : nodes) {
					preconditions+="<p>"+string+"</p>";
				}
				testCase.addElement("preconditions").addCDATA(preconditions);
				testCase.addElement("execution_type").addCDATA("1");
				testCase.addElement("importance").addCDATA("3");
				Element steps = testCase.addElement("steps");
//				System.out.println(yongli.getSteps().size());
				int i=1;
				for (CaseStep cstep : yongli.getSteps()) {
					
					Element step = steps.addElement("step");
					step.addElement("step_number").addCDATA(Integer.toString(i));
					step.addElement("actions").addCDATA("<p>"+cstep.getOperation()+"</p>");
					step.addElement("expectedresults").addCDATA("<p>"+cstep.getResult()+"</p>");
					step.addElement("execution_type").addCDATA("1");
					i++;
				}
			}
		}
		
		
		
		
		
		
		FileOutputStream out = new FileOutputStream(new File(path));
		XMLWriter writer = new XMLWriter(out);
		writer.write(document);
	}
	
	public  Project readExcel(String name) throws FileNotFoundException, IOException {
		Project project = new Project();
		HSSFWorkbook workBook = new HSSFWorkbook(new FileInputStream(name));
		int sheetNum = workBook.getNumberOfSheets();
		
		int index=0;
		
		while(index<sheetNum) {
			TestSuite suite =new TestSuite();
			List<TestCase> testCases = getTestSuite(workBook.getSheetAt(index));
			suite.setName(workBook.getSheetName(index));
			suite.setTestCases(testCases);
			List<TestSuite> suites = project.getSuite();
			suites.add(suite);
			project.setName("综合运维管理平台");
			index++;
		}
		
		return project;
		
	}
	
	public  List<TestCase> getTestSuite(HSSFSheet sheet) {
		List<TestCase> testSuite = new ArrayList<TestCase>();
		int count= sheet.getLastRowNum(); 
		int index=1;
		while(index <= count) {
			HSSFRow row = sheet.getRow(index);
			TestCase testCase = getTestCase(row);
			testSuite.add(testCase);
			index++;
		}
		return testSuite;
	}
	
	public  TestCase getTestCase(HSSFRow row) {
//		System.out.println(row.getRowNum());
		TestCase testCase = new TestCase();
		System.out.println(row.getCell(0).getStringCellValue());
		testCase.setName(row.getCell(0).getStringCellValue());
		testCase.setDescription(row.getCell(1).getStringCellValue());
		testCase.setPremise(row.getCell(2).getStringCellValue().split(";"));
		testCase.setMethod(row.getCell(3).getStringCellValue());
		testCase.setLevel(row.getCell(4).getStringCellValue());
//		System.out.println(row.getCell(5).getStringCellValue());
		String operation = row.getCell(5).getStringCellValue();
		String result = row.getCell(6).getStringCellValue();
		List<CaseStep> steps = getStep(operation, result);
		testCase.setSteps(steps);
		
		return testCase;
	}
	
	
	

	private  List<CaseStep> getStep(String operation, String result) {
		List<CaseStep> steps = new ArrayList<CaseStep>();
		String[] operators = operation.split("；");
		String[] results = result.split("；");
		
		System.out.println("数组长度"+operators.length);
		System.out.println("数组长度"+results.length);
		for (int i=0; i<operators.length;i++) {
			CaseStep step = new CaseStep();
			step.setOperation(operators[i]);
			try{
				step.setResult(results[i]);
				
			}catch (ArrayIndexOutOfBoundsException e) {
				step.setResult("空");
			}
			steps.add(step);
		}
		return steps;
	}
	
	
}
