package com.veryworks.android.recycleragain;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by pc on 6/2/2017.
 */

public class D_Holder extends RecyclerView.ViewHolder{
    private TextView textTel;
    private TextView textName;

    public D_Holder(View itemView) {
        super(itemView);
        textTel = (TextView) itemView.findViewById(R.id.textTel);
        textName = (TextView) itemView.findViewById(R.id.textName);
    }

    public void setTel(String value){
        textTel.setText(value);
    }

    public String getTel(){
        return textTel.getText().toString();
    }

    public void setName(String value){
        textName.setText(value);
    }

    public String getName(){
        return textName.getText().toString();
    }
}
