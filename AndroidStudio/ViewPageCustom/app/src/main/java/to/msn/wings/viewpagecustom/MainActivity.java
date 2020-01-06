package to.msn.wings.viewpagecustom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager pager = findViewById(R.id.pager);
        pager.setAdapter(
                new PageAdapter(getSupportFragmentManager())
        );

            //タブレイアウトにViewPagerを関連付け
        TabLayout tabLayout = findViewById(R.id.tabLayout);

        tabLayout.setupWithViewPager(pager);
        tabLayout.getTabAt(1).setIcon(R.drawable.tab1_icon);
    }
}
