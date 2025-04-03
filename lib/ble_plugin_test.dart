
import 'ble_plugin_test_platform_interface.dart';

class BlePluginTest {
  Future<String?> getPlatformVersion() {
    return BlePluginTestPlatform.instance.getPlatformVersion();
  }
}
