package com.AndikhaWisanggeniJSleepRJ;

//import java.util.Calendar;
import java.util.List;
import com.google.gson.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class JSleep
{

    public static com.AndikhaWisanggeniJSleepRJ.Room createRoom(){
        com.AndikhaWisanggeniJSleepRJ.Price price = new com.AndikhaWisanggeniJSleepRJ.Price(100000, 5);
        com.AndikhaWisanggeniJSleepRJ.Room room = new com.AndikhaWisanggeniJSleepRJ.Room(2, "hotel", 30, price, com.AndikhaWisanggeniJSleepRJ.Facility.AC, com.AndikhaWisanggeniJSleepRJ.City.DEPOK,"Jl. Margonda Raya");
        return room;
    }
//    /*class Country{
//        public String name;
//        public int population;
//        public List<String> listOfStates;
//    }*/
    public static void main (String[] args){
        SpringApplication.run(JSleep.class, args);
        com.AndikhaWisanggeniJSleepRJ.Renter testRegex = new com.AndikhaWisanggeniJSleepRJ.Renter("Netlab_", "081234567890", "Jl Margonda Raya");
        com.AndikhaWisanggeniJSleepRJ.Renter tesRegexFail = new com.AndikhaWisanggeniJSleepRJ.Renter("netlab", "081", "Jalan");
        System.out.println(testRegex.validate());
        System.out.println(tesRegexFail.validate());
        try{
            String filepath = "src\\json\\randomRoomList.json";
            com.AndikhaWisanggeniJSleepRJ.JsonTable<com.AndikhaWisanggeniJSleepRJ.Account> tableAccount = new com.AndikhaWisanggeniJSleepRJ.JsonTable<>(com.AndikhaWisanggeniJSleepRJ.Account.class, filepath);
            tableAccount.add(new com.AndikhaWisanggeniJSleepRJ.Account("name", "email", "password"));
            tableAccount.writeJson();
        }
        catch(Throwable t){
            t.printStackTrace();
        }
        for(int i = 0; i < 10; i++){
            com.AndikhaWisanggeniJSleepRJ.ThreadingObject thread = new com.AndikhaWisanggeniJSleepRJ.ThreadingObject("Thread " + i);
        }
//        /*
//        String filepath = "C:\\Users\\Andikha Wisanggeni\\OneDrive\\Documents\\Kuliah\\Semester 3\\OOP\\Code Praktikum\\city.json";
//        Gson gson = new Gson();
//        try{
//            BufferedReader br = new BufferedReader(new FileReader(filepath));
//            Country input = gson.fromJson(br, Country.class);
//            System.out.println("name: " + input.name);
//            System.out.println("population: " + input.population);
//            System.out.println("states: ");
//            input.listOfStates.forEach(state -> System.out.println(state));
//
//        }
//        catch(IOException e){
//            e.printStackTrace();
//        }*/
//        /*
//        ArrayList<Room> RoomSerialized = new ArrayList<>();
//        for(int i = 0; i < 5; i++){
//            RoomSerialized.add(i, JSleep.createRoom());
//            System.out.println(RoomSerialized.get(i).toString());
//        }*/
//        /*
//        Room RoomA = JSleep.createRoom();
//        Room RoomB = JSleep.createRoom();
//        System.out.println("Membuat booking dari tanggal 15 hingga 18");
//        Date start = Date.valueOf("2022-8-15");
//        Date end = Date.valueOf("2022-8-20");
//        System.out.println(Payment.makeBooking(start, end,RoomA));
//        System.out.println("Membuat booking dari tanggal 15 hingga 18");
//        Date start2 = Date.valueOf("2022-8-18");
//        Date end2 = Date.valueOf("2022-8-20");
//        System.out.println(Payment.makeBooking(start2, end2,RoomA));
//        System.out.println("Membuat booking dari tanggal 15 hingga 18 untuk kamar berbeda");
//        Date start3 = Date.valueOf("2022-8-18");
//        Date end3 = Date.valueOf("2022-8-20");
//        System.out.println(Payment.makeBooking(start3, end3,RoomB));*/
//        /*
//        Room hasil = createRoom();
//        System.out.println(hasil.name);
//        System.out.println(hasil.size);
//        System.out.println(hasil.price.price);
//        System.out.println(hasil.facility);*/
//        /*Complaint testComplain = new Complaint(1, "23 August 2022", "Bad Quality");
//        Price testPrice = new Price(100000, 200000);
//        Room testRoom = new Room(1, "Presidential Suite", 5, testPrice, Facility.FitnessCenter, City.DEPOK, "JL. Margonda Raya");
//        Account testAccount = new Account(1, "Bob", "bob@gmail.com", "bob");
//        Rating testRating = new Rating();
//        System.out.println(testComplain.toString());
//        System.out.println(testRoom.toString());
//        System.out.println(testAccount.toString());
//        System.out.println(testPrice.toString());
//        System.out.println(testRating.toString());*/
//        /*
//        Payment testPayment = new Payment(2, 2, 2,2);
//        System.out.println(testPayment.getTime());
//        System.out.println(testPayment.getDuration());
//        Price[] unfilteredArray = new Price[5];
//        for(int i=0;i < unfilteredArray.length;i++){
//            int j = 5000;
//            unfilteredArray[i] = new Price((i+1)*j);
//        }
//        System.out.println("Price List");
//        for(int i=0;i < unfilteredArray.length;i++){
//            System.out.println(unfilteredArray[i].price);
//        }
//        System.out.println("Below 12000.0");
//        System.out.println(Validate.filter(unfilteredArray, 12000,true));
//        System.out.println("Above 10000.0");
//        System.out.println(Validate.filter(unfilteredArray, 10000,false));*/
        
    }

    public static List<com.AndikhaWisanggeniJSleepRJ.Room> filterByCity(List<com.AndikhaWisanggeniJSleepRJ.Room> room, String city, int start, int end){
        return com.AndikhaWisanggeniJSleepRJ.Algorithm.<com.AndikhaWisanggeniJSleepRJ.Room>paginate(room, start, end, i  -> i.city.toString().toLowerCase().contains(city.toLowerCase()));
    }
    public static List<com.AndikhaWisanggeniJSleepRJ.Room> filterByPrice(List<com.AndikhaWisanggeniJSleepRJ.Room> room, double price1, double price2){
        return com.AndikhaWisanggeniJSleepRJ.Algorithm.<com.AndikhaWisanggeniJSleepRJ.Room>collect(room, i -> i.price.price >= price1 && i.price.price <= price2);
    }


    public static List<com.AndikhaWisanggeniJSleepRJ.Room> filterByAccountId(List<com.AndikhaWisanggeniJSleepRJ.Room> room, int accountId, int id1, int id2){
        return com.AndikhaWisanggeniJSleepRJ.Algorithm.<com.AndikhaWisanggeniJSleepRJ.Room>paginate(room, id1, id2, i  -> i.accountId == accountId);
    }


//    /*
//    public int getHotteld(){
//        return 0;
//    }
//
//    public String getHotelName(){
//        return "hotel";
//    }
//
//    public boolean isDiscount(){
//        return true;
//    }
//
//    public float getDiscountPercentage(int beforeDiscount, int afterDiscount){
//        int diskon;
//        float discountPercentage;
//        if (beforeDiscount < afterDiscount){
//            diskon = 0;
//        }
//        else{
//            diskon = beforeDiscount - afterDiscount;
//        }
//        discountPercentage = (diskon / beforeDiscount) * 10;
//        return discountPercentage;
//    }
//
//    public int getDiscountedPrice(int price, float discountPercentage){
//        int hasil;
//        int discountPrice;
//        if (discountPercentage >= 100){
//            return 0;
//        }
//        else{
//            hasil = price * ((int)discountPercentage / 100);
//        }
//        discountPrice = price - hasil;
//        return discountPrice;
//    }
//
//    public int getOriginalPrice(int discountedPrice, float discountPercentage){
//        int Hasil;
//        Hasil = (100 / (int)discountPercentage) * discountedPrice;
//        return Hasil;
//    }
//
//    public float getAdminFeePercentage(){
//        float admin;
//        admin = 5 / 100;
//        return admin;
//    }
//
//    public int getAdminFee(int price){
//        int adminfee;
//        adminfee = (5 / 100) * price;
//        return adminfee;
//    }
//
//    public int getTotalPrice(int price, int numberOfNight){
//        int Final;
//        Final = (price * numberOfNight) + getAdminFee(price);
//        return Final;
//    }
//
//    public Room createRoom(){
//        Price price = new Price (100000, 5);
//        Room room = new Room ("hotel", 30, price, Facility.AC);
//        return room;
//    }*/
}