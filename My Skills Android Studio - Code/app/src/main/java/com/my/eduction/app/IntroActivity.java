package com.my.eduction.app;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
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
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.smarteist.autoimageslider.*;
import com.unity3d.ads.*;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import okhttp3.*;
import org.jetbrains.kotlin.*;
import org.json.*;

public class IntroActivity extends AppCompatActivity {
	
	public final int REQ_CD_GAUTH = 101;
	
	FirebaseUser users;
	GoogleSignInOptions options;
	
	private LinearLayout background;
	private ImageView illustration;
	private TextView welcome_txt;
	private TextView sub_txt_1;
	private TextView sub_txt_2;
	private LinearLayout sign_with_google_lin;
	private LinearLayout create_account_lin;
	private LinearLayout already_bg;
	private ImageView google_icon;
	private TextView google_sign_txt;
	private TextView create_txt;
	private LinearLayout already_linear;
	private TextView already_txt;
	private TextView sign_in_txt;
	
	private GoogleSignInClient gauth;
	private Intent i = new Intent();
	private FirebaseAuth auth;
	private OnCompleteListener<AuthResult> _auth_create_user_listener;
	private OnCompleteListener<AuthResult> _auth_sign_in_listener;
	private OnCompleteListener<Void> _auth_reset_password_listener;
	private OnCompleteListener<Void> auth_updateEmailListener;
	private OnCompleteListener<Void> auth_updatePasswordListener;
	private OnCompleteListener<Void> auth_emailVerificationSentListener;
	private OnCompleteListener<Void> auth_deleteUserListener;
	private OnCompleteListener<Void> auth_updateProfileListener;
	private OnCompleteListener<AuthResult> auth_phoneAuthListener;
	private OnCompleteListener<AuthResult> auth_googleSignInListener;
	
	private SharedPreferences sp;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.intro);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		MobileAds.initialize(this);
		
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		background = findViewById(R.id.background);
		illustration = findViewById(R.id.illustration);
		welcome_txt = findViewById(R.id.welcome_txt);
		sub_txt_1 = findViewById(R.id.sub_txt_1);
		sub_txt_2 = findViewById(R.id.sub_txt_2);
		sign_with_google_lin = findViewById(R.id.sign_with_google_lin);
		create_account_lin = findViewById(R.id.create_account_lin);
		already_bg = findViewById(R.id.already_bg);
		google_icon = findViewById(R.id.google_icon);
		google_sign_txt = findViewById(R.id.google_sign_txt);
		create_txt = findViewById(R.id.create_txt);
		already_linear = findViewById(R.id.already_linear);
		already_txt = findViewById(R.id.already_txt);
		sign_in_txt = findViewById(R.id.sign_in_txt);
		auth = FirebaseAuth.getInstance();
		sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
		
		sign_with_google_lin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Intent signInIntent = gauth.getSignInIntent();
				
				startActivityForResult(signInIntent, REQ_CD_GAUTH);
			}
		});
		
		create_account_lin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), CreateActivity.class);
				startActivity(i);
			}
		});
		
		already_linear.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		sign_in_txt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), LoginActivity.class);
				startActivity(i);
			}
		});
		
		auth_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		auth_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_auth_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				if (_success) {
					i.setClass(getApplicationContext(), HomeActivity.class);
					startActivity(i);
					finish();
				}
			}
		};
		
		_auth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				if (_success) {
					i.setClass(getApplicationContext(), HomeActivity.class);
					startActivity(i);
					finish();
				}
			}
		};
		
		_auth_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				
			}
		};
	}
	
	private void initializeLogic() {
		_ui_design();
		GoogleSignInOptions options = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken("397165756385-fd21i23j1ff99dj6sbfogkc7c9rnj4iu.apps.googleusercontent.com").requestEmail().build();
		gauth = GoogleSignIn.getClient(this, options);
		auth = FirebaseAuth.getInstance();
		if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
			i.setClass(getApplicationContext(), HomeActivity.class);
			startActivity(i);
			overridePendingTransition(android.
			R.anim.fade_in,
			android.R.anim.fade_out);
			finish();
		}
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			case REQ_CD_GAUTH:
			if (_resultCode == Activity.RESULT_OK) {
				Task<GoogleSignInAccount> _task = GoogleSignIn.getSignedInAccountFromIntent(_data);
				
				try {
					                // Google Sign In was successful, authenticate with Firebase
					                GoogleSignInAccount account = _task.getResult(ApiException.class);
					                
					                firebaseAuthWithGoogle(account.getIdToken());
					            } catch (ApiException e) {
					                //On Fiailure
					                final String ErrorOnResultSign = e.getMessage();
					                SketchwareUtil.showMessage(getApplicationContext(), ErrorOnResultSign);
					            }
			}
			else {
				
			}
			break;
			default:
			break;
		}
	}
	
	public void _set_radius_with_ripple(final View _view, final String _color, final double _radius, final double _stroke, final String _s_color, final boolean _ripple) {
		if (_ripple) {
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor(_color));
			gd.setCornerRadius((int)_radius);
			gd.setStroke((int) _stroke, Color.parseColor(_s_color));
			_view.setBackground(gd);
			android.content.res.ColorStateList clrb = new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{Color.parseColor("#eeeeee")});
			android.graphics.drawable.RippleDrawable ripdrb = new android.graphics.drawable.RippleDrawable(clrb , gd, null);
			_view.setClickable(true);
			_view.setBackground(ripdrb);
		}
		else {
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor(_color));
			gd.setCornerRadius((int)_radius);
			gd.setStroke((int) _stroke, Color.parseColor(_s_color));
			_view.setBackground(gd);
		}
	}
	
	
	public void _Add(final String _Colour, final ImageView _Imageview) {
		_Imageview.getDrawable().setColorFilter(Color.parseColor(_Colour), PorterDuff.Mode.SRC_IN);
	}
	
	
	public void _ui_design() {
		_Add("#0041C4", google_icon);
		_set_radius_with_ripple(sign_with_google_lin, "#FFFFFF", 30, 0, "#000000", true);
		_set_radius_with_ripple(create_account_lin, "#0141C4", 30, 5, "#FFFFFF", true);
		if (Build.VERSION.SDK_INT >= 21) { Window w = this.getWindow(); w.setNavigationBarColor(Color.parseColor("#FF3500A5")); }
		
		
	}
	
	
	public void _signInWithGoogle() {
	}
	private void firebaseAuthWithGoogle(String idToken) {
		AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
		auth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
			
			@Override
			public void onComplete(@NonNull Task<AuthResult> task) {
				if (task.isSuccessful()) {
					users = auth.getCurrentUser();
					SketchwareUtil.showMessage(getApplicationContext(), "Login Not successful");
					i.setClass(getApplicationContext(), HomeActivity.class);
					sp.edit().putString("name", users.getDisplayName()).commit();
					sp.edit().putString("profile", users.getPhotoUrl().toString()).commit();
					startActivity(i);
				} else {
					SketchwareUtil.showMessage(getApplicationContext(), "Login Not successful");
				}
			}
		});
	}
	//[END auth_with_google]
	{
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