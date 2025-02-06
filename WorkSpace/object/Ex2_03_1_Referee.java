package object;
public class Ex2_03_1_Referee {
    
    final String HAND_G = "グー";
    final String HAND_C = "チョキ";
    final String HAND_P = "パー";

    private String name ;
    
    Ex2_03_1_Referee(String nm){
        this.name = nm;
    }

    public String getName() {
        return this.name;
    }

    // 開始合図
    void startJanken () {
        messageReferee("じゃんけん・・・・・ぽん！！！！！");

    }

    // プレイヤーの手を確認する　ここの仮引数にはmainメソッドのcheckHandメソッドの引数p1.p2がわたってくる！！
    void checkHand (Ex2_03_1_Player p) {
        if(p.getHandStatus() == HAND_G) {
            messageReferee(p.getName() + "さんの手はグーでした");
        } else if (p.getHandStatus() == HAND_C) {
            messageReferee(p.getName() + "さんの手はチョキでした");
        } else if (p.getHandStatus() == HAND_P) {
            messageReferee(p.getName() + "さんの手はパーでした");
        } else {
            messageReferee("不正です");
        }
    }

    //プレイヤーの出した手を確認
    
    void judgeJanken (Ex2_03_1_Player p1, Ex2_03_1_Player p2) {

        messageReferee("結果は・・・");

        // 勝敗
        if(p1.getHandStatus().equals(p2.getHandStatus())) {
            //　あいこ
            messageReferee("あいこ");
    
            // p1 win
        } else if (
            (p1.getHandStatus().equals(HAND_G) && p2.getHandStatus().equals(HAND_C))
            || (p1.getHandStatus().equals(HAND_C) && p2.getHandStatus().equals(HAND_P))
            || (p1.getHandStatus().equals(HAND_P) && p2.getHandStatus().equals(HAND_G))
        ) {
            messageReferee(p1.getName() + "さんの勝利");
            // p2 win
        } else if (
            (p2.getHandStatus().equals(HAND_G) && p1.getHandStatus().equals(HAND_C))
            || (p2.getHandStatus().equals(HAND_C) && p1.getHandStatus().equals(HAND_P))
            || (p2.getHandStatus().equals(HAND_P) && p1.getHandStatus().equals(HAND_G))
        ) {
            messageReferee(p2.getName() + "さんの勝利");
        } else {
            messageReferee("[エラー]じゃんけんの判定が不正です。");
        }
    }
    void messageReferee(String msg) {
        System.out.println(this.name + "「" + msg + "」");
    }

}
