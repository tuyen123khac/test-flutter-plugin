package com.example.ble_plugin_test.core.model

data class BasicInfo(
    val isTempSensorAttached: Int,
    val deviceOperationMode: Int,
    val modeThermostatState: Int,
    val modeManualState: Int,
    val fuelLevel: Int,
    //
    val currentLevel: Int,
    val expectedLevel: Int,
    val currentTemp: Float,
    val expectedTemp: Float,
)
