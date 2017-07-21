# Navigationbar_viewpage_fragment
底部导航栏+viewpage+fragment快速实现

模仿微信主界面
 
 
添加：

     allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
    --------
	dependencies {
	        compile 'com.github.xxfen:Navigationbar_viewpage_fragment:v.1'
	}
  
主xml文件中使用：

     <xxf.com.navigationbar_viewpageframent.Frage_vpage_bottomnavigationbar_view
        android:id="@+id/nvf"
         android:layout_width="match_parent"
          android:layout_height="match_parent"></xxf.com.navigationbar_viewpageframent.Frage_vpage_bottomnavigationbar_view>

MainActivity中使用：

      public class MainActivity extends AppCompatActivity {
    private frament_activity_home f_home;
    private frament_activity_my f_my;
    private frament_activity_center f_center;
    private List<Fragment> fgtList;
    private List<BottomNavigationItem> bniList;
    private Frage_vpage_bottomnavigationbar_view fvb;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fvb = (Frage_vpage_bottomnavigationbar_view) findViewById(R.id.nvf);
        indate();
        fvb.setFrage_vpage_bottomnavigationbar_view(getSupportFragmentManager(), fgtList, 1, bniList,R.color.colorAccent);
    }
    private void indate() {
        fgtList = new ArrayList<>();
        fgtList.add(new frament_activity_home());
        fgtList.add(new frament_activity_center());
        fgtList.add(new frament_activity_my());
        bniList = new ArrayList<>();
        bniList.add(new BottomNavigationItem(R.drawable.ic_android_black_24dp, "消息"));
        bniList.add(new BottomNavigationItem(R.drawable.ic_android_black_24dp, "主页"));
        bniList.add(new BottomNavigationItem(R.drawable.ic_android_black_24dp, "我的"));
    }

}    	  
