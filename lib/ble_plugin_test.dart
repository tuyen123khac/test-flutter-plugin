import 'package:ble_plugin_test/application/permission_utils.dart';
import 'package:ble_plugin_test/plugin/device_core/device_core_plugin.dart';
import 'package:ble_plugin_test/plugin/device_core/device_event_task.dart';
import 'package:ble_plugin_test/plugin/device_core/enum/event_enum.dart';
import 'package:ble_plugin_test/plugin/device_core/models/found_device.dart';

import 'ble_plugin_test_platform_interface.dart';

class BlePluginTest {
  Future<String?> getPlatformVersion() {
    return BlePluginTestPlatform.instance.getPlatformVersion();
  }

  static Future<void> checkPermission() async {
    await PermissionUtils.requestBluetoothPermission();
    await PermissionUtils.requestLocationPermission();
  }

  static Future<bool> isBleEnabled() async {
    return DeviceCorePlugin.isBleEnabled();
  }

  static startScan() async {
    await DeviceCorePlugin.startScan();
  }

  static stopScan() async {
    await DeviceCorePlugin.stopScan();
  }

  static subscribePluginEvents() {
    DeviceCorePlugin.subscribeEvents();
  }

  static Stream<DeviceEventTask> getDeviceEventStream() {
    return DeviceCorePlugin.listenEvent();
  }

  static void listenFoundDevice(Function(FoundDevice) onDeviceFound) {
    DeviceCorePlugin.listenEvent().listen(
      (event) {
        switch (event.event) {
          case EventEnum.onDeviceFound:
            onDeviceFound(event.toScannedDevice());
            break;
          default:
            break;
        }
      },
    );
  }
}
