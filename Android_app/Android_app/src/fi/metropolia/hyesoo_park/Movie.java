package fi.metropolia.hyesoo_park;


public class Movie {
	public String name, year, genre, plot, director;

	public Movie(String name, String year, String genre, String plot, String director) {
		super();
		this.name = name;
		this.year = year;
		this.genre = genre;
		this.plot = plot;
		this.director = director;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	
	public String getplot() {
		return plot;
	}

	public void setplot(String plot) {
		this.plot = plot;
	}
	
	public String getdirector() {
		return director;
	}

	public void setdirector(String director) {
		this.director = director;
	}
	
}