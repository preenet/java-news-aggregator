package parser;

import java.util.ArrayList;


/**
 * @author Pree
 */
public class Feed {

	private String title;
	private String link;
	private String description;
	private String language;
	private String copyright;
	private String pubDate;
	private ArrayList<FeedMessage> entries = new ArrayList<FeedMessage>();

	public Feed() {
		this.title = "";
		this.link = "";
		this.description = "";
		this.language = "";
		this.copyright = "";
		this.pubDate = "";
	}// end construction

	public ArrayList<FeedMessage> getMessages() {
		return entries;
	}// end method getMessage

	public String getTitle() {
		return title;
	}// end method getTitle

	public String getLink() {
		return link;
	}// end method getLink

	public String getDescription() {
		return description;
	}// end method getDescription

	public String getLanguage() {
		return language;
	}// end method getLanguage

	public String getCopyright() {
		return copyright;
	}// end method getCopyright

	public String getPubDate() {
		return pubDate;
	}// end method getPubDate
	
	public int getSize() {
		return this.entries.size();
	}// end method getSize

	@Override
	public String toString() {
		return "Feed [copyright=" + copyright + ", description=" + description
				+ ", language=" + language + ", link=" + link + ", pubDate="
				+ pubDate + ", title=" + title + "]";
	}// end Overrride method toString
}// end class Feed
