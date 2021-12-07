import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    String name;
    int qty;
    int sum;
    int mobile;
   private ArrayList<String> alMenu;
   private ArrayList<Integer> alQty;
   private ArrayList<Integer> alSum;
   private ArrayList<String> alMobile;
   private Scanner s;


   public Order(){	
     this.alMenu=new ArrayList<String>();
     this.alQty=new ArrayList<Integer>();
     this.alSum=new ArrayList<Integer>();
     this.alMobile=new ArrayList<String>();
     this.s=new Scanner(System.in);

    }
    
    private void add(String name,int qty,int sum) {
        this.alMenu.add(name);
        this.alQty.add(qty);
        this.alSum.add(sum);
    }
    private void add1(String mobile) {
    	   this.alMobile.add(mobile);
    }
	private void remvoe(int name_num) {
		this.alMobile.remove(name_num-1);
		this.alMenu.remove(name_num-1);
		this.alQty.remove(name_num-1);
		this.alSum.remove(name_num-1);
		
	}
	private void update(int name_num,String mobile,String name,int qty,int price) {
		  this.alMenu.set(name_num-1,name);
    	  this.alQty.set(name_num-1,qty);
    	  this.alMobile.set(name_num-1,mobile);
    	  this.alSum.set(name_num-1,qty*price);
	}
    
	public void Handling(Menu menu) {
	      Scanner s = new Scanner(System.in);
	        int menu_num=this.getInput(menu);
	          while(menu_num!=0) {
	             System.out.println("�޴��� ������ �Է��Ͻÿ�");
	             int qty=Integer.parseInt(s.nextLine()); //qty ���ڷ� �Է¹���
	             menu_num--; //�޴���ȣ -> �ε��� ��ȣ ��ȯ
	             this.add(menu.getAlMenu(menu_num), qty,menu.getAlPrice(menu_num)*qty);
	             this.showOrder();
	             
	             menu_num=this.getInput(menu);
	          }
	          
	         int start_ndx=this.addMobile();
	          int total=0;
	          for(int i=start_ndx;i<this.alMenu.size();i++) {
	             System.out.println(this.alMobile.get(i)+","+this.alMenu.get(i)+",x"+
	                            this.alQty.get(i)+","+this.alSum.get(i));
	             total+=this.alSum.get(i);
	          }
	             System.out.println("�� �ֹ� �ݾ�:"+total);
	             System.out.println("----------------------------");
	          
	   }
	  private void showOrder() {  //����޴�/�̸�/����/�Ѿ� ǥ��
	      int n=this.alMenu.size()-1; //���� ��Ų�� ����ߵǹǷ�
	      System.out.println(this.alMenu.get(n)+"x"+this.alQty.get(n)+","+
	                          this.alSum.get(n)+"��");
	   }
	  private int getInput(Menu m) {
	      m.display(); //ó���� �޴� ���
	      System.out.println("�ֹ��� �޴���ȣ�� �Է��Ͻÿ� (0:�ֹ�����)"); 
	      int n=Integer.parseInt(this.s.nextLine());
	      return n;
	   }
	  private int addMobile() {
	  
	      System.out.println("����� ��ȣ�� �Է��Ͻÿ�.(������ -)");
	      String mobile=s.nextLine();
	      if(mobile.equals("")) mobile="-";
	      int start_ndx=this.alMobile.size();
	      for(int i=this.alMobile.size(); i<this.alMenu.size();i++) {
	       this.alMobile.add(mobile);
	      }
	      return start_ndx;
	   }
	   public void display() {
		   for(int i=0;i<this.alMenu.size();i++) {
			   System.out.println(this.alMobile.get(i)+","+this.alMenu.get(i)+","+
		   this.alQty.get(i)+","+this.alSum.get(i));
		   }
	   }

     
     
     
     
     
     
     
     
    	}
