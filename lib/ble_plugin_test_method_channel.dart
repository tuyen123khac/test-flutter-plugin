import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';

import 'ble_plugin_test_platform_interface.dart';

/// An implementation of [BlePluginTestPlatform] that uses method channels.
class MethodChannelBlePluginTest extends BlePluginTestPlatform {
  /// The method channel used to interact with the native platform.
  @visibleForTesting
  final methodChannel = const MethodChannel('ble_plugin_test');

  @override
  Future<String?> getPlatformVersion() async {
    final version = await methodChannel.invokeMethod<String>('getPlatformVersion');
    return version;
  }
}
