package com.example.ble_plugin_test.core.handler

import com.example.ble_plugin_test.core.model.BasicInfo
import com.example.ble_plugin_test.core.model.DeviceInfo
import com.example.ble_plugin_test.core.model.HotBoxData
import com.example.ble_plugin_test.core.model.Schedule
import com.example.ble_plugin_test.core.model.TimeStamp

interface DeviceHandlerCallBack {
    // Connection
    fun onConnected(handler: DeviceHandler)
    fun onDisConnected(handler: DeviceHandler)

    // Data response
    fun onDeviceNameRsp(deviceName: String, handler: DeviceHandler)
    fun onDeviceInfoRsp(deviceInfo: DeviceInfo, handler: DeviceHandler)
    fun onBasicInfoRsp(basicInfo: BasicInfo, handler: DeviceHandler)
    fun onHotBoxDataRsp(hotBoxData: HotBoxData, handler: DeviceHandler)
    fun onTimeStampRsp(timeStamp: TimeStamp, handler: DeviceHandler)
    fun onScheduleRsp(schedule: Schedule, handler: DeviceHandler)
}