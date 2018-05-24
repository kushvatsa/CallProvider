package com.kushapps.providerandroid

import android.annotation.TargetApi
import android.content.Context
import android.os.Build

import com.kushapps.providercore.AbstractProvider
import com.kushapps.providercore.Data

/**
 * Created by Kush Vatsa
 */
@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
class CallsProvider(context: Context) : AbstractProvider(context) {

    /**
     * Get all calls.
     *
     * @return List of calls
     */
    val calls: Data<Call>?
        get() {
            val calls = getContentTableData(Call.uri, Call::class.java)
            return calls
        }

}
