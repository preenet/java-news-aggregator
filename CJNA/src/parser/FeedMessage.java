package parser;

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
	}// end method getTitle

	public void setTitle(String title) {
		this.title = title;
	}// end method setTitle

	public String getDescription() {
		return description;
	}// end method getDescription

	public void setDescription(String description) {
		this.description = description;
	}// end method setDescription

	public String getLink() {
		return link;
	}// end method getLink

	public void setLink(String link) {
		this.link = link;
	}/// end method setLink

	public String getAuthor() {
		return author;
	}// end method getAuthor

	public void setAuthor(String author) {
		this.author = author;
	}// end method setAuthor

	public String getGuid() {
		return guid;
	}// end method getGuid

	public void setGuid(String guid) {
		this.guid = guid;
	}// end method setGuid

	@Override
	public String toString() {
		return "FeedMessage [title=" + title + ", description=" + description
				+ ", link=" + link + ", author=" + author + ", guid=" + guid
				+ "]";
	}// end Override method toString
}// end class FeedMessage
