package com.example.ble_plugin_test_example

import com.example.ble_plugin_test.plugin.blestate.BleStatePlugin
import com.example.ble_plugin_test.plugin.devicecore.event.DeviceCoreEventPlugin
import com.example.ble_plugin_test.plugin.devicecore.method.DeviceCoreMethodPlugin
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine

class MainActivity: FlutterActivity(){
    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        flutterEngine.plugins.add(BleStatePlugin())
        flutterEngine.plugins.add(DeviceCoreMethodPlugin())
        flutterEngine.plugins.add(DeviceCoreEventPlugin())
    }
}