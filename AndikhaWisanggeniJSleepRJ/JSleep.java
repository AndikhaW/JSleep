package AndikhaWisanggeniJSleepRJ;

public class JSleep
{
    
    public static void main (String[] args){
        /*
        Room hasil = createRoom();
        System.out.println(hasil.name);
        System.out.println(hasil.size);
        System.out.println(hasil.price.price);
        System.out.println(hasil.facility);*/
        Complaint testComplain = new Complaint(1, "23 August 2022", "Bad Quality");
        Price testPrice = new Price(100000, 200000);
        Room testRoom = new Room(1, "Presidential Suite", 5, testPrice, Facility.FitnessCenter, City.DEPOK, "JL. Margonda Raya");
        Account testAccount = new Account(1, "Bob", "bob@gmail.com", "bob");
        Rating testRating = new Rating();
        System.out.println(testComplain.toString());
        System.out.println(testRoom.toString());
        System.out.println(testAccount.toString());
        System.out.println(testPrice.toString());
        System.out.println(testRating.toString());
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
    
    public Room createRoom(){
        Price price = new Price (100000, 5);
        Room room = new Room ("hotel", 30, price, Facility.AC);
        return room;
    }*/
}
