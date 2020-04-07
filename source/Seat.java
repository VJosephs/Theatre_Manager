public class Seat {
    private char seatChar;
    private boolean valid;
    private String type;

    /**
     * @param type Used to know what type of event the seat is for
     * @return n/a     its a constructor
     * @exception  n/a
     */
    public Seat(String type) {
        setType(type);

    }

    public void setType(String type) {
        if (type.equalsIgnoreCase("taken")) {
            valid = false;
            seatChar = 'X';
        } else if (type.equalsIgnoreCase("available")) {
            valid = true;
            seatChar = 'O';
        } else if (type.equalsIgnoreCase("handicap")) {
            valid = true;
            seatChar = '\u267f';
        } else if (type.equalsIgnoreCase("blank")) {
            valid = false;
            seatChar = ' ';
        } else {
            valid = false;
            seatChar = '\u1234';
        }
        this.type = type;
    }

    public char getSeatChar() {
        return seatChar;
    }

    public boolean isValid() {
        return valid;
    }

    public void setInValid() {
        this.valid = false;
    }

    public String getType() {
        return type;
    }
}
