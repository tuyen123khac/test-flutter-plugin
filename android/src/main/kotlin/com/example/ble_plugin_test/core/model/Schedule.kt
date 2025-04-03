package com.example.ble_plugin_test.core.model

data class Schedule(
    val enableSchedule: Int,
    val turnOn: TimeSchedule,
    val turnOff: TimeSchedule,
)
