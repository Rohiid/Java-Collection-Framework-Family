package birthdayPresent;


import java.util.*;

public class Uncle implements Comparable<Uncle> {
    private String name;
    private Map<Niece, String> presents;

    // constructor
    protected Uncle(String name) {
        this.name = name;
        this.presents = new LinkedHashMap<>();
    }

    // method setter dan getter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Niece, String> getPresents() {
        return presents;
    }

    public void setPresents(Map<Niece, String> presents) {
        this.presents = presents;
    }

    // Menambahkan hadiah baru yang diberikan oleh paman, mengembalikan nilai true jika belom ada hadiah yang sama
    // jika keponakan sudah menerima hadiah dari uncle ini, maka akan mengembalikan nilai return dan tidak ada yang ditambahkan
    public boolean addPresent(Niece niece, String present) {
        if (presents.containsKey(niece)) {
            return false;
        }
        presents.put(niece, present);
        return true;
    }

    // List hadiah yang diterima keponakan, menampilkan paman yang memberikannya, paman yang tidak memberikan hadiah juga ditampilkan
    public void listPresents() {
        for (Niece niece : Family.getNieces()) {
            if (presents.containsKey(niece)) {
                System.out.println(niece.getName() + " - " + presents.get(niece));
            } else {
                System.out.println(niece.getName() + " - No present");
            }
        }
    }

    // Menghapus hadaih yang diberikan paman ke keponakan, mengembalikan nilai true jika hadiah berhasil diihapus
    public boolean removePresent(Niece niece) {
        if (presents.containsKey(niece)) {
            presents.remove(niece);
            return true;
        }
        return false;
    }

    // Check given present to all niece by this uncle. return true if present doesn't exist.
    // 
    public boolean checkPresent(String newPresent) {
        newPresent = newPresent.toUpperCase();
        if (presents.containsValue(newPresent)) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Uncle other = (Uncle) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.presents, other.presents);
    }

    @Override
    public String toString() {
        return "Uncle{" + "name=" + name + '}';
    }

    @Override
    public int compareTo(Uncle o) {
        return name.compareTo(o.name);
    }
}
