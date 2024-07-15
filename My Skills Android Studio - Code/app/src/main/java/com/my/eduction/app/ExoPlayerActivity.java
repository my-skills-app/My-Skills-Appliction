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
import android.widget.*;
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

public class ExoPlayerActivity extends AppCompatActivity {
	
	private String movie_url = "";
	private String poster_url = "";
	private String subtitle_url = "";
	private String movie_type = "";
	private String htmlCode = "";
	
	private WebView playerview;
	
	private RequestNetwork network;
	private RequestNetwork.RequestListener _network_request_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.exo_player);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		MobileAds.initialize(this);
		
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		playerview = findViewById(R.id.playerview);
		playerview.getSettings().setJavaScriptEnabled(true);
		playerview.getSettings().setSupportZoom(true);
		network = new RequestNetwork(this);
		
		//webviewOnProgressChanged
		playerview.setWebChromeClient(new WebChromeClient() {
				@Override public void onProgressChanged(WebView view, int _newProgress) {
					
				}
		});
		
		//OnDownloadStarted
		playerview.setDownloadListener(new DownloadListener() {
			public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
				DownloadManager.Request playerviewa = new DownloadManager.Request(Uri.parse(url));
				String playerviewb = CookieManager.getInstance().getCookie(url);
				playerviewa.addRequestHeader("cookie", playerviewb);
				playerviewa.addRequestHeader("User-Agent", userAgent);
				playerviewa.setDescription("Downloading file...");
				playerviewa.setTitle(URLUtil.guessFileName(url, contentDisposition, mimetype));
				playerviewa.allowScanningByMediaScanner(); playerviewa.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED); playerviewa.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, URLUtil.guessFileName(url, contentDisposition, mimetype));
				
				DownloadManager playerviewc = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
				playerviewc.enqueue(playerviewa);
				showMessage("Downloading File....");
				BroadcastReceiver onComplete = new BroadcastReceiver() {
					public void onReceive(Context ctxt, Intent intent) {
						showMessage("Download Complete!");
						unregisterReceiver(this);
						
					}};
				registerReceiver(onComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
			}
		});
		
		playerview.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView _param1, String _param2, Bitmap _param3) {
				final String _url = _param2;
				
				super.onPageStarted(_param1, _param2, _param3);
			}
			
			@Override
			public void onPageFinished(WebView _param1, String _param2) {
				final String _url = _param2;
				
				super.onPageFinished(_param1, _param2);
			}
		});
		
		_network_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
	}
	
	private void initializeLogic() {
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
		movie_url = getIntent().getStringExtra("url");
		poster_url = getIntent().getStringExtra("img");
		subtitle_url = getIntent().getStringExtra("tit");
		movie_type = movie_url.substring((int)(movie_url.length() - 3), (int)(movie_url.length()));
		htmlCode = "<!DOCTYPE html>\n<html>\n<head>\n  <title>Shaka Player with Embedded and External Subtitles</title>\n  <!-- Include Shaka Player library from CDN -->\n  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/shaka-player/4.3.8/shaka-player.compiled.js\"></script>\n  <style>\n    /* CSS to center the video and set black background */\n    body, html {\n      margin: 0;\n      padding: 0;\n      height: 100%;\n    }\n    #videoContainer {\n      display: flex;\n      justify-content: center;\n      align-items: center;\n      height: 100vh; /* Set the container height to full viewport height */\n      background-color: black; /* Set the background color to black */\n    }\n    #videoElement {\n      max-width: 100%;\n      max-height: 100%;\n    }\n  </style>\n</head>\n<body>\n  <main>\n    <div id=\"videoContainer\">\n      <!-- Add the autoplay, playsinline, and muted attributes to the video element -->\n      <!-- Use your video URL here -->\n      <video id=\"videoElement\" poster=\"".concat(poster_url.concat("\" controls autoplay playsinline >\n        <!-- Add video source(s) -->\n        <source src=\"".concat(movie_url.concat("\" type=\"video/".concat(movie_type.concat("\">\n      </video>\n    </div>\n  </main>\n\n  <script>\n    // Your JavaScript code to initialize Shaka Player\n    const videoElement = document.getElementById('videoElement');\n\n    // Initialize Shaka Player\n    const player = new shaka.Player(videoElement);\n\n    // Listen for the 'loadedmetadata' event to request fullscreen after video metadata is loaded\n    videoElement.addEventListener('loadedmetadata', () => {\n      // When the video metadata is loaded, start fullscreen mode\n      if (videoElement.requestFullscreen) {\n        videoElement.requestFullscreen();\n      } else if (videoElement.webkitRequestFullscreen) {\n        videoElement.webkitRequestFullscreen();\n      } else if (videoElement.mozRequestFullScreen) {\n        videoElement.mozRequestFullScreen();\n      } else if (videoElement.msRequestFullscreen) {\n        videoElement.msRequestFullscreen();\n      }\n    });\n\n    // Load the stream URL\n    player.load(\"".concat(movie_url.concat("\").then(() => {\n      // Start playback after the video is loaded and in fullscreen\n      videoElement.play();\n    }).catch(error => {\n      console.error('Error loading stream:', error);\n    });\n\n    // Add a function to load external subtitle file\n    function loadExternalSubtitle(subtitleUrl) {\n      const track = videoElement.addTextTrack('subtitles', 'External Subtitle', 'en');\n      track.mode = 'showing';\n\n      // Fetch the subtitle file\n      fetch(subtitleUrl)\n        .then(response => response.text())\n        .then(data => {\n          track.mode = 'showing';\n          const vttBlob = new Blob([data], { type: 'text/vtt' });\n          const vttUrl = URL.createObjectURL(vttBlob);\n          track.src = vttUrl;\n        })\n        .catch(error => {\n          console.error('Error loading subtitle:', error);\n        });\n    }\n\n    // Add a function to enable embedded subtitles\n    function enableEmbeddedSubtitles() {\n      const manifestUri = '".concat(movie_url.concat("';\n      player.load(manifestUri).then(() => {\n        // Start playback after the video is loaded and in fullscreen\n        videoElement.play();\n      }).catch(error => {\n        console.error('Error loading stream:', error);\n      });\n    }\n\n    // Call the function to load the external subtitle\n    const subtitleUrl = '".concat(subtitle_url.concat("'; // Replace with your subtitle file URL\n    loadExternalSubtitle(subtitleUrl);\n\n    // Call the function to enable embedded subtitles\n    enableEmbeddedSubtitles();\n  </script>\n</body>\n</html>"))))))))))));
		playerview.getSettings().setJavaScriptEnabled(true);
		playerview.getSettings().setBuiltInZoomControls(false);
		playerview.loadData(htmlCode, "text/html", "UTF-8");
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