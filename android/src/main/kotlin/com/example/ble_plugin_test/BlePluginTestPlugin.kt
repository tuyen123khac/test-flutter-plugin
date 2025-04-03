package com.example.ble_plugin_test

import io.flutter.embedding.engine.plugins.FlutterPlugin
import com.example.ble_plugin_test.plugin.devicecore.method.DeviceCoreMethodPlugin
import com.example.ble_plugin_test.plugin.devicecore.event.DeviceCoreEventPlugin

/** BlePluginTestPlugin
 *
 *  Primary entry point for our Flutter plugin. This plugin
 *  internally registers two sub-plugins:
 *   - DeviceCoreMethodPlugin (MethodChannel)
 *   - DeviceCoreEventPlugin  (EventChannel)
 */
class BlePluginTestPlugin : FlutterPlugin {

  private var deviceCoreMethodPlugin: DeviceCoreMethodPlugin? = null
  private var deviceCoreEventPlugin: DeviceCoreEventPlugin? = null

  override fun onAttachedToEngine(binding: FlutterPlugin.FlutterPluginBinding) {
    // Create + attach the sub-plugins
    deviceCoreMethodPlugin = DeviceCoreMethodPlugin().also {
      it.onAttachedToEngine(binding)
    }

    deviceCoreEventPlugin = DeviceCoreEventPlugin().also {
      it.onAttachedToEngine(binding)
    }
  }

  override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
    // Detach each sub-plugin
    deviceCoreMethodPlugin?.onDetachedFromEngine(binding)
    deviceCoreEventPlugin?.onDetachedFromEngine(binding)
  }
}
