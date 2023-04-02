package birthdayPresent;

import java.util.*;

public class Main{
    public static void main(String[] args) {
        String uncleName;
        String nieceName;
        String present;

        while (true) {
            System.out.println("+=====+ Birthday Present Program +=====+");
            System.out.println("|        1. Add Uncle                   |");
            System.out.println("|        2. Add Niece                   |");
            System.out.println("|        3. List Uncles                 |");
            System.out.println("|        4. List Nieces                 |");
            System.out.println("|        5. Add Present                 |");
            System.out.println("|        6. List Presents               |");
            System.out.println("|        7. Clear Presents              |");
            System.out.println("|        8. Exit                        |");
            System.out.println("+=======================================+\n");

            System.out.print("Input your choice: ");
            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();
            scan.nextLine();
            System.out.println();

            switch (choice) {
                // Menambahkan paman baru
                case 1:
                    // Nama paman
                    System.out.print("Enter Uncle's name: ");
                    uncleName = scan.nextLine().toUpperCase();
                    if (Family.addUncle(uncleName) && !uncleName.isEmpty()) {
                        System.out.println("Uncle added");
                    } else {
                        System.out.println("Uncle already exists");
                    }
                    break;

                // Menambahkan keponakan baru
                case 2:
                    try {
                        // Ulang tahun keponakan (tanggal)
                        System.out.print("Enter Niece's birthday (date): ");
                        int day = scan.nextInt();
                        try{
                            if (day < 1 || day > 31) {
                                throw new Exception("Invalid day");
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            break;
                        }

                        // Ulang tahun keponakan (bulan)
                        System.out.print("Enter Niece's birthday (month in number): ");
                        int month = scan.nextInt();
                        try{
                            if (month < 1 || month > 12) {
                                throw new Exception("Invalid month");
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            break;
                        }

                        // Nama keponakan
                        scan.nextLine();
                        System.out.print("Enter Niece's name: ");
                        nieceName = scan.nextLine().toUpperCase();
                        if (Family.addNiece(nieceName, day, month) && !nieceName.isEmpty()) {
                            System.out.println("Niece added");
                        } else {
                            System.out.println("Niece already exists");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input");
                    }
                    break;

                // Menampilkan list paman
                case 3:
                    Family.listUncles();
                    break;

                // Menampilkan list keponakan
                case 4:
                    Family.listNieces();
                    break;
                 // Menambahkan hadiah dari paman untuk keponakan
                case 5:
                    try {
                        // Nama paman 
                        System.out.print("Enter Uncle's name: ");
                        uncleName = scan.nextLine().toUpperCase();
                        if (Family.findUncle(uncleName) == null) {
                            throw new Exception("Uncle not found");
                        }

                        // Nama keponakan 
                        System.out.print("Enter Niece's name: ");
                        nieceName = scan.nextLine().toUpperCase();
                        if (Family.findNiece(nieceName) == null) {
                            throw new Exception("Niece not found");
                        }

                        // Untuk input hadiah
                        System.out.print("Enter Present: ");
                        present = scan.nextLine().toUpperCase();
                        
                        //Melakukan pengecekan apakah hadiah yang sama telah diberikan kepada keponakan lain (paman yang sama)
                        boolean isSuccess = Family.findUncle(uncleName).checkPresent(present);
                        if (!isSuccess) {
                            throw new Exception("Present already given to other niece");
                        }
                        
                        // Paman memberikan hadian dan keponakan menerima hadiah dari paman 
                        isSuccess = Family.findUncle(uncleName).addPresent(Family.findNiece(nieceName), present);
                        isSuccess = Family.findNiece(nieceName).receivePresent(Family.findUncle(uncleName), present);
                        if (isSuccess) {
                            System.out.println("Present added");
                        } else {
                            throw new Exception("Present already exists");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                // Menampilkan hadiah yang dapat dilihat dari sisi paman mau pun sisi keponakan
                case 6:
                    try {
                        System.out.println("List presents by:");
                        System.out.println("1. Uncle");
                        System.out.println("2. Niece");
                        System.out.print("Enter your choice: ");
                        int listChoice = scan.nextInt();
                        scan.nextLine();
                        System.out.println();
                        switch (listChoice) {
                            case 1:
                                System.out.print("Enter Uncle's name: ");
                                uncleName = scan.nextLine().toUpperCase();
                                if (Family.findUncle(uncleName) == null) {
                                    throw new Exception("Uncle not found");
                                }
                                System.out.println("================== " + uncleName + " Presents ==================");
                                Family.findUncle(uncleName).listPresents();
                                break;
                            case 2:
                                System.out.print("Enter Niece's name: ");
                                nieceName = scan.nextLine().toUpperCase();
                                if (Family.findNiece(nieceName) == null) {
                                    throw new Exception("Niece not found");
                                }
                                System.out.println("================== " + nieceName + " Presents ==================");
                                Family.findNiece(nieceName).listPresents();
                                break;
                            default:
                                throw new Exception("Invalid choice");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                // Menghapus hadiah
                case 7:
                    try {
                        System.out.print("Enter Niece's name: ");
                        nieceName = scan.nextLine().toUpperCase();
                        if (Family.findNiece(nieceName) == null) {
                            throw new Exception("Niece not found");
                        } else {
                            int amount = Family.findNiece(nieceName).clearPresents();
                            final String temp_name = nieceName;
                            Family.getUncles().forEach((uncle) -> {
                                uncle.removePresent(Family.findNiece(temp_name));
                            });
                            System.out.println(amount + " presents cleared from " + nieceName);
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                // Keluar dari program
                case 8:
                    scan.close();
                    System.exit(0);
                    break;

                // Pilihan salah
                default:
                    System.out.println("Invalid choice");
                    break;
            }
            System.out.println("\n");
        }
    }
}
