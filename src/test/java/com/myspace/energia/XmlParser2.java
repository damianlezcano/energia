package com.myspace.energia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XmlParser2 implements Serializable {
//
//	private static final long serialVersionUID = -6139939763319901407L;
//	private String tag;
//	private StringBuffer xml;
//
//	public XmlParser2() {
//		super();
//	}
//
//	public XmlParser2(String xml) {
//		this();
//		this.xml = new StringBuffer(xml);
//	}
//
//	private XmlParser2(String xml, String tag) {
//		this(xml);
//		this.tag = tag;
//	}
//
//	public XmlParser path(String t) {
//		String r = toString(match("(<" + t + "[\\s\\S]*?<\\/" + t + ">)"));
//		return new XmlParser(r, t);
//	}
//
//	public List<XmlParser> list(String t) {
//		List<String> matches = match("(<" + t + "[\\s\\S]*?<\\/" + t + ">)");
//		List<XmlParser> xp = new ArrayList<XmlParser>();
//		for (String m : matches) {
//			XmlParser p = new XmlParser(m, t);
//			xp.add(p);
//		}
//		return xp;
//	}
//
//	private String toString(List<String> text) {
//		String s = "";
//		for (String t : text) {
//			s += t;
//		}
//		return s;
//	}
//
//	private List<String> match(String regx) {
//		Pattern p = Pattern.compile(regx);
//		Matcher m = p.matcher(xml);
//		List<String> matches = new ArrayList<String>();
//		while (m.find()) {
//			matches.add(m.group(1));
//		}
//		List<String> s = new ArrayList<String>();
//		for (String match : matches) {
//			s.add(match);
//		}
//		return s;
//	}
//
//	public String asText() {
//		return match("<" + tag + ".*>(.*)<\\/" + tag + ">").get(0);
//	}
//
//	@Override
//	public String toString() {
//		return xml.toString();
//	}
//
//	public String attr(String key) {
//		try {
//			String f = match(key + "=(\".*?\")").get(0);
//			int inicio = f.indexOf("\"");
//			int fin = f.lastIndexOf("\"");
//			if (inicio != -1 && fin != -1) {
//				return f.substring(inicio + 1, fin);
//			}
//			return f;
//		} catch (Exception e) {
//			return null;
//		}
//	}

}