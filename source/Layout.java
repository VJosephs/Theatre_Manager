import java.awt.*;
import java.util.Scanner;

public class Layout {
    public String name;
    public Seat[][] seats;

    private String currentSeatType;
    private int HEIGHT;
    private int WIDTH;

    /**
     * @param name  Name of the seat that would appear on a ticket
     * @param seats index within the matrix for specific seat location
     * @return n/a   its a constructor
     * @exception  n/a
     */

    public Layout(String name, Seat[][] seats) {
        this.name = name;
        this.seats = seats;
    }

    public Layout(String name) {
        this.name = name;
    }

    public void printLayout() {
        for (int i = 0; i < seats.length + 1; ++i) {
            for (int j = 0; j < seats[0].length; ++j) {
                if (i == 0)
                    System.out.print((char) (j + 65) + " ");
                else
                    System.out.print(seats[i - 1][j].getSeatChar() + " ");
            }
            if (i != 0)
                System.out.print("| " + (i - 1));
            System.out.println();
        }
    }

    /**
     * @param input used for user to put in a specific
     * @return n/a   its void
     * @exception  n/a
     */
    public void makeLayout(Scanner input) {
        int width;
        int height;


        System.out.println("Please give the width and height of the Theatre: \n");
        width = takeIntVal(input, "Width: ");
        height = takeIntVal(input, "Height: ");

        initSeats(width, height);
        System.out.println("The seats have been initialized");

        String type = "";
        System.out.println("Please choose what the seats will be set to type \"quit\" to finish");
        while (!type.equalsIgnoreCase("quit")) {
            System.out.println("Enter two points followed by a type ex( A1 B4 available): ");
            type = input.nextLine();
            if (stringValid(type)) {
                String[] brokenString = chopString(type);
                setSeatType(brokenString);
                setSeats(getDim(getPoints(brokenString)));
            } else if (!type.equalsIgnoreCase("quit")) {
                System.out.println("The line \"" + type + "\" seems to be invalid please try again");
            }
        }
    }

    private int takeIntVal(Scanner input, String prompt) {
        int Val = 0;
        while (Val == 0) {
            try {
                System.out.print(prompt);
                Val = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid Value must be an integer above 0");
            }
        }
        return Val;
    }

    /**
     * @param width  used for the horizontal rows in layout
     * @param height used for the vertical rows in layout
     * @return n/a   its void
     * @exception  n/a
     */
    private void initSeats(int width, int height) {
        WIDTH = width;
        HEIGHT = height;
        seats = new Seat[WIDTH][HEIGHT];
        for (Seat[] seat : seats) {
            for (int j = 0; j < seats[0].length; ++j) {
                seat[j] = new Seat("blank");
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

    /**
     * @param arr indexes that would appear on the ticket
     * @return intp[]   tzhis will be the coordinates of the seat in layout
     * @exception  n/a
     */
    private int[] getPoints(String[] arr) {
        int a = (arr[0].charAt(0)) - 65;
        String justTheNums = arr[0].replaceAll("[A-Za-z]", "");
        int b = Integer.parseInt(justTheNums);
        int c = (arr[1].charAt(0)) - 65;
        justTheNums = arr[1].replaceAll("[A-Za-z]", "");
        int d = Integer.parseInt(justTheNums);

        if (a > WIDTH)
            a = WIDTH;
        if (b > HEIGHT)
            b = HEIGHT;
        if (c > WIDTH)
            c = WIDTH;
        if (d > HEIGHT)
            d = HEIGHT;

        return new int[]{a, b, c, d};
    }

    /**
     * @param points used for exact location of the seat
     * @return int[]   This will be where the seat is located
     * @exception  n/a
     */
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

    /**
     * @param arr certain inedexes for specific seats
     * @return n/a   its void
     * @exception  n/a
     */
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

    public Seat[][] getSeats() {
        return seats;
    }

    public void setSeats(Seat[][] seats) {
        this.seats = seats;
    }

    public String getCurrentSeatType() {
        return currentSeatType;
    }

    public void setCurrentSeatType(String currentSeatType) {
        this.currentSeatType = currentSeatType;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public void setHEIGHT(int HEIGHT) {
        this.HEIGHT = HEIGHT;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public void setWIDTH(int WIDTH) {
        this.WIDTH = WIDTH;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}	
