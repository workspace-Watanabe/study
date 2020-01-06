package decorator;

public abstract class Border extends Display{
	protected Display display;

		//インスタンス生成時に中身を引数で指定
	protected Border(Display display) {
		this.display = display;
	}
}
