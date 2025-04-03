package com.example.ble_plugin_test.core.command

import com.example.ble_plugin_test.core.command.builder.CommandBuilder
import com.example.ble_plugin_test.core.enum.CommandCode
import com.example.ble_plugin_test.core.handler.DeviceHandler
import java.nio.ByteBuffer
import java.nio.ByteOrder

/** Data format
 *
 *  float       fuel_capacity
 *
 * */

object FuelCapacitySetCmd {
    fun send(fuelCapacity: Float, handler: DeviceHandler) {
        val buffer = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN)

        buffer.putFloat(fuelCapacity)

        val data = buffer.array()

        val packet = CommandBuilder.build(
            CommandCode.PACKET_CMD_FUEL_CAPACITY_SET,
            data
        )

        handler.write(packet)
    }
}