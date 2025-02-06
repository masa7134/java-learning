package object;
public class Ex2_03_1_Janken {
    public static void main(String[] args) {

        // 事前準備
        final String HAND_G = "グー";
        final String HAND_C = "チョキ";
        final String HAND_P = "パー";
        
        String nameP1 = args[0];
        String nameP2 = args[1];
        String nameReferee = args[2];

        // インスタンス生成
        Ex2_03_1_Player p1 = new Ex2_03_1_Player(nameP1);
        Ex2_03_1_Player p2 = new Ex2_03_1_Player(nameP2);
        Ex2_03_1_Referee ref = new Ex2_03_1_Referee(nameReferee);
        
        // 開始合図
        ref.startJanken();

        // 手を握らせる
        p1.makeHandStatus();
        p2.makeHandStatus();

        // それぞれの出した手を審判が宣言する
        ref.checkHand(p1);
        ref.checkHand(p2);

        // 審判による勝敗判定
        ref.judgeJanken(p1, p2);
    }
    
}
