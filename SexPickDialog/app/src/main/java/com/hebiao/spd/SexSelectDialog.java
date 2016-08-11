package com.hebiao.spd;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by macpro on 16/8/11.
 */
public class SexSelectDialog extends Dialog implements View.OnClickListener{



    RelativeLayout nanLayout,nvLayout;
    ImageView nanImageView,nvImgageView;
    OnSexSelectLister sexSelectLister;
    Context context;
    AlertDialog dialog;
    public SexSelectDialog(Context context) {
        super(context);
        this.context=context;
        dialog=new android.app.AlertDialog.Builder(context).create();
        dialog.show();
        Window window = dialog.getWindow();
        window.setContentView(R.layout.sex_select_dialog);
        nanLayout=(RelativeLayout)window.findViewById(R.id.sex_select_nan_button);
        nanLayout.setOnClickListener(this);
        nvLayout=(RelativeLayout)window.findViewById(R.id.sex_select_nv_button);
        nvLayout.setOnClickListener(this);

        nanImageView=(ImageView)window.findViewById(R.id.sex_dialog_nanimg);
        nvImgageView=(ImageView)window.findViewById(R.id.sex_dialog_nvimg);

    }

    public  void  setSex(String sexString){
        if ("男".equals(sexString)){
            nanImageView.setImageResource(R.mipmap.sex_dialog_select);
            nvImgageView.setImageResource(R.mipmap.sex_dialog_unselect);
        }else {
            nvImgageView.setImageResource(R.mipmap.sex_dialog_select);
            nanImageView.setImageResource(R.mipmap.sex_dialog_unselect);
        }
    }

    public void  setOnSexClickLister(OnSexSelectLister sexSelectLister){
        this.sexSelectLister=sexSelectLister;
    }

    @Override
    public void onClick(View view) {
        dialog.dismiss();
        switch (view.getId()){
            case R.id.sex_select_nan_button:
                if (sexSelectLister!=null)
                {
                    sexSelectLister.sexSelectClick("男");
                    setSex("男");
                };

            break;
            case R.id.sex_select_nv_button:
                if (sexSelectLister!=null){
                    sexSelectLister.sexSelectClick("女");
                    setSex("女");
                }
            break;
            default:
        }

    }

    public  interface OnSexSelectLister{
        void sexSelectClick(String sex);
    }

}
