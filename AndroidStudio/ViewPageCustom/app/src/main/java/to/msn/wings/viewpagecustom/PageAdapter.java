package to.msn.wings.viewpagecustom;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {
        //ページ数
    private final int PAGE_COUNT = 3;
        //ページのタイトル
    private String[] titles = new String[] {"ゾウ", "キャラクター", "アザラシ"};

    PageAdapter(FragmentManager fm){
        super(fm);
    }

        //インデックス番号に応じてページを取得
    @NonNull
    @Override
    public Fragment getItem(int index) {
         switch (index) {
             case 0:
                 return new Page1Fragment();
             case 1:
                 return new Page2Fragment();
             default:
                 return new Page3Fragment();
         }
    }
        //ページの個数を取得
    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

        //ページのタイトルを取得
    @Override
    public CharSequence getPageTitle(int index){
        return titles[index];
    }
}
