public class Ticket {
    private int id;
    private String artist;
    private String date;
    private int price;
    private int quantity;

    // Constructors
    public Ticket() {
    }

    public Ticket(String artist, String date, int price, int quantity) {
        this.artist = artist;
        this.date = date;
        this.price = price;
        this.quantity = quantity;
    }

    public Ticket(int id, String artist, String date, int price, int quantity) {
        this.id = id;
        this.artist = artist;
        this.date = date;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
