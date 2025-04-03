package com.example.ble_plugin_test.ble

import android.bluetooth.BluetoothDevice

data class FoundDevice(
    val btDevice: BluetoothDevice,
    val rssi : Int,
)
