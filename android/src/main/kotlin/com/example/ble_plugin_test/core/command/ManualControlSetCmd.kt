package com.example.ble_plugin_test.core.command

import com.example.ble_plugin_test.core.command.builder.CommandBuilder
import com.example.ble_plugin_test.core.enum.CommandCode
import com.example.ble_plugin_test.core.handler.DeviceHandler
import java.nio.ByteBuffer
import java.nio.ByteOrder

/** Data format
 *
 *  uint8_t     command                         (0: Idle; 1: Running)
 *  float       expected_temperature
 *
 * */

object ManualControlSetCmd {
    fun send(command: Int, expectedTemp: Float, handler: DeviceHandler) {

        // 1. Allocate 5 bytes for command (1 byte) + float (4 bytes)
        val dataBuffer = ByteBuffer.allocate(5).order(ByteOrder.LITTLE_ENDIAN)

        // 2. Put the 1-byte command (0 for Idle, 1 for Running)
        dataBuffer.put(command.toByte())

        // 3. Put the 4 bytes of the float
        dataBuffer.putFloat(expectedTemp)

        // 4. Convert to ByteArray
        val dataArray = dataBuffer.array()

        // 5. Build the packet with your CommandBuilder
        val packet = CommandBuilder.build(
            CommandCode.PACKET_CMD_MODE_MANUAL_CONTROL_SET,
            dataArray
        )

        handler.write(packet)
    }
}