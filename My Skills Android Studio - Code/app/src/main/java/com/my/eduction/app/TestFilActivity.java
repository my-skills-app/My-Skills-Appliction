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
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.*;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.aghajari.waveanimation.*;
import com.blogspot.atifsoftwares.animatoolib.*;
import com.facebook.shimmer.*;
import com.github.barteksc.pdfviewer.*;
import com.google.android.gms.ads.MobileAds;
import com.google.android.material.appbar.AppBarLayout;
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

public class TestFilActivity extends AppCompatActivity {
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	
	private WebView webview1;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.test_fil);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		MobileAds.initialize(this);
		
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		_app_bar = findViewById(R.id._app_bar);
		_coordinator = findViewById(R.id._coordinator);
		_toolbar = findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		webview1 = findViewById(R.id.webview1);
		webview1.getSettings().setJavaScriptEnabled(true);
		webview1.getSettings().setSupportZoom(true);
		
		//webviewOnProgressChanged
		webview1.setWebChromeClient(new WebChromeClient() {
				@Override public void onProgressChanged(WebView view, int _newProgress) {
					
				}
		});
		
		//OnDownloadStarted
		webview1.setDownloadListener(new DownloadListener() {
			public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
				DownloadManager.Request webview1a = new DownloadManager.Request(Uri.parse(url));
				String webview1b = CookieManager.getInstance().getCookie(url);
				webview1a.addRequestHeader("cookie", webview1b);
				webview1a.addRequestHeader("User-Agent", userAgent);
				webview1a.setDescription("Downloading file...");
				webview1a.setTitle(URLUtil.guessFileName(url, contentDisposition, mimetype));
				webview1a.allowScanningByMediaScanner(); webview1a.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED); webview1a.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, URLUtil.guessFileName(url, contentDisposition, mimetype));
				
				DownloadManager webview1c = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
				webview1c.enqueue(webview1a);
				showMessage("Downloading File....");
				BroadcastReceiver onComplete = new BroadcastReceiver() {
					public void onReceive(Context ctxt, Intent intent) {
						showMessage("Download Complete!");
						unregisterReceiver(this);
						
					}};
				registerReceiver(onComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
			}
		});
		
		webview1.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView _param1, String _param2, Bitmap _param3) {
				final String _url = _param2;
				
				super.onPageStarted(_param1, _param2, _param3);
			}
			
			@Override
			public void onPageFinished(WebView _param1, String _param2) {
				final String _url = _param2;
				_telegramLoaderDialog(false);
				super.onPageFinished(_param1, _param2);
			}
		});
	}
	
	private void initializeLogic() {
		_telegramLoaderDialog(true);
		webview1.loadUrl(getIntent().getStringExtra("url"));
	}
	
	public void _telegramLoaderDialog(final boolean _visibility) {
		if (_visibility) {
			if (coreprog == null){
				coreprog = new ProgressDialog(this);
				coreprog.setCancelable(false);
				coreprog.setCanceledOnTouchOutside(false);
				
				coreprog.requestWindowFeature(Window.FEATURE_NO_TITLE);  coreprog.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
				
			}
			coreprog.show();
			coreprog.setContentView(R.layout.loading);
			
			
			LinearLayout linear2 = (LinearLayout)coreprog.findViewById(R.id.linear2);
			
			LinearLayout back = (LinearLayout)coreprog.findViewById(R.id.background);
			
			LinearLayout layout_progress = (LinearLayout)coreprog.findViewById(R.id.layout_progress);
			
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable(); 
			gd.setColor(Color.parseColor("#FFFFFF")); /* color */
			gd.setCornerRadius(45); /* radius */
			gd.setStroke(0, Color.WHITE); /* stroke heigth and color */
			linear2.setBackground(gd);
			
			RadialProgressView progress = new RadialProgressView(this);
			layout_progress.addView(progress);
		}
		else {
			if (coreprog != null){
				coreprog.dismiss();
			}
		}
	}
	private ProgressDialog coreprog;
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