package com.example.ble_plugin_test.core.handler

import android.bluetooth.BluetoothDevice
import android.content.Context
import com.example.ble_plugin_test.ble.BleConnectionCallBack
import com.example.ble_plugin_test.ble.BlePeripheral
import com.example.ble_plugin_test.core.parser.DataParser
import com.example.ble_plugin_test.util.ThreadPoolCreater

class DeviceHandler(
    context: Context,
    device: BluetoothDevice,
    val callBack: DeviceHandlerCallBack
) :
    BleConnectionCallBack {

    private val peripheral: BlePeripheral = BlePeripheral(context, device, this)

    private var parser: DataParser = DataParser(this) {
        ReceiveDataHandler.handle(it, this)
    }

    val executor = ThreadPoolCreater.create()

    init {
        executor.submit(parser)
    }

    override fun onConnected(connection: BluetoothDevice) {
        callBack.onConnected(this)
    }

    override fun onDisconnected(connection: BluetoothDevice) {
        callBack.onDisConnected(this)
    }

    override fun onDataReceived(connection: BluetoothDevice, byteArray: ByteArray) {
        parser.push(byteArray)
    }

    fun requestToConnect(autoConnect: Boolean = false) {
        peripheral.requestToConnect(autoConnect)
    }

    fun reconnect() {
        peripheral.reconnect()
    }

    fun requestToDisconnect() {
        peripheral.requestToDisconnect()
    }

    fun isEqual(address: String): Boolean {
        return peripheral.getAddress() == address
    }

    fun getDevice(): BlePeripheral {
        return peripheral
    }

    fun write(data: ByteArray) {
        peripheral.write(data)
    }
}