package hungnt2004110032;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DanhSachHangHoa implements Serializable {
    
    private List<HangHoa> danhSach = new ArrayList<>();

    public List<HangHoa> getDanhSach() {
        return danhSach;
    }
    
    public void them(HangHoa hangHoa){

        this.danhSach.add(hangHoa);

    }

    public void inDanhSach(){
        for (HangHoa hangHoa : danhSach) {
            System.out.println(hangHoa);
            System.out.println("");
        }
        
    }

    public void xoaHangHoa(HangHoa hangHoa){

        this.danhSach.remove(hangHoa);

    }

    public int timViTriCuaHangHoa(HangHoa hangHoa){

        int viTri = -1;
        viTri = this.danhSach.indexOf(hangHoa);
        return viTri;

    }

    public void suaHangHoa(int viTri, HangHoa hangHoa){
        this.danhSach.set(viTri, hangHoa);
    }

    public HangHoa timKiemHangHoaTheoMa(String maHangHoa){
        HangHoa hangHoa = null;

        for (HangHoa hh : danhSach) {
            if(hh.getMaHang().equalsIgnoreCase(maHangHoa)){
                hangHoa = hh;
            }
        }
        
        if(hangHoa == null){
            System.out.println("Khong tim thay hang hoa !");
        }

        return hangHoa;
    }

    public HangHoa timKiemHangHoaTheoTen(String tenHangHoa){
        HangHoa hangHoa = null;

        for (HangHoa hh : danhSach) {
            if(hh.getTenHang().equalsIgnoreCase(tenHangHoa)){
                hangHoa = hh;
            }
        }

        if(hangHoa == null){
            System.out.println("Khong tim thay hang hoa !");
        }

        return hangHoa;
    }

    public int demTongHH(){
        int count = 0;
        for(int i = 0; i < danhSach.size(); i++){
            count++;
        }
        return count;
    }



}
