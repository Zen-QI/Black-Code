/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.SequenceInputStream;

/**
 *
 * @author black
 */
public class test {

    public static void main(String[] args) throws IOException, InterruptedException {
	Runtime rt = Runtime.getRuntime();
	String arr[] = {"CLASSPATH=D://","Path=C:\\Program Files\\Java\\jdk1.8.0_131\\bin"};
	Process pr = rt.exec("cmd /c javac a.java && java a", arr, new File("D://"));
//	Process pr = rt.exec("cmd /c javac a.java && java a");
	SequenceInputStream sis = new SequenceInputStream(pr.getInputStream(), pr.getErrorStream());
	InputStreamReader inst = new InputStreamReader(sis, "GBK");
	BufferedReader br = new BufferedReader(inst);

	String res = null;
	StringBuilder sb = new StringBuilder();
	while ((res = br.readLine()) != null) {
	    sb.append(res+"\n");
	}
	br.close();
	pr.waitFor();
	pr.destroy();
	System.out.print(sb);
//	String arr[] = {"shutdown -s -t 3600"};
////	String arr[] = {"shutdown -a"};
//	rt.exec(arr);
    }
}
