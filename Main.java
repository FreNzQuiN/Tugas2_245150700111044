import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
import java.io.IOException;

public class ClearScreen {
    public static void clear() {
        try {
            String os = System.getProperty("os.name").toLowerCase();

            if (os.contains("win")) {
                // Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // macOS/Linux
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException ex) {
            System.err.println("Gagal membersihkan layar: " + ex.getMessage());
        }
    }
}
class Pegawai {
    private String nama;
    private String jabatan;
    private double gajiPokok;
    private double tunjangan;
    private double potongan;
    private double bonus;
    // --- CONSTRUCTOR --- \\
    public Pegawai() {
        this.nama = "";
        this.jabatan = "";
        this.gajiPokok = 0.0;
        this.tunjangan = 0.0;
        this.potongan = 0.0;
        this.bonus = 0.0;
    }
    public Pegawai(String nama, String jabatan, double gajiPokok, double tunjangan, double potongan, double bonus) {
        this.nama = nama;
        this.jabatan = jabatan;
        this.gajiPokok = gajiPokok;
        this.tunjangan = tunjangan;
        this.potongan = potongan;
        this.bonus = bonus;
    }
    // --- METHOD SYSTEM --- \\
    public double hitungGajiTotal() {
        return gajiPokok + tunjangan + bonus - potongan;
    }
    public void displayInfo() {
        NumberFormat rupiah = NumberFormat.getCurrencyInstance(new Locale("ID","id"));
        System.out.println("==++ DATA PEGAWAI ++==");
        System.out.println("Nama: " + nama);
        System.out.println("Jabatan: " + jabatan);
        System.out.println("Gaji Pokok: " + rupiah.format(gajiPokok));
        System.out.println("Tunjangan: " + rupiah.format(tunjangan));
        System.out.println("Potongan: " + rupiah.format(potongan));
        System.out.println("Bonus: " + rupiah.format(bonus));
        System.out.println("Total Gaji: " + rupiah.format(hitungGajiTotal()) + "\n");
    }
    public void tambahBonus(double tambahanBonus) {
        this.bonus += tambahanBonus;
    }
    // --- SETTER --- \\
    public void setNama(String nama) {
    	this.nama = nama;
    }
    public void setJabatan(String jabatan) {
    	this.jabatan = jabatan;
    }
    public void setGajiPokok(double gajiPokok) {
    	this.gajiPokok = gajiPokok;
    }
    public void setTunjangan(double tunjangan) {
    	this.tunjangan = tunjangan;
    }
    public void setPotongan(double potongan) {
    	this.potongan = potongan;
    }
    public void setBonus(double bonus) {
    	this.bonus = bonus;
    }
    // --- GETTER --- \\
    public String getNama() {
    	return this.nama;
    }
    public String getJabatan() {
    	return this.jabatan;
    }
    public double getGajiPokok() {
    	return this.gajiPokok;
    }
    public double getTunjangan() {
    	return this.tunjangan;
    }
    public double getPotongan() {
    	return this.potongan;
    }
    public double getBonus() {
    	return this.bonus;
    }
}

class Main {
    public static void main(String[] args) {
        
        Pegawai pegawai1 = new Pegawai();
        pegawai1.setNama("Budi");
        pegawai1.setJabatan("Staff IT");
        pegawai1.setGajiPokok(5000000);
        pegawai1.setTunjangan(1000000);
        pegawai1.setPotongan(500000);
        pegawai1.setBonus(200000);
        
        Pegawai pegawai2 = new Pegawai("Surti","Data Analis", 4500000,1000000,300000,200000);
        
        // --- DATABASE APLIKASI-- \\
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.printf("=+  SELAMAT DATANG DI APLIKASI PERUSAHAAN +=\n");
            System.out.printf("1. Tampilkan Data Pegawai\n");
            System.out.printf("2. Ubah Data Pegawai\n");
            System.out.printf("3. Keluar\n");
            System.out.print("Pilih menu: ");
            try {
                int pilihan = scan.nextInt();
                scan.nextLine();
                ClearScreen.clear();
                switch (pilihan) {
                    case 1:
                        pegawai1.displayInfo();
                        pegawai2.displayInfo();
                        break;
                    case 2:
                    	 { // --- UBAH DATA --- \\
                    	 System.out.printf("Ubah Pegawai 1 atau 2? ");
                    	 pilihan = scan.nextInt(); scan.nextLine();
                    	 System.out.print("\n");
                    	 String tempString = "";
                    	 double tempDouble =0.0;
                    	 switch (pilihan){
                    	 	case 1:
                    	 	System.out.printf("Masukkan nama: ");
                    	 tempString = scan.nextLine();
                    	 System.out.print("\n");
                    	 pegawai1.setNama(tempString);
                    	 System.out.printf("Masukkan jabatan: ");
                    	 tempString = scan.nextLine();
                    	 System.out.print("\n");
                    	 pegawai1.setJabatan(tempString);
                    	 System.out.printf("Masukkan Gaji Pokok: ");
                    	 tempDouble = scan.nextDouble(); scan.nextLine();
                    	 System.out.print("\n");
                    	 pegawai1.setGajiPokok(tempDouble);
                    	 System.out.printf("Masukkan Tunjangan: ");
                    	 tempDouble = scan.nextDouble(); scan.nextLine();
                    	 System.out.print("\n");
                    	 pegawai1.setTunjangan(tempDouble);
                    	 System.out.printf("Masukkan Potongan ");
                    	 tempDouble = scan.nextDouble(); scan.nextLine();
                    	 System.out.print("\n");
                    	 pegawai1.setPotongan(tempDouble);
                    	 System.out.printf("Masukkan Bonus: ");
                    	 tempDouble = scan.nextDouble(); scan.nextLine();
                    	 System.out.print("\n");
                    	 pegawai1.setBonus(tempDouble);
                    	 ClearScreen.clear();
                    	 System.out.println("DATA BERHASIL DIMASUKKAN!!\n");
                    	 continue;
                    	 case 2:
                    	 System.out.printf("Masukkan nama: ");
                    	 tempString = scan.nextLine();
                    	 System.out.print("\n");
                    	 pegawai2.setNama(tempString);
                    	 System.out.printf("Masukkan jabatan: ");
                    	 tempString = scan.nextLine();
                    	 System.out.print("\n");
                    	 pegawai2.setJabatan(tempString);
                    	 System.out.printf("Masukkan Gaji Pokok: ");
                    	 tempDouble = scan.nextDouble(); scan.nextLine();
                    	 System.out.print("\n");
                    	 pegawai2.setGajiPokok(tempDouble);
                    	 System.out.printf("Masukkan Tunjangan: ");
                    	 tempDouble = scan.nextDouble(); scan.nextLine();
                    	 System.out.print("\n");
                    	 pegawai2.setTunjangan(tempDouble);
                    	 System.out.printf("Masukkan Potongan: ");
                    	 tempDouble = scan.nextDouble(); scan.nextLine();
                    	 System.out.print("\n");
                    	 pegawai2.setPotongan(tempDouble);
                    	 System.out.printf("Masukkan Bonus: ");
                    	 tempDouble = scan.nextDouble(); scan.nextLine();
                    	 System.out.print("\n");
                    	 pegawai2.setBonus(tempDouble);
                    	 ClearScreen.clear();
                    	 System.out.println("DATA BERHASIL DIMASUKKAN!!\n");
                    	 continue;
                    	 default:
                        System.out.println("Pilihan tidak valid.");
                    	 }
                    	 }
                    case 3:
                        System.out.println("Terima kasih!");
                        scan.close();
                        return;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Input tidak valid. Masukkan angka.");
            }
        }
        
    }
}
