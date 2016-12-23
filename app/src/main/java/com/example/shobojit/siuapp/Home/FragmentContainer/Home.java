package com.example.shobojit.siuapp.Home.FragmentContainer;

import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.TextView;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.shobojit.siuapp.R;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.HashMap;

public class Home extends Fragment  implements  BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {
    TextView ttday,ttdate,ttmonth,tttime;
    private SliderLayout mDemoSlider;
    String HomeText , ChairText, VcText;
    WebView wv1,wv2,wv3;
    SimpleDraweeView ChairmanImage,VCImage;
    FloatingActionButton fab,fab_man,fab_exit;
    Animation fab_open,fab_clos,fab_rotate,fab_rotate_back;
    View v;
    boolean isOpen =false;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.home_fragment,container,false);

        Text ();
        TextViewIntailization(v);
        SliderIntailization(v);
        FloatingIntialization(v);
        ImageInitailaization(v);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isOpen){
                fab_man.startAnimation(fab_clos);
                    fab_exit.startAnimation(fab_clos);
                        fab.startAnimation(fab_rotate_back);
                    fab_exit.setVisibility(View.GONE);
                    fab_man.setVisibility(View.GONE);
                    fab_man.setClickable(false);
                    fab_exit.setClickable(false);
                    isOpen=false; }
                else {
                    fab_man.startAnimation(fab_open);
                    fab_exit.startAnimation(fab_open);
                    fab.startAnimation(fab_rotate);
                    fab_man.setClickable(true);
                    fab_exit.setClickable(true);
                    isOpen=true; }
            } });

        fab_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
                alertDialog.setTitle("Alert");
                alertDialog.setIcon(R.drawable.alertpic);
                alertDialog.onWindowFocusChanged(true);
                alertDialog.setMessage("Are you sure you want to exit?");
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                System.exit(1);
                            }
                        });
                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();

            }
        });
        return v;
    }





    public void FloatingIntialization(View v){
        fab = (FloatingActionButton) v.findViewById(R.id.fab);
        fab_man = (FloatingActionButton) v.findViewById(R.id.fab_man);
        fab_exit = (FloatingActionButton) v.findViewById(R.id.fab_exit);


        //For Animation
        fab_open = AnimationUtils.loadAnimation(getContext(),R.anim.fab_open);
        fab_clos = AnimationUtils.loadAnimation(getContext(),R.anim.fab_close);
        fab_rotate = AnimationUtils.loadAnimation(getContext(),R.anim.fab_rotat);
        fab_rotate_back= AnimationUtils.loadAnimation(getContext(),R.anim.fab_rotate_back);

    }



    public void Text (){
        ChairText = "<html><body>"
                + "<p align=\"justify\">"+"<font size=\"3.5\">" + getString(R.string.chairman1) +"</font>"+"</p> "
                + "<p align=\"justify\">"+"<font size=\"3.5\">"+ getString(R.string.chairman2) +"</font>"+"</p> "
                + "<p align=\"justify\">"+"<font size=\"3.5\">" + getString(R.string.chairman3) +"</font>"+ "</p> "
                + "<p align=\"justify\">"+"<font size=\"3.5\">"+ getString(R.string.chairman4) +"</font>"+"</p> "
                + "</body></html>";

        HomeText = "<html><body>"
                + "<p align=\"justify\">"+"<font size=\"3.5\">" + getString(R.string.Home1) +"</font>"+"</p> "
                + "<p align=\"justify\">"+"<font size=\"3.5\">"+ getString(R.string.Home2) +"</font>"+ "</p> "
                + "<p align=\"justify\">"+"<font size=\"3.5\">" + getString(R.string.Home3) +"</font>"+"</p> "
                + "<p align=\"justify\">"+"<font size=\"3.5\">"+ getString(R.string.Home4) +"</font>"+ "</p> "
                + "</body></html>";

        VcText = "<html><body>"
                + "<p align=\"justify\">"+"<font size=\"3.5\">"+ getString(R.string.vc1) +"</font>"+ "</p> "
                + "<p align=\"justify\">"+"<font size=\"3.5\">"+ getString(R.string.vc2) +"</font>"+ "</p> "
                + "<p align=\"justify\">"+"<font size=\"3.5\">" + getString(R.string.vc3) +"</font>"+ "</p> "
                + "</body></html>";
    }



    public void TextViewIntailization(View v){
        wv1 = (WebView) v.findViewById(R.id.NormalText);
        wv1.loadData(HomeText, "text/html", "utf-8");

        wv2 = (WebView) v.findViewById(R.id.chairmanText);
        wv2.loadData(ChairText, "text/html", "utf-8");

        wv3 = (WebView) v.findViewById(R.id.vctext);
        wv3.loadData(VcText, "text/html", "utf-8");
    }




    public void SliderIntailization(View v){
        mDemoSlider = (SliderLayout)v.findViewById(R.id.slider);
        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("SIU Garden", R.drawable.siu_garden);
        file_maps.put("SIU Main Gate",R.drawable.s2);
        file_maps.put("Physics Olympiad ",R.drawable.physics1);
        file_maps.put("Sylhet International University",R.drawable.campus);
        file_maps.put("SIU Hostel",R.drawable.hostel);
        file_maps.put("1st Convocation of SIU ",R.drawable.ca);
        file_maps.put("Physics Olympiad ",R.drawable.physics2);
        file_maps.put("SIU Campus", R.drawable.s5);
         for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(getContext());
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.DepthPage);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Top);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);
    }



    public void ImageInitailaization(View v){
        ChairmanImage= (SimpleDraweeView) v.findViewById(R.id.chairmanimage);
        String ChairmanImagepath="res:/" + R.drawable.chairman;
        String VCImagepath="res:/" + R.drawable.vc;
        //ChairmanImage.setImageURI(Uri.parse("http://siu.edu.bd/wp-content/uploads/2015/09/chairman-sir1-1023x450.jpg"));
        ChairmanImage.setImageURI(Uri.parse(ChairmanImagepath));
        VCImage= (SimpleDraweeView) v.findViewById(R.id.vcimage);
        //VCImage.setImageURI(Uri.parse("http://siu.edu.bd/wp-content/uploads/2015/09/vc.jpg"));
        VCImage.setImageURI(Uri.parse(VCImagepath));

    }


    @Override
    public void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mDemoSlider.stopAutoCycle();
        super.onStop();
    }
    @Override
    public void onSliderClick(BaseSliderView slider) {

    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }
    @Override
    public void onPageSelected(int position) {

    }
    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
