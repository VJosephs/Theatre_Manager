

import java.util.ArrayList;

public class Theatre {

	private String name;
	private String address;
	private Layout layout;
	private ArrayList ratings;
	private ArrayList shows;

	public Theatre(String name, String address, Layout layout, ArrayList<Rating> ratings,
			ArrayList<Show> shows) {
		this.name = name;
		this.address = address;
		this.layout = layout;
		setRatings(ratings);
		setShows(shows);
	}

	public Theatre(String name, String address, Layout layout) {
		this.name = name;
		this.address = address;
		this.layout = layout;
		this.ratings = new ArrayList<>();
		this.shows = new ArrayList<>();
	}

	public void addShow(Show show) {
		shows.add(show);
	}

	public void removeShow(Show show) {
		shows.remove(show);
	}

	public void addRating(Rating rating) {
		ratings.add(rating);
	}

	public void removeRating(Rating rating) {
		ratings.remove(rating);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Layout getLayout() {
		return layout;
	}

	public void setLayout(Layout layout) {
		this.layout = layout;
	}

	public double getAvgRating() {
		double sum = 0;
		for(Rating r : ratings) {
			sum += r.getRating();
		}
		return sum / ratings.size();
	}

	public void setRatings(ArrayList<Rating> ratings) {
		if(ratings == null)
			ratings = new ArrayList<>();
		this.ratings = ratings;
	}

	public void setShows(ArrayList<Show> shows) {
		if(shows == null)
			shows = new ArrayList<>();
		this.shows = shows;
	}
}