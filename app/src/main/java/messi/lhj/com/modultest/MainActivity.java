package messi.lhj.com.modultest;

import android.os.Bundle;

import com.clj.fastble.BleManager;
import com.julyzeng.baserecycleradapterlib.BaseRecyclerAdapter;
import com.julyzeng.baserecycleradapterlib.BaseViewHolder;
import com.project.common.core.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        test();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    private void test() {
        BaseRecyclerAdapter<String> baseRecyclerAdapter = new BaseRecyclerAdapter<String>(mContext, null, R.layout.item_test) {
            @Override
            protected void convert(BaseViewHolder helper, String item) {

            }
        };
        BleManager.getInstance().init(getApplication());
    }
}
