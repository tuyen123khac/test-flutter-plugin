package com.example.ble_plugin_test.ble

import android.bluetooth.BluetoothDevice

interface BleConnectionCallBack {
    fun onConnected(connection: BluetoothDevice)
    fun onDisconnected(connection: BluetoothDevice)

    // For live data, notified from Central RX characteristic
    fun onDataReceived(connection: BluetoothDevice, byteArray: ByteArray)
}