package com.example.ble_plugin_test.plugin.blestate.constant

/** Make sure the method value matches the BleStateMethod on Flutter side */
enum class BleStateMethod(val value: String) {
    IS_BLE_ENABLED("isBleEnabled"),
    ENABLE_BLE("enableBle")
}