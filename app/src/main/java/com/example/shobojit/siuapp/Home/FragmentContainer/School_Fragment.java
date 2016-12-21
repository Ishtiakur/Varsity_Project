package com.example.shobojit.siuapp.Home.FragmentContainer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shobojit.siuapp.Home.Faculty_Activity.Buc_fac;
import com.example.shobojit.siuapp.Home.Faculty_Activity.Eng_fac;
import com.example.shobojit.siuapp.Home.Faculty_Activity.Hum_fac;
import com.example.shobojit.siuapp.Home.Faculty_Activity.Law_fac;
import com.example.shobojit.siuapp.R;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by SHOBOJIT on 12/18/2016.
 */

public class School_Fragment extends Fragment {
    View v;
    SimpleDraweeView imgeng,imglaw,imgbus,imghum;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.shcool_fragment,container,false);
        IniTialization(v);

        //Eng Faculty OnClick
        imgeng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), Eng_fac.class));
            }
        });
        //For Bus Faculty
        imgbus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), Buc_fac.class));
            }
        });

        imghum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), Hum_fac.class));
            }
        });

        imglaw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), Law_fac.class));
            }
        });

        return v;
    }

    void IniTialization(View v){
        imgeng = (SimpleDraweeView) v.findViewById(R.id.engineering);
        imglaw = (SimpleDraweeView) v.findViewById(R.id.laws);
        imgbus = (SimpleDraweeView) v.findViewById(R.id.business);
        imghum = (SimpleDraweeView) v.findViewById(R.id.humanaties);
        imgeng.setImageURI(Uri.parse("res:/" + R.drawable.school1));
        imglaw.setImageURI(Uri.parse("res:/" + R.drawable.school2));
        imgbus.setImageURI(Uri.parse("res:/" + R.drawable.school3));
        imghum.setImageURI(Uri.parse("res:/" + R.drawable.school4));
    }
}
