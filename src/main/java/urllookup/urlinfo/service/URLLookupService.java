package urllookup.urlinfo.service;

import java.util.List;

import org.eclipse.persistence.internal.databaseaccess.DatabaseCall;

import urllookup.urlinfo.database.DataBaseClass;
import urllookup.urlinfo.model.URLInfo;
//This class is responsible to get the reputation and send. As of now the status is getting sent as safe
public class URLLookupService {
	
	public URLInfo getURLInfo(String url)
	{
		URLInfo urlInfo = DataBaseClass.getURLInfo(url);
		if(null == urlInfo)
		{
			urlInfo = new URLInfo();
			urlInfo.setReputation("Unknown");
			urlInfo.setUrl(url);
		}
		return urlInfo;
	}

	public void addMessages(List<URLInfo> urlInfos) {
		DataBaseClass.addURLInfo(urlInfos);
	}

}
