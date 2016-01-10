package social.yadi.rndimmer;

import android.app.Activity;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.IllegalViewOperationException;

public class ReactNativeDimmerModule extends ReactContextBaseJavaModule {

    private Activity mActivity = null;

    public ReactNativeDimmerModule( ReactApplicationContext reactContext, Activity activity ) {
        super( reactContext );
        mActivity = activity;
    }

    @Override
    public String getName() {
        return "RNDimmer";
    }

    @ReactMethod
    public void set( final boolean disabled, final Promise promise ) {
        try {
            mActivity.runOnUiThread( new Runnable() {
                @Override
                public void run() {
                    WritableMap result = new WritableNativeMap();
                    Window window = mActivity.getWindow();
                    if ( disabled ) {
                        window.addFlags( WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON );
                    } else {
                        window.clearFlags( WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON );
                    }
                    promise.resolve( result );
                }
            } );
        } catch ( IllegalViewOperationException e ) {
            promise.reject( e.getMessage() );
        }
    }

}
