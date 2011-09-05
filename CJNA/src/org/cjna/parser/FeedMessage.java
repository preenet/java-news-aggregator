package org.cjna.parser;

/**
 * 
 * @author Pree Thiengburanathum preenet@gmail.com
 * 
 */
public class FeedMessage {

	private String title;
	private String description;
	private String link;
	private String author;
	private String guid;

	private String formatMultipleLine(String s) {
		// we will token the string s into equal size of line then will add <br>
		// and the end of line
		// and at </html> at the end of the last string.
		int partLength = 70;
		int len = s.length();

		// number of parts
		int nparts = (len + partLength - 1) / partLength;
		String parts = "";

		// break into parts
		int offset = 0;
		int i = 0;
		while (i < nparts) {
			parts += s.substring(offset, Math.min(offset + partLength, len))
					+ "<br>";
			offset += partLength;
			i++;
		}
		return parts;
	}

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
		return "<html><font size = \"4\" color = \"black\">" + title
				+ "</font> <br>" + formatMultipleLine(description) + "</html>";
	}

	/*
	 * @Override public String toString() { return "FeedMessage [title=" + title
	 * + ", description=" + description + ", link=" + link + ", author=" +
	 * author + ", guid=" + guid + "]"; }
	 */
}// end class FeedMessage
