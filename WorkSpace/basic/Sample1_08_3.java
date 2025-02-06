package basic;
class Sample1_08_3 {
	public static void main (String[] args) {

		// System.out.println は1つの引数しか受け取れない
		// カンマで区切ると２つの引数をわたすのでエラーになる。
		
		System.out.println("性：" + args[0] +  " / 名：" + args[1] );
		
	}
}
