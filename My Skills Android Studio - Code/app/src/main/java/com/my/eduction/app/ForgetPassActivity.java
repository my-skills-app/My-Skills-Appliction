package com.my.eduction.app;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
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
import com.smarteist.autoimageslider.*;
import com.unity3d.ads.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import okhttp3.*;
import org.jetbrains.kotlin.*;
import org.json.*;

public class ForgetPassActivity extends AppCompatActivity {
	
	private LinearLayout background;
	private ImageView back_img;
	private TextView sign_in_txt;
	private LinearLayout main_background;
	private TextView welcome_title;
	private TextView welcome_sub;
	private TextView username_txt;
	private LinearLayout username_linear;
	private TextView password_txt;
	private TextView forgot_txt;
	private LinearLayout sign_in_button;
	private LinearLayout dot_prog_linear;
	private LinearLayout bottom_linear;
	private EditText username_edittext;
	private TextView button_txt;
	private TextView dont_txt;
	private TextView sign_up_txt;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.forget_pass);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		MobileAds.initialize(this);
		
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		background = findViewById(R.id.background);
		back_img = findViewById(R.id.back_img);
		sign_in_txt = findViewById(R.id.sign_in_txt);
		main_background = findViewById(R.id.main_background);
		welcome_title = findViewById(R.id.welcome_title);
		welcome_sub = findViewById(R.id.welcome_sub);
		username_txt = findViewById(R.id.username_txt);
		username_linear = findViewById(R.id.username_linear);
		password_txt = findViewById(R.id.password_txt);
		forgot_txt = findViewById(R.id.forgot_txt);
		sign_in_button = findViewById(R.id.sign_in_button);
		dot_prog_linear = findViewById(R.id.dot_prog_linear);
		bottom_linear = findViewById(R.id.bottom_linear);
		username_edittext = findViewById(R.id.username_edittext);
		button_txt = findViewById(R.id.button_txt);
		dont_txt = findViewById(R.id.dont_txt);
		sign_up_txt = findViewById(R.id.sign_up_txt);
	}
	
	private void initializeLogic() {
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