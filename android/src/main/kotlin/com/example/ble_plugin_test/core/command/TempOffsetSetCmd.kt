package com.example.ble_plugin_test.core.command

import com.example.ble_plugin_test.core.command.builder.CommandBuilder
import com.example.ble_plugin_test.core.enum.CommandCode
import com.example.ble_plugin_test.core.handler.DeviceHandler
import java.nio.ByteBuffer
import java.nio.ByteOrder

/** Data format
 *
 *  float       temperature_offset
 *
 * */

object TempOffsetSetCmd {
    fun send(tempOffset: Float, handler: DeviceHandler) {
        val buffer = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN)

        buffer.putFloat(tempOffset)

        val data = buffer.array()

        val packet = CommandBuilder.build(
            CommandCode.PACKET_CMD_TEMPERATURE_OFFSET_SET,
            data
        )

        handler.write(packet)
    }

}