

import java.util.ArrayList;

public class Theatre {
private String name;
private String address;
private Layout layout;
private double avgRating;
private ArrayList<Rating> ratings= new ArrayList<>();
private ArrayList<Show> shows= new ArrayList<>();

public Theatre(String name, String address, Layout layout, double avgRating, ArrayList<Rating> ratings,
		ArrayList<Show> shows) {
	super();
	this.name = name;
	this.address = address;
	this.layout = layout;
	this.avgRating = avgRating;
	this.ratings = ratings;
	this.shows = shows;
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
 return 0.0;
}
public void setAvgRating(double avgRating) {
	this.avgRating = avgRating;
}


}