package hungnt2004110032;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class Main {

    static DanhSachHangHoa danhSachHangHoa = new DanhSachHangHoa();
    static ConsoleInputing consoleInputing = new ConsoleInputing();
    
    public static void main(String[] args) {

        readToFile(); // Đọc file có sẵn 10 hàng hóa
        
        int luaChon;
        do{
            System.out.println("--------------Menu--------------");
            System.out.println("1> Them hang hoa");
            System.out.println("2> In danh sach hang hoa"); // có sẵn 10 hàng hóa trong danh sách khi chạy chương trình
            System.out.println("3> Tim kiem hang hoa");
            System.out.println("4> Xoa hang hoa");
            System.out.println("5> Sua hang hoa");
            System.out.println("6> Thong ke hang hoa");
            System.out.println("7> Tien ich");
            System.out.println("0> Thoat chuong trinh");

            System.out.print("Chon chuc nang: ");
            luaChon = consoleInputing.getNhap().nextInt();
            consoleInputing.getNhap().nextLine();

            switch(luaChon){

                case 0:
                    System.out.println("Thoat chuong trinh thanh cong!");
                    System.exit(0);
                    break;
                case 1: nhapHangHoa();
                    break;
                case 2: danhSachHangHoa.inDanhSach();
                    break;
                case 3: timKiemHangHoa();
                    break;
                case 4: xoaHangHoa();
                    break;
                case 5: suaHangHoa(); 
                    break;
                case 6: thongKeHangHoa();
                    break;
                case 7: tienIch();
                    break;
                default: System.out.println("Lua chon khong hop le");
            
            }
            System.out.print("Quay ve menu (Y/N)>> ");

        }while(consoleInputing.getNhap().nextLine().equalsIgnoreCase("Y"));

    }

    static void nhapHangHoa(){

        do{
            HangHoa hangHoa = consoleInputing.nhapHangHoa();
            danhSachHangHoa.them(hangHoa);
            System.out.print("ban muon nhap tiep khong ? (Y/N)>> ");               
        }while(consoleInputing.getNhap().nextLine().equalsIgnoreCase("Y"));

    }

    static void inDanhSach(){
        System.out.println("1> In danh sach hang thuc pham");
        
    }

    static void xoaHangHoa(){

        System.out.print("Nhap ma hang hoa muon xoa: ");
        String maHangHoa = consoleInputing.getNhap().nextLine();

        HangHoa hangHoa = danhSachHangHoa.timKiemHangHoaTheoMa(maHangHoa);
        danhSachHangHoa.xoaHangHoa(hangHoa);
        if(hangHoa == null){
            System.out.println("Xoa khong thanh cong !");
        }else{
            System.out.println("Xoa hang hoa thanh cong !");
        }

    }

    static void suaHangHoa(){
        System.out.println("Sua hang hoa");
        HangHoa hangHoa = danhSachHangHoa.timKiemHangHoaTheoMa("MG01");
        int viTri = danhSachHangHoa.timViTriCuaHangHoa(hangHoa);
        danhSachHangHoa.suaHangHoa(viTri, hangHoa);

    }

    static void timKiemHangHoa(){

        System.out.println("1> Tim kiem theo ma hang hoa");
        System.out.println("2> Tim kiem theo ten hang hoa");
        System.out.print("Lua chon cua ban: ");

        int luaChon = consoleInputing.getNhap().nextInt();
        consoleInputing.getNhap().nextLine();
        if(luaChon == 1){
            System.out.print("Nhap ma hang hoa muon tim: ");
            String maHangHoa = consoleInputing.getNhap().nextLine();
            HangHoa hangHoa = danhSachHangHoa.timKiemHangHoaTheoMa(maHangHoa);
            if(hangHoa != null){
                System.out.println("Da tim thay hang hoa !");
                System.out.println(hangHoa);
            }
        }else if(luaChon == 2){
            System.out.print("Nhap ten hang hoa muon tim: ");
            String tenHangHoa = consoleInputing.getNhap().nextLine();
            HangHoa hangHoa = danhSachHangHoa.timKiemHangHoaTheoTen(tenHangHoa);
            System.out.println("Da tim thay hang hoa !");
            System.out.println(hangHoa);
        }else{
            System.out.println("Lua chon khong hop le !");
        }

    }

    static void writeToFile(){
        try (
        FileOutputStream outFile = new FileOutputStream("data.dat")) {

            ObjectOutputStream objOut = new ObjectOutputStream(outFile);
            objOut.writeObject(danhSachHangHoa.getDanhSach());
            System.out.println("Luu file thành công");

            objOut.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File khong ton tai !");
        }
    }

    static void readToFile(){
        try (
            FileInputStream inFile = new FileInputStream("data.dat")) {
                
                ObjectInputStream objIn = new ObjectInputStream(inFile);
                List<HangHoa> list = (List) objIn.readObject();

                for(int i = 0; i < list.size(); i++){
                    HangHoa hangHoa = list.get(i);
                    danhSachHangHoa.them(hangHoa);
                }
                System.out.println("Doc file thanh cong !");

                objIn.close();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
            System.out.println("File khong ton tai !");
            
        }
    }

    static void tienIch(){
        System.out.println("1> Luu danh sach hang hoa xuong file");
        System.out.println("2> Doc danh sach hang hoa tu file");
        System.out.print("Lua chon cua ban: ");
        int luaChon = consoleInputing.getNhap().nextInt();
        consoleInputing.getNhap().nextLine();
        if(luaChon == 1){
            writeToFile();
        }else if(luaChon == 2){
            readToFile();
        }else{
            System.out.println("Lua chon khong hop le");
        }
    }

    static void thongKeHangHoa(){

        System.out.println("Tong so luong cac hang hoa: " + danhSachHangHoa.demTongHH());
        System.out.println("Tong don gia tat ca hang hoa: ");

    }
    
}