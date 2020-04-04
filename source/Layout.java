

public class Layout {
    public String name;
    public Seat[][] seats;

    public Layout(String name, Seat[][] seats) {
        //TODO add method body
    	this.name = name;
    	this.seats = seats;
    }

    public void printLayout() {
<<<<<<< HEAD
    	for (int i = 0; i < seats.length; i++)
		{
			for (int j = 0; (seats[i] != null && j < seats[i].length); j++)
				System.out.print(seats[i][j].getType() + " ");

			System.out.println();
		}
=======
        for (int i = 0; i < seats.length + 1; ++i) {
            for (int j = 0; j < seats[0].length + 1; ++j) {
                if (i == 0 && j == 0)
                    System.out.print("  ");
                else if(i == 0)
                    System.out.print((char)((j-1)+65) + " ");
                else if(j == 0) {
                    System.out.print(i + " ");
                }
                else
                    System.out.print(seats[i-1][j-1] + " ");
            }
            System.out.println();
        }
>>>>>>> 96b28faca3fcfa06631c7d0d826d35431310f646
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