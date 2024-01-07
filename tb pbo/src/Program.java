import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Scanner;

public class Program{
    static Connection conn;

    //Main Program
    public static void main(String[] args) throws Exception{
        //Scanner
        Scanner dataInput = new Scanner(System.in);
        String pilihMenu;

        Boolean isLanjutkan = true;

        //URL SQL untuk menyambungkan kode ke Database
        String url = "jdbc:mysql://localhost:3306/dbdataendorse";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, "root", "");
            System.out.println("Database berhasil ditemukan!");

            Transaksi transaksi = new Transaksi();

            //Perulangan
            while (isLanjutkan){
                System.out.println("Tugas Besar PBO");
                System.out.println("Nama : Athaya Clara Diva");
                System.out.println("NIM : 2211523009");
                System.out.println("Dosen Pengampu : Jefril Rahmadoni, M.Kom");
                System.out.println("");
                System.out.println("===================================");
                System.out.println( "        RATE CARD ENDORSE");
                System.out.println("            FADIL JAIDI");
                System.out.println("----------------------------------");
                System.out.println("");
                
                //Kodingan tanggal & waktu
                Date tanggalhariini = new Date(0);
                SimpleDateFormat tanggal = new SimpleDateFormat("E,dd/MM/yyy");
                SimpleDateFormat waktu = new SimpleDateFormat("HH:mm:ss zzzz");
                System.out.println("Tanggal\t" + tanggal.format(tanggalhariini));
                System.out.println("Waktu\t" + waktu.format(tanggalhariini));
                
                //Collection Framework
                HashMap<Integer, String> jenisEndorse = new HashMap<Integer,String>();
                jenisEndorse.put(100000, " Foto Story");
                jenisEndorse.put(150000, " Video Story");
                jenisEndorse.put(200000, " Foto Feed");
                jenisEndorse.put(300000, " Video Feed");
                
                System.out.println("\nHarga Endorse :");
                for(Integer a : jenisEndorse.keySet()){
                    System.out.println("Rp "+ a + jenisEndorse.get(a)+ "/postingan");
                }

                //Menu CRUD
                System.out.println("--------------------------------");
                System.out.println("          PILIHAN MENU         ");
                System.out.println("--------------------------------");
                System.out.println("");
                System.out.println("1. Tambah Data Endorse");
                System.out.println("2. Lihat Data Endorse");
                System.out.println("3. Ubah Data Endorse");
                System.out.println("4. Hapus Data Endorse");
                System.out.println("5. Cari dari Menu");
                System.out.println("");
                System.out.println("Masukkan pilihan anda : ");

                pilihMenu = dataInput.next();

                //Percabangan
                switch (pilihMenu) {
                    case "1":
                        transaksi.TransaksiEndorse();
                        break;
                    
                    case "2" :
                        transaksi.LihatData();
                        break;
                    
                    case "3":
                        transaksi.UbahData();
                        break;
                    
                    case "4":
                        transaksi.HapusData();
                        break;
                    
                    case "5":
                        transaksi.CariData();
                        break;
                        
                
                    default:
                        System.err.println("Masukkan input yang benar!");
                }
                // Method String equalsIgnoreCase
                System.out.print("Ingin melanjutkan? (Y/T)");
                pilihMenu = dataInput.next();
                isLanjutkan = pilihMenu.equalsIgnoreCase("Y");
            }
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Terima Kasih!! Admin akan segera menghubungi mu dalam 24 jam!! ");



        }catch(ClassNotFoundException ex){  //Exception
            System.err.println("Driver bermasalah");
            System.exit(0);
        }catch (SQLException e){            //Exception
            System.err.println("Driver tidak terkoneksi!!");
            e.printStackTrace();
        }
    }
}