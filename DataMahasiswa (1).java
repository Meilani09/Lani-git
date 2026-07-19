import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

// ================= INTERFACE =================
interface Cetak {
    void printData();
}

// ================= ABSTRACT CLASS =================
abstract class Aktivitas {
    abstract void info();
}

// ================= ENCAPSULATION =================
class Mahasiswa<T1, T2, T3> implements Cetak {

    private T1 nim;
    private T2 nama;
    private T3 kelas;

    // Setter
    public void setNim(T1 nim) {
        this.nim = nim;
    }

    public void setNama(T2 nama) {
        this.nama = nama;
    }

    public void setKelas(T3 kelas) {
        this.kelas = kelas;
    }

    // Getter
    public T1 getNim() {
        return nim;
    }

    public T2 getNama() {
        return nama;
    }

    public T3 getKelas() {
        return kelas;
    }

    // Interface
    @Override
    public void printData() {
        System.out.println("NIM    : " + nim);
        System.out.println("Nama   : " + nama);
        System.out.println("Kelas  : " + kelas);
    }
}

// ================= INHERITANCE =================
class User {
    protected String username;

    public User(String username) {
        this.username = username;
    }
}

class Admin extends User {

    public Admin(String username) {
        super(username);
    }

    public void tampilAdmin() {
        System.out.println("Admin : " + username);
    }
}

// ================= POLIMORFISME =================
class Login {
    public void masuk() {
        System.out.println("Login User");
    }
}

class LoginAdmin extends Login {

    @Override
    public void masuk() {
        System.out.println("Login Admin");
    }
}

// ================= ABSTRACT IMPLEMENT =================
class AktivitasMahasiswa extends Aktivitas {

    @Override
    void info() {
        System.out.println("Data Mahasiswa Aktif");
    }
}

// ================= MAIN CLASS =================
public class DataMahasiswa {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Collection ArrayList
        ArrayList<Mahasiswa<String, String, Integer>> daftarMhs = new ArrayList<>();

        // Collection ArrayDeque
        ArrayDeque<String> antrian = new ArrayDeque<>();

        // Polimorfisme
        Login lg = new LoginAdmin();
        lg.masuk();

        // Inheritance
        Admin adm = new Admin("Nadia");
        adm.tampilAdmin();

        // Abstract
        AktivitasMahasiswa act = new AktivitasMahasiswa();
        act.info();

        int pilih;

        do {

            System.out.println("\n=== MENU DATA MAHASISWA ===");
            System.out.println("1. Tambah Data");
            System.out.println("2. Lihat Data");
            System.out.println("3. Tambah Antrian");
            System.out.println("4. Lihat Antrian");
            System.out.println("0. Keluar");
            System.out.print("Pilih : ");
            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {

                case 1:

                    Mahasiswa<String, String, Integer> m = new Mahasiswa<>();

                    System.out.print("Masukkan NIM : ");
                    String nim = input.nextLine();

                    System.out.print("Masukkan Nama : ");
                    String nama = input.nextLine();

                    System.out.print("Masukkan Kelas : ");
                    int kelas = input.nextInt();
                    input.nextLine();

                    m.setNim(nim);
                    m.setNama(nama);
                    m.setKelas(kelas);

                    daftarMhs.add(m);

                    System.out.println("Data berhasil ditambahkan");
                    break;

                case 2:

                    System.out.println("\n=== DATA MAHASISWA ===");

                    for (Mahasiswa<String, String, Integer> data : daftarMhs) {

                        data.printData();
                        System.out.println("-------------------");
                    }

                    break;

                case 3:

                    System.out.print("Nama Antrian : ");
                    String antri = input.nextLine();

                    antrian.add(antri);

                    System.out.println("Antrian berhasil ditambahkan");
                    break;

                case 4:

                    System.out.println("\n=== DAFTAR ANTRIAN ===");

                    for (String a : antrian) {
                        System.out.println(a);
                    }

                    break;

                case 0:

                    System.out.println("Program selesai");
                    break;

                default:

                    System.out.println("Pilihan tidak tersedia");
            }

        } while (pilih != 0);

    }
}