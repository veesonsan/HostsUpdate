package com.springapp.mvc;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HostsUpdate {
	private static String ceshiServerHost = "10.2.50.245";
	private static String yanfaServerHost = "10.2.50.38";
	private static String candaoServerHost = "10.2.50.99";
	public static final String CHARSET = "UTF-8";

	public static void main(String[] args) {
		if (args.length > 0 && "test".equalsIgnoreCase(args[0])) {
			yanfaServerHost = ceshiServerHost;
		}
		try {
			String lineSeparator = System.getProperty("line.separator");
			String hostsString = "127.0.0.1 localhost" + lineSeparator;
			hostsString += candaoServerHost + " berbon.candao.com" + lineSeparator;
			hostsString += yanfaServerHost + " login.berbon.com" + lineSeparator;
			hostsString += yanfaServerHost + " user.berbon.com" + lineSeparator;
			hostsString += yanfaServerHost + " static.berbon.com" + lineSeparator;
			hostsString += yanfaServerHost + " image.berbon.com" + lineSeparator;
			hostsString += yanfaServerHost + " d.berbon.com" + lineSeparator;
			hostsString += yanfaServerHost + " m.berbon.com" + lineSeparator;
			hostsString += yanfaServerHost + " dshop.berbon.com" + lineSeparator;
			hostsString += yanfaServerHost + " www.monitor.com" + lineSeparator;
			hostsString += yanfaServerHost + " www.berbon.com" + lineSeparator;
			hostsString += yanfaServerHost + " cms.berbon.com" + lineSeparator;
			hostsString += yanfaServerHost + " newcms.berbon.com" + lineSeparator;
			hostsString += yanfaServerHost + " bbs.berbon.com" + lineSeparator;
			hostsString += yanfaServerHost + " shop.berbon.com" + lineSeparator;
			hostsString += yanfaServerHost + " file.berbon.com" + lineSeparator;
			hostsString += "127.0.0.1 l.qq.com" + lineSeparator;
			hostsString += "127.0.0.1 ra.gtimg.com" + lineSeparator;
			hostsString += "127.0.0.1 livec.l.qq.com" + lineSeparator;
			Pattern pattern = Pattern.compile("[a-zA-z]+://[^\\s]*txt");
			String result = get("http://zeus.softweek.net/item-slt-1.html");
			if (result != null) {
				Matcher matcher = pattern.matcher(result);
				if (matcher.find()) {
					String url = matcher.group();
					String hosts = get(url);
					if (hosts != null && hosts.contains("www.google.com")) {
						hostsString += hosts;
					}
				}
			}
			System.out.println(hostsString);
			String filePath = "C:/Windows/System32/drivers/etc/hosts";
			System.out.println("------------------Hosts-------------------");
			System.out.println(hostsString);
			saveAsFileWriter(hostsString, new File(filePath));
			System.out.println("------------------Success-------------------");
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println("------------------Fail-------------------");
		}
	}

	public static String getGoogleHosts(){
		String lineSeparator = System.getProperty("line.separator");
		String hostsString = "127.0.0.1 localhost" + lineSeparator;
		hostsString += candaoServerHost + " berbon.candao.com" + lineSeparator;
		hostsString += yanfaServerHost + " login.berbon.com" + lineSeparator;
		hostsString += yanfaServerHost + " user.berbon.com" + lineSeparator;
		hostsString += yanfaServerHost + " static.berbon.com" + lineSeparator;
		hostsString += yanfaServerHost + " image.berbon.com" + lineSeparator;
		hostsString += yanfaServerHost + " d.berbon.com" + lineSeparator;
		hostsString += yanfaServerHost + " m.berbon.com" + lineSeparator;
		hostsString += yanfaServerHost + " dshop.berbon.com" + lineSeparator;
		hostsString += yanfaServerHost + " www.monitor.com" + lineSeparator;
		hostsString += yanfaServerHost + " www.berbon.com" + lineSeparator;
		hostsString += yanfaServerHost + " cms.berbon.com" + lineSeparator;
		hostsString += yanfaServerHost + " newcms.berbon.com" + lineSeparator;
		hostsString += yanfaServerHost + " bbs.berbon.com" + lineSeparator;
		hostsString += yanfaServerHost + " shop.berbon.com" + lineSeparator;
		hostsString += yanfaServerHost + " file.berbon.com" + lineSeparator;
		hostsString += "127.0.0.1 l.qq.com" + lineSeparator;
		hostsString += "127.0.0.1 ra.gtimg.com" + lineSeparator;
		hostsString += "127.0.0.1 livec.l.qq.com" + lineSeparator;
		hostsString += "127.0.0.1 atm.youku.com" + lineSeparator;
		hostsString += "127.0.0.1 Fvid.atm.youku.com" + lineSeparator;
		hostsString += "127.0.0.1 html.atm.youku.com" + lineSeparator;
		hostsString += "127.0.0.1 valb.atm.youku.com" + lineSeparator;
		hostsString += "127.0.0.1 valf.atm.youku.com" + lineSeparator;
		hostsString += "127.0.0.1 valo.atm.youku.com" + lineSeparator;
		hostsString += "127.0.0.1 valp.atm.youku.com" + lineSeparator;
		hostsString += "127.0.0.1 lstat.youku.com" + lineSeparator;
		hostsString += "127.0.0.1 speed.lstat.youku.com" + lineSeparator;
		hostsString += "127.0.0.1 urchin.lstat.youku.com" + lineSeparator;
		hostsString += "127.0.0.1 stat.youku.com" + lineSeparator;
		hostsString += "127.0.0.1 static.lstat.youku.com" + lineSeparator;
		hostsString += "127.0.0.1 valc.atm.youku.com" + lineSeparator;
		hostsString += "127.0.0.1 vid.atm.youku.com" + lineSeparator;
		hostsString += "127.0.0.1 walp.atm.youku.com" + lineSeparator;
		hostsString += "127.0.0.1 afp.qiyi.com" + lineSeparator;
		hostsString += "127.0.0.1 focusbaiduafp.allyes.com" + lineSeparator;
		hostsString += "127.0.0.1 dcads.sina.com.cn" + lineSeparator;
		hostsString += "127.0.0.1 pp2.pptv.com" + lineSeparator;
		hostsString += "127.0.0.1 pro.letv.com" + lineSeparator;
		hostsString += "127.0.0.1 images.sohu.com" + lineSeparator;
		Pattern pattern = Pattern.compile("[a-zA-z]+://[^\\s]*txt");
		String result = get("http://zeus.softweek.net/item-slt-1.html");
		if (result != null) {
			Matcher matcher = pattern.matcher(result);
			if (matcher.find()) {
				String url = matcher.group();
				String hosts = get(url);
				if (hosts != null && hosts.contains("www.google.com")) {
					hostsString += hosts;
				}
			}
		}
		return  hostsString;
	}
	public static void saveAsFileWriter(String content, File file) {
		FileWriter fwriter = null;
		try {
			fwriter = new FileWriter(file);
			fwriter.write(content);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				fwriter.flush();
				fwriter.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static String get(String url) {
		HttpURLConnection con = null;
		OutputStream osw = null;
		InputStream ins = null;
		try {
			con = (HttpURLConnection) new URL(url).openConnection();
			con.setRequestMethod("GET");
			int resCode = con.getResponseCode();
			if (resCode < 400) {
				ins = con.getInputStream();
			} else {
				ins = con.getErrorStream();
			}
			return readContent(ins);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (osw != null) {
					osw.close();
				}
				if (ins != null) {
					ins.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	private static final String readContent(InputStream ins) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(ins, CHARSET));
		if (ins != null) {
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line).append(System.getProperties().getProperty("line.separator"));
			}
		}
		return sb.toString();
	}
}
