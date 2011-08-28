package cjna.parser;

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
	}
	public ArrayList<FeedMessage> getMessages() {
		return entries;
	}

	public String getTitle() {
		return title;
	}// end method getTitle

	public String getLink() {
		return link;
	}

	public String getDescription() {
		return description;
	}

	public String getLanguage() {
		return language;
	}

	public String getCopyright() {
		return copyright;
	}

	public String getPubDate() {
		return pubDate;
	}
	
	public int getSize() {
		return this.entries.size();
	}

	@Override
	public String toString() {
		return "Feed [copyright=" + copyright + ", description=" + description
				+ ", language=" + language + ", link=" + link + ", pubDate="
				+ pubDate + ", title=" + title + "]";
	}
}// end class Feed
