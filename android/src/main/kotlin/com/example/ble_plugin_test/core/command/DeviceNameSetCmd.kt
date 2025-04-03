package com.example.ble_plugin_test.core.command

import com.example.ble_plugin_test.core.command.builder.CommandBuilder
import com.example.ble_plugin_test.core.enum.CommandCode
import com.example.ble_plugin_test.core.handler.DeviceHandler

/** Data format
 *
 *  char[20]       name
 *
 * */

object DeviceNameSetCmd {
    fun send(name: String, handler: DeviceHandler) {
        val nameData = nameTo20Bytes(name)
        val builder = CommandBuilder.build(CommandCode.PACKET_CMD_DEVICE_NAME_SET, nameData)

        handler.write(builder)
    }

    private fun nameTo20Bytes(name: String): ByteArray {
        val raw = name.toByteArray(Charsets.US_ASCII)
        return when {
            raw.size == 20 -> raw
            raw.size < 20  -> {
                val padded = ByteArray(20)
                System.arraycopy(raw, 0, padded, 0, raw.size)
                padded
            }
            else -> raw.copyOf(20)
        }
    }
}