package com.mangocity.spring.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.common.base.Strings;

@Controller
@RequestMapping(value = "/cache")
public class CacheController {

	@RequestMapping("/reload.action")
	public ResponseEntity<String> cache(
			HttpServletRequest request,
			// 为了方便测试，此处传入文档最后修改时间
			@RequestParam("millis") long lastModifiedMillis,
			// 浏览器验证文档内容是否修改时传入的Last-Modified
			@RequestHeader(value = "If-Modified-Since", required = false) Date ifModifiedSince) {
		System.out.println("cache begin{}");
		// 当前系统时间
		long now = System.currentTimeMillis();
		// 文档可以在浏览器端/proxy上缓存多久
		long maxAge = 20;

		if (null == ifModifiedSince) {
			System.out.println("ifModifiedSince: " + "");
		} else {
			System.out.println("ifModifiedSince: " + ifModifiedSince.getTime());
		}
		System.out.println("lastModifiedMillis: " + lastModifiedMillis);
		// 判断内容是否修改了，此处使用等值判断
		if (ifModifiedSince != null
				&& ifModifiedSince.getTime() == lastModifiedMillis) {
			System.out.println("304");
			return new ResponseEntity<String>(HttpStatus.NOT_MODIFIED);
		}

		DateFormat gmtDateFormat = new SimpleDateFormat(
				"EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);

		String body = "<a href=''>点击访问当前链接</a>";
		MultiValueMap<String, String> headers = new HttpHeaders();

		// 文档修改时间
		headers.add("Last-Modified",
				gmtDateFormat.format(new Date(lastModifiedMillis)));
		// 当前系统时间
		headers.add("Date", gmtDateFormat.format(new Date(now)));
		// 过期时间 http 1.0支持
		headers.add("Expires", gmtDateFormat.format(new Date(now + maxAge)));
		// 文档生存时间 http 1.1支持
		headers.add("Cache-Control", "max-age=" + maxAge);
		System.out.println("end{}");
		return new ResponseEntity<String>(body, headers, HttpStatus.OK);
	}
}
