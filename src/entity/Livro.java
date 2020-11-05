package entity;

public class Livro {

    private int id;
    private String titulo;
    private String isbn;
    private Editora publisher_id;
    private float price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Editora getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(Editora publisher_id) {
        this.publisher_id = publisher_id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        return this.getTitulo(); 
    }

}
