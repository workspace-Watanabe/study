package framework;

public class Director {
	
	private Builder builder;
		
		/**
		 * Builderインターフェースを実装しているクラスに渡される
		 * 
		 * @param builder
		 */
	public Director(Builder builder) {
		this.builder = builder;
	}
	
	public void construct() {
			//タイトル
		builder.makeTitle("Greeting");
			//文字列
		builder.makeString("朝から昼にかけて");
			//箇条書き
		builder.makeItems(new String[] {
				"おはようございます。",
				"こんにちは、",
		});
		
		builder.makeString("夜に");
		builder.makeItems(new String[] {
				"こんばんは。",
				"おやすみなさい、",
				"さようなら"
		});
		builder.close();
	}
}
