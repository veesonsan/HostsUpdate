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
			response.setContentType("application/x-msdownload");
			response.addHeader("Content-Disposition", "attachment;filename=hosts.txt");
			ServletOutputStream sos=response.getOutputStream();
			sos.write(HostsUpdate.getGoogleHosts().getBytes());
			sos.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}