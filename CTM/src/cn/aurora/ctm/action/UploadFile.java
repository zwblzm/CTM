package cn.aurora.ctm.action;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import sun.misc.BASE64Encoder;

import cn.aurora.ctm.model.Project;
import cn.aurora.ctm.utils.ExcelUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 上传文件
 * @author Administrator
 *
 */
@Controller
@Scope("prototype")
public class UploadFile extends ActionSupport{

	
	private File file;
	private String fileFileName;
	private String fileName;
	private String fileContentType;
	
	
	
	
	public String getFileName() throws IOException {
		// 获得浏览器类型:User-Agent
				String agent = ServletActionContext.getRequest()
						.getHeader("User-Agent");
				return encodeDownloadFilename(fileName, agent);
	}




	public void setFileName(String fileName) throws UnsupportedEncodingException {
		String fileNameSuper = new String(fileName.getBytes("ISO-8859-1"),"utf-8");
		this.fileName = fileNameSuper;
	}




	public File getFile() {
		return file;
	}




	public void setFile(File file) {
		this.file = file;
	}




	public String getFileFileName() {
//		System.out.println(fileFileName);
		return fileFileName;
	}




	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}




	public String getFileContentType() {
		return fileContentType;
	}




	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	/**
	 * 下载属性
	 */
	
	public String getContentType() {
		String mimeType = ServletActionContext.getServletContext().getMimeType(fileFileName);
		return mimeType;
	}
	
	public InputStream getInputStream() throws FileNotFoundException {
		String path=ServletActionContext.getServletContext().getRealPath("/file");
		
		return  new FileInputStream(new File(path+"/"+fileName));
	}
	
	
	
	
	
	

/**
 * 文件上传
 * @return
 * @throws Exception 
 */
	public String updateFile() throws Exception {
		String path = ServletActionContext.getServletContext().getRealPath("/file");
		//复制文件到指定目录
		
		FileUtils.copyFile(file, new File(path+"/"+fileFileName));
		
		Project project = new ExcelUtils().readExcel(path+"/"+fileFileName);
		ExcelUtils.toXML(project, path+"/"+fileFileName+".xml");
		
		return "uploadSuccess";
	}
	
	public String fileList() {
		String path = ServletActionContext.getServletContext().getRealPath("/file");
		
		File parent = new File(path);
	
		FileFilter filter = new FileFilter() {
			
			@Override
			public boolean accept(File pathname) {
				String name = pathname.getName();
				if(name.endsWith(".xml")) {
					
					return true;
				}else{
					return false;
				}
			}
		};
		File[] files = parent.listFiles(filter);
//		System.out.println(files.length);
		ActionContext.getContext().put("files", files);
		return SUCCESS;
	}
	
	
	
	public String fileDownload() throws Exception {
//		System.out.println(fileName);
		
		return "fileDownload";
	}
	
	public String encodeDownloadFilename(String fileName, String agent)
			throws IOException {
		if (agent.contains("Firefox")) { // 火狐浏览器
			fileName = "=?UTF-8?B?"
					+ new BASE64Encoder().encode(fileName.getBytes("utf-8"))
					+ "?=";
		} else { // IE及其他浏览器
			fileName = URLEncoder.encode(fileName, "utf-8");
		}
		return fileName;
	}
}
