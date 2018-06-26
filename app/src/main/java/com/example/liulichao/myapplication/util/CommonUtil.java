package com.example.liulichao.myapplication.util;

import android.content.Context;
import android.widget.Toast;

public class CommonUtil {
    private static Toast mToast;

    public  static void ShowTips(Context context,String tips){
        if(mToast == null){

            mToast = Toast.makeText(context,tips,Toast.LENGTH_SHORT);

        }else{
            mToast.setText(tips);
        }

        mToast.show();;
    }
}
