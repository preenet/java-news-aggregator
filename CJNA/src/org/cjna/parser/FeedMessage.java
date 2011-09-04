package org.cjna.parser;

/**
 * 
 * @author Pree
 *
 */
public class FeedMessage {

	private String title;
	private String description;
	private String link;
	private String author;
	private String guid;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	
	@Override
	public String toString() {
		return "<html><font size = \"4\" color = \"blue\">"   + title + "</font> <br>"   + description + "</html>";
	}
	
	private String formatLine(String s) {
	// we will token the string s into equal size of line then will add <br> and the end of line
	// and at </html> at the end of the last string.
		return s;
	}
/*
	@Override
	public String toString() {
		return "FeedMessage [title=" + title + ", description=" + description
				+ ", link=" + link + ", author=" + author + ", guid=" + guid
				+ "]";
	}
*/
}// end class FeedMessage
