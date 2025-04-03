package com.example.ble_plugin_test.core.handler.response


import com.example.ble_plugin_test.core.handler.DeviceHandler
import com.example.ble_plugin_test.core.model.TimeStamp
import java.nio.ByteBuffer
import java.nio.ByteOrder

/** Data format
 *
 *  uint64_t     epoch_time
 *
 * */

// TODO: check unit64_t and long
object TimeStampRspHandler {
    fun handle(data: ByteArray, handler: DeviceHandler) {
        try {
            val buffer = ByteBuffer.wrap(data)
            buffer.order(ByteOrder.LITTLE_ENDIAN)

            // Extract the epoch_time from the data, uint64_t = 8 bytes
            val epochTime = buffer.long
            val timeStamp = TimeStamp(epochTime)

            handler.callBack.onTimeStampRsp(timeStamp, handler)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}