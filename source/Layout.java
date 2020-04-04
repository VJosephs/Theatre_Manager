

public class Layout {
    public String name;
    public Seat[][] seats;

    public Layout(String name, Seat[][] seats) {
        //TODO add method body
    	this.name = name;
    	this.seats = seats;
    }

    public void printLayout() {
    	for (int i = 0; i < seats.length; i++)
		{
			for (int j = 0; (seats[i] != null && j < seats[i].length); j++)
				System.out.print(seats[i][j].getType() + " ");

			System.out.println();
		}
    }
    public void makeLayout() {
        //TODO add method body
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}	