package object;
public class Ex2_02_1_Janken {
    public static void main(String[] args) {

        // 事前準備
        final String HAND_G = "グー";
        final String HAND_C = "チョキ";
        final String HAND_P = "パー";
        
        String nameP1 = args[0];
        String nameP2 = args[1];

        // インスタンス生成
        Ex2_02_1_Player p1 = new Ex2_02_1_Player(nameP1);
        Ex2_02_1_Player p2 = new Ex2_02_1_Player(nameP2);
        
        // 開始合図
        System.out.println("じゃんけん・・・・・ぽん！！！！！");

        // 手を握らせる
        p1.makeHandStatus();
        p2.makeHandStatus();

        //プレイヤーの出した手を確認
        System.out.println(p1.name + "さんの手：" + p1.handStatus);
        System.out.println(p2.name + "さんの手：" + p2.handStatus);

        // 勝敗
        if(p1.handStatus.equals(p2.handStatus)) {
            //　あいこ

            // p1 win
        } else if (
            (p1.handStatus.equals(HAND_G) && p2.handStatus.equals(HAND_C))
            || (p1.handStatus.equals(HAND_C) && p2.handStatus.equals(HAND_P))
            || (p1.handStatus.equals(HAND_P) && p2.handStatus.equals(HAND_G))
        ) {
            System.out.println(p1.name + "さんの勝利");
            // p2 win
        } else if (
            (p2.handStatus.equals(HAND_G) && p1.handStatus.equals(HAND_C))
            || (p2.handStatus.equals(HAND_C) && p1.handStatus.equals(HAND_P))
            || (p2.handStatus.equals(HAND_P) && p1.handStatus.equals(HAND_G))
        ) {
            System.out.println(p2.name + "さんの勝利");
        } else {
            System.out.println("[エラー]じゃんけんの判定が不正です。");
            
        }
    }
    
}
