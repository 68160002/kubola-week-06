public class Customer {
    private int id;
    private Fullname name;
    private String tel;
    public int getId (){
        return id;
    }
    public void setId (int id){
        this.id = id;
    }
    public Fullname getName(){
        return name;
    }
    public void setName (Fullname name){
        this.name =  name;
    }
    public String getTel(){
        return tel;
    }
    public void setTel (String tel){
        this.tel = tel;
    }
    public void display() {
        System.out.print(getId() + " ");
        getName().display();
        System.out.println(" " + getTel());
    }
}
