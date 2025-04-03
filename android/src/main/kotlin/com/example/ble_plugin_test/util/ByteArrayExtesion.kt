package com.example.ble_plugin_test.util

fun ByteArray.toHexString(): String {
    return joinToString(prefix = "[", postfix = "]") {
        String.format("%02X", it)
    }
}