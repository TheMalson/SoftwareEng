package excercise3;

public abstract class Car implements ICar{

    protected String brand;
    private String color;
    private int hash;

    public Car (){

    }

    public Car (String brand){
        this.brand = brand;
        this.hash = hashCode();
    }

    public String getBrand(){
        return brand;
    }

    @Override
    public boolean equals(Object obj) {


        //null check
        if (obj == null) {
            return false;
        }

        //indentity check
        if (this == obj) {
            return true;
        }

        //type check
        if (!(obj instanceof Car)) {
            return false;
        }

        //type specific check
        if(this.brand==((Car) obj).brand){
            return true;
        }

        return false;

    }

    public boolean isEqualModle(Object obj){

        if(obj.getClass()==this.getClass()){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode(){
        int hash = 1;



        return hash
    }
}
