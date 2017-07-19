package com.brain.jd.controller;

import android.content.Context;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.brain.jd.consts.INetWorkConst;
import com.brain.jd.consts.IdiyMessage;
import com.brain.jd.domain.RResult;
import com.brain.jd.domain.RTopCategoryBean;
import com.brain.jd.utils.NetWorkUtil;

import java.util.ArrayList;
import java.util.List;


/**
 * @author : Brian
 * @date : 2017/7/19
 */

public class CategoryController extends JDBaseController {

    private static final String TAG = "CategoryController";



    public CategoryController(Context context) {
        super(context);
    }

    @Override
    public void handleAsyncMessage(int pAction, Object[] pValues) {
        switch (pAction) {
            case IdiyMessage.MSG_ACTION_TOP_CATEGORY:
                loadTopCategory();
                break;
        }
    }

    /**
     * load top category
     */
    private void loadTopCategory() {
        String json = NetWorkUtil.doGet(INetWorkConst.TOP_CATEGORY_URL);
        RResult rResult = JSON.parseObject(json, RResult.class);
        List<RTopCategoryBean> rTopCategoryBeen = new ArrayList<>();

        // Log.d(TAG, "loadTopCategory: " + rResult.getResult());
        if (rResult.isSuccess()) {
            rTopCategoryBeen = JSON.parseArray(rResult.getResult(), RTopCategoryBean.class);
        }

        if (mIContrllerListenner != null) {
            Log.d(TAG, "loadTopCategory: " + rTopCategoryBeen);
            mIContrllerListenner.onMessageResult(IdiyMessage.MSG_ACTION_TOP_CATEGORY_RESULT, rTopCategoryBeen);
        }
    }
}
