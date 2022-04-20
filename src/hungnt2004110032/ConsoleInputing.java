package hungnt2004110032;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ConsoleInputing {
    
    private Scanner nhap = new Scanner(System.in);
    private SimpleDateFormat ngayVietNam = new SimpleDateFormat("dd/MM/yyyy");

    public Scanner getNhap() {
        return nhap;
    }

    public HangHoa nhapHangHoa(){
        HangHoa hangHoa = null;
        hangHoa = new HangThucPham();
        System.out.println("----------------------------------");
        System.out.println("Ban muon nhap hang hoa nao ?");
        System.out.println("1> Hang Thuc Pham");
        System.out.println("2> Hang Dien May");
        System.out.println("3> Hang Sanh Su");
        System.out.print("Lua chon cua ban: ");
        int luaChon = nhap.nextInt();
        nhap.nextLine();

        System.out.print("Nhap ma hang: ");
        hangHoa.setMaHang(nhap.nextLine()); 

        System.out.print("Nhap ten hang: ");
        hangHoa.setTenHang(nhap.nextLine());
        System.out.print("Nhap so luong hang ton kho: ");
        hangHoa.setSoLuongTonKho(nhap.nextInt());
        System.out.print("Nhap don gia: ");
        hangHoa.setDonGia(nhap.nextDouble());
        nhap.nextLine();

        switch(luaChon){
            case 1:
                System.out.print("Nhap ngay san xuat: ");
                String ngaySanXuat = nhap.nextLine(); 
                System.out.print("Nhap ngay het han: ");
                String ngayHetHan = nhap.nextLine();

                try {
                    while(ngayVietNam.parse(ngayHetHan).before(ngayVietNam.parse(ngaySanXuat))){
                        System.out.println("Ngay het han phai sau ngay san xuat !");
                        System.out.println("Moi ban nhap lai ngay het han ");
                        ngayHetHan = nhap.nextLine();
                    }
                } catch (ParseException e1) {
                    
                    e1.printStackTrace();
                    System.out.println("Nhap sai dinh dang ngay nen bi loi !");
                }
                System.out.print("Nhap nha cung cap: ");
                String nhaCungCap = nhap.nextLine();

                try {
                    hangHoa = new HangThucPham(hangHoa.getMaHang(), hangHoa.getTenHang(), hangHoa.getSoLuongTonKho(), hangHoa.getDonGia(), 
                            ngayVietNam.parse(ngaySanXuat), ngayVietNam.parse(ngayHetHan), nhaCungCap);
                } catch (ParseException e) {
                    e.printStackTrace();
                    System.out.println("Ban nhap sai dinh dang ngay nen bi loi");
                }
                break;

            case 2:
                HangDienMay hangDienMay = new HangDienMay();
                System.out.print("Nhap thoi gian bao hanh (bao nhieu thang): ");
                hangDienMay.setThoiGianBaoHanh(nhap.nextInt());
                System.out.print("Nhap cong suat: ");
                hangDienMay.setCongSuat(nhap.nextInt());
                nhap.nextLine();

                hangHoa = new HangDienMay(hangHoa.getMaHang(), hangHoa.getTenHang(), hangHoa.getSoLuongTonKho(), hangHoa.getDonGia(),
                        hangDienMay.getThoiGianBaoHanh(), hangDienMay.getCongSuat());
                break;
                
            case 3:
                HangSanhSu hangSanhSu = new HangSanhSu();
                System.out.print("Nhap nha san xuat: ");
                hangSanhSu.setNhaSanXuat(nhap.nextLine());
                System.out.print("Nhap ngay nhap kho: ");
                try {
                    hangSanhSu.setNgayNhapKho(ngayVietNam.parse(nhap.nextLine()));
                } catch (ParseException e) {
                    e.printStackTrace();
                    System.out.println("Nhap sai dinh dang ngay nen loi");
                }

                hangHoa = new HangSanhSu(hangHoa.getMaHang(), hangHoa.getTenHang(), hangHoa.getSoLuongTonKho(), hangHoa.getDonGia(),
                        hangSanhSu.getNhaSanXuat(), hangSanhSu.getNgayNhapKho());
                break;

            default: System.out.println("Lua chon khong hop le");
        }
        
        return hangHoa;
    }

}
