package com.example.ble_plugin_test.core.command

import com.example.ble_plugin_test.core.command.builder.CommandBuilder
import com.example.ble_plugin_test.core.enum.CommandCode
import com.example.ble_plugin_test.core.handler.DeviceHandler


object DeviceNameGetCmd {
    fun send(handler: DeviceHandler) {
        val builder = CommandBuilder.build(CommandCode.PACKET_CMD_DEVICE_NAME_GET)
        handler.write(builder)
    }
}