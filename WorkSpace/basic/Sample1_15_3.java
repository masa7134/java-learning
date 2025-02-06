package basic;
import java.util.List;
import java.util.ArrayList;

class Sample1_15_3{
	public static void main (String[] args) {
		
		//APIの活用（ArrayList）
		
		List<String> dogsNameList = new ArrayList<String>();// String型の配列っぽいものを作成
		
		dogsNameList.add("タロウ");   //インデックス0で要素が生成される
		dogsNameList.add("グレース"); //インデックス1で要素が生成される
		dogsNameList.add("モコ");     //インデックス2で要素が生成される
		dogsNameList.add("チョコ");   //インデックス3で要素が生成される
		
		System.out.println("▼「dogsNameList.remove(1)」実行前");

		for( int i = 0 ; i < dogsNameList.size() ; i++ ){ // ~.size()は配列のときの~.lengthと同じ
			System.out.println( dogsNameList.get(i) );// ~.get()は配列のときの~.[i]と同じ
		}
		
		dogsNameList.remove(1);// 要素を削除、削除後のインデックスは前に詰めて変更される
		
		System.out.println("▼「dogsNameList.remove(1)」実行後");
		for( int i = 0 ; i < dogsNameList.size() ; i++ ){
			System.out.println( dogsNameList.get(i) );
		}
		
	}
}