package global;

import shape.GArc;
import shape.GEllipse;
import shape.GGroup;
import shape.GLine;
import shape.GPen;
import shape.GPolygon;
import shape.GRectangle;
import shape.GRoundRectangle;
import shape.GShape;
import shape.GText;

public class GConstants {
	public static String imageSufix = ".png";
	public static String library = "img/";
	public static String selectedImage = "SLT";
	public static String defaulttheme = "com.jtattoo.plaf.hifi.HiFiLookAndFeel";
	
	public enum EShapeType {TP, NP, GR}
	public enum EPointerState {	NW, WW, SW, NN, SS, NE, EE, SE, RR, MM}

	public enum EMainFrame {
		w(1000), h(700);
		private int v;
		
		private EMainFrame(int v) {this.v = v;}
		public int getText() {	return this.v;}
	}

	public enum EMenu {
		fileMenu("File"), editMenu("Edit"), colorMenu("color"), themeMenu("theme");
		private String text;
		
		private EMenu(String text) {this.text = text;}
		public String getText() {return this.text;}
	}

	public enum EFileMenu {
		newItem("새로 만들기", "nnew"),
		openItem("불러오기", "open"),
		saveItem("저장하기", "save"),
		saveAsItem("다른 이름으로 저장하기", "saveAs"),
		print("프린트하기", "print"),
		closeItem("닫기", "close");
		private String text;
		private String method;
		
		private EFileMenu(String text, String method) {
			this.text = text;
			this.method = method;
		}
		public String getText() {return this.text;}
		public String getMethod() {return this.method;}
	}

	public enum EEditMenu {
		undo("되돌리기", "undo"), redo("다시실행", "redo"), cut("잘라내기", "cut"), copy("복사하기", "copy"), paste("붙여넣기", "paste"),
		group("그룹", "group"), ungroup("언그룹", "ungroup");
		private String text;
		private String method;
		
		private EEditMenu(String text, String method) {
			this.text = text;
			this.method = method;
		}
		public String getText() {return this.text;}
		public String getMethod() {return this.method;}
	}

	public static enum EColorMenu {
		lineColor("선색", "changeLineColor"),
		fillColor("면색", "changeFillColor"),
		clearLineColor("선색 초기화", "clearLineColor"),
		clearFillColor("면색 초기화", "clearFillColor");
		private String text;
		private String method;
		
		private EColorMenu(String text, String method) {
			this.text = text;
			this.method = method;
		}
		public String getText() {return this.text;}
		public String getMethod() {return this.method;}
	}
	public enum EThemeMenu{
		theme3("AERO","com.jtattoo.plaf.aero.AeroLookAndFeel"),
		theme4("ALUMINIUM","com.jtattoo.plaf.aluminium.AluminiumLookAndFeel"),
		theme5("BERNSTEIN","com.jtattoo.plaf.bernstein.BernsteinLookAndFeel"),
		theme6("FAST","com.jtattoo.plaf.fast.FastLookAndFeel"),
		theme7("GRAPHITE","com.jtattoo.plaf.graphite.GraphiteLookAndFeel"),
		theme8("HIFI","com.jtattoo.plaf.hifi.HiFiLookAndFeel"),
		theme9("LUNA","com.jtattoo.plaf.luna.LunaLookAndFeel"),
		theme10("MCWIN","com.jtattoo.plaf.mcwin.McWinLookAndFeel"),
		theme11("MINT","com.jtattoo.plaf.mint.MintLookAndFeel"), 
		theme12("NOIRE","com.jtattoo.plaf.noire.NoireLookAndFeel"),
		theme13("SMART","com.jtattoo.plaf.smart.SmartLookAndFeel"),
		theme14("TEXTURE","com.jtattoo.plaf.texture.TextureLookAndFeel");
		private String text;
		private String themeId;
		
		private EThemeMenu(String text,String themeId) {
			this.text = text;
			this.themeId = themeId;
			}
		public String getText() {return this.text;}
		public String getTheme() {return this.themeId;}
	}
	
	public enum EThemechangeMenu {
		settheme("테마설정",""), cleartheme("테마 초기화","com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		private String text;
		private String themeId;
		
		private EThemechangeMenu(String text,String themeId) {
			this.text = text;
			this.themeId = themeId;
		}
		public String getText() {return this.text;}
		public String getTheme() {return this.themeId;}

	}

	public enum EToolBar {
		select("select", new GGroup()),
		rectangle("rectangle", new GRectangle()),
		roundrectangle("roundrect", new GRoundRectangle()),
		ellipse("ellipse", new GEllipse()),
		arc("arc",new GArc()),
		line("line", new GLine()),
		polygon("polygon", new GPolygon()),
		pen("pen",new GPen()),
		texting("texting", new GText());
		private String text;
		private GShape shape;
		
		private EToolBar(String text, GShape shape) {
			this.text = text;
			this.shape = shape;
		}
		public String getText() {return this.text;}
		public GShape getShape() {	return this.shape;}
	}

	
}