package urllookup.urlinfo.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class URLInfo {
	
	String url;
	String reputation;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getReputation() {
		return reputation;
	}
	public void setReputation(String reputation) {
		this.reputation = reputation;
	}
	
}
