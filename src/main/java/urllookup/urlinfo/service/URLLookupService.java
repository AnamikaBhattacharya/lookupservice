package urllookup.urlinfo.service;

import urllookup.urlinfo.model.URLInfo;
//This class is responsible to get the reputation and send. As of now the status is getting sent as safe
public class URLLookupService {
	
	public URLInfo getURLInfo(String url)
	{
		URLInfo urlInfo = new URLInfo();
    	urlInfo.setReputation("Safe");
    	urlInfo.setUrl(url);
    	return urlInfo;
	}

}
