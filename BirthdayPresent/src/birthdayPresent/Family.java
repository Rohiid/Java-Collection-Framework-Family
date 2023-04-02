package birthdayPresent;

import java.util.*;

public class Family {
    private static Set<Uncle> uncles = new TreeSet<>();
    private static Set<Niece> nieces = new TreeSet<>();

    // method getter untuk uncle
    public static Set<Uncle> getUncles() {
        return uncles;
    }

    // method getter untuk niece
    public static Set<Niece> getNieces() {
        return nieces;
    }

    // constructor 
    private Family() {
       
    }

    /* Menambahkan keponakan baru.*/
    public static boolean addNiece(String name, int day, int month) {
        // melakukan pengecekan terhadap nama keponakan, jika nama
    	// keponakan sudah ada maka akan mengembalikan nilai false
        for (Niece niece : nieces) {
            if (niece.getName().equals(name)) {
                return false;
            }
        }
        // menambahkan objek 'Niece' baru ke dalam koleksi niece
        // jika operasi penambahan berhasil dilakukan maka akan mengembalikan
        // nilai true, namun jika operasi penambahan gagal karena objek 'Niece' 
        // yang sama telah ada di dalam koleksi 'nieces', maka akan mengembalikan nilai 'false'
        if (nieces.add(new Niece(name, day, month))){
            return true;
        } else {
            return false;
        }
    }

    /*Menambahkan paman baru ke dalam koleksi 'uncles' */
    public static boolean addUncle(String name) {
        Uncle uncle = new Uncle(name);
        // melakukan pengecekan apakah objek 'Uncle' sudah ada dalam 
        // koleksi 'uncles' menggunakan method contains, jika sudah ada 
        // maka akan mengembalikan nilai false
        if (uncles.contains(uncle)) {
            return false;
        }
        //menambahkan objek 'Uncle' ke dalam koleksi menggunakan method add
        // dan mengembalikan nilai true
        uncles.add(uncle);
        return true;
    }

    /* Mencari objek 'Niece' dalam koleksi 'nieces' berdasarkan nama yang 
       diparsingkan pada parameter, jika ditemukan maka akan mengembalikan objek 'Niece'
       namun jika tidak akan mengembalikan nilai null*/
    public static Niece findNiece(String name) {
        for (Niece niece : nieces) {
            if (niece.getName().equals(name)) {
                return niece;
            }
        }
        return null;
    }

    /* Mencari objek 'Uncle' dalam koleksi 'uncles' berdasarkan nama yang 
    diparsingkan pada parameter, jika ditemukan maka akan mengembalikan objek 'Uncle'
    namun jika tidak akan mengembalikan nilai null*/
    public static Uncle findUncle(String name) {
        for (Uncle uncle : uncles) {
            if (uncle.getName().equals(name)) {
                return uncle;
            }
        }
        return null;
    }

    /* Menampilkan list dari keponakan */
    public static void listNieces() {
        System.out.println("============ List of Nieces =============");
        for (Niece niece : nieces) {
            System.out.println(niece);
        }
    }

    /* Menampilkan list dari Uncle*/ 
    public static void listUncles() {
        System.out.println("============ List of Uncles =============");
        for (Uncle uncle : uncles) {
            System.out.println(uncle);
        }
    }

}
