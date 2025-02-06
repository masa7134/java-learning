package basic;
public class CalcCakeSum {

    public static void main(String[] args) {

        String cakeName = "";
        int cakeNum = 0;
        int totalPrice = 0;
        int taxIncludePrice = 0;
        
        for(int i = 0; i < args.length; i++){
            
            if(i % 2 == 0){
                cakeName =  args[i];
                cakeNum = Integer.parseInt(args[i + 1]) ;
                
                switch(cakeName){
                    case "ショートケーキ":
                        totalPrice += 320 * cakeNum;
                        break;
                    case "モンブラン":
                        totalPrice += 350 * cakeNum;
                        break;
                    case "チョコレートケーキ":
                        totalPrice += 370 * cakeNum;
                        break;
                    case "いちごのタルト":
                        totalPrice += 400 * cakeNum;
                        break;
                    case "チーズケーキ":
                        totalPrice += 300 * cakeNum;
                        break;
                }
            }
        }
            if(totalPrice >= 1000){
                int discountPrice = (int)(totalPrice * 0.8);
                taxIncludePrice = (int)(discountPrice * 1.08);
            }else{
                taxIncludePrice =  (int)(totalPrice * 1.08);
            }
        System.out.println("合計金額は" + taxIncludePrice + "円です。");
    }
}