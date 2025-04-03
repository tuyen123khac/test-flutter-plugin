import 'package:plugin_platform_interface/plugin_platform_interface.dart';

import 'ble_plugin_test_method_channel.dart';

abstract class BlePluginTestPlatform extends PlatformInterface {
  /// Constructs a BlePluginTestPlatform.
  BlePluginTestPlatform() : super(token: _token);

  static final Object _token = Object();

  static BlePluginTestPlatform _instance = MethodChannelBlePluginTest();

  /// The default instance of [BlePluginTestPlatform] to use.
  ///
  /// Defaults to [MethodChannelBlePluginTest].
  static BlePluginTestPlatform get instance => _instance;

  /// Platform-specific implementations should set this with their own
  /// platform-specific class that extends [BlePluginTestPlatform] when
  /// they register themselves.
  static set instance(BlePluginTestPlatform instance) {
    PlatformInterface.verifyToken(instance, _token);
    _instance = instance;
  }

  Future<String?> getPlatformVersion() {
    throw UnimplementedError('platformVersion() has not been implemented.');
  }
}
