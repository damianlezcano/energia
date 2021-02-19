package com.myspace.energia;

import java.util.List;

public class JsonParser {
	
	public static void main(String[] args) {
		String json = "<content>\n"
				+ "    <data>\n"
				+ "        <content-item>\n"
				+ "            <resourceURI>http://insecure-nexus-nexus.noprod-apps.pro.edenor/nexus/service/local/repositories/brms-releases/content/com/myspace/energia/1.0.1/energia-1.0.1.jar</resourceURI>\n"
				+ "            <relativePath>/com/myspace/energia/1.0.1/energia-1.0.1.jar</relativePath>\n"
				+ "            <text>energia-1.0.1.jar</text>\n"
				+ "            <leaf>true</leaf>\n"
				+ "            <lastModified>2021-02-17 18:15:10.0 UTC</lastModified>\n"
				+ "            <sizeOnDisk>6353</sizeOnDisk>\n"
				+ "        </content-item>\n"
				+ "        <content-item>\n"
				+ "            <resourceURI>http://insecure-nexus-nexus.noprod-apps.pro.edenor/nexus/service/local/repositories/brms-releases/content/com/myspace/energia/1.0.1/energia-1.0.1.jar.sha1</resourceURI>\n"
				+ "            <relativePath>/com/myspace/energia/1.0.1/energia-1.0.1.jar.sha1</relativePath>\n"
				+ "            <text>energia-1.0.1.jar.sha1</text>\n"
				+ "            <leaf>true</leaf>\n"
				+ "            <lastModified>2021-02-17 18:15:11.0 UTC</lastModified>\n"
				+ "            <sizeOnDisk>40</sizeOnDisk>\n"
				+ "        </content-item>\n"
				+ "        <content-item>\n"
				+ "            <resourceURI>http://insecure-nexus-nexus.noprod-apps.pro.edenor/nexus/service/local/repositories/brms-releases/content/com/myspace/energia/1.0.1/energia-1.0.1.jar.md5</resourceURI>\n"
				+ "            <relativePath>/com/myspace/energia/1.0.1/energia-1.0.1.jar.md5</relativePath>\n"
				+ "            <text>energia-1.0.1.jar.md5</text>\n"
				+ "            <leaf>true</leaf>\n"
				+ "            <lastModified>2021-02-17 18:15:11.0 UTC</lastModified>\n"
				+ "            <sizeOnDisk>32</sizeOnDisk>\n"
				+ "        </content-item>\n"
				+ "        <content-item>\n"
				+ "            <resourceURI>http://insecure-nexus-nexus.noprod-apps.pro.edenor/nexus/service/local/repositories/brms-releases/content/com/myspace/energia/1.0.1/energia-1.0.1.pom</resourceURI>\n"
				+ "            <relativePath>/com/myspace/energia/1.0.1/energia-1.0.1.pom</relativePath>\n"
				+ "            <text>energia-1.0.1.pom</text>\n"
				+ "            <leaf>true</leaf>\n"
				+ "            <lastModified>2021-02-17 18:15:12.0 UTC</lastModified>\n"
				+ "            <sizeOnDisk>2481</sizeOnDisk>\n"
				+ "        </content-item>\n"
				+ "        <content-item>\n"
				+ "            <resourceURI>http://insecure-nexus-nexus.noprod-apps.pro.edenor/nexus/service/local/repositories/brms-releases/content/com/myspace/energia/1.0.1/energia-1.0.1.pom.sha1</resourceURI>\n"
				+ "            <relativePath>/com/myspace/energia/1.0.1/energia-1.0.1.pom.sha1</relativePath>\n"
				+ "            <text>energia-1.0.1.pom.sha1</text>\n"
				+ "            <leaf>true</leaf>\n"
				+ "            <lastModified>2021-02-17 18:15:12.0 UTC</lastModified>\n"
				+ "            <sizeOnDisk>40</sizeOnDisk>\n"
				+ "        </content-item>\n"
				+ "        <content-item>\n"
				+ "            <resourceURI>http://insecure-nexus-nexus.noprod-apps.pro.edenor/nexus/service/local/repositories/brms-releases/content/com/myspace/energia/1.0.1/energia-1.0.1.pom.md5</resourceURI>\n"
				+ "            <relativePath>/com/myspace/energia/1.0.1/energia-1.0.1.pom.md5</relativePath>\n"
				+ "            <text>energia-1.0.1.pom.md5</text>\n"
				+ "            <leaf>true</leaf>\n"
				+ "            <lastModified>2021-02-17 18:15:13.0 UTC</lastModified>\n"
				+ "            <sizeOnDisk>32</sizeOnDisk>\n"
				+ "        </content-item>\n"
				+ "    </data>\n"
				+ "</content>";
		
		XmlParser xml = new XmlParser(json);
		
		List<XmlParser> list = xml.path("content").path("data").list("content-item");
		
		for (XmlParser xp : list) {
			System.out.println(xp.path("text"));
		}
		
	}
	
	
	
	
	
}
