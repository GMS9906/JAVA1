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
	             System.out.println("메뉴의 수량을 입력하시오");
	             int qty=Integer.parseInt(s.nextLine()); //qty 숫자로 입력받음
	             menu_num--; //메뉴번호 -> 인덱스 변호 변환
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
	             System.out.println("총 주문 금액:"+total);
	             System.out.println("----------------------------");
	          
	   }
	  private void showOrder() {  //현재메뉴/이름/수량/총액 표시
	      int n=this.alMenu.size()-1; //전에 시킨걸 띄워야되므로
	      System.out.println(this.alMenu.get(n)+"x"+this.alQty.get(n)+","+
	                          this.alSum.get(n)+"원");
	   }
	  private int getInput(Menu m) {
	      m.display(); //처음에 메뉴 띄움
	      System.out.println("주문할 메뉴번호를 입력하시오 (0:주문종료)"); 
	      int n=Integer.parseInt(this.s.nextLine());
	      return n;
	   }
	  private int addMobile() {
	  
	      System.out.println("모바일 번호를 입력하시오.(없으면 -)");
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
