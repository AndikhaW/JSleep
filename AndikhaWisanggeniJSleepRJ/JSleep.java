package AndikhaWisanggeniJSleepRJ;

public class JSleep
{
    
    public void main (String[] args){
        Room hasil = createRoom();
        System.out.println(hasil.name);
        System.out.println(hasil.size);
        System.out.println(hasil.price.price);
        System.out.println(hasil.facility);
    }
    
    
    /*
    public int getHotteld(){
        return 0;
    }
    
    public String getHotelName(){
        return "hotel";
    }
    
    public boolean isDiscount(){
        return true;
    }
    
    public float getDiscountPercentage(int beforeDiscount, int afterDiscount){
        int diskon;
        float discountPercentage;
        if (beforeDiscount < afterDiscount){
            diskon = 0;
        }
        else{
            diskon = beforeDiscount - afterDiscount;
        }
        discountPercentage = (diskon / beforeDiscount) * 10;
        return discountPercentage;
    }
    
    public int getDiscountedPrice(int price, float discountPercentage){
        int hasil;
        int discountPrice;
        if (discountPercentage >= 100){
            return 0;
        }
        else{
            hasil = price * ((int)discountPercentage / 100);
        }
        discountPrice = price - hasil;
        return discountPrice;
    }
    
    public int getOriginalPrice(int discountedPrice, float discountPercentage){
        int Hasil;
        Hasil = (100 / (int)discountPercentage) * discountedPrice;
        return Hasil;
    }
    
    public float getAdminFeePercentage(){
        float admin;
        admin = 5 / 100;
        return admin;
    }
    
    public int getAdminFee(int price){
        int adminfee;
        adminfee = (5 / 100) * price;
        return adminfee;
    }
    
    public int getTotalPrice(int price, int numberOfNight){
        int Final;
        Final = (price * numberOfNight) + getAdminFee(price);
        return Final;
    }
    */
    public Room createRoom(){
        Price price = new Price (100000, 5);
        Room room = new Room ("hotel", 30, price, Facility.AC);
        return room;
    }
}
