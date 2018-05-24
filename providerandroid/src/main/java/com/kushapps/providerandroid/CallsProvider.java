package com.kushapps.providerandroid;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;

import com.kushapps.providercore.AbstractProvider;
import com.kushapps.providercore.Data;

/**
 * Created by Kush Vatsa
 */
@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
public class CallsProvider extends AbstractProvider {

	public CallsProvider(Context context) {
		super(context);
	}

	/**
	 * Get all calls.
	 * 
	 * @return List of calls
	 */
	public Data<Call> getCalls() {
        Data<Call> calls = getContentTableData(Call.uri, Call.class);
		return calls;
	}

}
