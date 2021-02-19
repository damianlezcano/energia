package com.myspace.energia;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroovyTest {

	static String URL_BASE = "http://insecure-nexus-nexus.noprod-apps.pro.edenor/nexus/service/local/repositories/brms-releases/content";
	
	public static List main(){
		Map<String,List<String>> kjar = new HashMap<String,List<String>>();
		find("/",kjar);
		
		List<String> res = new ArrayList<String>();
		
		for (Entry<String,List<String>> entry : kjar.entrySet()) {
			
			String versions = new String();
			for(String v : entry.getValue()) {
				versions+= v + ",";
			}
			
			versions = versions.substring(0, versions.length() -1 );
			
			String item = String.format("%s:%s", entry.getKey(),versions);
			res.add(item);
		}
		
		return res;
	}
	
	public static void find(String context,Map<String,List<String>> kjar){
	    XmlParser xml = get(context);
	    List<XmlParser> list = xml.path("content").path("data").list("content-item");
	    for (XmlParser data : list) {
	        try{
	            if(data.path("leaf") != null && "false".equalsIgnoreCase(data.path("leaf").asText())){
	            	find(data.path("relativePath").asText(),kjar);
	            }else{
	                String tx = data.path("text").asText();
	                if(tx.endsWith(".pom")){
	                    XmlParser pom = get(data.path("relativePath").asText());
	                    
	                    String key = String.format("%s:%s",pom.list("groupId").get(0).asText(),pom.list("artifactId").get(0).asText());
	                    List value = new ArrayList<String>();
	                    if(kjar.containsKey(key)){
	                        value = kjar.get(key);
	                    }else{
	                        kjar.put(key,value);
	                    }
	                    value.add(pom.list("version").get(0).asText());
	                    
	                }
	            }
	        } catch(Exception e) {
	            println(">>>>> # Error obteniendo informacion de nexus -> " + e);
	        }
	    }
	}
	
	public static XmlParser get(String context){
		
		try {

		    String a = URL_BASE + context;
		    URLConnection connection = new URL(a).openConnection();
		    connection.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
		    connection.connect();

		    BufferedReader r = new BufferedReader(new InputStreamReader(connection.getInputStream(),Charset.forName("UTF-8")));

		    StringBuilder sb = new StringBuilder();
		    String line;
		    while ((line = r.readLine()) != null) {
		        sb.append(line);
		    }
		    
			return new XmlParser(sb.toString());
		    
		} catch (Exception e) {
			return null;
		}

	}

	//---------------------------------------------------------

	public static void println(String msg) {
		System.out.println(msg);
	}
	
	public static void main(String[] args) {
		System.out.println(main());
	}
	
}


class XmlParser {

	private static final long serialVersionUID = -6139939763319901407L;
	private String tag;
	private StringBuffer xml;

	public XmlParser() {
		super();
	}

	public XmlParser(String xml) {
		this();
		this.xml = new StringBuffer(xml);
	}

	private XmlParser(String xml, String tag) {
		this(xml);
		this.tag = tag;
	}

	public XmlParser path(String t) {
		String r = toString(match("(<" + t + "[\\s\\S]*?<\\/" + t + ">)"));
		return new XmlParser(r, t);
	}

	public List<XmlParser> list(String t) {
		List<String> matches = match("(<" + t + "[\\s\\S]*?<\\/" + t + ">)");
		List<XmlParser> xp = new ArrayList<XmlParser>();
		for (String m : matches) {
			XmlParser p = new XmlParser(m, t);
			xp.add(p);
		}
		return xp;
	}

	private String toString(List<String> text) {
		String s = "";
		for (String t : text) {
			s += t;
		}
		return s;
	}

	private List<String> match(String regx) {
		Pattern p = Pattern.compile(regx);
		Matcher m = p.matcher(xml);
		List<String> matches = new ArrayList<String>();
		while (m.find()) {
			matches.add(m.group(1));
		}
		List<String> s = new ArrayList<String>();
		for (String match : matches) {
			s.add(match);
		}
		return s;
	}

	public String asText() {
		return match("<" + tag + ".*>(.*)<\\/" + tag + ">").get(0);
	}

	@Override
	public String toString() {
		return xml.toString();
	}

	public String attr(String key) {
		try {
			String f = match(key + "=(\".*?\")").get(0);
			int inicio = f.indexOf("\"");
			int fin = f.lastIndexOf("\"");
			if (inicio != -1 && fin != -1) {
				return f.substring(inicio + 1, fin);
			}
			return f;
		} catch (Exception e) {
			return null;
		}
	}

	
}