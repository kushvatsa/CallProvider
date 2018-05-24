package com.kushapps.providerandroid

import android.annotation.TargetApi
import android.net.Uri
import android.os.Build
import android.provider.BaseColumns
import android.provider.CallLog.Calls

import com.kushapps.providercore.Entity
import com.kushapps.providercore.EnumInt
import com.kushapps.providercore.FieldMapping
import com.kushapps.providercore.IgnoreMapping

/**
 * Created by Kush Vatsa
 */
@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
public class Call : Entity() {

    @FieldMapping(columnName = BaseColumns._ID, physicalType = FieldMapping.PhysicalType.Long)
    var id: Long = 0

    @FieldMapping(columnName = Calls.CACHED_NAME, physicalType = FieldMapping.PhysicalType.String)
    var name: String? = null

    @FieldMapping(columnName = Calls.DATE, physicalType = FieldMapping.PhysicalType.Long)
    var callDate: Long = 0

    @FieldMapping(columnName = Calls.DURATION, physicalType = FieldMapping.PhysicalType.Long)
    var duration: Long = 0

    @FieldMapping(columnName = Calls.IS_READ, physicalType = FieldMapping.PhysicalType.Int, logicalType = FieldMapping.LogicalType.Boolean)
    var isRead: Boolean = false

    @FieldMapping(columnName = Calls.NUMBER, physicalType = FieldMapping.PhysicalType.String)
    var number: String? = null

    @FieldMapping(columnName = Calls.TYPE, physicalType = FieldMapping.PhysicalType.Int, logicalType = FieldMapping.LogicalType.EnumInt)
    var type: CallType? = null

    enum class CallType private constructor(internal var `val`: Int) : EnumInt {
        INCOMING(Calls.INCOMING_TYPE),
        OUTGOING(Calls.OUTGOING_TYPE),
        MISSED(Calls.MISSED_TYPE);


        companion object {

            fun fromVal(`val`: Int): CallType? {
                for (messageStatus in values()) {
                    if (messageStatus.`val` == `val`) {
                        return messageStatus
                    }
                }
                return null
            }
        }
    }

    companion object {

        @IgnoreMapping
        var uri = Calls.CONTENT_URI
    }
}
