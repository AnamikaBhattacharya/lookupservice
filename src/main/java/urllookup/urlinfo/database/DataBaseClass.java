package urllookup.urlinfo.database;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//This is a dummy class which mocks the database part. For the api
//as of now the data is fetched and added to map rather than actual db
import java.util.stream.Collectors;

import urllookup.urlinfo.model.URLInfo;
public class DataBaseClass {
	
	private static Map<String,URLInfo> urlInfos = new HashMap<>();
		
	public static URLInfo getURLInfo(String url)
	{
		
		return urlInfos.get(url);
	}

	public static void addURLInfo(List<URLInfo> urlInfo) {
		
		urlInfos.putAll(urlInfo.stream().collect(Collectors.toMap(URLInfo::getUrl,
                c->c,(oldValue, newValue) -> newValue)));
	}
	
}
