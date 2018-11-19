package messi.lhj.com.modultest;

import android.os.Bundle;

import com.julyzeng.imagepicker.ui.ImageGridActivity;
import com.project.common.core.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        test();
    }

    private void test() {
        ImageGridActivity imageGridActivity = new ImageGridActivity();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

}
