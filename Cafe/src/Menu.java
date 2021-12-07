import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;  //java\\util\\c\Scanner.class      //JDK

public class Menu {
  private ArrayList<String> alMenu;
  private ArrayList<Integer> alPrice;
  private Scanner s;
  public String getAlMenu(int ndx) {
		 return this.alMenu.get(ndx);
	 }
	public int getAlPrice(int ndx) {
		return this.alPrice.get(ndx);
	}
 
     public Menu(){
    	 this.alMenu=new ArrayList<String>();
    	 this.alPrice=new ArrayList<Integer>();
    	 this.s=new Scanner(System.in);
    	 File f=new File("C:\\Temp\\menu.txt");
    	 //������: ����->ȭ��->�����ͺ��̽�
    	 try {
			FileReader fr=new FileReader(f);
			BufferedReader br=new BufferedReader(fr);
			try {
				String line=br.readLine();
				while(line!=null) {
				String[] ar=line.split(",");
				this.alMenu.add(ar[0]);
				this.alPrice.add(Integer.parseInt(ar[1]));
				line=br.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
      }
   
       public void display() {
    	  //Ŀ�Ǹ�,����
    	  int i=0;
         for(i=0; i<this.alPrice.size(); i++) {
             System.out.println((i+1)+"."+this.alMenu.get(i)+":" +this.alPrice.get(i));
          }
//         this.gd(); 
      }
     private void gd() {
    	  System.out.println("�޴�����(X:����,C:�޴��߰�,U:�޴�����,D:�޴�����)");
      }
      
    private void add(String menu,int price) {
         this.alMenu.add(menu);
         this.alPrice.add(price);
         this.saveMenu();
      }
    private void update(int menu_num,String menu,int price) {
    	  this.alMenu.set(menu_num-1,menu);
    	  this.alPrice.set(menu_num-1,price);
    	  this.saveMenu();
    	  
      }
    private void remove(int menu_num) {
    	  this.alMenu.remove(menu_num-1);
    	  this.alPrice.remove(menu_num-1);
    	  this.saveMenu();
      }
    private void saveMenu() {
    	File f=new File("C:\\Temp\\menu.txt");
    	try {
			FileWriter fw=new FileWriter(f);
			PrintWriter pw=new PrintWriter(fw);
			for(int i=0;i<this.alMenu.size();i++) {
				pw.print(this.alMenu.get(i)+","+this.alPrice.get(i)+"\n");
			}
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
      
    public void Handling() {
          this.display(); 
          this.gd();
          String sch=s.nextLine();
          while(!sch.equals("X")) {
             if(sch.equals("C")) {
                System.out.println("�޴��߰�");
                System.out.println("�޴����� �Է��ϼ���");
                sch=s.nextLine();
                System.out.println("������ �Է��ϼ���");
                 int sth=Integer.parseInt(s.nextLine());
                   this.add(sch,sth);
             } else if(sch.equals("U")) {
                System.out.println("�޴�����");
                System.out.println("������ �޴���ȣ�� �Է��ϼ���");
                int sth=Integer.parseInt(s.nextLine());
                System.out.println("�� �޴����� �Է��ϼ���");
                sch=s.nextLine();
                System.out.println("�� ������ �Է��ϼ���");
                int sth1=Integer.parseInt(s.nextLine());
                this.update(sth,sch,sth1);
             } else if(sch.equals("D")) {
                 System.out.println("�޴�����");
                 System.out.println("������ �޴���ȣ�� �Է��ϼ���");
                 int sth=Integer.parseInt(s.nextLine());
                 this.remove(sth);
             }
             this.display();
             this.gd();
             sch=s.nextLine();
          }
      }
}
      
      
      
   
