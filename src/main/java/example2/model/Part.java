package example2.model;

import javax.persistence.*;

@Entity
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false,unique = true)
    private String partNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Part part = (Part) o;

        if (id != part.id) return false;
        if (!title.equals(part.title)) return false;
        return partNumber.equals(part.partNumber);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + title.hashCode();
        result = 31 * result + partNumber.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Part{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", partNumber='" + partNumber + '\'' +
                '}';
    }
}
