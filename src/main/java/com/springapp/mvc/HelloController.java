package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/")
public class HelloController {
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", HostsUpdate.getGoogleHosts().replaceAll("[\\n]", "<br>"));
		return "listPage";
	}
	@RequestMapping(value = "/downloadHosts", method = RequestMethod.GET)
	private void download(HttpServletResponse response) {
		try {
			response.reset();
			response.setContentType("application/x-download");
			response.addHeader("Content-Disposition", "attachment;filename=hosts_" + getTodayString() + ".txt");
			ServletOutputStream sos = response.getOutputStream();
			sos.write(HostsUpdate.getGoogleHosts().getBytes());
			sos.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@RequestMapping(value = "/downloadBat", method = RequestMethod.GET)
	private void downloadBat(HttpServletResponse response) {
		try {
		    response.reset();
			response.setContentType("application/x-download");
			response.addHeader("Content-Disposition", "attachment;filename=run.bat");
			ServletOutputStream sos = response.getOutputStream();
			String content = "copy hosts_" + getTodayString() + ".txt C:\\Windows\\System32\\drivers\\etc\\hosts";
			sos.write(content.getBytes());
			sos.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}


	private  String getTodayString(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(new Date());
	}
}