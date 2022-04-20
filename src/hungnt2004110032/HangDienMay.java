package hungnt2004110032;

public class HangDienMay extends HangHoa {
    
    private int thoiGianBaoHanh;
    private int congSuat;
    
    public int getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }

    public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
        // code ràng buộc thời gian bảo hành phải >= 0
        while(thoiGianBaoHanh < 0){
            System.out.println("Thoi gian bao hanh phai >= 0 !!!");
            System.out.print("Moi ban nhap lai thoi gian bao hanh: ");
            thoiGianBaoHanh = getNhap().nextInt();
        }
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }

    public int getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(int congSuat) {
        // code ràng buộc công suất > 0 
        while(congSuat <= 0){
            System.out.println("Cong suat phai > 0 !!!");
            System.out.print("Moi ban nhap lai cong suat: ");
            congSuat = getNhap().nextInt();
        }
        this.congSuat = congSuat;
    }

    public HangDienMay(String maHang, String tenHang, int soLuongTonKho, double donGia, int thoiGianBaoHanh,
            int congSuat) {
        super(maHang, tenHang, soLuongTonKho, donGia);
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.congSuat = congSuat;
    }

    public HangDienMay(){}

    @Override
    String danhGiaHangHoa() {

        if(this.getSoLuongTonKho() < 3){
            return "Danh gia hang hoa ban duoc";
        }else{
            return "Xem nhu khong danh gia";
        }
        
    }

    @Override
    public String toString() {
        System.out.println("----------Hang Dien May----------");
        return super.toString() + "HangDienMay [congSuat=" + congSuat + ", thoiGianBaoHanh=" + getNgayVietNam().format(thoiGianBaoHanh) + "]"
            + "\n" + danhGiaHangHoa() ;
    }
    
    

    
}
