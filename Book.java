package librarymanagment;

public class Book {
	private String isbn;
	private String name;
	private String author;
	
	public Book() {}
	
	public Book(String isbn , String name , String author) {
		this.isbn = isbn;
		this.name = name;
		this.author =author;
	}
	
	public String getisbn() {
		return isbn;
	}
	
	public void setisbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getname() {
		return name;
	}
	
	public void setname(String name) {
		this.name = name;
	}
	
	public String getauthor() {
		return author;
	}
	
	public void setauthor(String author) {
		this.author = author;
	}

}
