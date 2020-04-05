import java.util.Scanner;

public class Layout {
    public String name;
    public Seat[][] seats;

    private String currentSeatType;

    public Layout(String name, Seat[][] seats) {
        this.name = name;
        this.seats = seats;
    }

    public Layout(String name) {
        this.name = name;
    }

    public void printLayout() {

        for (int i = 0; i < seats.length + 1; ++i) {
            for (int j = 0; j < seats[0].length + 1; ++j) {
                if (i == 0 && j == 0)
                    System.out.print("  ");
                else if (i == 0)
                    System.out.print((char) ((j - 1) + 65) + " ");
                else if (j == 0)
                    System.out.print(i - 1 + " ");
                else
                    System.out.print(seats[i - 1][j - 1].getType() + " ");
            }
            System.out.println();
        }

    }

    public void makeLayout() {
        Scanner input = new Scanner(System.in);
        int width;
        int height;


        System.out.println("Please give the width and height of the Theatre. \n");
        width = takeIntVal(input);
        height = takeIntVal(input);

        initSeats(width, height);
        System.out.println("The seats have been initialized");

        String type = "";
        System.out.println("Please choose what the seats will be set to type \"quit\" to finish");
        while(!type.equalsIgnoreCase("quit")) {
            System.out.println("Enter two points followed by a type ex( A1 B4 available)\n: ");
            type = input.nextLine();
            if(stringValid(type)) {
                String[] brokenString =  chopString(type);
                setSeatType(brokenString);
                setSeats(getDim(getPoints(brokenString)));
            }
            else if (!type.equalsIgnoreCase("quit")){
                System.out.println("The line \"" + type + "\" seems to be invalid please try again");
            }
        }



        input.close();
    }

    private int takeIntVal(Scanner input) {
        int Val = 0;
        while (Val == 0) {
            try {
                System.out.println("Width: ");
                Val = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid Value must be an integer above 0");
            }
        }

        return Val;
    }

    private void initSeats(int width, int height) {
        seats = new Seat[height][width];
        for (Seat[] seat : seats) {
            for (int j = 0; j < seats[0].length; ++j) {
                seat[j].setType("blank");
            }
        }
    }

    private boolean stringValid(String str) {
        return str.matches("[A-Za-z][0-9]+ [A-Za-z][0-9]+ [A-Za-z]+");
    }

    private void setSeatType(String[] arr) {
        currentSeatType = arr[arr.length - 1];
    }

    private String[] chopString(String str) {
        str = str.toUpperCase();
        return str.split(" ");
    }

    private int[] getPoints(String[] arr) {
        int a = (arr[0].charAt(0)) - 65;
        String justTheNums = arr[0].replaceAll("[A-Za-z]", "");
        int b = Integer.parseInt(justTheNums);
        int c = (arr[1].charAt(0)) - 65;
        justTheNums = arr[1].replaceAll("[A-Za-z]", "");
        int d = Integer.parseInt(justTheNums);

        return new int[]{a, b, c, d};
    }

    private int[] getDim(int[] points) {
        int aX = points[0];
        int aY = points[1];
        int bX = points[2];
        int bY = points[3];

        int width = Math.abs(aX - bX) + 1;
        int height = Math.abs(aY - bY) + 1;
        int x = Math.min(aX, bX);
        int y = Math.min(aY, bY);

        return new int[]{x, y, width, height};
    }

    private void setSeats(int[] arr) {
        int x = arr[0];
        int y = arr[1];
        int width = arr[2];
        int height = arr[3];

        for (int i = x; i < width + x; ++i) {
            for (int j = y; j < height + y; ++j) {
                seats[j][i].setType(currentSeatType);
            }
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}	