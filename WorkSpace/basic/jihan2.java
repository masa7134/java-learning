package basic;
public class jihan2 {
    public static void main(String[] args) {
        


        int coinNum = args.length -1;
        int coinChk = 0;
        int coinSum = 0;
        int price = Integer.parseInt(args[coinNum]);
        int coinChange = 0;

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
        coinChange = (coinSum - price);
        System.out.println( coinChange + "円のお釣りですありがとうございました。");

    }
}
