package basic;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class SalaryCalculator {

    public static void main(String[] args) {

		// コンマ
		final String COMMA = ","; 
        //ファイルから読み込んだデータの格納用
        List<String> workingResults = new ArrayList<String>();

		//  WorkingResult.csvを読み込む
		try {
			// WorkingResult.csvの読み込み準備
			File file = new File("/Users/masa/WorkSpace/WorkingResult.csv");
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			// WorkingResult.csvを1行ずつ読み込んでArrayListに格納する
			String recode = br.readLine();
			while (recode != null) {
				workingResults.add(recode);
				recode = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			System.out.println(e);
		}

        // 今月の給与
        int partTimeFreeByMonth = 0;
        
		// ArrayListから1行ずつ取り出して日付/出勤時間/退勤時間に振り分け
		for (int i = 0; i < workingResults.size() ; i++) {
			
			String workingRecodeSt    = workingResults.get(i);      // 1行ずつ文字列を取り出す
			String[] workingRecodeAr = workingRecodeSt.split(COMMA); // splitメソッドを用いてカンマ区切りで文字列を分解＆配列にそれぞれ格納
            partTimeFreeByMonth += calcPartTimeFreeByTheDay(workingRecodeAr[1], workingRecodeAr[2]);

		}
        System.out.println("今月の給与は" + partTimeFreeByMonth  + "円です");
    }



    public static int calcPartTimeFreeByTheDay ( String st, String ed) {

            // 定数の定義（すべて秒換算）
            final int HOURLY_SALARY = 900;
            final int MINUTE_SALARY = HOURLY_SALARY / 60;
            final int CONV_HOUR_TO_MILLISEC = 1000 * 60 * 60; // 1時間のミリ秒換算
            final int CONV_MINUTE_TO_MILLISEC  = 1000 * 60;      // 1分のミリ秒換算
            final int  CONV_HOUR_TO_MINUTE       = 60;             // 1時間の分換算
            final long WORK_TIME_TYPE_1_END = 6 * CONV_HOUR_TO_MILLISEC; // 6時間勤務
            final long WORK_TIME_TYPE_2_START = 6 * CONV_HOUR_TO_MILLISEC; // 
            final long WORK_TIME_TYPE_2_END = 8 * CONV_HOUR_TO_MILLISEC;
            final long WORK_TIME_TYPE_3_START = 8 * CONV_HOUR_TO_MILLISEC;
            final long REST_TIME_TYPE_1 = 45 * CONV_MINUTE_TO_MILLISEC;
            final long REST_TIME_TYPE_2 = 60 * CONV_MINUTE_TO_MILLISEC;
            final double OVERTIME_SALARY_RATE = 1.25;
            final int ACTUAL_WORK_TIME_OVERTIME_OCCUR_MIN = 8 * CONV_HOUR_TO_MINUTE; // なんで分に変換？　あとで再確認


                // 変数の定義（
            Time startTime  = Time.valueOf( st ); // java.sql.Time クラスの valueOf メソッドを使用して、String を Time 型に変換し
            Time finishTime = Time.valueOf( ed );
            // getTimeメソッドを使って労働時間をミリ秒（0.001秒単位）で取得する(戻り値はlong型であることに注意)
            long workTime = finishTime.getTime() - startTime.getTime(); // 勤務時間,ミリ秒
            int actualWorkTimeMin = 0; // 実質労働時間
            int partTimeFree = 0; // 給料


        //　実労働時間の計算
        // 6時間未満、休憩時間なし
        if (workTime <= WORK_TIME_TYPE_1_END){
        
            actualWorkTimeMin =  (int)( workTime / CONV_MINUTE_TO_MILLISEC );
        
        // ６〜８時間、45分休憩
        } else if (workTime >  WORK_TIME_TYPE_2_START && workTime <= WORK_TIME_TYPE_2_END){
        
            actualWorkTimeMin = (int)((workTime - REST_TIME_TYPE_1) / CONV_MINUTE_TO_MILLISEC);
        
        // ８時間より多い、１時間休憩
        } else {
        
            actualWorkTimeMin = (int)((workTime - REST_TIME_TYPE_2) / CONV_MINUTE_TO_MILLISEC);
        
        }
        
        // 残業代の切り分け
        if (actualWorkTimeMin > ACTUAL_WORK_TIME_OVERTIME_OCCUR_MIN) {
        
            partTimeFree = ACTUAL_WORK_TIME_OVERTIME_OCCUR_MIN * MINUTE_SALARY
            + (actualWorkTimeMin - ACTUAL_WORK_TIME_OVERTIME_OCCUR_MIN) * (int)(MINUTE_SALARY * OVERTIME_SALARY_RATE);
        
        } else {
            
            partTimeFree = actualWorkTimeMin * MINUTE_SALARY;
        
        }

        return partTimeFree;
    }

}
