package basic;
public class jihan {
    public static void main(String[] args) {

        int coinNum = args.length;
        int coinChk = 0;
        int coinSum = 0;

        for(int i = 0; i < coinNum; i++){
            coinChk = Integer.parseInt(args[i]);
            if(coinChk == 10 || coinChk == 50 || coinChk == 100 || coinChk == 500){
                coinSum += coinChk;
            }else if(coinChk == 1 || coinChk == 5){
                System.out.println("警告：" + coinChk + "円玉はつかえません");
            }else{
                System.out.println("警告：" + coinChk + "は硬貨として適切ではありません");
            }

        }
        System.out.println("ただいまの投入金額は" + coinSum + "円です");



        
        // int total_amount = 0;

        // for(int i = 0; i < args.length; i++){

        //     int received_coin = Integer.parseInt(args[i]);

        //     if(received_coin == 1){
        //         System.out.println("警告：１円玉はつかえません");
        //         continue;
        //     }else if(received_coin == 5){
        //         System.out.println("警告：５円玉はつかえません");
        //         continue;
        //     }else if(received_coin == 777){
        //         System.out.println("警告：７７７は硬貨として適切ではありません");
        //         continue;
        //     }else{
        //         total_amount += received_coin;
        //     }
        // }
        // System.out.println("ただいまの投入金額は" + total_amount + "円です");

    }
}
