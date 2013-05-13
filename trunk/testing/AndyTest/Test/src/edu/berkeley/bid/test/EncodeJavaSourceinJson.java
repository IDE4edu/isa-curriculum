package edu.berkeley.bid.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

public class EncodeJavaSourceinJson {

	public static void main(String [ ] args) {
		
		File f = new File("src/edu/berkeley/bid/test/NaiveReverse.java");
		System.out.println("Path: "+f.getAbsolutePath());
		
		
		String codeStr = null;
		try {
			codeStr = FileUtils.readFileToString(f, "UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String b64str = Base64.encodeBase64String(codeStr.getBytes());
		//System.out.println(b64);
		System.out.println(new String(Base64.decodeBase64(b64str)));

		
	}
	
}
