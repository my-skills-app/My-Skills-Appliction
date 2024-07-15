package com.my.eduction.app;

import android.animation.*;
import android.animation.ObjectAnimator;
import android.app.*;
import android.content.*;
import android.content.Intent;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.os.Bundle;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.webkit.*;
import android.widget.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.aghajari.waveanimation.*;
import com.blogspot.atifsoftwares.animatoolib.*;
import com.facebook.shimmer.*;
import com.github.barteksc.pdfviewer.*;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.FirebaseApp;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.smarteist.autoimageslider.*;
import com.unity3d.ads.*;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import okhttp3.*;
import org.jetbrains.kotlin.*;
import org.json.*;

public class MainActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear4;
	private LinearLayout linear3;
	private ImageView imageview1;
	
	private Intent i = new Intent();
	private TimerTask t;
	private ObjectAnimator object = new ObjectAnimator();
	private ObjectAnimator b = new ObjectAnimator();
	private ObjectAnimator c = new ObjectAnimator();
	private ObjectAnimator d = new ObjectAnimator();
	private ObjectAnimator bd = new ObjectAnimator();
	private TimerTask timer;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		MobileAds.initialize(this);
		
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		linear4 = findViewById(R.id.linear4);
		linear3 = findViewById(R.id.linear3);
		imageview1 = findViewById(R.id.imageview1);
	}
	
	private void initializeLogic() {
		_Disine();
		_rippleRoundStroke(linear4, "#FFFFFF", "#3500a5", 555, 5, "#FFFFFF");
		object.setTarget(linear2);
		object.setPropertyName("alpha");
		object.setFloatValues((float)(0), (float)(1));
		object.setDuration((int)(500));
		object.start();
		timer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						object.setTarget(linear4);
						object.setPropertyName("scaleX");
						object.setFloatValues((float)(1), (float)(30));
						object.setDuration((int)(1200));
						object.start();
						_imageScale();
						_lscaleY();
					}
				});
			}
		};
		_timer.schedule(timer, (int)(3000));
		_Elevation(linear2, 20);
	}
	
	public void _Disine() {
		if (Build.VERSION.SDK_INT >= 21) { Window w = this.getWindow(); w.setNavigationBarColor(Color.parseColor("#FF3500A5")); }
		
		
	}
	
	
	public void _lscaleY() {
		c.setTarget(linear4);
		c.setPropertyName("scaleY");
		c.setFloatValues((float)(1), (float)(30));
		c.setDuration((int)(1200));
		c.start();
		timer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						i.setClass(getApplicationContext(), IntroActivity.class);
						startActivity(i);
					}
				});
			}
		};
		_timer.schedule(timer, (int)(350));
	}
	
	
	public void _imageScale() {
		d.setTarget(imageview1);
		d.setPropertyName("scaleX");
		d.setFloatValues((float)(1), (float)(0));
		d.setDuration((int)(300));
		d.start();
		if (true) {
			bd.setTarget(imageview1);
			bd.setPropertyName("scaleY");
			bd.setFloatValues((float)(1), (float)(0));
			bd.setDuration((int)(300));
			bd.start();
		}
	}
	
	
	public void _rippleRoundStroke(final View _view, final String _focus, final String _pressed, final double _round, final double _stroke, final String _strokeclr) {
		android.graphics.drawable.GradientDrawable GG = new android.graphics.drawable.GradientDrawable();
		GG.setColor(Color.parseColor(_focus));
		GG.setCornerRadius((float)_round);
		GG.setStroke((int) _stroke,
		Color.parseColor("#" + _strokeclr.replace("#", "")));
		android.graphics.drawable.RippleDrawable RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor(_pressed)}), GG, null);
		_view.setBackground(RE);
	}
	
	
	public void _Elevation(final View _view, final double _number) {
		
		_view.setElevation((int)_number);
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}