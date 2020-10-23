
package bai2;

import java.util.*;
import java.io.*;

public class bai15 {
    public static void main(String[] args) throws IOException,NullPointerException {
        //1.
        File myfile= new File("C:\\Users\\Admin\\Desktop\\B18DCCN267_NguyenCongHuy\\src\\bai2\\SV.INP");
        Scanner s=new Scanner(myfile);
        ArrayList<SinhVienPTIT>  students =new ArrayList<SinhVienPTIT>();
        while(s.hasNextLine()){
            SinhVienPTIT student = null;
            try{
            student=new SinhVienPTIT(Integer.parseInt(s.nextLine()),
            s.nextLine(),s.nextLine(),Double.parseDouble(s.nextLine()));
            students.add(student); // neu ko co exception xay ra, ta moi add student vao arraylist 
            
            
            }
            catch(Exception e){
                
            }
            
            
        }
        s.close();
        
        //2.
        show(students);
        
        
       
        //3.
        
       // sort sinh viên theo thứ tự giảm dần điểm trung bình
        Collections.sort(students, new Comparator<SinhVienPTIT>() {
            @Override
            public int compare(SinhVienPTIT sv1, SinhVienPTIT sv2) {
                if (sv1.getDtb() < sv2.getDtb()) {
                    return 1;
                } else {
                    if (sv1.getDtb() == sv2.getDtb()) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            }
        });
        
        
       output(students);
        
       //4.
       // sap xep theo ten:
       Collections.sort(students, new Comparator<SinhVienPTIT>() {
            @Override
            public int compare(SinhVienPTIT sv1, SinhVienPTIT sv2) {
                StringTokenizer st1=new StringTokenizer(sv1.getTen());
                StringTokenizer st2=new StringTokenizer(sv2.getTen());
                String t1=null;
                String t2=null;
                while(st1.hasMoreTokens()){
                    t1=st1.nextToken();
                }
                while(st2.hasMoreTokens()){
                    t2=st2.nextToken();
                }
                return (t1.compareTo(t2));
            }
        });
       
       //tao ra 1 arraylist moi roi them tung doi tuong sinh vien theo thu tu diem tu tren xuong, dong thoi ghi ra file XEPLOAI.OUT
       ArrayList<SinhVienPTIT> students1=new ArrayList<SinhVienPTIT>();
       PrintWriter w=new PrintWriter(new File("C:\\Users\\Admin\\Desktop\\B18DCCN267_NguyenCongHuy\\src\\bai2\\XEPLOAI.OUT"));
       w.println("Gioi: ");
       for(int i=0;i<students.size();i++){
           if(students.get(i).getDtb()>=8){
               students1.add(students.get(i));
               w.println(students.get(i).getMaSV()+" "+students.get(i).getTen()
            +" "+students.get(i).getLop()+" "+students.get(i).getDtb());
           }
       }
       w.println("Kha: ");
       for(int i=0;i<students.size();i++){
           if(students.get(i).getDtb()>=7 && students.get(i).getDtb()<8 ){
               students1.add(students.get(i));
               w.println(students.get(i).getMaSV()+" "+students.get(i).getTen()
            +" "+students.get(i).getLop()+" "+students.get(i).getDtb());
           }
       }
       w.println("Tb: ");
       for(int i=0;i<students.size();i++){
           if(students.get(i).getDtb()>=5 && students.get(i).getDtb()<7 ){
               students1.add(students.get(i));
               w.println(students.get(i).getMaSV()+" "+students.get(i).getTen()
            +" "+students.get(i).getLop()+" "+students.get(i).getDtb());
           }
       }
       w.println("Yeu: ");
       for(int i=0;i<students.size();i++){
           if(students.get(i).getDtb()<5){
               students1.add(students.get(i));
               w.println(students.get(i).getMaSV()+" "+students.get(i).getTen()
            +" "+students.get(i).getLop()+" "+students.get(i).getDtb());
           }
       }
       w.close();
    }

    private static void show(ArrayList<SinhVienPTIT> students) throws NullPointerException {
        for(int i=0;i<students.size();i++){
            System.out.println(students.get(i).getMaSV()+" "+students.get(i).getTen()
            +" "+students.get(i).getLop()+" "+students.get(i).getDtb());
        }
    }
    
    
   
    private static void output(ArrayList<SinhVienPTIT> students) throws IOException{
        PrintWriter p = new PrintWriter(new File("C:\\Users\\Admin\\Desktop\\B18DCCN267_NguyenCongHuy\\src\\bai2\\SX.OUT"));
        for(int i=0;i<students.size();i++){
           p.println(students.get(i).getMaSV()+" "+students.get(i).getTen()
            +" "+students.get(i).getLop()+" "+students.get(i).getDtb());
           
        }
        p.close();
    }
    
    
}
