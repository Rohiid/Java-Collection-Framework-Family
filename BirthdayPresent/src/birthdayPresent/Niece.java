package birthdayPresent;


import java.util.*;

public class Niece implements Comparable<Niece> {
    private String name;
    private int day;
    private int month;
    private Map<Uncle, String> presents;

    // constructor
    protected Niece(String name, int day, int month) {
        this.name = name;
        this.day = day;
        this.month = month;
        this.presents = new HashMap<>();
    }

    // method getter dan setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public Map<Uncle, String> getPresents() {
        return presents;
    }

    public void setPresents(Map<Uncle, String> presents) {
        this.presents = presents;
    }

    // Menghapus semua hadiah, kemudain mengembalikan nomor yang dihapuskan
    public int clearPresents() {
        int count = presents.size();
        presents.clear();
        return count;
    }

    // List hadiah yang diterima keponakan, menampilkan paman yang memberikannya, paman yang tidak memberikan hadiah juga ditampilkan
    public void listPresents() {
        for (Uncle uncle : Family.getUncles()) {
            if (presents.containsKey(uncle)) {
                System.out.println(uncle.getName() + " - " + presents.get(uncle));
            } else {
                System.out.println(uncle.getName() + " - No present");
            }
        }
    }

    // Menerima hadiah dari paman, mengembalikan nilai true jika present belom ada
    public boolean receivePresent(Uncle uncle, String present) {
        if (presents.containsKey(uncle)) {
            return false;
        }

        if (presents.containsValue(present)) {
            return false;
        }

        presents.put(uncle, present);
        return true;
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
        final Niece other = (Niece) obj;
        if (this.day != other.day) {
            return false;
        }
        if (this.month != other.month) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.presents, other.presents);
    }

    @Override
    public String toString() {
        return "Niece{" + "name=" + name + ", day=" + day + ", month=" + month + '}';
    }

    @Override
    public int compareTo(Niece o) {
        if (month == o.month) {
            return day - o.day;
        }
        return month - o.month;
    }
}
